package com.inventles.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.inventles.data.pojo.BusinessEntity;
import com.inventles.data.pojo.Employee;

@Path("/emp")
public class EmployeeFacadeREST extends AbstractREST<Employee> {

	public EmployeeFacadeREST() {
		super(Employee.class);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addEmployee(Employee employee) {
		employee.setBusinessEntity((BusinessEntity) getBusinessEntity());
		super.upsert(employee);
		return "Success";
	}
}
