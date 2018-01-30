package com.munsiji.controller;

import javax.annotation.PostConstruct;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.munsiji.resource.UserDetail;
import com.munsiji.resource.reqres.LoginReq;
import com.munsiji.resource.reqres.ServerResponse;
import com.munsiji.resource.reqres.UserDetailReq;
import com.munsiji.service.LoginService;
import com.munsiji.service.RegisterProcess;


@Service
@Path("/rest")
public class RestControllerService {
	@Autowired
	DozerBeanMapper dozerBeanMapper;
    @Autowired
    LoginService loginService;
    @Autowired
    RegisterProcess registerProcess;
	
	@PostConstruct
	public void init(){
		System.out.println("this is init method called");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    
	@PermitAll // will be access by all user without any authentication
	@GET
	@Path("/gethealth")
	public String healthCheck(){
	   System.out.println("healthcheck method called");	
	   return "{\"get status\":\"sucess\"}";
	}
	@POST    // will  be access by after performing BASIC Authentication same goes for all without any annotation for security
	@Path("/posthealth")
	public String healthCheck(String str){
	   System.out.println("healthcheck method called");	
	   return "{\"post status\":\"sucess\"}";
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ServerResponse login(LoginReq loginReq){
		System.out.println("login method excuted:"+loginReq.getUname());
		System.out.println("loginService:"+loginService);;
		ServerResponse response=null;
		//LoginService loginService=new LoginService();
		response=loginService.processReq(loginReq);
		return response;
		
	}
	@RolesAllowed("ADMIN") // will be access by the user who is having admin role
	@POST 
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ServerResponse  register(UserDetailReq user, @Context SecurityContext secContext){
		ServerResponse response=null;
		System.out.println("called register:"+user);
		UserDetail userDetail=dozerBeanMapper.map(user, UserDetail.class);
		System.out.println("dozer mapper worked properly");
		registerProcess.register(userDetail);
		return response;
	}
	@PermitAll
	@POST
	@Path("/checkrestclient")
	@Produces(MediaType.APPLICATION_JSON)
	public String checkClientCode(){
	  String str = null;
	  Client client = ClientBuilder.newClient();
	  WebTarget webTarget = client.target("http://localhost:8080/projectservices/");
	  WebTarget employeeWebTarget = webTarget.path("route/rest/gethealth");
	  Invocation.Builder invocationBuilder = employeeWebTarget.request(MediaType.APPLICATION_JSON);
	  Response response = invocationBuilder.get();
	  if(response.hasEntity()){
	   System.out.println("response objectt:"+response.readEntity(String.class));
	   str = response.readEntity(String.class); //instead of String.class. we can use any pojo class mapping to JSON obj
	                                            // need to test with that
	  }
	  return str;
	}
	
	
	
}
