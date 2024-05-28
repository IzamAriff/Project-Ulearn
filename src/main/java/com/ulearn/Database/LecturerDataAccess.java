package com.ulearn.Database;

import java.sql.*;
import java.util.ArrayList;
import com.ulearn.Main.Lecturer;
import com.ulearn.Main.Office;

public class LecturerDataAccess {
	private Connection connection;

	public LecturerDataAccess(Connection connection) { 
		this.connection = connection;
	}
	

	public ArrayList<Lecturer> getAllLecturers () throws SQLException {
		
        int age;
        String name;
		String ID;
		String email;
        String password;
        String phoneNum;
		String IC;
		String department;
		Office office;

		
		try {
			String query = "SELECT * FROM Lecturer";
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet result = stmt.executeQuery();			
			ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
			
			while(result.next()) {
				Lecturer lecturer = new Lecturer();
				lecturer.setName(result.getString("name"));
				lecturer.setId(result.getString("id"));
				lecturer.setAge(result.getInt("age"));
				lecturer.setIc(result.getString("ic"));
                lecturer.setEmail(result.getString("email"));
                lecturer.setPassword(result.getString("password"));
                lecturer.setPhoneNum(result.getString("phoneNum"));
				lecturer.setDepartment(result.getString("department"));
				String officeStr = result.getString("office");
				String[] officeSplit;
				officeSplit = officeStr.split(" ");
				
				office = new Office(officeSplit[0], officeSplit[1], officeSplit[2]);

				lecturers.add(lecturer);
				
			}
			
			return lecturers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
