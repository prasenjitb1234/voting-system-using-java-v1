package votingsystem.voter;

import java.util.Scanner;

import votingsystem.home.Test;

public class Operations1 {
	static Scanner sc = new Scanner(System.in);
	static MultiVoter mv=new MultiVoter();
	public static void setVoter() {
		int ch=1;
		while(ch==1) {
			Voter vt=new Voter();
	
			System.out.println("Enter Name:");
			vt.setName(sc.next());
			System.out.println("Enter Gender:");
			vt.setGender(sc.next());
			System.out.println("Enter Age:");
			vt.setAge(sc.nextInt());
			mv.addVoter(vt);
			System.out.println("Press 1 for add more Voters\nPress 2 for save");
			ch=sc.nextInt();
		}
		if(ch==2) {
			mv.save();
		}
		}

	
	
	public void VoterOperations() {
		while(true) {
		System.out.println("Press 1 for Register a Voter\n Press 2 for Update Voter\n Press 3 for Delete Voter\n Press 4 for Display Voter\n Press 5 for Exit");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			Operations1.setVoter();
			break;
		case 2:
			Database1.UpdateVoter();
			break;
		case 3:
			Database1.DeleteVoter();
			break;
		case 4:
			Database1.DisplayVoter();
			break;
		default:
			Test.start();
			
		}
	}
}
	}
	
