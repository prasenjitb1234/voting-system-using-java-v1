package votingsystem.voter;

import java.util.ArrayList;
public class MultiVoter {

	private ArrayList<Voter> list;
	public MultiVoter() {
		this.list=new ArrayList<Voter>();
	}
	public void addVoter(Voter vt) {
		list.add(vt);
	}
	public void save() {
		Database1.saveToDb1(list);
	}
	
}
