package com.lti.college;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class RegisterDaoImpl implements RegisterDao {
	
	Connection con=null;
	
	
	 public RegisterDaoImpl() throws SQLException {
			super();
			
			
			
			final String url="jdbc:oracle:thin:@localhost:1521:XE";
			final String username="hr";
			final String password="hr";
			
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("loaded");
			
			con=DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			
		}
	

	@Override
	public int addCollege(College c) throws SQLException {
		
		int cid=c.getCid();
		String cname=c.getCname();
		String coursetype=c.getCoursetype();
		String city=c.getCity();
		int fees=c.getFees();
		int pincode=c.getPincode();
		
		String sql="insert into college values(?,?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, cid);
		ps.setString(2, cname);
		ps.setString(3, coursetype);
		ps.setString(4, city);
		ps.setInt(5, fees);
		ps.setInt(6, pincode);
		
		int i=ps.executeUpdate();
		 return i;
		
	}

	@Override
	public List<College> viewAnCollege() throws SQLException {
		
		return null;
	}

	@Override
	public int deleteCollege(int cid) throws SQLException {
		
		String sql="delete from college where cid=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, cid);
		
		int i=ps.executeUpdate();
		 return i;
	}

}
