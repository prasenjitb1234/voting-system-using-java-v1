package votingsystem.home;

import java.util.Scanner;

import votingsystem.Reset.Reset;
import votingsystem.home.candidate.Operation;
import votingsystem.voter.Operations1;
import votingsystem.voting.voting;

public class Test {
	static {
		System.out.println("Welcome to Election ");
	}
	static Scanner sc = new Scanner(System.in);
	static Operation op=new Operation();
	static Operations1 op1 = new Operations1();
	static voting vt = new voting();
	static Reset st = new Reset();
	public static void start() {
		
		
	
		
		while(true) {
		
		System.out.println("Press 1 for candidate \n 2 for  voters \n 3 start voting \n 4 Reset");
		int ch = sc.nextInt();
		
		switch(ch) {
		case 1: 
			op.candidateOperation();
			break;
		case 2:
			op1.VoterOperations();
			break;
		case 3:
			vt.StartVoting();
			break;
		case 4:
			Reset.ResetData();
			break;
		}
		
		}
		
	

	
}
public static void main(String[] args) {
	
	Test.start();
}
}
