package votingsystem.voting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import votingsystem.database.Connect;

public class voting {
	static Scanner sc=new Scanner(System.in);
	int op=0;
	public void setId(){
		Connection co=Connect.getConnect();
		
		try {
			
			Statement st=co.createStatement();
			ResultSet pst=st.executeQuery("Select ID from candidate");
			PreparedStatement destination=co.prepareStatement("Insert into voting (id) VALUES(?)");
			while(pst.next()) {
				int id=pst.getInt("id");
				destination.setInt(1, id);
				int a=destination.executeUpdate();
				op=op+a;
			}
		
			System.out.println(op+" Successful");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void StartVoting() {
		Connection co=Connect.getConnect();
		System.out.println("Enter a Voter id: ");
		int VoterId=sc.nextInt();
		try {
			Statement st1=co.createStatement();
			ResultSet pst=st1.executeQuery("Select id from voter");
			boolean found=false;

			while(pst.next()) {
				int ids=pst.getInt("id");
				while(VoterId==ids){
					Statement stmt=co.createStatement();
					ResultSet trashIds = stmt.executeQuery("Select ID from trash");
					boolean check=false;
					while(trashIds.next()) {
						int existingId=trashIds.getInt("id");
						if(existingId==VoterId) {
							System.out.println("Already Voted");
							check=true;
							break;
						}
					}
					if(check==false) {
						PreparedStatement trash=co.prepareStatement("Insert into trash(id)Values(?);");
						trash.setInt(1, VoterId);
						trash.executeUpdate();
						voting.setVote();
					}
					
					found=true;
					break;
				}
			}
			if(found==false) {
				System.out.println("Invalid Voter");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void setVote() {
		voting.finalcandidate();
		System.out.println("Choose your Candidate");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		Connection co=Connect.getConnect();
		try {
			PreparedStatement pst=co.prepareStatement("Select votes from voting where id=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			while(rst.next()) {
				
				int singlevote=rst.getInt("votes");
				singlevote=singlevote+1;
				PreparedStatement voting=co.prepareStatement("UPDATE voting SET votes=? where id=?");
				voting.setInt(1, singlevote);
				voting.setInt(2, id);
				voting.executeUpdate();
				System.out.println("Vote Success");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void finalcandidate() {
		Connection co=Connect.getConnect();
		try {
			Statement st=co.createStatement();
			ResultSet rst=st.executeQuery("Select * from candidate");
			while(rst.next()) {
				int id=rst.getInt("id");
				String name=rst.getString("name");
				String party=rst.getString("party");
				int age=rst.getInt("age");
				System.out.println("Id: "+id+"\tName: "+name+"\tParty: "+party+"\tAge: "+age);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

}