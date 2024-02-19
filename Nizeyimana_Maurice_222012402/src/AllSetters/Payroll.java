package AllSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Payroll {

	private int Pay_Id;
	private String Empl_Id;
	private String Salary;
	private String Overtime;
	private String Deduct;
	private String Net_Pay;
	
	public Payroll(int Pay_Id,String Empl_Id, String Salary,String Overtime,String Deduct,String Net_Pay) {
		super();
		this.Pay_Id=Pay_Id;
		this.Empl_Id=Empl_Id;
		this.Salary=Salary;
		this.Overtime=Overtime;
		this.Deduct=Deduct;
		this.Net_Pay= Net_Pay;
	}

	public Payroll() {
		// TODO Auto-generated constructor stub
	}
	
	public int getPay_Id() {
		return Pay_Id;
	}

	public void setPay_Id(int pay_Id) {
		Pay_Id = pay_Id;
	}

	public String getEmpl_Id() {
		return Empl_Id;
	}

	public void setEmpl_Id(String empl_Id) {
		Empl_Id = empl_Id;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public String getOvertime() {
		return Overtime;
	}

	public void setOvertime(String overtime) {
		Overtime = overtime;
	}

	public String getDeduct() {
		return Deduct;
	}

	public void setDeduct(String deduct) {
		Deduct = deduct;
	}

	public String getNet_Pay() {
		return Net_Pay;
	}

	public void setNet_Pay(String net_Pay) {
		Net_Pay = net_Pay;
	}

	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to insert data
	    String sql = "INSERT INTO Payroll (Employee_Id, Salary, Overtime, Deductions, Net_Pay) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setString(1, this.Empl_Id);
	        preparedStatement.setString(2, this.Salary);
	        preparedStatement.setString(3, this.Overtime);
	        preparedStatement.setString(4, this.Deduct);
	        preparedStatement.setString(5, this.Net_Pay);
	       
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
			    String sql = "SELECT * FROM Payroll";

			    try {
			        Connection con = DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}


	public void update(int inputPayroll_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to update data
	    String sql = "UPDATE Payroll SET  Employee_Id=?, Salary=?, Overtime=?, Deductions=?, Net_Pay=?WHERE Payroll_Id=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement Payroll = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	Payroll.setString(1, this.getEmpl_Id());
	    	Payroll.setString(2, this.getSalary());
	    	Payroll.setString(3, this.getOvertime()); // Assuming there is a column named 'id' for the WHERE clause
	    	Payroll.setString(4, this.getDeduct());
	    	Payroll.setString(5, this.getNet_Pay());
	        Payroll.setInt(6, inputPayroll_Id);
	       
	        // Execute the update
	        int rowsAffected = Payroll.executeUpdate();

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
	public void delete(int inputPayroll_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to delete data
	    String sql = "DELETE FROM Payroll WHERE Payroll_Id=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputPayroll_Id); // Assuming there is a column named 'id' for the WHERE clause

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
	




