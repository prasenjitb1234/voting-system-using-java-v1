package votingsystem.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import votingsystem.home.candidate.Candidate;



public class Database {
	static Scanner sc=new Scanner(System.in);
	public static void saveToDb(ArrayList<Candidate> list) {
		Connection cn=Connect.getConnect();
		try {
			int op=0;
			PreparedStatement st=cn.prepareStatement("INSERT INTO candidate (name,party,age)VALUES(?,?,?);");
			for(Candidate cd: list) {
				String name=cd.getName();
				String party=cd.getParty();
				int age=cd.getAge();
				st.setString(1, name);
				st.setString(2, party);
				st.setInt(3, age);
				int ch=st.executeUpdate();
				op=op+ch;
			}
			System.out.println(op+" Candidates added successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void UpdateCandidate() {
		Connection co=Connect.getConnect();
		try {
			System.out.println("Press 1 for update Name\nPress 2 for update Party\nPress 3 for update age ");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				PreparedStatement st=co.prepareStatement("UPDATE candidate SET name=? WHERE id=?");
				System.out.println("Enter a new Name:");
				st.setString(1, sc.next());
				System.out.println("Enter id of candidate");
				st.setInt(2, sc.nextInt());
				int ex1=st.executeUpdate();
				System.out.println(ex1+"Candidate name updated");
				break;
			case 2:
				PreparedStatement st1=co.prepareStatement("UPDATE candidate SET party=? WHERE id=?");
				System.out.println("Enter a new party:");
				st1.setString(1, sc.next());
				System.out.println("Enter id of candidate");
				st1.setInt(2, sc.nextInt());
				int ex2=st1.executeUpdate();
				System.out.println(ex2+"Candidate party updated");
				break;
			case 3:
				PreparedStatement st2=co.prepareStatement("UPDATE candidate SET age=? WHERE id=?");
				System.out.println("Enter a new age:");
				st2.setInt(1, sc.nextInt());
				System.out.println("Enter id of candidate");
				st2.setInt(2, sc.nextInt());
				int ex3=st2.executeUpdate();
				System.out.println(ex3+"Candidate age updated");
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void DeleteCandidate() {
		Connection co=Connect.getConnect();
		System.out.println("Enter Candidate id to delete");
		try {
			PreparedStatement st=co.prepareStatement("DELETE FROM candidate WHERE id=?");
			System.out.println("Are you want to delete the data");
			System.out.println("Press 1 for delete\nPress 2 for cancel");
			int sure=sc.nextInt();
			if(sure==1){
				st.setInt(1, sc.nextInt());
				int d=st.executeUpdate();
				System.out.println(d+"Candidate succesfully deleted");
			}else {
				System.out.println("Cancelled");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	
	public static void DisplayCandidadte() {
		Connection co=Connect.getConnect();
		try {
			Statement st=co.createStatement();
			ResultSet executeQuery=st.executeQuery("Select * from candidate");
			while(executeQuery.next()) {
				int ID=executeQuery.getInt("ID");
				String NAME=executeQuery.getString("NAME");
				int age=executeQuery.getInt("age");
				String party=executeQuery.getString("Party");
				int votes=executeQuery.getInt("votes");
				System.out.println("ID:"+ID+"\nName:"+NAME+"\nAge:"+age+"\nParty:"+party+"\nVote"+votes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}