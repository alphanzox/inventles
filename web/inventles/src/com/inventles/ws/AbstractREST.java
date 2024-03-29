package com.inventles.ws;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
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
	public List<T> findAll() {
		return super.findAll();
	}
	
	

	// TODO: extract user business entity code from http session.
	@Override
	public InventlesDO getBusinessEntity() {
		HttpSession session = request.getSession();
		session.getAttribute("user");
		// TODO: Add code to reterive Business Enity from User
		BusinessEntity be = new BusinessEntity();
		be.setEntityCode("APL");

		return be;
	}
	

}
