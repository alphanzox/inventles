package com.inventles.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.inventles.data.AbstractFacade;

public class AbstractREST<T> extends AbstractFacade<T> {

	public AbstractREST(Class<T> entityClass) {
		super(entityClass);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object find(@PathParam("id") Integer id) {
		Object entity =  (T) super.find(id);
		return entity;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<T> findAll1() {
		return super.findAll();
	}
	
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void findAll(String id) {
		System.out.println("Post Called plain");
		//return convertToJSON(super.findAll());
	}
	

}
