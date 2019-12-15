package com.apcsa.model;

import com.apcsa.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

//*smiley face*

public class Administrator extends User {
	
    private int administratorId;
    private String firstName;
    private String lastName;
    private String jobTitle;
	
    public Administrator(User user, ResultSet rs) throws SQLException{
	super(rs);
	    
	this.administratorId = rs.getInt("administrator_id");
    	this.firstName = rs.getString("first_name");
    	this.lastName = rs.getString("last_name");
    	this.jobTitle = rs.getString("job_title");
	
    }

    

}
