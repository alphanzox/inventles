package com.inventles.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.inventles.data.pojo.BusinessEntity;
import com.inventles.data.pojo.Customer;

@Path("/cust")
public class CustomerFacadeREST extends AbstractREST<Customer> {

	public CustomerFacadeREST() {
		super(Customer.class);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddCustomer(Customer customer) {
		customer.setBusinessEntity((BusinessEntity) getBusinessEntity());
		super.upsert(customer);
		return "Success";
	}
}
