package com.apcsa.controller;

import java.util.ArrayList;
import java.util.Scanner;
import com.apcsa.data.PowerSchool;
import com.apcsa.model.Teacher;
import com.apcsa.model.User;

public class Application {

    private Scanner in;
    private User activeUser;

    /**
     * Creates an instance of the Application class, which is responsible for interacting
     * with the user via the command line interface.
     */

    public Application() {
        this.in = new Scanner(System.in);

        try {
            PowerSchool.initialize(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts the PowerSchool application.
     */

    public void startup() {
        System.out.println("PowerSchool -- now for students, teachers, and school administrators!");

        while (true) {
            System.out.print("\nUsername: ");
            String username = in.next();

            System.out.print("Password: ");
            String password = in.next();

            try {
	            if (login(username, password)) {
	                activeUser = activeUser.isAdministrator()
	                    ? PowerSchool.getAdministrator(activeUser) : activeUser.isTeacher()
	                    ? PowerSchool.getTeacher(activeUser) : activeUser.isStudent()
	                    ? PowerSchool.getStudent(activeUser) : activeUser.isRoot()
	                    ? activeUser : null;
	
	                if (isFirstLogin() && !activeUser.isRoot()) {
	                    System.out.print("\nInput a new password: ");
	                    String newPassword = in.next();
	                    
	                    changePass(username, newPassword);
	                }
	                
	                createAndShowUI();
	            } else {
	                System.out.println("\nInvalid username and/or password.");
	            }
            } catch (Exception e) {
            	shutdown(e);
            }
        }
    }
	
	 public void createAndShowUI() {
    	System.out.println("\nHello, again, " + activeUser.getFirstName() + "!\n");
    	
    	if(activeUser.isRoot()) {
    		showRootUI();
    	} else if (activeUser.isAdministrator()) {
    		showAdministratorUI();
    	} else if (activeUser.isTeacher()) {
    		showTeacherUI();
    	} else if (activeUser.isStudent()) {
    		showStudentUI();
    	}
    }
    
    private void showRootUI() {
    	while (activeUser != null) {
    		switch (getRootMenuSelection()) {
            case 1: rootResetPassword(); break;
            case 2: factoryReset(); break;
            case 3: logout(); break;
            case 4: shutdown(); break;
            default: System.out.println("\nInvalid selection."); break;
        	}
    	}
    }
    
    private void showAdministratorUI() {
    	while (activeUser != null) {
 			switch (administratorSelection()) {
 			case 1: faculty(); break;
 			case 2: facultyByDepartment(); break;
 			case 3: studentEnrollment(); break;
 			case 4: studentEnrollmentbyGrade(); break;
 			case 5: studentEnrollmentbyCourse(); break;
 			case 6: resetPassword(); break;
 			case 7: logout(); break;
 			default: System.out.println("\nInvalid selection. \n"); break;
 			}
         }
    }

    public static void main(String[] args) {
        Application app = new Application();

        app.startup();
    }
}
