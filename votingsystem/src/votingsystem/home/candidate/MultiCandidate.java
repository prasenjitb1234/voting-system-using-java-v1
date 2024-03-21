package votingsystem.home.candidate;

import java.util.ArrayList;

import votingsystem.database.Database;

public class MultiCandidate {
	private ArrayList<Candidate> list;
	
	public MultiCandidate() {
		this.list = new ArrayList<Candidate>();
	}
	public void addCandidate(Candidate cd) {
		list.add(cd);
	}
	
	public void save() {
		Database.saveToDb(list);
	}
	
}
