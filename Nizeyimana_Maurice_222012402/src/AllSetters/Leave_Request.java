package AllSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Leave_Request {
	private int Request_Id;
	private String Emp_Id;
	private String Leave_Type;
	private String Start_Date;
	private String  End_Date;
	private String Status;

	public Leave_Request(int Request_Id,String Emp_Id,String Leave_Type,String Start_Date,String End_Date,String Status) {
		super();
		this.Request_Id=Request_Id;
		this.Emp_Id= Emp_Id;
		this.Leave_Type=Leave_Type;
		this.Start_Date=Start_Date;
		this.End_Date=End_Date;
		this.Status= Status;
	}
	
	public Leave_Request() {
		// TODO Auto-generated constructor stub
	}

	public int getRequest_Id() {
		return Request_Id;
	}
   public void setRequest_Id(int reque_Id) {
		Request_Id = reque_Id;
	}
   public String getEmp_Id() {
		return Emp_Id;
   }
   public void setEmp_Id(String emp_Id) {
		Emp_Id = emp_Id;
	}

   public String getLeave_Type() {
		return Leave_Type;
	}

   public void setLeave_Type(String leave_Type) {
		Leave_Type = leave_Type;
	}

   public String getStart_Date() {
		return Start_Date;
	}


	public void setStart_Date(String start_Date) {
		Start_Date = start_Date;
	}


	public String getEnd_Date() {
		return End_Date;
	}


	public void setEnd_Date(String end_Date) {
		End_Date = end_Date;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to insert data
	    String sql = "INSERT INTO Leave_Request (Employee_Id, Leave_Type, Start_Date, End_Date, Status) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setString(1, this.Emp_Id);
	        preparedStatement.setString(2, this.Leave_Type);
	        preparedStatement.setString(3, this.Start_Date);
	        preparedStatement.setString(4, this.End_Date);
	        preparedStatement.setString(5, this.Status);
	      
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
			    String sql = "SELECT * FROM Leave_Request";

			    try {
			        Connection con = DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}

	public void update(int inputRequest_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to update data
	    String sql = "UPDATE Leave_Request SET  Employee_Id=?, Leave_Type=?, Start_Date=?, End_Date=?, Status=? WHERE Request_Id=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement Request = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	Request.setString(1, this.getEmp_Id());
	    	Request.setString(2, this.getLeave_Type());
	    	Request.setString(3, this.getStart_Date()); // Assuming there is a column named 'id' for the WHERE clause
	    	Request.setString(4, this.getEnd_Date());
	    	Request.setString(5, this.getStatus());
	    	Request.setInt(6, inputRequest_Id);
	       
	        // Execute the update
	        int rowsAffected = Request.executeUpdate();

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
	public void delete(int inputRequest_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to delete data
	    String sql = "DELETE FROM Leave_Request WHERE Request_Id=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputRequest_id); // Assuming there is a column named 'id' for the WHERE clause

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



