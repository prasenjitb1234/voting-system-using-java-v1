package votingsystem.voter;
//import votingsystem.database.Connect; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import votingsystem.database.AgeException;
import votingsystem.database.Connect;



public class Database1 {

	static Scanner sc=new Scanner(System.in);
	public static void saveToDb1(ArrayList<Voter> list) {
		Connection cn=Connect.getConnect();
		try {
			int op=0;
			PreparedStatement st=cn.prepareStatement("INSERT INTO voter (name,gender,age)VALUES(?,?,?);");
			for(Voter vt: list) {
				String name=vt.getName();
				String gender=vt.getGender();
				int age=vt.getAge();
				if(age<18) {
					throw new AgeException();
				}
				else {
					st.setString(1, name);
					st.setString(2, gender);
					st.setInt(3, age);
					int ch=st.executeUpdate();
					op=op+ch;
				}
				System.out.println(op+" Voters added successfully");
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (AgeException e) {
			System.out.println("You are not Eligible");
		}
	
	}
	
	
	public static void UpdateVoter() {
		Connection co=Connect.getConnect();
		try {
			System.out.println("Press 1 for update Name\nPress 2 for update gender\nPress 3 for update age ");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				PreparedStatement st=co.prepareStatement("UPDATE candidate SET name=? WHERE id=?");
				System.out.println("Enter a new Name:");
				st.setString(1, sc.next());
				System.out.println("Enter id of voter");
				st.setInt(2, sc.nextInt());
				int ex1=st.executeUpdate();
				System.out.println(ex1+"Voter name updated");
				break;
			case 2:
				PreparedStatement st1=co.prepareStatement("UPDATE voter SET gender=? WHERE id=?");
				System.out.println("Enter a new gender:");
				st1.setString(1, sc.next());
				System.out.println("Enter id of voter");
				st1.setInt(2, sc.nextInt());
				int ex2=st1.executeUpdate();
				System.out.println(ex2+"Voter gender updated");
				break;
			case 3:
				PreparedStatement st2=co.prepareStatement("UPDATE voter SET age=? WHERE id=?");
				System.out.println("Enter a new age:");
				st2.setInt(1, sc.nextInt());
				System.out.println("Enter id of voter");
				st2.setInt(2, sc.nextInt());
				int ex3=st2.executeUpdate();
				System.out.println(ex3+"voter age updated");
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		public static void DeleteVoter() {
			Connection co=Connect.getConnect();
			
			try {
				PreparedStatement st=co.prepareStatement("DELETE FROM voter WHERE id=?");
				System.out.println("Are you want to delete the data");
				System.out.println("Press 1 for delete\nPress 2 for cancel");
				int sure=sc.nextInt();
				System.out.println("Enter voter id to delete");
				
				if(sure==1){
					st.setInt(1, sc.nextInt());
					int d=st.executeUpdate();
					if(d==0) {
						System.out.println("Voter Id not available in table");
					}else {
						System.out.println(d+"Voter succesfully deleted");
					}
					
				}else {
					System.out.println("Cancelled");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
	}
		public static void DisplayVoter() {
			Connection co=Connect.getConnect();
			try {
				Statement st=co.createStatement();
				ResultSet executeQuery=st.executeQuery("Select * from voter");
				while(executeQuery.next()) {
					int ID=executeQuery.getInt("ID");
					String NAME=executeQuery.getString("NAME");
					int age=executeQuery.getInt("age");
					String gender=executeQuery.getString("gender");
					System.out.println("ID:"+ID+"\nName:"+NAME+"\nAge:"+age+"\nGender:"+gender);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	
}
