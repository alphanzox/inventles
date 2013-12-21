package com.inventles.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventles.data.AbstractFacade;
import com.inventles.data.pojo.InventlesDO;

public class AbstractREST<T> extends AbstractFacade<T> {

	public AbstractREST(Class<T> entityClass) {
		super(entityClass);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String find(@PathParam("id") Integer id) {
		Object entity =  (T) super.find(id);
		return convertToJSON(entity);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String findAll1() {
		return convertToJSON(super.findAll());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void findAll1(InventlesDO event) {
		System.out.println("Post Called");
		//return convertToJSON(super.findAll());
	}
	
	private String convertToJSON(Object obj){
		String json = "";
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return json;
	}

}
