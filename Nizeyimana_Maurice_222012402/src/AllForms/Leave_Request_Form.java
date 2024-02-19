package AllForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AllSetters.Employee;
import AllSetters.Leave_Request;


public class Leave_Request_Form implements ActionListener {
	JFrame frame;
	JLabel Request_Id_lb=new JLabel("Request_Id");
	JLabel Emp_id_lb=new JLabel("Employee_Id");
	JLabel leave_Type_lb=new JLabel("leave_Type");
	JLabel  Start_Date_lb=new JLabel("Start_Date");
	JLabel  End_Date_lb=new JLabel("End_Date");
	JLabel  Status_lb=new JLabel(" Status");
	
	
	JTextField Request_Id_txf=new JTextField();
	JTextField Emp_id_txf=new JTextField();
    JTextField leave_Type_txf=new JTextField();
    JTextField Start_Date_txf= new JTextField();
    JTextField End_Date_txf=new JTextField();
    JTextField Status_txf=new JTextField();
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();
    
	public Leave_Request_Form() {
		setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }
    private void actionEvent() {
        insert_btn.addActionListener((ActionListener) this);
        read_btn.addActionListener((ActionListener) this);
        update_btn.addActionListener((ActionListener) this);
        delete_btn.addActionListener((ActionListener) this);
        }
    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Leave_RequestForm");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Request_Id_lb.setBounds(10, 10, 200, 30);
    	Emp_id_lb.setBounds(10, 50, 200, 30);
    	leave_Type_lb.setBounds(10, 90, 200, 30);
    	Start_Date_lb.setBounds(10, 130, 200, 30);
   	    End_Date_lb.setBounds(10, 170, 200, 30);
   	    Status_lb.setBounds(10,210,200,30);
  	
  	 
   	 Request_Id_txf.setBounds(200, 10, 150, 30);
   	 Emp_id_txf.setBounds(200, 50, 150, 30);
   	 leave_Type_txf.setBounds(200, 90, 150, 30);
   	 Start_Date_txf.setBounds(200, 130, 150, 30);
   	 End_Date_txf.setBounds(200, 170, 150, 30);
   	 Status_txf.setBounds(200,210,150,30);
  	 
  	 
  	   insert_btn.setBounds(10, 300, 85, 30);
       read_btn.setBounds(100, 300, 85, 30);
       update_btn.setBounds(190, 300, 85, 30);
       delete_btn.setBounds(280, 300, 85, 30);
       table.setBounds(500, 10, 600, 240);
   	}
    private void setFontForAll() {
      	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
      	Request_Id_lb.setFont(fontLabel);
      	Emp_id_lb.setFont(fontLabel);
      	leave_Type_lb.setFont(fontLabel);
      	Start_Date_lb.setFont(fontLabel);
      	End_Date_lb.setFont(fontLabel);
      	Status_lb.setFont(fontLabel);
      	 
      	
      	
      	Font fontText = new Font("Georgia", Font.BOLD, 18);
      	Request_Id_txf.setFont(fontText);
      	Emp_id_txf.setFont(fontText);
      	leave_Type_txf.setFont(fontText);
      	Start_Date_txf.setFont(fontText);
      	End_Date_txf.setFont(fontText);
      	Status_txf.setFont(fontText);
          

          Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
          insert_btn.setFont(fontButtonItalic);
          read_btn.setFont(fontButtonItalic);
          update_btn.setFont(fontButtonItalic);
          delete_btn.setFont(fontButtonItalic);
      }
    private void addComponentToFrame() {
    	frame.add(Request_Id_lb);
        frame.add(Emp_id_lb);
        frame.add(leave_Type_lb);
        frame.add(Start_Date_lb);
        frame.add(End_Date_lb);	
        frame.add(Status_lb);	
       	
    	
    	
        frame.add(Request_Id_txf);
        frame.add(Emp_id_txf);
        frame.add(leave_Type_txf);
        frame.add(Start_Date_txf);
        frame.add(End_Date_txf);
        frame.add(Status_txf);
       

        
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    @Override
	public void actionPerformed(ActionEvent e) {
    	Leave_Request Request=new Leave_Request();
			if(e.getSource()==insert_btn) {
				Request.setEmp_Id(Emp_id_txf.getText());
				Request.setLeave_Type(leave_Type_txf.getText());
				Request.setStart_Date(Start_Date_txf.getText());
				Request.setEnd_Date(End_Date_txf.getText());
				Request.setStatus(Status_txf.getText());
				Request.insertData();
			    }
    
			else if (e.getSource() == read_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(1);
	            model.addColumn("Request_Id");
	            model.addColumn("Employee_Id");
	            model.addColumn("leave_Type");
	            model.addColumn("Start_Date");
	            model.addColumn("End_Date");
	            model.addColumn("Status");
	           
	            ResultSet resultSet =Leave_Request.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
			}
                else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(Request_Id_txf.getText());
				Request.setEmp_Id(Emp_id_txf.getText());
				Request.setLeave_Type(leave_Type_txf.getText());
				Request.setStart_Date(Start_Date_txf.getText());
				Request.setEnd_Date(End_Date_txf.getText());
				Request.setStatus(Status_txf.getText());
				Request.update(id);
				}
                else {
				int id=Integer.parseInt(Request_Id_txf.getText());
				Request.delete(id);
              }
			}
		public static void main(String[] args) {
			Leave_Request_Form Leave_RequestForm= new Leave_Request_Form();
		System.out.println(Leave_RequestForm);

}
		}


