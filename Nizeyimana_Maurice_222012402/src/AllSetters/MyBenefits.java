package AllSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyBenefits {
	
	private int Ben_Id;
	private String Employee_Id;
	private String Health_Ins;
	private String Retire_Plan;
	private String Other_Ben;
	
	
	public MyBenefits(int Ben_Id,String Employee_Id,String Health_Ins,String Retire_Plan,String Other_Ben) {
		super();
		this.Ben_Id= Ben_Id;
		this.Employee_Id=Employee_Id;
		this.Health_Ins=Health_Ins;
		this.Retire_Plan=Retire_Plan;
		this.Other_Ben=Other_Ben;
		
	}


	public MyBenefits() {
		// TODO Auto-generated constructor stub
	}


	public int getBen_Id() {
		return Ben_Id;
	}


	public void setBen_Id(int ben_Id) {
		Ben_Id = ben_Id;
	}


	public String getEmployee_Id() {
		return Employee_Id;
	}


	public void setEmployee_Id(String employee_Id) {
		Employee_Id = employee_Id;
	}


	public String getHealth_Ins() {
		return Health_Ins;
	}


	public void setHealth_Ins(String health_Ins) {
		Health_Ins = health_Ins;
	}


	public String getRetire_Plan() {
		return Retire_Plan;
	}


	public void setRetire_Plan(String retire_Plan) {
		Retire_Plan = retire_Plan;
	}


	public String getother_Ben() {
		return Other_Ben;
	}


	public void setOther_Ben(String other_Ben) {
		this.Other_Ben = other_Ben;
	}
	
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/labor_management";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO Benefits (Employee_Id, Health_Insurance, Retirement_Plans, Other_Benefits) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setString(1, this.Employee_Id);
	        preparedStatement.setString(2, this.Health_Ins);
	        preparedStatement.setString(3, this.Retire_Plan);
	        preparedStatement.setString(4, this.Other_Ben);
	       
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
			    String sql = "SELECT * FROM Benefits";

			    try (Connection con = DriverManager.getConnection(host, user, password);
			         PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}


	public void update(int inputBenefit_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to update data
	    String sql = "UPDATE Benefits SET  Employee_Id=?, Health_Insurance=?, Retirement_Plans=?,Other_Benefits=? WHERE Benefit_Id=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement Benefits = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	Benefits.setString(1, this.getEmployee_Id());
	    	Benefits .setString(2, this.getHealth_Ins());
	    	Benefits.setString(3, this.getRetire_Plan()); // Assuming there is a column named 'id' for the WHERE clause
	    	Benefits.setString(4, this.getother_Ben());
	    	Benefits.setInt(5, inputBenefit_Id);
	       
	        // Execute the update
	        int rowsAffected = Benefits.executeUpdate();

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
	public void delete(int inputBenefit_Id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/labor_management";
	    String user = "222012402";
	    String password = "222012402";

	    // SQL query to delete data
	    String sql = "DELETE FROM Benefits WHERE Benefit_Id=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputBenefit_Id); // Assuming there is a column named 'id' for the WHERE clause

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


