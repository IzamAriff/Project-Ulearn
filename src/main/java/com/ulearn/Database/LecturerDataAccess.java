package com.ulearn.Database;

import java.sql.*;
import java.util.ArrayList;
import com.ulearn.Main.Lecturer;
import com.ulearn.Main.Office;

public class LecturerDataAccess {
    public static ArrayList<Lecturer> getAllLecturers (Connection con) {
		
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
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Lecturer");			
			ResultSet result = stmt.executeQuery();			
			ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
			
			while(result.next()) {
				
				name = result.getString("name");
				ID = result.getString("id");
				age = result.getInt("age");
				IC = result.getString("ic");
                email = result.getString("email");
                password = result.getString("password");
                phoneNum = result.getString("phoneNum");
				department = result.getString("department");
				String officeStr = result.getString("office");
				String[] officeSplit;
				officeSplit = officeStr.split(" ");
				
				office = new Office(officeSplit[0], officeSplit[1], officeSplit[2]);
				
				Lecturer lecturer = new Lecturer(name, email, password, age, id, ic, department, phoneNum);
				lecturers.add(lecturer);
				
			}
			
			return lecturers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
