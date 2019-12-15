package com.apcsa.model;

import com.apcsa.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Teacher extends User {

    private int teacherId;
    private int departmentId;
    private String firstName;
    private String lastName;

    public Teacher(User user, ResultSet rs) throws SQLException {
        super(user);
        
        this.teacherId = rs.getInt("teacher_id");
        this.departmentId = rs.getInt("department_id");
        this.firstName = rs.getString("first_name");
        this.lastName = rs.getString("last_name");
        this.departmentId = rs.getInt("department_id");
    }
    
    public int getTeacherId() {
    	return teacherId;
    }
    
    public int getDepartmentId() {
    	return departmentId;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public String getDepartmentName() {
    	return departmentName;
    }

}
