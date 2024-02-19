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
import AllSetters.MyPerformance;

public class PerformanceForm implements ActionListener{

	JFrame frame;
	JLabel Perfrm_Id_lb=new JLabel("Perfrm_Id");
	JLabel Empll_Id_lb=new JLabel("Empll_Id");
	JLabel Evalpd_lb=new JLabel("Evalpd");
	JLabel KPIs_lb=new JLabel("KPIs");
	JLabel Rate_lb=new JLabel("Rate");
	JLabel Comm_lb=new JLabel("Comm");
	
	JTextField Perfrm_Id_txf=new JTextField();
	JTextField Empll_Id_txf=new JTextField();
    JTextField Evalpd_txf=new JTextField();
    JTextField KPIs_txf= new JTextField();
    JTextField Rate_txf=new JTextField();
    JTextField Comm_txf=new JTextField();
   
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  PerformanceForm() {
		
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
        frame.setTitle("PerformanceForm");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	 Perfrm_Id_lb.setBounds(10, 10, 200, 30);
    	 Empll_Id_lb.setBounds(10, 50, 200, 30);
    	 Evalpd_lb.setBounds(10, 90, 200, 30);
    	 KPIs_lb.setBounds(10, 130, 200, 30);
    	 Rate_lb.setBounds(10, 170, 200, 30);
    	 Comm_lb.setBounds(10,210,200,30);
  	
  	 
    	 Perfrm_Id_txf.setBounds(200, 10, 150, 30);
    	 Empll_Id_txf.setBounds(200, 50, 150, 30);
    	 Evalpd_txf.setBounds(200, 90, 150, 30);
    	 KPIs_txf.setBounds(200, 130, 150, 30);
    	 Rate_txf.setBounds(200, 170, 150, 30);
    	 Comm_txf.setBounds(200,210,150,30);
  	 
  	 
  	   insert_btn.setBounds(10, 300, 85, 30);
       read_btn.setBounds(100, 300, 85, 30);
       update_btn.setBounds(190, 300, 85, 30);
       delete_btn.setBounds(280, 300, 85, 30);
       
       table.setBounds(500, 10, 750, 240);
   	}
    private void setFontForAll() {
     	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
     	Perfrm_Id_lb.setFont(fontLabel);
     	Empll_Id_lb.setFont(fontLabel);
     	Evalpd_lb.setFont(fontLabel);
     	KPIs_lb.setFont(fontLabel);
     	Rate_lb.setFont(fontLabel);
     	Comm_lb.setFont(fontLabel);
     	 
     	
     	
     	Font fontText = new Font("Georgia", Font.BOLD, 18);
     	Perfrm_Id_txf.setFont(fontText);
     	Empll_Id_txf.setFont(fontText);
     	Evalpd_txf.setFont(fontText);
     	KPIs_txf.setFont(fontText);
     	Rate_txf.setFont(fontText);
     	Comm_txf.setFont(fontText);
         

         Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
         insert_btn.setFont(fontButtonItalic);
         read_btn.setFont(fontButtonItalic);
         update_btn.setFont(fontButtonItalic);
         delete_btn.setFont(fontButtonItalic);
     }
    private void addComponentToFrame() {
    	frame.add(Perfrm_Id_lb);
        frame.add(Empll_Id_lb);
        frame.add(Evalpd_lb);
        frame.add(KPIs_lb);
        frame.add(Rate_lb);	
        frame.add(Comm_lb);	
        	
        frame.add(Perfrm_Id_txf);
        frame.add(Empll_Id_txf);
        frame.add(Evalpd_txf);
        frame.add(KPIs_txf);
        frame.add(Rate_txf);
        frame.add(Comm_txf);
      
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    @Override
	public void actionPerformed(ActionEvent e) {
    	MyPerformance Performance=new MyPerformance();
			if(e.getSource()==insert_btn) {
				Performance.setEmpll_Id(Empll_Id_txf.getText());
				Performance.setEvalpd(Evalpd_txf.getText());
				Performance.setKPIs(KPIs_txf.getText());
				Performance.setRate(Rate_txf.getText());
				Performance.setComm(Comm_txf.getText());
				Performance.insertData();
			    }
    
			else if (e.getSource() == read_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(1);
	            model.addColumn("Perfrm_Id");
	            model.addColumn("Empll_Id");
	            model.addColumn("Evalpd");
	            model.addColumn("KPIs");
	            model.addColumn("Rate");
	            model.addColumn("Comm");
	 
	            ResultSet resultSet =MyPerformance.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(6)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            }
                else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(Perfrm_Id_txf.getText());
				Performance.setEmpll_Id(Empll_Id_txf.getText());
				Performance.setEvalpd(Evalpd_txf.getText());
				Performance.setKPIs(KPIs_txf.getText());
				Performance.setRate(Rate_txf.getText());
				Performance.setComm(Comm_txf.getText());
				Performance.update(id);
				}
                else {
				int id=Integer.parseInt(Perfrm_Id_txf.getText());
				Performance.delete(id);
				}
               }
		public static void main(String[] args) {
	    PerformanceForm PerformanceForm= new PerformanceForm();
		System.out.println(PerformanceForm);

}
		}


