package test;

import java.util.HashMap;


import java.io.*;
import java.nio.file.*;
import java.util.List;

import javax.ws.rs.GET;


import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;
import java.util.Base64.*;
import java.util.Date;
import java.util.Base64;


import test.dco.*;
import test.dto.*;



/**
 * Root resource (exposed at "etj" path)
 */
@Path("hello")

public class HelloService {
	
	  static Logger log = LogManager.getLogger("HelloServiceLogger");
	  
	  @Context
	  private HttpServletRequest httpRequest;
	  
	  @GET
	    @Produces(MediaType.APPLICATION_JSON)
		@Path("/sayHello")
	    public Response sayHello(@QueryParam("name") String name) throws Exception {
		  
		  //String response = "";
		  
		  // New Comment
		  
		  HelloResponseDTO response = null;
		  
		  try {
			  
			  log.info("End   sayHello::" + name + "::Time::" + System.currentTimeMillis() );
			  
			  HelloDCO dco = new HelloDCO();
			  
			  response = dco.getHelloResponse(name);
			 									
			  //response = "Hello " + name;
			 
			  if(response == null) 
				    throw new Exception(" Hello Response not found!!");
			  
			  return  Response.status(200)
				        .entity(response).type(MediaType.APPLICATION_JSON).build();
			  
		  } catch(java.nio.file.NoSuchFileException f) {
			   return  Response.status(Response.Status.NOT_FOUND)
	           .entity("dodID not found!!").type(MediaType.TEXT_PLAIN).build();
		    }catch(Throwable t) {
				return  Response.status(Response.Status.EXPECTATION_FAILED)
		        .entity(t.getMessage()).type(MediaType.TEXT_PLAIN).build();
			}		
	  }
	  	

}
