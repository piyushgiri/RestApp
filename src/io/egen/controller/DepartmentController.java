package io.egen.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

public class DepartmentController {

	@GET
	public void findAll(){
		
	}
	@GET
	@Path("/{id}")
	public void findOne(int id){
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
