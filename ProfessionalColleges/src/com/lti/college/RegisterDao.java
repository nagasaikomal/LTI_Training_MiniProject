package com.lti.college;

import java.sql.SQLException;
import java.util.List;

public interface RegisterDao 
{
int addCollege(College c) throws SQLException;
	
	List<College> viewAnCollege() throws SQLException;
	
	int deleteCollege(int cid) throws SQLException;
}
