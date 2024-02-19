package AllSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Employee {
	private int emp_id;
	private String fname;
	private String lname;
	private String dob;
	private String pos;
	private String dep;
	private String cont_info;
	public Employee() {
		//constructor
	}

	public Employee(int emp_id,String fname,String lname,String dob,String pos,String dep,String cont_info) {
		super();
		this.emp_id=emp_id;
		this.fname= fname;
		this.lname=lname;
		this.dob=dob;
		this.pos=pos;
		this.dep=dep;
		this.cont_info=cont_info;
	}
	
public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getCont_info() {
		return cont_info;
	}

	public void setCont_info(String cont_info) {
		this.cont_info = cont_info;
	}

public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/labor_management";
    String user = "222012402";
    String password = "222012402";

    // SQL query to insert data
    String sql = "INSERT INTO Employee (First_Name, Last_Name, Date_Of_Birth, Position, Department, Contact_Information) VALUES (?,?,?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       
        preparedStatement.setString(1, this.fname);
        preparedStatement.setString(2, this.lname);
        preparedStatement.setString(3, this.dob);
        preparedStatement.setString(4, this.pos);
        preparedStatement.setString(5, this.dep);
        preparedStatement.setString(6, this.cont_info);
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
		    String sql = "SELECT * FROM Employee";

		    try {
		        Connection con = DriverManager.getConnection(host, user, password);
		        PreparedStatement preparedStatement = con.prepareStatement(sql);
		        return preparedStatement.executeQuery();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}

public void update(int inputEmployee_Id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/labor_management";
    String user = "222012402";
    String password = "222012402";

    // SQL query to update data
    String sql = "UPDATE Employee SET  First_Name=?, Last_Name=?, Date_Of_Birth=?, Position=?, Department=?, Contact_Information=? WHERE Employee_Id=?";

    try (
        // Establish the co
        Connection co = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement emp = co.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	 emp.setString(1, this.getFname());
         emp.setString(2, this.getLname());
         emp.setString(3, this.getDob()); // Assuming there is a column named 'id' for the WHERE clause
         emp.setString(4, this.getPos());
         emp.setString(5, this.getDep());
         emp.setString(6, this.getCont_info());
         emp.setInt(7, inputEmployee_Id);
       
        // Execute the update
        int rowsAffected = emp.executeUpdate();

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
public void delete(int inputemp_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/labor_management";
    String user = "222012402";
    String password = "222012402";

    // SQL query to delete data
    String sql = "DELETE FROM Employee WHERE Employee_Id=?";

    try (
        // Establish the 
        Connection co = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = co.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputemp_id); // Assuming there is a column named 'id' for the WHERE clause

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
