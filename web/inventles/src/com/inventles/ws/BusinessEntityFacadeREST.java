package com.inventles.ws;

import javax.ws.rs.Path;

import com.inventles.data.pojo.BusinessEntity;

@Path("/businessentity")
public class BusinessEntityFacadeREST extends AbstractREST<BusinessEntity> {

  public BusinessEntityFacadeREST() {
		super(BusinessEntity.class);
	}
} 
