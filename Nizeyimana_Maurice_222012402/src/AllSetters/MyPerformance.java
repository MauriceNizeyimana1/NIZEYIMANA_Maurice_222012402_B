package AllSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyPerformance {
	private int Perfrm_Id;
	private String Empll_Id;
	private String Evalpd;
	private String KPIs;
	private String Rate;
	private String Comm;
	
	public MyPerformance(int Perfrm_Id,String Empll_Id,String Evalpd,String KPIs,String Rate,String Comm) {
		super();
		this. Perfrm_Id= Perfrm_Id;
		this.Empll_Id=Empll_Id;
		this.Evalpd=Evalpd;
		this. KPIs= KPIs;
		this.Rate=Rate;
		this.Comm= Comm;
	}

	public MyPerformance() {
		// TODO Auto-generated constructor stub
	}

	public int getPerfrm_Id() {
		return Perfrm_Id;
	}

	public void setPerfrm_Id(int perfrm_Id) {
		Perfrm_Id = perfrm_Id;
	}

	public String getEmpll_Id() {
		return Empll_Id;
	}

	public void setEmpll_Id(String empll_Id) {
		Empll_Id = empll_Id;
	}

	public String getEvalpd() {
		return Evalpd;
	}

	public void setEvalpd(String evalpd) {
		Evalpd = evalpd;
	}

	public String getKPIs() {
		return KPIs;
	}

	public void setKPIs(String kPIs) {
		KPIs = kPIs;
	}

	public String getRate() {
		return Rate;
	}

	public void setRate(String rate) {
		Rate = rate;
	}

	public String getComm() {
		return Comm;
	}

	public void setComm(String comm) {
		Comm = comm;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to insert data
	    String sql = "INSERT INTO Performance (Employee_Id,Evaluation_Period,Key_Performance_Indicators, Rating, Comments) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setString(1, this.Empll_Id);
	        preparedStatement.setString(2, this.Evalpd);
	        preparedStatement.setString(3, this.KPIs);
	        preparedStatement.setString(4, this.Rate);
	        preparedStatement.setString(5, this.Comm);
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data inserted sucessfully");
	            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

			public static ResultSet viewData() {
			    String host = "jdbc:mysql://localhost/labor_management";
			    String user = "222012402";
			    String password = "222012402";
			    String sql = "SELECT * FROM Performance";

			    try {
			        Connection con = DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}

	public void update(int inputPerformance_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to update data
	    String sql = "UPDATE Performance SET  Employee_Id=?, Evaluation_Period=?, Key_Performance_Indicators=?, Rating=?, Comments=? WHERE Performance_Id=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement Performance = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	Performance.setString(1, this.getEmpll_Id());
	    	Performance.setString(2, this.getEvalpd());
	    	Performance.setString(3, this.getKPIs()); // Assuming there is a column named 'id' for the WHERE clause
	    	Performance.setString(4, this.getRate());
	    	Performance.setString(5, this.getComm());
	    	Performance.setInt(6, inputPerformance_Id);
	       
	        // Execute the update
	        int rowsAffected = Performance.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data!","After update",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputPerformance_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to delete data
	    String sql = "DELETE FROM Performance WHERE Performance_Id=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputPerformance_Id); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	}


