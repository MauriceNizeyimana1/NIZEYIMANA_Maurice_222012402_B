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

public class EmployeeForm implements ActionListener{
	JFrame frame;
	JLabel emp_id_lb=new JLabel("Employee_id");
	JLabel fname_lb=new JLabel("First Name");
	JLabel lname_lb=new JLabel("Last Name");
	JLabel  dob_lb=new JLabel("Date OF birth");
	JLabel  pos_lb=new JLabel("Position");
	JLabel  dep_lb=new JLabel("Department");
	JLabel  cont_info_lb=new JLabel("Contact Information");
	
	JTextField emp_id_txf=new JTextField();
	JTextField fname_txf=new JTextField();
    JTextField lname_txf=new JTextField();
    JTextField dob_txf= new JTextField();
    JTextField  pos_txf=new JTextField();
    JTextField dep_txf=new JTextField();
    JTextField cont_info_txf=new JTextField();
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();


    public  EmployeeForm() {
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
        frame.setTitle(" Employee Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	 emp_id_lb.setBounds(10, 10, 200, 30);
    	 fname_lb.setBounds(10, 50, 200, 30);
    	 lname_lb.setBounds(10, 90, 200, 30);
    	 dob_lb.setBounds(10, 130, 200, 30);
    	 pos_lb.setBounds(10, 170, 200, 30);
    	 dep_lb.setBounds(10,210,200,30);
    	 cont_info_lb.setBounds(10,250,200,30);
    	 
    	 emp_id_txf.setBounds(200, 10, 150, 30);
    	 fname_txf.setBounds(200, 50, 150, 30);
    	 lname_txf.setBounds(200, 90, 150, 30);
    	 dob_txf.setBounds(200, 130, 150, 30);
    	 pos_txf.setBounds(200, 170, 150, 30);
    	 dep_txf.setBounds(200,210,150,30);
    	 cont_info_txf.setBounds(200,250,150,30);
    	 
    	 insert_btn.setBounds(10, 300, 85, 30);
         read_btn.setBounds(100, 300, 85, 30);
         update_btn.setBounds(190, 300, 85, 30);
         delete_btn.setBounds(280, 300, 85, 30);
         
         table.setBounds(500, 10, 600, 240);
     	}
    
    private void setFontForAll() {
    	 Font fontLabel = new Font("Georgia", Font.BOLD, 18);
    	 emp_id_lb.setFont(fontLabel);
    	 fname_lb.setFont(fontLabel);
    	 lname_lb.setFont(fontLabel);
    	 dob_lb.setFont(fontLabel);
    	 pos_lb.setFont(fontLabel);
    	 dep_lb.setFont(fontLabel);
    	 cont_info_lb.setFont(fontLabel);
    	
    	
    	Font fontText = new Font("Georgia", Font.BOLD, 18);
        emp_id_txf.setFont(fontText);
        fname_txf.setFont(fontText);
        lname_txf.setFont(fontText);
        dob_txf.setFont(fontText);
        pos_txf.setFont(fontText);
        dep_txf.setFont(fontText);
        cont_info_txf.setFont(fontText);

        Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
        insert_btn.setFont(fontButtonItalic);
        read_btn.setFont(fontButtonItalic);
        update_btn.setFont(fontButtonItalic);
        delete_btn.setFont(fontButtonItalic);
    }
    private void addComponentToFrame() {
    	frame.add(emp_id_lb);
        frame.add( fname_lb);
        frame.add( lname_lb);
        frame.add( dob_lb);
        frame.add( pos_lb);	
        frame.add( dep_lb);	
        frame.add( cont_info_lb);	
    	
    	
        frame.add( emp_id_txf);
        frame.add( fname_txf);
        frame.add(lname_txf);
        frame.add(dob_txf);
        frame.add(pos_txf);
        frame.add(dep_txf);
        frame.add( cont_info_txf);

        
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    @Override
	public void actionPerformed(ActionEvent e) {
    	Employee emp=new Employee();
			if(e.getSource()==insert_btn) {
				emp.setFname(fname_txf.getText());
				emp.setLname(lname_txf.getText());
				emp.setDob(dob_txf.getText());
				emp.setPos(pos_txf.getText());
				emp.setDep(dep_txf.getText());
				emp.setCont_info(cont_info_txf.getText());
			    emp.insertData();
			    }
    
			else if (e.getSource() == read_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(1);
	            model.addColumn("Employee_id");
	            model.addColumn("First Name");
	            model.addColumn("Last Name");
	            model.addColumn("Date OF birth");
	            model.addColumn("Position");
	            model.addColumn("Department");
	            model.addColumn("Contact Information");
	           
	            ResultSet resultSet =Employee.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }}
                else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(emp_id_txf.getText());
				emp.setFname(fname_txf.getText());
				emp.setLname(lname_txf.getText());
				emp.setDob(dob_txf.getText());
				emp.setPos(pos_txf.getText());
				emp.setDep(dep_txf.getText());
				emp.setCont_info(cont_info_txf.getText());
				emp.update(id);
				}
                else {
				int id=Integer.parseInt(emp_id_txf.getText());
				emp.delete(id);
				}
			}
                
		public static void main(String[] args) {
		EmployeeForm EmployeeForm= new EmployeeForm();
		System.out.println(EmployeeForm);

}
		}

