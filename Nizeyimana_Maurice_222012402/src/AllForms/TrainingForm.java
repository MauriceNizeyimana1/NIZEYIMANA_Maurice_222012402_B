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


import AllSetters.Training;

public class TrainingForm implements ActionListener{
	JFrame frame;
	JLabel Train_Id_lb=new JLabel("Training_Id");
	JLabel Employ_Id_lb=new JLabel("Employee_Id");
	JLabel Train_Type_lb=new JLabel("Training_Type");
	JLabel Trainn_lb=new JLabel("Trainner");
	JLabel Durat_lb=new JLabel("Duration");
	JLabel Comple_Status_lb=new JLabel("Completion_Status");
	
	JTextField Train_Id_txf=new JTextField();
	JTextField Employ_Id_txf=new JTextField();
    JTextField Train_Type_txf=new JTextField();
    JTextField Trainn_txf= new JTextField();
    JTextField Durat_txf=new JTextField();
    JTextField Comple_Status_txf=new JTextField();
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();


    public  TrainingForm() {
    	setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
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
    	Train_Id_lb.setBounds(10, 10, 200, 30);
    	Employ_Id_lb.setBounds(10, 50, 200, 30);
    	Train_Type_lb.setBounds(10, 90, 200, 30);
    	Trainn_lb.setBounds(10, 130, 200, 30);
    	Durat_lb.setBounds(10, 170, 200, 30);
    	Comple_Status_lb.setBounds(10,210,200,30);
    	 
    	Train_Id_txf.setBounds(200, 10, 150, 30);
    	Employ_Id_txf.setBounds(200, 50, 150, 30);
    	Train_Type_txf.setBounds(200, 90, 150, 30);
    	Trainn_txf.setBounds(200, 130, 150, 30);
    	Durat_txf.setBounds(200, 170, 150, 30);
    	Comple_Status_txf.setBounds(200,210,150,30);
    	 
    	 
    	 insert_btn.setBounds(10, 300, 85, 30);
         read_btn.setBounds(100, 300, 85, 30);
         update_btn.setBounds(190, 300, 85, 30);
         delete_btn.setBounds(280, 300, 85, 30);
         
         table.setBounds(500, 10, 600, 240);
     	}
    
    private void setFontForAll() {
    	 Font fontLabel = new Font("Georgia", Font.BOLD, 18);
    	 Train_Id_lb.setFont(fontLabel);
    	 Employ_Id_lb.setFont(fontLabel);
    	 Train_Type_lb.setFont(fontLabel);
    	 Trainn_lb.setFont(fontLabel);
    	 Durat_lb.setFont(fontLabel);
    	 Comple_Status_lb.setFont(fontLabel);
    	 
    	Font fontText = new Font("Georgia", Font.BOLD, 18);
    	Train_Id_txf.setFont(fontText);
    	Employ_Id_txf.setFont(fontText);
    	Train_Type_txf.setFont(fontText);
    	Trainn_txf.setFont(fontText);
    	Durat_txf.setFont(fontText);
    	Comple_Status_txf.setFont(fontText);
      
        Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
        insert_btn.setFont(fontButtonItalic);
        read_btn.setFont(fontButtonItalic);
        update_btn.setFont(fontButtonItalic);
        delete_btn.setFont(fontButtonItalic);
    }
    private void addComponentToFrame() {
    	frame.add(Train_Id_lb);
        frame.add(Employ_Id_lb);
        frame.add(Train_Type_lb);
        frame.add(Trainn_lb);
        frame.add(Durat_lb);	
        frame.add(Comple_Status_lb);	
      
        frame.add(Train_Id_txf);
        frame.add(Employ_Id_txf);
        frame.add(Train_Type_txf);
        frame.add(Trainn_txf);
        frame.add(Durat_txf);
        frame.add(Comple_Status_txf);
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    
    private void actionEvent() {
        insert_btn.addActionListener((ActionListener) this);
        read_btn.addActionListener((ActionListener) this);
        update_btn.addActionListener((ActionListener) this);
        delete_btn.addActionListener((ActionListener) this);
        }
    @Override
	public void actionPerformed(ActionEvent e) {
    	Training Training=new Training();
			if(e.getSource()==insert_btn) {
				Training.setEmploy_Id(Employ_Id_txf.getText());
				Training.setTrain_Type(Train_Type_txf.getText());
				Training.setTrainn(Trainn_txf.getText());
				Training.setDurat(Durat_txf.getText());
				Training.setComple_Status(Comple_Status_txf.getText());
				Training.insertData();
			    }
    
			else if (e.getSource() == read_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(1);
	            model.addColumn("Training_Id");
	            model.addColumn("Employee_Id");
	            model.addColumn("Training_Type");
	            model.addColumn("Trainner");
	            model.addColumn("Duration");
	            model.addColumn("Completion_Status");
	           
	            ResultSet resultSet =Training.viewData();
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
				int id=Integer.parseInt(Train_Id_txf.getText());
				Training.setEmploy_Id(Employ_Id_txf.getText());
				Training.setTrain_Type(Train_Type_txf.getText());
				Training.setTrainn(Trainn_txf.getText());
				Training.setDurat(Durat_txf.getText());
				Training.setComple_Status(Comple_Status_txf.getText());
				Training.update(id);
				}
                else {
				int id=Integer.parseInt(Train_Id_txf.getText());
				Training.delete(id);
				}
			}
                
		public static void main(String[] args) {
			TrainingForm TrainingForm= new TrainingForm();
		System.out.println(TrainingForm);

}
		}

