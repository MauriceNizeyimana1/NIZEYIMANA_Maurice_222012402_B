package AllForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AllSetters.Attendance;
import AllSetters.Employee;

public class AttendanceForm implements ActionListener{
	JFrame frame;
	JLabel attend_id_lb=new JLabel("Attendance Id");
	JLabel Emp_id_lb=new JLabel("Employee Id ");
	JLabel DATE_lb=new JLabel("Date");
	JLabel Clock_in_lb=new JLabel("ClockIn Time");
	JLabel Clock_out_lb=new JLabel("Clock Out Time");
	JLabel Total_Hrs_lb=new JLabel("Total Hours");
	
	
	JTextField attend_id_txf=new JTextField();
	JTextField Emp_id_txf=new JTextField();
    JTextField DATE_txf=new JTextField();
    JTextField Clock_in_txf= new JTextField();
    JTextField Clock_out_txf=new JTextField();
    JTextField Total_Hrs_txf=new JTextField();
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();
	

    public  AttendanceForm() {
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
        frame.setTitle(" Attendance Form");
        frame.setBounds(400,250,600,400);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	 attend_id_lb.setBounds(10, 10, 200, 30);
    	 Emp_id_lb.setBounds(10, 50, 200, 30);
    	 DATE_lb.setBounds(10, 90, 200, 30);
    	 Clock_in_lb.setBounds(10, 130, 200, 30);
    	 Clock_out_lb.setBounds(10, 170, 200, 30);
    	 Total_Hrs_lb.setBounds(10,210,200,30);
   	
   	 
    	 attend_id_txf.setBounds(200, 10, 150, 30);
    	 Emp_id_txf.setBounds(200, 50, 150, 30);
    	 DATE_txf.setBounds(200, 90, 150, 30);
    	 Clock_in_txf.setBounds(200, 130, 150, 30);
    	 Clock_out_txf.setBounds(200, 170, 150, 30);
    	 Total_Hrs_txf.setBounds(200,210,150,30);
   	 
   	 
   	    insert_btn.setBounds(10, 300, 85, 30);
        read_btn.setBounds(100, 300, 85, 30);
        update_btn.setBounds(190, 300, 85, 30);
        delete_btn.setBounds(280, 300, 85, 30);
        table.setBounds(500, 10, 600, 240);
        
        }
    private void setFontForAll() {
   	    Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	    attend_id_lb.setFont(fontLabel);
   	    Emp_id_lb.setFont(fontLabel);
   	    DATE_lb.setFont(fontLabel);
        Clock_in_lb.setFont(fontLabel);
        Clock_out_lb.setFont(fontLabel);
        Total_Hrs_lb.setFont(fontLabel);
   	 
   	
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	attend_id_txf.setFont(fontText);
    Emp_id_txf.setFont(fontText);
    DATE_txf.setFont(fontText);
    Clock_in_txf.setFont(fontText);
    Clock_out_txf.setFont(fontText);
    Total_Hrs_txf.setFont(fontText);
       

       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(attend_id_lb);
        frame.add(Emp_id_lb);
        frame.add(DATE_lb);
        frame.add(Clock_in_lb);
        frame.add(Clock_out_lb);	
        frame.add(Total_Hrs_lb);	
       	
    	
    	
        frame.add(attend_id_txf);
        frame.add(Emp_id_txf);
        frame.add(DATE_txf);
        frame.add(Clock_in_txf);
        frame.add(Clock_out_txf);
        frame.add(Total_Hrs_txf);
       

        
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);   
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Attendance Att =new Attendance();
		if(e.getSource()==insert_btn) {
			Att.setEmp_id(Emp_id_txf.getText());
			Att.setDATE(DATE_txf.getText());
			Att.setClock_in(Clock_in_txf.getText());
			Att.setClock_out(Clock_out_txf.getText());
			Att.setTotal_Hrs(Total_Hrs_txf.getText());
			Att.insertData();
	    }   
	

		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Attendance Id");
            model.addColumn("Employee Id");
            model.addColumn("Date");
            model.addColumn("ClockIn Time");
            model.addColumn("Clock Out Time");
            model.addColumn("Total Hours");
            
            ResultSet resultSet =Attendance.viewData();
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
			int id=Integer.parseInt(attend_id_txf.getText());
			Att.setEmp_id(Emp_id_txf.getText());
			Att.setDATE(DATE_txf.getText());
			Att.setClock_in(Clock_in_txf.getText());
			Att.setClock_out(Clock_out_txf.getText());
			Att.setTotal_Hrs(Total_Hrs_txf.getText());
			Att.update(id);
			}
            else {
			int id=Integer.parseInt(attend_id_txf.getText());
			Att.delete(id);
			}
		}

            
	public static void main(String[] args) {
	AttendanceForm AttForm= new AttendanceForm();
	System.out.println(AttForm);

}
		
	}

    
    
