package votingsystem.Reset;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import votingsystem.database.Connect;

public class Reset {
	public static void ResetData() {
		
		Connection co  = Connect.getConnect();
		
		try {
			Statement st = co.createStatement();
			st.executeUpdate("ALTER TABLE candidate DISABLE KEY");
			st.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
			st.executeUpdate("TRUNCATE TABLE candidate");
			st.executeUpdate("TRUNCATE TABLE voter");
			st.executeUpdate("TRUNCATE TABLE voting");
			st.executeUpdate("TRUNCATE TABLE trash");
			st.executeUpdate("SET FOREIGN_KEY_CHECKS=1");
			System.out.println("Data Reset Successful");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}




