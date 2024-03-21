package votingsystem.home.candidate;

import java.util.Scanner;

import votingsystem.database.Database;

public class Operation {
	static Scanner sc = new Scanner(System.in);
	static MultiCandidate md = new MultiCandidate();
	
		public static void setCandidate() {
		int ch = 1;
		while(ch==1) {
			Candidate cd = new Candidate();
			
			System.out.println("Enter name ");
			String name = sc.next();
			cd.setName(name);
			System.out.println("Enter party: ");
			String party = sc.next();
			cd.setParty(party);
			System.out.println("Enter age :");
			int age = sc.nextInt();
			cd.setAge(age);
			md.addCandidate(cd);
			System.out.println("Press 1 for add candidate \n Press 2 for save");
			ch = sc.nextInt();

	}
		if(ch==2) {
			md.save();
			
		}
	}
		public void candidateOperation() {
			System.out.println("Pres 1 register candiate \n 2 for update canidate \n 3 for delete candidate \n 4 for show candidate ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				Operation.setCandidate();
				break;
			case 2:
				Database.UpdateCandidate();
				break;
			case 3:
				Database.DeleteCandidate();
				break;
			case 4:
				Database.DisplayCandidadte();
				
			}
		}
}
