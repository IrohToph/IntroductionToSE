package Windows;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DBConnection.DBConnection;
import User.User;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class App {

	private JFrame frame;
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static DBConnection connection = new DBConnection();
	public static User user;
	/**
	 * Launch the application.
//	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App app = new App();
					app.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Windows's size and the pop-up location
		int windowHeight = (int) screenSize.getHeight()*1/3;
		int windowWidth = (int) screenSize.getWidth()*1/3;
		int xPopUp = (((int) (screenSize.getHeight())) - windowHeight)/2;
		int yPopUp = (((int) (screenSize.getWidth())) - windowWidth)/2;
		
		// Tao window
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(128, 0, 0));
		frame.setBounds(yPopUp, xPopUp, windowWidth, windowHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// App Title Line 1
		JLabel titleLabel = new JLabel("Khai báo y tế tổ 16");
		titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		titleLabel.setBounds(63, 20, 354, 47);
		frame.getContentPane().add(titleLabel);
		
		//Line 2
		JLabel usernameLabel = new JLabel("Tên đăng nhập: ");
		usernameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		usernameLabel.setBounds(25, 90, 141, 25);
		frame.getContentPane().add(usernameLabel);
		
		JTextField usernameBox = new JTextField();
		usernameBox.setBounds(160, 90, 300, 25);
		frame.getContentPane().add(usernameBox);
		usernameBox.setColumns(10);
		
		//Line 3
		JLabel passwordLabel = new JLabel("Mật khẩu: ");
		passwordLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		passwordLabel.setBounds(25, 127, 141, 25);
		frame.getContentPane().add(passwordLabel);
		
		JPasswordField passwordBox = new JPasswordField();
		passwordBox.setBounds(160, 127, 300, 25);
		frame.getContentPane().add(passwordBox);
		passwordBox.setColumns(10);
		
		// Line 4
		JRadioButton medicalStaffButton = new JRadioButton("Cán bộ y tế");
		medicalStaffButton.setBounds(25, 165, 141, 23);
		frame.getContentPane().add(medicalStaffButton);
		
		JRadioButton hoRButton = new JRadioButton("Tổ trưởng");
		hoRButton.setBounds(195, 165, 141, 23);
		frame.getContentPane().add(hoRButton);
		
		JRadioButton residentButton = new JRadioButton("Dân cư");
		residentButton.setBounds(340, 165, 141, 23);
		frame.getContentPane().add(residentButton);
		
		// Line 5
		
		JLabel forgetPassLabel = new JLabel("Quên mật khẩu?");
		forgetPassLabel.setForeground(SystemColor.controlHighlight);
		forgetPassLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 12));
		forgetPassLabel.setBounds(200, 200, 101, 23);
		forgetPassLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ResetPasswordWindow.createWindow();
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		frame.getContentPane().add(forgetPassLabel);
		
		// Line 6
		JButton Button = new JButton("Xác nhận");
		Button.setBounds(160, 225, 167, 47);
		frame.getContentPane().add(Button);
		
		// This block of codes make only 1 button of Access Permission is selected
		ButtonGroup group = new ButtonGroup();
		group.add(hoRButton);
		group.add(residentButton);
		group.add(medicalStaffButton);
		
		// This block of codes check whether or not the account exists or the user input correctly account
		Button.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (medicalStaffButton.isSelected() == true) {
					try {
						String sql = "Select * from Accounts";
						Statement st = connection.makeConnection().createStatement();
						ResultSet rs = st.executeQuery(sql);
						boolean isPassed = false;
						while (rs.next()) {
							if (rs.getString("Username").equals(usernameBox.getText()) && rs.getString("Password").equals(passwordBox.getText()) && rs.getString("Access Permission").equals("Medical Staff")) {
								MedicalStaffWindow.createWindow();
								frame.setVisible(false);
								isPassed = true;
								user = new User(rs.getString("Username"));
							}
						}
						if (isPassed == false) {
							JOptionPane.showMessageDialog(frame, "Tài khoản không có hoặc mật khẩu không đúng!");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if (hoRButton.isSelected() == true){
					try {
						String sql = "Select * from Accounts";
						Statement st = connection.makeConnection().createStatement();
						ResultSet rs = st.executeQuery(sql);
						boolean isPassed = false;
						while (rs.next()) {
							if (rs.getString("Username").equals(usernameBox.getText()) && rs.getString("Password").equals(passwordBox.getText()) && rs.getString("Access Permission").equals("Head of the Resident")) {
								HoRWindow.createWindow();
								frame.setVisible(false);
								isPassed = true;
								user = new User(rs.getString("Username"));
							}
						}
						if (isPassed == false) {
							JOptionPane.showMessageDialog(frame, "Tài khoản không có hoặc mật khẩu không đúng!");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if (residentButton.isSelected() == true) {
					try {
						String sql = "Select * from Accounts";
						Statement st = connection.makeConnection().createStatement();
						ResultSet rs = st.executeQuery(sql);
						boolean isPassed = false;
						while (rs.next()) {
							if (rs.getString("Username").equals(usernameBox.getText()) && rs.getString("Password").equals(passwordBox.getText()) && rs.getString("Access Permission").equals("Resident")) {
								ResidentWindow.createWindow();
								frame.setVisible(false);
								isPassed = true;
								user = new User(rs.getString("Username"));
							}
						}
						if (isPassed == false) {
							JOptionPane.showMessageDialog(frame, "Tài khoản không có hoặc mật khẩu không đúng!");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} 
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
	}
}
