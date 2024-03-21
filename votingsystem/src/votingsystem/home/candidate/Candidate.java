package votingsystem.home.candidate;

public class Candidate {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	private String name;
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private String party;
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	
	private String votes;
	public String getVotes() {
		return votes;
	}
	public void setVotes(String votes) {
		this.votes = votes;
	}
	
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", party=" + party + ", votes=" + votes + ", age=" + age
				+ "]";
	}
	
	public void candidate() {
		
	}
	
	
	
}
