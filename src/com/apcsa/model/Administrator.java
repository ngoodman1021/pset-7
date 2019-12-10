package com.apcsa.model;

import com.apcsa.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

//*smiley face*

public class Administrator extends User {
	
	public Administrator(User user, ResultSet rs) throws SQLException{
			super(rs);
	}

    private int administratorId;
    private String firstName;
    private String lastName;
    private String jobTitle;

}