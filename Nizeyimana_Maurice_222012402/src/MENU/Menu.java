package MENU;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import AllForms.AttendanceForm;
import AllForms.BenefitForm;
import AllForms.EmployeeForm;
import AllForms.Leave_Request_Form;
import AllForms.PayrollForm;
import AllForms.PerformanceForm;
import AllForms.TrainingForm;

public class Menu extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Attendancemenu;
    private JMenu Benefitmenu;
    private JMenu Employeemenu;
    private JMenu Leave_Requestmenu;
    private JMenu Payrollmenu;
    private JMenu Performancemenu;
    private JMenu Trainingmenu;
    private JMenu Logoutmenu;
    


	public Menu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem AttendanceItem;
    private JMenuItem BenefitItem;
    private JMenuItem EmployeeItem;
    private JMenuItem Leave_RequestItem;
    private JMenuItem PayrollItem;
    private JMenuItem PerformanceItem;
    private JMenuItem TrainingItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public Menu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Attendancemenu = new JMenu("Attendance");
        Benefitmenu = new JMenu("Benefit");
        Employeemenu= new JMenu("Employee");
        Leave_Requestmenu= new JMenu("Leave_Request");
        Payrollmenu = new JMenu("Payroll");
        Performancemenu = new JMenu("Performance");
        Trainingmenu = new JMenu("Training");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(Attendancemenu);
        AttendanceItem = new JMenuItem("AttendanceForm");
        AttendanceItem.addActionListener(this);
        
        menuBar.add(Benefitmenu);
        BenefitItem = new JMenuItem("BenefitForm");
        BenefitItem.addActionListener(this);
        
        menuBar.add(Employeemenu);
        EmployeeItem = new JMenuItem("EmployeeForm");
        EmployeeItem.addActionListener(this);
        
        menuBar.add(Leave_Requestmenu);
        Leave_RequestItem = new JMenuItem("Leave_Request_Form");
        Leave_RequestItem.addActionListener(this);
        
        menuBar.add(Payrollmenu);
        PayrollItem = new JMenuItem("PayrollForm");
        PayrollItem.addActionListener(this);
        
        menuBar.add(Performancemenu);
        PerformanceItem = new JMenuItem("PerformanceForm");
        PerformanceItem.addActionListener(this);
        
        menuBar.add(Trainingmenu);
        TrainingItem = new JMenuItem("TrainingForm");
        TrainingItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Attendancemenu.add(AttendanceItem);
        Benefitmenu.add(BenefitItem);
        Employeemenu.add(EmployeeItem);
        Leave_Requestmenu.add(Leave_RequestItem);
        Payrollmenu.add(PayrollItem);
        Performancemenu.add(PerformanceItem);
        Trainingmenu.add(TrainingItem);
        
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AttendanceItem) {
            new AttendanceForm();
        
        } else if (e.getSource() == BenefitItem) {
            new BenefitForm();
        
        } else if (e.getSource() == EmployeeItem) {
            new EmployeeForm();
       
        } else if (e.getSource() == Leave_RequestItem) {
           new Leave_Request_Form();
        
        } else if (e.getSource() == PayrollItem) {
           new PayrollForm();
           
        } else if (e.getSource() == PerformanceItem) {
            new PerformanceForm();
            
        } else if (e.getSource() == TrainingItem) {
            new TrainingForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu("TO LABOR_MANAGEMENT_SYSTEM"));
    }
}




