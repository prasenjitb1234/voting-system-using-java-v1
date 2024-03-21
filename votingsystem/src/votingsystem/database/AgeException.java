package votingsystem.database;

public class AgeException extends Exception{
	public AgeException() {
		super("You are not eligibal for candidate");
	}
	
}
