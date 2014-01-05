package com.inventles.ws;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.inventles.data.AbstractFacade;
import com.inventles.data.pojo.BusinessEntity;
import com.inventles.data.pojo.InventlesDO;

public class AbstractREST<T> extends AbstractFacade<T> {
	
	@Context 
    private ServletContext context; 

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

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

	// TODO: extract user business entity code from http session.
	@Override
	public InventlesDO getBusinessEntity() {
		HttpSession session = request.getSession();
		session.getAttribute("user");
		// TODO: remove
		BusinessEntity be = new BusinessEntity();
		be.setEntityCode("mk");

		return be;
	}
	

}
