package io.egen.controller;


import java.util.List;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import io.RSS.exception.AppException;
import io.RSS.exception.NotFoundException;
import io.egen.dao.EmployeeDAO;
import io.egen.model.Employee;

@Path("/employees")
public class EmployeeController {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> findAll()throws AppException{		
		List<Employee> employees = null;	
		try{
			EmployeeDAO dao = new EmployeeDAO();
			employees=dao.findAll();
		}catch(AppException e){
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return employees;
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee findOne(@PathParam ("id")int id) throws AppException, NotFoundException{
		Employee employee = null;	
		try{
			EmployeeDAO dao = new EmployeeDAO();
			employee=dao.findOne(id);
		}catch(AppException e){
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return employee;
	}
	@POST
	public void create(){
		
	}
	@PUT
	public void update(){
		
	}
	@DELETE
	public void delete(){
		
	}
}
