package AllSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Attendance {
	private String Emp_id;
	private String DATE;
	private String Clock_in;
	private String Clock_out;
	private String Total_Hrs;
	

	public Attendance() {
		// CONSTRUCTOR
	}

	
	
public Attendance(int attend_id, String emp_id, String dATE, String clock_in, String clock_out, String total_Hrs) {
		super();
		this.Emp_id = emp_id;
		this.DATE = dATE;
		this.Clock_in = clock_in;
		this.Clock_out = clock_out;
		this.Total_Hrs = total_Hrs;
	}



public String getEmp_id() {
	return Emp_id;
}



public void setEmp_id(String emp_id) {
	Emp_id = emp_id;
}



public String getDATE() {
	return DATE;
}



public void setDATE(String dATE) {
	DATE = dATE;
}



public String getClock_in() {
	return Clock_in;
}



public void setClock_in(String clock_in) {
	Clock_in = clock_in;
}



public String getClock_out() {
	return Clock_out;
}



public void setClock_out(String clock_out) {
	Clock_out = clock_out;
}



public String getTotal_Hrs() {
	return Total_Hrs;
}



public void setTotal_Hrs(String total_Hrs) {
	Total_Hrs = total_Hrs;
}



public void makeconnection() {
}
public void insertData() {
// JDBC URL, username, and password of MySQL server
String host = "jdbc:mysql://localhost/labor_management";
String user = "root";
String password = "";

// SQL query to insert data
String sql = "INSERT INTO Attendance (Employee_ID,Date , Clock_In_Time, Clock_Out_Time, Total_Hours) VALUES (?,?,?,?,?)";

try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       

preparedStatement.setString(1, this.Emp_id);
preparedStatement.setString(2, this.DATE);
preparedStatement.setString(3, this.Clock_in);
preparedStatement.setString(4, this.Clock_out);
preparedStatement.setString(5, this.Total_Hrs);

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
    String sql = "SELECT * FROM Attendance";

    try {
        Connection con = DriverManager.getConnection(host, user, password);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        return preparedStatement.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

public void update(int inputAttendance_Id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/labor_management";
    String user = "222012402";
    String password = "222012402";

    // SQL query to update data
    String sql = "UPDATE Attendance SET Employee_Id=?,Date=?,Clock_In_Time=?,Clock_Out_Time=?, Total_Hours=? WHERE Attendance_Id=?";

    try (
        // Establish the co
        Connection co = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement Att = co.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	Att.setString(1, this.getEmp_id());
    	Att.setString(2, this.getDATE());
    	Att.setString(3, this.getClock_in()); // Assuming there is a column named 'id' for the WHERE clause
    	Att.setString(4, this.getClock_out());
    	Att.setString(5, this.getTotal_Hrs());
    	
        Att.setInt(6, inputAttendance_Id);
        // Execute the update
        int rowsAffected = Att.executeUpdate();

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
    public void delete(int inputattend_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/labor_management";
    String user = "222012402";
    String password = "222012402";

    // SQL query to delete data
    String sql = "DELETE FROM Attendance WHERE Attendance_Id=?";

    try (
        // Establish the 
        Connection co = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = co.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputattend_id); // Assuming there is a column named 'id' for the WHERE clause

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
    }}



