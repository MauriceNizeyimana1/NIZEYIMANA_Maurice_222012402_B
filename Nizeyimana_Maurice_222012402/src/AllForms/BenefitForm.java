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
import  AllSetters.MyBenefits;


public class BenefitForm implements ActionListener {
	JFrame frame;
	JLabel  Ben_Id_lb=new JLabel("Benefit_Id");
	JLabel  Employee_Id_lb=new JLabel("Employee_Id");
	JLabel  Health_Ins_lb=new JLabel("Health_Insurance");
	JLabel  Retire_Plan_lb=new JLabel("Retirement_Plan");
	JLabel  other_Ben_lb=new JLabel("Other_Benefit");
	
	JTextField Ben_Id_txf=new JTextField();
	JTextField Employee_Id_txf=new JTextField();
    JTextField Health_Ins_txf=new JTextField();
    JTextField Retire_Plan_txf= new JTextField();
    JTextField other_Ben_txf=new JTextField();
    
   
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public BenefitForm() {
		
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
        frame.setTitle("BenefitForm");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	Ben_Id_lb.setBounds(10, 10, 200, 30);
    	Employee_Id_lb.setBounds(10, 50, 200, 30);
    	Health_Ins_lb.setBounds(10, 90, 200, 30);
    	Retire_Plan_lb.setBounds(10, 130, 200, 30);
    	other_Ben_lb.setBounds(10, 170, 200, 30);
    	
    	Ben_Id_txf.setBounds(200, 10, 150, 30);
    	Employee_Id_txf.setBounds(200, 50, 150, 30);
    	Health_Ins_txf.setBounds(200, 90, 150, 30);
    	Retire_Plan_txf.setBounds(200, 130, 150, 30);
    	other_Ben_txf.setBounds(200, 170, 150, 30);
    	
  	 
  	   insert_btn.setBounds(10, 300, 85, 30);
       read_btn.setBounds(100, 300, 85, 30);
       update_btn.setBounds(190, 300, 85, 30);
       delete_btn.setBounds(280, 300, 85, 30);
       
       table.setBounds(500, 10, 600, 240);
       }
    
    private void setFontForAll() {
     	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
     	Ben_Id_lb.setFont(fontLabel);
     	Employee_Id_lb.setFont(fontLabel);
     	Health_Ins_lb.setFont(fontLabel);
     	Retire_Plan_lb.setFont(fontLabel);
     	other_Ben_lb.setFont(fontLabel);
     	
     	Font fontText = new Font("Georgia", Font.BOLD, 18);
     	Ben_Id_txf.setFont(fontText);
     	Employee_Id_txf.setFont(fontText);
     	Health_Ins_txf.setFont(fontText);
     	Retire_Plan_txf.setFont(fontText);
     	other_Ben_txf.setFont(fontText);
     	
         

         Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
         insert_btn.setFont(fontButtonItalic);
         read_btn.setFont(fontButtonItalic);
         update_btn.setFont(fontButtonItalic);
         delete_btn.setFont(fontButtonItalic);
     }
    private void addComponentToFrame() {
    	frame.add(Ben_Id_lb);
        frame.add(Employee_Id_lb);
        frame.add(Health_Ins_lb);
        frame.add(Retire_Plan_lb);
        frame.add(other_Ben_lb);	
       	
        frame.add(Ben_Id_txf);
        frame.add(Employee_Id_txf);
        frame.add(Health_Ins_txf);
        frame.add(Retire_Plan_txf);
        frame.add(other_Ben_txf);
        
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }

@Override
public void actionPerformed(ActionEvent e) {
	MyBenefits Benefits=new MyBenefits();
		if(e.getSource()==insert_btn) {
			Benefits.setEmployee_Id(Employee_Id_txf.getText());
			Benefits.setHealth_Ins(Health_Ins_txf.getText());
			Benefits.setRetire_Plan(Retire_Plan_txf.getText());
			Benefits.setOther_Ben(other_Ben_txf.getText());
			Benefits.insertData();
		    }

		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Benefit_Id");
            model.addColumn("Employee_Id");
            model.addColumn("Health_Insurance");
            model.addColumn("Retirement_Plan");
            model.addColumn("Other_Benefit");
           
            ResultSet resultSet =MyBenefits.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
		}
            else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(Ben_Id_txf.getText());
			Benefits.setEmployee_Id(Employee_Id_txf.getText());
			Benefits.setHealth_Ins(Health_Ins_txf.getText());
			Benefits.setRetire_Plan(Retire_Plan_txf.getText());
			Benefits.setOther_Ben(other_Ben_txf.getText());
			Benefits.update(id);
			}
            else {
			int id=Integer.parseInt(Ben_Id_txf.getText());
			Benefits.delete(id);
			}

            }
	public static void main(String[] args) {
	BenefitForm BenF=new BenefitForm();
	System.out.println(BenF);	

	}}

	
