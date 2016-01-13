package io.egen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.RSS.exception.AppException;
import io.RSS.exception.NotFoundException;
import io.egen.model.Employee;
import io.egen.util.DBUtil;

public class EmployeeDAO  {

	public List<Employee> findAll()throws AppException{
		List<Employee> employees = new ArrayList<Employee>();
		Connection con = DBUtil.connect();
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		try {
			ps= con.prepareStatement("SELECT * FROM employee");
			rs = ps.executeQuery();
			
			while(rs.next()){
				Employee emp= new Employee();
				emp.setId(rs.getInt("ID"));
				emp.setFirstname(rs.getString("FIRST_NAME"));
				emp.setLastname(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setAddress1(rs.getString("ADDRESS1"));
				emp.setAddress2(rs.getString("ADDRESS2"));
				emp.setCity(rs.getString("CITY"));
				emp.setZip(rs.getInt("ZIP"));
				emp.setState(rs.getString("STATE"));
				emp.setPhone(rs.getString("PHONE"));
				employees.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally{
			
			try{
			if(ps != null)
		{
			ps.close();
		}
			if(rs != null){
				rs.close();
			}
			if(con!= null){
				con.close();
			}
			} catch (SQLException e){
				e.printStackTrace();
			}
		}	
		return employees;
	}

	public Employee findOne(int id) throws AppException, NotFoundException{
		Employee emp = null;
		Connection con = DBUtil.connect();
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		try {
			ps= con.prepareStatement("SELECT * FROM employee WHERE ID=?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				emp= new Employee();
				emp.setId(rs.getInt("ID"));
				emp.setFirstname(rs.getString("FIRST_NAME"));
				emp.setLastname(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setAddress1(rs.getString("ADDRESS1"));
				emp.setAddress2(rs.getString("ADDRESS2"));
				emp.setCity(rs.getString("CITY"));
				emp.setZip(rs.getInt("ZIP"));
				emp.setState(rs.getString("STATE"));
				emp.setPhone(rs.getString("PHONE"));
			}
			else{
				throw new NotFoundException("Employee with this id is not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally{
			
			try{
			if(ps != null)
		{
			ps.close();
		}
			if(rs != null){
				rs.close();
			}
			if(con!= null){
				con.close();
			}
			} catch (SQLException e){
				e.printStackTrace();
			}
		}	
		return emp;
	}
}
