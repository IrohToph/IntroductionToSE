package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;



public class ResetPasswordWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetPasswordWindow window = new ResetPasswordWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResetPasswordWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(570, 350, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Khôi phục mật khẩu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblNewLabel.setBounds(6, 6, 288, 61);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1.setBounds(6, 67, 97, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(115, 66, 179, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Khôi phục qua email");
		rdbtnNewRadioButton.setBounds(6, 94, 167, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Khôi phục qua số điện thoại");
		rdbtnNewRadioButton_1.setBounds(6, 118, 208, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);

		JButton btnNewButton = new JButton("Tiếp tục");
		btnNewButton.setBounds(97, 143, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Hãy nhập tên đăng nhập của bạn!");
				} else {
					try {
						String sql = "Select Username from Accounts";
						Statement st = App.connection.makeConnection().createStatement();
						ResultSet rs = st.executeQuery(sql);
						boolean check = false;
						while(rs.next()) {
							if (rs.getString("Username").equals(textField.getText())) {
								check = true;
							}
						}
						if (check) {
							if (!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected()) {
								JOptionPane.showMessageDialog(frame, "Hãy chọn phương thức khôi phục tài khoản của bạn!");
							} else {
								if(rdbtnNewRadioButton.isSelected()) {
									JOptionPane.showMessageDialog(frame, "Tin nhắn đã được gửi đến email của bạn");
								} else if(rdbtnNewRadioButton_1.isSelected()) {
									JOptionPane.showMessageDialog(frame, "Tin nhắn đã được gửi đến số điện thoại của bạn");
								}
								frame.setVisible(false);
							}
						} else {
							JOptionPane.showMessageDialog(frame, "Tài khoản không tồn tại!");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
	}
}
