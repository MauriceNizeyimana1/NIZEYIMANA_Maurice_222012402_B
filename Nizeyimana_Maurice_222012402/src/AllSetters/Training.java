package AllSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Training {
	private int Train_Id;
	private String Employ_Id;
	private String Train_Type;
	private String Trainn;
	private String Durat;
	private String Comple_Status;
	public Training() {
		//constructor
	}
	public Training(int Train_Id,String Employ_Id,String Train_Type,String Trainn,String Durat,String Comple_Status) {
		super();
		this.Train_Id=Train_Id;
		this.Employ_Id= Employ_Id;
		this.Train_Type=Train_Type;
		this.Trainn=Trainn;
		this.Durat=Durat;
		this.Comple_Status=Comple_Status;
		
	}
	
	public int getTrain_Id() {
		return Train_Id;
	}
	public void setTrain_Id(int train_Id) {
		Train_Id = train_Id;
	}
	public String getEmploy_Id() {
		return Employ_Id;
	}
	public void setEmploy_Id(String employ_Id) {
		Employ_Id = employ_Id;
	}
	public String getTrain_Type() {
		return Train_Type;
	}
	public void setTrain_Type(String train_Type) {
		Train_Type = train_Type;
	}
	public String getTrainn() {
		return Trainn;
	}
	public void setTrainn(String trainn) {
		Trainn = trainn;
	}
	public String getDurat() {
		return Durat;
	}
	public void setDurat(String durat) {
		Durat = durat;
	}
	public String getComple_Status() {
		return Comple_Status;
	}
	public void setComple_Status(String comple_Status) {
		Comple_Status = comple_Status;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to insert data
	    String sql = "INSERT INTO Training (Employee_Id, Training_Type, Trainner, Duration, Completion_Status) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setString(1, this.Employ_Id);
	        preparedStatement.setString(2, this.Train_Type);
	        preparedStatement.setString(3, this.Trainn);  
	        preparedStatement.setString(4, this.Durat);
	        preparedStatement.setString(5, this.Comple_Status);
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
			    String sql = "SELECT * FROM Training ";

			    try {
			        Connection con = DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}


	public void update(int inputTrain_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to update data
	    String sql = "UPDATE Training SET Employee_Id=?, Training_Type=?, Trainner=?, Duration=?, Completion_Status=? WHERE Training_Id=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement Training = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	 Training.setString(1, this.getEmploy_Id());
	    	 Training.setString(2, this.getTrain_Type());
	         Training.setString(3, this.getTrainn()); // Assuming there is a column named 'id' for the WHERE clause
	         Training.setString(4, this.getDurat());
	         Training.setString(5, this.getComple_Status());
	         Training.setInt(6, inputTrain_Id);
	       
	        // Execute the update
	        int rowsAffected = Training.executeUpdate();

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
	public void delete(int inputTraining_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/labor_management";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Training WHERE Training_Id=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputTraining_Id); // Assuming there is a column named 'id' for the WHERE clause

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
