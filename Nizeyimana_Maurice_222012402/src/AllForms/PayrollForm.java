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
import AllSetters.Payroll;

public class PayrollForm implements ActionListener {
	JFrame frame;
	JLabel  Pay_Id_lb=new JLabel("Payroll_Id");
	JLabel Empl_Id_lb=new JLabel("Employee_Id");
	JLabel Salary_lb=new JLabel("Salary");
	JLabel  Overt_lb=new JLabel("Overtime");
	JLabel  Deduct_lb=new JLabel("Deductions");
	JLabel  Net_lb=new JLabel("Net Pay");
	
	JTextField Pay_Id_txf=new JTextField();
	JTextField Empl_Id_txf=new JTextField();
    JTextField Salary_txf=new JTextField();
    JTextField Overt_txf= new JTextField();
    JTextField Deduct_txf=new JTextField();
    JTextField Net_txf=new JTextField();
   
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  PayrollForm() {
		
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
        frame.setTitle(" PayrollForm");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.GREEN);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Pay_Id_lb.setBounds(10, 10, 200, 30);
    	Empl_Id_lb.setBounds(10, 50, 200, 30);
    	Salary_lb.setBounds(10, 90, 200, 30);
    	Overt_lb.setBounds(10, 130, 200, 30);
    	Deduct_lb.setBounds(10, 170, 200, 30);
    	Net_lb.setBounds(10,210,200,30);
  	
  	 
    	Pay_Id_txf.setBounds(200, 10, 150, 30);
    	Empl_Id_txf.setBounds(200, 50, 150, 30);
    	Salary_txf.setBounds(200, 90, 150, 30);
    	Overt_txf.setBounds(200, 130, 150, 30);
    	Deduct_txf.setBounds(200, 170, 150, 30);
    	Net_txf.setBounds(200,210,150,30);
  	 
  	 
  	   insert_btn.setBounds(10, 300, 85, 30);
       read_btn.setBounds(100, 300, 85, 30);
       update_btn.setBounds(190, 300, 85, 30);
       delete_btn.setBounds(280, 300, 85, 30);
       table.setBounds(500, 10, 600, 240);
   	}
    private void setFontForAll() {
     	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
     	Pay_Id_lb.setFont(fontLabel);
     	Empl_Id_lb.setFont(fontLabel);
     	Salary_lb.setFont(fontLabel);
     	Overt_lb.setFont(fontLabel);
     	Deduct_lb.setFont(fontLabel);
     	Net_lb.setFont(fontLabel);
     	 
     	
     	
     	Font fontText = new Font("Georgia", Font.BOLD, 18);
     	Pay_Id_txf.setFont(fontText);
     	Empl_Id_txf.setFont(fontText);
     	Salary_txf.setFont(fontText);
     	Overt_txf.setFont(fontText);
     	Deduct_txf.setFont(fontText);
     	Net_txf.setFont(fontText);
         

         Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
         insert_btn.setFont(fontButtonItalic);
         read_btn.setFont(fontButtonItalic);
         update_btn.setFont(fontButtonItalic);
         delete_btn.setFont(fontButtonItalic);
     }
    private void addComponentToFrame() {
    	frame.add(Pay_Id_lb);
        frame.add(Empl_Id_lb);
        frame.add(Salary_lb);
        frame.add(Overt_lb);
        frame.add(Deduct_lb);	
        frame.add(Net_lb);	
        	
        frame.add(Pay_Id_txf);
        frame.add(Empl_Id_txf);
        frame.add(Salary_txf);
        frame.add(Overt_txf);
        frame.add(Deduct_txf);
        frame.add(Net_txf);
      
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    @Override
	public void actionPerformed(ActionEvent e) {
    	Payroll Payroll=new Payroll();
			if(e.getSource()==insert_btn) {
				Payroll.setEmpl_Id(Empl_Id_txf.getText());
				Payroll.setSalary(Salary_txf.getText());
				Payroll.setOvertime(Overt_txf.getText());
				Payroll.setDeduct(Deduct_txf.getText());
				Payroll.setNet_Pay(Net_txf.getText());
				Payroll.insertData();
			    }
    
			else if (e.getSource() == read_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(1);
	            model.addColumn("Payroll_Id");
	            model.addColumn("Employee_Id");
	            model.addColumn("Salary");
	            model.addColumn("Overtime");
	            model.addColumn("Deductions");
	            model.addColumn("Net Pay");
	           
	            ResultSet resultSet =Payroll.viewData();
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
				int id=Integer.parseInt(Pay_Id_txf.getText());
				Payroll.setEmpl_Id(Empl_Id_txf.getText());
				Payroll.setSalary(Salary_txf.getText());
				Payroll.setOvertime(Overt_txf.getText());
				Payroll.setDeduct(Deduct_txf.getText());
				Payroll.setNet_Pay(Net_txf.getText());
				Payroll.update(id);
				}
                else {
				int id=Integer.parseInt(Pay_Id_txf.getText());
				Payroll.delete(id);
                }
			}
                
		public static void main(String[] args) {
			PayrollForm PayrollForm= new PayrollForm();
		System.out.println(PayrollForm);

}
		}



