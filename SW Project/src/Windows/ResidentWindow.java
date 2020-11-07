package Windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;


public class ResidentWindow extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextField birthTextField;
	private JTextField phoneNumberTextField;
	private JTextField addressTextField;
	private JTextField nameTextField_1;
	private JTextField idTextField_1;
	private JTextField houseAddressTextField_1;
	private JTextField phoneTextField_1;
	private JTextField emailTextField_1;
	private JTextField questionTextField_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;


	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResidentWindow window = new ResidentWindow();
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
	public ResidentWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Color lightBlack = new Color(34,34,34);
		Color black = new Color(0,0,0);
		Color lightGray = new Color(211,211,211);
		Border border = BorderFactory.createLineBorder(new Color(59, 59, 59),1);
		Border border_1 = BorderFactory.createLineBorder(Color.GRAY,1);
		
		// Create window
		
		frame = new JFrame();
		frame.setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 1440, 40);
		panel_3.setBackground(Color.CYAN);
		panel_3.setLayout(null);
		frame.getContentPane().add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("ỨNG DỤNG QUẢN LÝ COVID-19");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblNewLabel_3.setBounds(5, 0, 400, 40);
		panel_3.add(lblNewLabel_3);
		
		//MenuBar
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 40, 240, 745);
		menuPanel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(menuPanel);
		menuPanel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 240, 745);
		menuPanel.add(menuBar);
		menuBar.setBackground(Color.BLACK);
		menuBar.setLayout(new GridLayout(0,1));
		
		JButton menuButton_1 = new JButton("Cập nhật thông tin cá nhân");
		menuButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		menuBar.add(menuButton_1);
		
		JButton menuButton_2 = new JButton("Khai báo y tế");
		menuButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		menuBar.add(menuButton_2);
		
		JButton menuButton_3 = new JButton("Cập nhật diễn biến dịch bệnh");
		menuButton_3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		menuBar.add(menuButton_3);
		
		JButton menuButton_4 = new JButton("Hỏi & đáp");
		menuButton_4.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		menuBar.add(menuButton_4);
		
//		 Personal Infomation Pane
		
		JDesktopPane accountInfoPane = new JDesktopPane();
		accountInfoPane.setBackground(lightBlack);
		accountInfoPane.setBounds(239, 40, 1200, 745);
		accountInfoPane.setVisible(true);
		frame.getContentPane().add(accountInfoPane);
		
		// Line 1
		
		JLabel nameLabel = new JLabel("Họ và tên: ");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setForeground(lightGray);
		nameLabel.setSize(240, 50);
		nameLabel.setLocation(30, 30);
		nameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		accountInfoPane.add(nameLabel);
		
		JTextField nameTextField = new JTextField(App.user.getName());
		nameTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		nameTextField.setBounds(300, 30, 850, 50);
		accountInfoPane.add(nameTextField);
		
		// Line 2
		
		JLabel genderLabel = new JLabel("Giới tính: ");
		genderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		genderLabel.setForeground(lightGray);
		genderLabel.setBounds(30, 90, 240, 50);
		genderLabel.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		
		JComboBox<String> genderComboBox = new JComboBox<String>();
		genderComboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		genderComboBox.setBounds(300, 90, 150, 50);
		genderComboBox.addItem("Nữ");
		genderComboBox.addItem("Nam");
		genderComboBox.setSelectedItem(App.user.getGender());
		accountInfoPane.add(genderLabel);
		accountInfoPane.add(genderComboBox);

		// Line 3
		
		JLabel birthLabel = new JLabel("Ngày sinh:");
		birthLabel.setHorizontalAlignment(SwingConstants.LEFT);
		birthLabel.setForeground(lightGray);
		birthLabel.setBounds(30, 150, 240, 50);
		birthLabel.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		accountInfoPane.add(birthLabel);
		
		birthTextField = new JTextField(App.user.getBirthday().toString());
		birthTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		birthTextField.setBounds(300, 150, 220, 50);
		accountInfoPane.add(birthTextField);
		
		// Line 4
		
		JLabel phoneNumberLabel = new JLabel("Số điện thoại: ");
		phoneNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
		phoneNumberLabel.setForeground(lightGray);
		phoneNumberLabel.setBounds(30, 210, 240, 50);
		phoneNumberLabel.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		accountInfoPane.add(phoneNumberLabel);
		
		phoneNumberTextField = new JTextField(App.user.getPhoneNumber());
		phoneNumberTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		phoneNumberTextField.setBounds(300, 210, 220, 50);
		accountInfoPane.add(phoneNumberTextField);
		
		// Line 5
		
		JLabel addressLabel = new JLabel("Căn hộ: ");
		addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addressLabel.setForeground(lightGray);
		addressLabel.setBounds(30, 270, 240, 50);
		addressLabel.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		accountInfoPane.add(addressLabel);
		
		addressTextField = new JTextField(App.user.getAddress());
		addressTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		addressTextField.setBounds(300, 270, 90, 50);
		accountInfoPane.add(addressTextField);
		
		// Line 6
		
		JButton confirmButton = new JButton("Xác nhận");
		confirmButton.setBounds(525, 695, 150, 50);
		accountInfoPane.add(confirmButton);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setForeground(lightGray);
		idLabel.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		idLabel.setBounds(30, 330, 240, 50);
		accountInfoPane.add(idLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setForeground(lightGray);
		emailLabel.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		emailLabel.setBounds(30, 390, 240, 50);
		accountInfoPane.add(emailLabel);
		
		textField = new JTextField(App.user.getID());
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		textField.setBounds(300, 330, 260, 50);
		accountInfoPane.add(textField);
		
		textField_1 = new JTextField(App.user.getEmail());
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		textField_1.setBounds(300, 390, 700, 50);
		accountInfoPane.add(textField_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 500, 1200, 245);
		panel.setBackground(lightBlack);
		panel.setLayout(null);
		panel.setVisible(false);
		accountInfoPane.add(panel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Đổi mật khẩu?");
		rdbtnNewRadioButton.setForeground(lightGray);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		rdbtnNewRadioButton.setBounds(25, 450, 269, 50);
		accountInfoPane.add(rdbtnNewRadioButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(300, 10, 500, 50);
		panel.add(passwordField);
		
		JLabel lblMtKhuC = new JLabel("Mật khẩu cũ:");
		lblMtKhuC.setForeground(lightGray);
		lblMtKhuC.setHorizontalAlignment(SwingConstants.LEFT);
		lblMtKhuC.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		lblMtKhuC.setBounds(30, 10, 210, 50);
		panel.add(lblMtKhuC);
		
		JLabel lblMtKhuMi = new JLabel("Mật khẩu mới:");
		lblMtKhuMi.setForeground(lightGray);
		lblMtKhuMi.setHorizontalAlignment(SwingConstants.LEFT);
		lblMtKhuMi.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		lblMtKhuMi.setBounds(30, 70, 236, 50);
		panel.add(lblMtKhuMi);
		
		JLabel lblNhpLiMt = new JLabel("Nhập lại:");
		lblNhpLiMt.setForeground(lightGray);
		lblNhpLiMt.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhpLiMt.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		lblNhpLiMt.setBounds(30, 130, 144, 50);
		panel.add(lblNhpLiMt);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(300, 70, 500, 50);
		panel.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(300, 130, 500, 50);
		panel.add(passwordField_2);
		
		rdbtnNewRadioButton.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (panel.isVisible()) {
					panel.setVisible(false);
				} else {
					panel.setVisible(true);
				}
			}
		});
		
//		 Health declaration
		
		JPanel formPanel = new JPanel();
		formPanel.setBackground(black);
		formPanel.setBounds(240, 40, 720, 745);
		frame.getContentPane().add(formPanel);
		formPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("90px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("35px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("48px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("7px"),
				ColumnSpec.decode("14px"),
				ColumnSpec.decode("4px"),
				ColumnSpec.decode("17px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("48px"),
				ColumnSpec.decode("54px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("38px"),
				ColumnSpec.decode("24px"),
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("30px"),
				ColumnSpec.decode("34px"),
				ColumnSpec.decode("15px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("81px"),
				ColumnSpec.decode("17px"),
				ColumnSpec.decode("106px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("35px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("27px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("27px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("26px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("35px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("60px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				RowSpec.decode("23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				RowSpec.decode("24px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				RowSpec.decode("29px"),}));
		
		// Line 1
		
		JLabel lblNewLabel = new JLabel("Khai báo y tế cá nhân");
		lblNewLabel.setForeground(lightGray);
		formPanel.add(lblNewLabel, "10, 2, 11, 1, left, top");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		// Line 2
		
		JLabel nameLabel_1 = new JLabel("Họ và tên (ghi chữ IN HOA)");
		nameLabel_1.setForeground(lightGray);
		nameLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(nameLabel_1, "2, 4, 9, 1, fill, top");
		
		JLabel idLabel_1 = new JLabel("Số hộ chiếu / CMND / CCCD");
		idLabel_1.setForeground(lightGray);
		idLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(idLabel_1, "17, 4, 9, 1, left, top");
		
		nameTextField_1 = new JTextField();
		nameTextField_1.setBackground(lightBlack);
		nameTextField_1.setForeground(lightGray);
		formPanel.add(nameTextField_1, "2, 6, 12, 1, fill, fill");
		nameTextField_1.setColumns(10);
		
		idTextField_1 = new JTextField();
		formPanel.add(idTextField_1, "17, 6, 9, 1, fill, fill");
		idTextField_1.setBackground(lightBlack);
		idTextField_1.setForeground(lightGray);
		idTextField_1.setColumns(10);
		
		//Line 3
		
		JLabel birthLabel_1 = new JLabel("Năm sinh");
		birthLabel_1.setForeground(lightGray);
		birthLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(birthLabel_1, "2, 8, fill, fill");
		
		JComboBox<Integer> birthComboBox_1 = new JComboBox<Integer>();
		for (int i = 1920; i <= 2020; i++) {
			birthComboBox_1.addItem(i);
		}
		formPanel.add(birthComboBox_1, "4, 8, 3, 1, fill, fill");
		
		JLabel genderLabel_1 = new JLabel("Giới tính");
		genderLabel_1.setForeground(lightGray);
		genderLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(genderLabel_1, "11, 8, 3, 1, fill, fill");
		
		JComboBox<String> genderComboBox_1 = new JComboBox<String>();
		genderComboBox_1.addItem("Nam");
		genderComboBox_1.addItem("Nữ");
		formPanel.add(genderComboBox_1, "14, 8, 3, 1, fill, fill");
		
		JLabel nationalityLabel_1 = new JLabel("Quốc tịch");
		nationalityLabel_1.setForeground(lightGray);
		nationalityLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(nationalityLabel_1, "19, 8, 3, 1, fill, fill");
		
		JComboBox<String> nationalityComboBox_1 = new JComboBox<String>();
		formPanel.add(nationalityComboBox_1, "23, 8, 3, 1, fill, fill");
		
		// Line 3

		JCheckBox healthInsuranceCheckBox_1 = new JCheckBox("Có thẻ bảo hiểm y tế");
		healthInsuranceCheckBox_1.setForeground(lightGray);
		healthInsuranceCheckBox_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(healthInsuranceCheckBox_1, "2, 10, 7, 1, left, fill");
		
		// Line 4
		
		JLabel addressLabel_1 = new JLabel("Địa chỉ liên lạc tại Việt Nam");
		addressLabel_1.setForeground(lightGray);
		addressLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		formPanel.add(addressLabel_1, "2, 12, 10, 1, fill, fill");
		
		// Line 5
		JLabel provinceLabel_1 = new JLabel("Tỉnh thành");
		provinceLabel_1.setForeground(lightGray);
		provinceLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(provinceLabel_1, "2, 14, fill, fill");
		
		JComboBox provinceComboBox_1 = new JComboBox();
		formPanel.add(provinceComboBox_1, "2, 16, 9, 1, fill, center");
		
		JLabel districtLabel_1 = new JLabel("Quận/huyện");
		districtLabel_1.setForeground(lightGray);
		districtLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(districtLabel_1, "13, 14, 2, 1, right, fill");
		
		JComboBox districtComboBox_1 = new JComboBox();
		formPanel.add(districtComboBox_1, "13, 16, 7, 1, fill, center");
		
		JLabel wardLabel_1 = new JLabel("Phường/xã");
		wardLabel_1.setForeground(lightGray);
		wardLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(wardLabel_1, "21, 14, 3, 1, left, fill");
		
		JComboBox wardComboBox_1 = new JComboBox();
		formPanel.add(wardComboBox_1, "21, 16, 5, 1, fill, center");
		
		JLabel houseAddressLabel_1 = new JLabel("Số nhà, phố, tổ dân phố/thôn/đội");
		houseAddressLabel_1.setForeground(lightGray);
		houseAddressLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(houseAddressLabel_1, "2, 18, 12, 1, fill, fill");
		
		houseAddressTextField_1 = new JTextField();
		houseAddressTextField_1.setColumns(10);
		houseAddressTextField_1.setBackground(lightBlack);
		houseAddressTextField_1.setForeground(lightGray);
		formPanel.add(houseAddressTextField_1, "2, 20, 24, 1, fill, fill");
		
		JLabel phoneLabel_1 = new JLabel("Điện thoại");
		phoneLabel_1.setForeground(lightGray);
		phoneLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(phoneLabel_1, "2, 22, fill, fill");
		
		JLabel emailLabel_1 = new JLabel("Email");
		emailLabel_1.setForeground(lightGray);
		emailLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(emailLabel_1, "16, 22, 2, 1, left, fill");
		
		phoneTextField_1 = new JTextField();
		phoneTextField_1.setColumns(10);
		phoneTextField_1.setBackground(lightBlack);
		phoneTextField_1.setForeground(lightGray);
		formPanel.add(phoneTextField_1, "6, 22, 9, 1, fill, fill");
		
		emailTextField_1 = new JTextField();
		emailTextField_1.setColumns(10);
		emailTextField_1.setBackground(lightBlack);
		emailTextField_1.setForeground(lightGray);
		formPanel.add(emailTextField_1, "21, 22, 5, 1, fill, fill");
		
		JLabel questionLabel_1_1 = new JLabel("Trong vòng 21 ngày qua, Anh/chị có đến quốc gia/ Vùng lãnh thổ nào?\n");
		questionLabel_1_1.setForeground(lightGray);
		questionLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(questionLabel_1_1, "2, 24, 22, 1, fill, fill");
		
		questionTextField_1 = new JTextField();
		questionTextField_1.setColumns(10);
		questionTextField_1.setBackground(lightBlack);
		questionTextField_1.setForeground(lightGray);
		formPanel.add(questionTextField_1, "2, 26, 24, 1, fill, fill");
		
		JLabel questionLabel_1_2 = new JLabel("Trong vòng 21 ngày qua, Anh/chị có thấy xuất hiện dấu hiệu nào sau đây không?\n");
		questionLabel_1_2.setForeground(lightGray);
		questionLabel_1_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		formPanel.add(questionLabel_1_2, "2, 28, 24, 1, fill, fill");
		
		JCheckBox medicalCheckBox_1 = new JCheckBox("Sốt");
		medicalCheckBox_1.setForeground(lightGray);
		medicalCheckBox_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_1, "2, 29, left, fill");
		
		JCheckBox medicalCheckBox_2 = new JCheckBox("Ho");
		medicalCheckBox_2.setForeground(lightGray);
		medicalCheckBox_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_2, "4, 29, 3, 1, left, fill");
		
		JCheckBox medicalCheckBox_3 = new JCheckBox("Khó thở");
		medicalCheckBox_3.setForeground(lightGray);
		medicalCheckBox_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_3, "8, 29, 6, 1, fill, fill");
		
		JCheckBox medicalCheckBox_4 = new JCheckBox("Viêm phổi");
		medicalCheckBox_4.setForeground(lightGray);
		medicalCheckBox_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_4, "14, 29, 6, 1, center, fill");
		
		JCheckBox medicalCheckBox_5 = new JCheckBox("Đau họng");
		medicalCheckBox_5.setForeground(lightGray);
		medicalCheckBox_5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_5, "20, 29, 4, 1, left, fill");
		
		JCheckBox medicalCheckBox_6 = new JCheckBox("Mệt mỏi");
		medicalCheckBox_6.setForeground(lightGray);
		medicalCheckBox_6.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_6, "25, 29, left, fill");
		
		JLabel questionLabel_1_3 = new JLabel("Trong vòng 21 ngày qua, Anh/chị có tiếp xúc với?\n\n");
		questionLabel_1_3.setForeground(lightGray);
		questionLabel_1_3.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		formPanel.add(questionLabel_1_3, "2, 31, 24, 1, fill, fill");
		
		JCheckBox medicalCheckBox_7 = new JCheckBox("Người bệnh, hoặc nghi ngờ mắc COVID-19\n");
		medicalCheckBox_7.setForeground(lightGray);
		medicalCheckBox_7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_7, "2, 32, 24, 1, fill, fill");
		
		JCheckBox medicalCheckBox_8 = new JCheckBox("Người từ nước có bệnh COVID-19\n");
		medicalCheckBox_8.setForeground(lightGray);
		medicalCheckBox_8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_8, "2, 34, 24, 1, fill, fill");
		
		JCheckBox medicalCheckBox_9 = new JCheckBox("Người có biểu hiện (sốt, ho, khó thở, viêm phổi)\n");
		medicalCheckBox_9.setForeground(lightGray);
		medicalCheckBox_9.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_9, "2, 36, 24, 1, fill, fill");
		
		JLabel questionLabel_1_4 = new JLabel("Hiện tại Anh/chị có bị bệnh nào dưới đây?\n");
		questionLabel_1_4.setForeground(lightGray);
		questionLabel_1_4.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		formPanel.add(questionLabel_1_4, "2, 38, 24, 1, fill, fill");
		
		JCheckBox medicalCheckBox_10 = new JCheckBox("Bệnh gan mãn tính\n");
		medicalCheckBox_10.setForeground(lightGray);
		medicalCheckBox_10.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_10, "2, 39, 5, 1, left, center");
		
		JCheckBox medicalCheckBox_11 = new JCheckBox("Bệnh máu mãn tính\n");
		medicalCheckBox_11.setForeground(lightGray);
		medicalCheckBox_11.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_11, "16, 39, 8, 1, left, center");
		
		JCheckBox medicalCheckBox_12 = new JCheckBox("Bệnh phổi mãn tính\n");
		medicalCheckBox_12.setForeground(lightGray);
		medicalCheckBox_12.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_12, "2, 41, 7, 1, left, fill");
		
		JCheckBox medicalCheckBox_13 = new JCheckBox("Bệnh thận mãn tính\n");
		medicalCheckBox_13.setForeground(lightGray);
		medicalCheckBox_13.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_13, "16, 41, 8, 1, left, fill");
		
		JCheckBox medicalCheckBox_14 = new JCheckBox("Bệnh tim mạch");
		medicalCheckBox_14.setForeground(lightGray);
		medicalCheckBox_14.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_14, "2, 43, 5, 1, left, fill");
		
		JCheckBox medicalCheckBox_15 = new JCheckBox("Huyết áp cao");
		medicalCheckBox_15.setForeground(lightGray);
		medicalCheckBox_15.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_15, "16, 43, 6, 1, fill, fill");
		
		JCheckBox medicalCheckBox_16 = new JCheckBox("Suy giảm miễn dịch");
		medicalCheckBox_16.setForeground(lightGray);
		medicalCheckBox_16.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_16, "2, 45, 5, 1, left, fill");
		
		JCheckBox medicalCheckBox_17 = new JCheckBox("Người nhận ghép tạng, Thuỷ xương");
		medicalCheckBox_17.setForeground(lightGray);
		medicalCheckBox_17.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_17, "16, 45, 10, 1, fill, fill");
		
		JCheckBox medicalCheckBox_18 = new JCheckBox("Tiểu đường");
		medicalCheckBox_18.setForeground(lightGray);
		medicalCheckBox_18.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_18, "2, 47, 3, 1, fill, fill");
		
		JCheckBox medicalCheckBox_19 = new JCheckBox("Ung thư");
		medicalCheckBox_19.setForeground(lightGray);
		medicalCheckBox_19.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_19, "16, 47, 4, 1, fill, fill");
		
		JLabel questionLabel_1_5 = new JLabel("Bạn có đang trong thai kỳ hay không?");
		questionLabel_1_5.setForeground(lightGray);
		questionLabel_1_5.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		formPanel.add(questionLabel_1_5, "2, 49, 13, 1, left, fill");
		
		JCheckBox medicalCheckBox_20 = new JCheckBox("Có");
		medicalCheckBox_20.setForeground(lightGray);
		medicalCheckBox_20.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_20, "16, 49, 2, 1, right, top");
		
		JCheckBox medicalCheckBox_21 = new JCheckBox("Không");
		medicalCheckBox_21.setForeground(lightGray);
		medicalCheckBox_21.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formPanel.add(medicalCheckBox_21, "20, 49, 4, 1, left, top");
		
		ButtonGroup group_1 = new ButtonGroup();
		group_1.add(medicalCheckBox_20);
		group_1.add(medicalCheckBox_21);
		
		JButton confirmButton_1 = new JButton("Xác nhận");
		formPanel.add(confirmButton_1, "14, 50, 4, 1, fill, top");
		
		JScrollPane scrollPane_1 = new JScrollPane(formPanel);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(240, 40, 720, 745);
		scrollPane_1.setVisible(false);
		frame.getContentPane().add(scrollPane_1);
		
		JPanel infoPanel_1 = new JPanel();
		infoPanel_1.setBounds(960, 40, 480, 745);
		infoPanel_1.setBackground(black);
		infoPanel_1.setVisible(false);
		frame.getContentPane().add(infoPanel_1);
		infoPanel_1.setLayout(null);
		
		JLabel personalInfoLabel_1 = new JLabel("Thông tin cá nhân");
		personalInfoLabel_1.setForeground(lightGray);
		personalInfoLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 48));
		personalInfoLabel_1.setBounds(12, 6, 456, 92);
		infoPanel_1.add(personalInfoLabel_1);
		
		JLabel avaLabel = new JLabel();
		avaLabel.setBounds(140, 110, 200, 200);
		infoPanel_1.add(avaLabel);
		
		ImageIcon maleAvatar = new ImageIcon("/Users/levietdung/Desktop/male.png");
		ImageIcon femaleAvatar = new ImageIcon("/Users/levietdung/Desktop/female.png");
		
		if (App.user.getGender().equals("Male")) {
			avaLabel.setIcon(maleAvatar);
		} else {
			avaLabel.setIcon(femaleAvatar);
		}
		
		
		JLabel nameLabel_1_2 = new JLabel("Họ và tên");
		nameLabel_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		nameLabel_1_2.setForeground(lightGray);
		nameLabel_1_2.setBackground(new Color(43,43,43));
		nameLabel_1_2.setBounds(10, 350, 150, 55);
		nameLabel_1_2.setBorder(border_1);
		infoPanel_1.add(nameLabel_1_2);
		
		JLabel nameLabel_1_2_1 = new JLabel("Ngày sinh");
		nameLabel_1_2_1.setForeground(lightGray);
		nameLabel_1_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		nameLabel_1_2_1.setBounds(10, 405, 150, 55);
		nameLabel_1_2_1.setBackground(new Color(43,43,43));
		nameLabel_1_2_1.setBorder(border_1);
		infoPanel_1.add(nameLabel_1_2_1);
		
		JLabel nameLabel_1_2_1_1 = new JLabel("ID");
		nameLabel_1_2_1_1.setForeground(lightGray);
		nameLabel_1_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		nameLabel_1_2_1_1.setBounds(10, 460, 150, 55);
		nameLabel_1_2_1_1.setBorder(border_1);
		nameLabel_1_2_1_1.setBackground(new Color(43,43,43));
		infoPanel_1.add(nameLabel_1_2_1_1);
		
		JLabel nameLabel_1_2_1_1_1 = new JLabel("Giới tính");
		nameLabel_1_2_1_1_1.setForeground(lightGray);
		nameLabel_1_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		nameLabel_1_2_1_1_1.setBounds(10, 515, 150, 55);
		nameLabel_1_2_1_1_1.setBorder(border_1);
		nameLabel_1_2_1_1_1.setBackground(new Color(43,43,43));
		infoPanel_1.add(nameLabel_1_2_1_1_1);
		
		JLabel nameLabel_1_2_1_1_1_1 = new JLabel("Căn hộ ");
		nameLabel_1_2_1_1_1_1.setForeground(lightGray);
		nameLabel_1_2_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		nameLabel_1_2_1_1_1_1.setBounds(10, 570, 150, 55);
		nameLabel_1_2_1_1_1_1.setBorder(border_1);
		nameLabel_1_2_1_1_1_1.setBackground(new Color(43,43,43));
		infoPanel_1.add(nameLabel_1_2_1_1_1_1);
		
		JLabel nameLabel_1_2_2 = new JLabel(App.user.getName());
		nameLabel_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel_1_2_2.setForeground(lightGray);
		nameLabel_1_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		nameLabel_1_2_2.setBounds(160, 350, 310, 55);
		nameLabel_1_2_2.setBorder(border_1);
		nameLabel_1_2_2.setBackground(new Color(43,43,43));
		infoPanel_1.add(nameLabel_1_2_2);
		
		JLabel nameLabel_1_2_2_1 = new JLabel(App.user.getBirthday().toString());
		nameLabel_1_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel_1_2_2_1.setForeground(lightGray);
		nameLabel_1_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		nameLabel_1_2_2_1.setBounds(160, 405, 310, 55);
		nameLabel_1_2_2_1.setBorder(border_1);
		nameLabel_1_2_2_1.setBackground(new Color(43,43,43));
		infoPanel_1.add(nameLabel_1_2_2_1);
		
		JLabel nameLabel_1_2_2_1_1 = new JLabel(App.user.getID());
		nameLabel_1_2_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel_1_2_2_1_1.setForeground(lightGray);
		nameLabel_1_2_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		nameLabel_1_2_2_1_1.setBounds(160, 460, 310, 55);
		nameLabel_1_2_2_1_1.setBorder(border_1);
		nameLabel_1_2_2_1_1.setBackground(new Color(43,43,43));
		infoPanel_1.add(nameLabel_1_2_2_1_1);
		
		JLabel nameLabel_1_2_2_1_2 = new JLabel(App.user.getGender());
		nameLabel_1_2_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel_1_2_2_1_2.setForeground(lightGray);
		nameLabel_1_2_2_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		nameLabel_1_2_2_1_2.setBounds(160, 515, 310, 55);
		nameLabel_1_2_2_1_2.setBorder(border_1);
		nameLabel_1_2_2_1_2.setBackground(new Color(43,43,43));
		infoPanel_1.add(nameLabel_1_2_2_1_2);
		
		JLabel nameLabel_1_2_2_1_3 = new JLabel(App.user.getAddress());
		nameLabel_1_2_2_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel_1_2_2_1_3.setForeground(lightGray);
		nameLabel_1_2_2_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		nameLabel_1_2_2_1_3.setBounds(160, 570, 310, 55);
		nameLabel_1_2_2_1_3.setBorder(border_1);
		nameLabel_1_2_2_1_3.setBackground(new Color(43,43,43));
		infoPanel_1.add(nameLabel_1_2_2_1_3);
		
		// Update Pane
		
		String URL = "https://www.worldometers.info/coronavirus/";
	    ArrayList<CountryData> dataRecord = new ArrayList<CountryData>();
	    int vnindex = 0;
	    int counter = -1;
	    try {
	    	Document source = Jsoup.connect(URL).timeout(30*1000).get();
	    	Element table = source.select("tbody").first();
	    	Elements rows = table.select("tr");
	    	for (Element row: rows) {
	    		Elements data = row.select("td");
	    		counter++;
	    		if (data.get(1).text().equals("Vietnam")) {
	    			 vnindex = counter;
	    		}
	    		dataRecord.add(new CountryData(data.get(1).text(), data.get(2).text(), data.get(3).text(), data.get(4).text(), data.get(5).text(), data.get(6).text(), data.get(8).text()));
	    	}
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(240, 40, 1200, 745);
		desktopPane.setBackground(new Color(0, 0, 0));
		desktopPane.setLayout(null);
		desktopPane.setVisible(false);
		frame.getContentPane().add(desktopPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(260, 5, 365, 49);
		panel_2.setBackground(new Color(34, 34, 34));
		panel_2.setVisible(true);
		panel_2.setLayout(null);
		desktopPane.add(panel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblNewLabel_4.setBounds(6, 6, 353, 37);
		panel_2.add(lblNewLabel_4);
		
		Clock clock = new Clock();
		clock.activate(lblNewLabel_4);
		
		JPanel clockPanel = new JPanel();
		clockPanel.setBounds(5, 5, 250, 100);
		clockPanel.setBackground(new Color(34, 34, 34));
		desktopPane.add(clockPanel);
		clockPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Global Cases");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(70, 15, 110, 25);
		clockPanel.add(lblNewLabel_5);
		
//		World's cases Counter
		
		JLabel worldCasesLabel = new JLabel(dataRecord.get(7).getTotalCases());
		worldCasesLabel.setForeground(Color.RED);
		worldCasesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		worldCasesLabel.setBounds(5, 50, 240, 30);
		worldCasesLabel.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		clockPanel.add(worldCasesLabel);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(34, 34, 34));
		desktopPane.add(panel_21);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(5, 110, 250, 300);
		panel_4.setBackground(new Color(34, 34, 34));
		desktopPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5_1 = new JLabel("Cases by");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(80, 15, 90, 25);
		panel_4.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Country/Region/Sovereignty");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_5_2.setBounds(5, 40, 240, 25);
		panel_4.add(lblNewLabel_5_2);
		
		int numOfCountries = dataRecord.size()-8;
		JLabel[] countryNameArray = new JLabel[numOfCountries];
		JLabel[] numOfCasesArray = new JLabel[numOfCountries];
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setBackground(new Color(34, 34, 34));
		panel_5.setLayout(new GridLayout(numOfCountries, 2, 0, 0));
		

		
		for (int i = 8; i <= (dataRecord.size()-1); i++) {
			countryNameArray[(i-8)] = new JLabel(dataRecord.get(i).getCountryName());
			countryNameArray[(i-8)].setForeground(Color.RED);
			countryNameArray[(i-8)].setBorder(border);
			panel_5.add(countryNameArray[(i-8)]);
			numOfCasesArray[(i-8)] = new JLabel(dataRecord.get(i).getTotalCases());
			numOfCasesArray[(i-8)].setForeground(Color.RED);
			numOfCasesArray[(i-8)].setBorder(border);
			panel_5.add(numOfCasesArray[(i-8)]);
		}
		
		JScrollPane scrollPane = new JScrollPane(panel_5);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 80, 250, 220);
		scrollPane.setBorder(border);
		panel_4.add(scrollPane);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(5, 650, 250, 90);
		panel_6.setBackground(new Color(34, 34, 34));
		desktopPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("Last Update");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel1.setForeground(Color.WHITE);
		lblNewLabel1.setBounds(75, 20, 100, 25);
		panel_6.add(lblNewLabel1);
		
		JLabel lblNewLabel_11 = new JLabel();
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setBounds(35, 45, 180, 25);
		clock.activate(lblNewLabel_11);
		panel_6.add(lblNewLabel_11);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(5, 415, 250, 230);
		panel_7.setBackground(new Color(34, 34, 34));
		desktopPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_21 = new JLabel("Viet Nam");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblNewLabel_21.setForeground(Color.WHITE);
		lblNewLabel_21.setBounds(65, 10, 120, 25);
		panel_7.add(lblNewLabel_21);
		
		JLabel lblNewLabel_8 = new JLabel("Total Cases");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(80, 35, 90, 25);
		panel_7.add(lblNewLabel_8);
		
		JLabel worldCasesLabel_1 = new JLabel(dataRecord.get(vnindex).getTotalCases());
		worldCasesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		worldCasesLabel_1.setForeground(Color.RED);
		worldCasesLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		worldCasesLabel_1.setBounds(6, 59, 240, 30);
		panel_7.add(worldCasesLabel_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("Active Cases");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_8_1.setBounds(70, 90, 110, 25);
		panel_7.add(lblNewLabel_8_1);
		
		JLabel worldCasesLabel_1_1 = new JLabel(dataRecord.get(vnindex).getActiveCases());
		worldCasesLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		worldCasesLabel_1_1.setForeground(Color.RED);
		worldCasesLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		worldCasesLabel_1_1.setBounds(6, 115, 240, 30);
		panel_7.add(worldCasesLabel_1_1);
		
		JLabel lblNewLabel_9 = new JLabel("Total Recovered");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(0, 150, 125, 20);
		lblNewLabel_9.setBorder(border_1);
		panel_7.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("New Cases");
		lblNewLabel_9_1.setForeground(Color.WHITE);
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setBounds(125, 150, 125, 20);
		lblNewLabel_9_1.setBorder(border_1);
		panel_7.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_2 = new JLabel(dataRecord.get(vnindex).getTotalRecovered());
		lblNewLabel_9_2.setForeground(Color.GREEN);
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_2.setBounds(0, 170, 125, 19);
		lblNewLabel_9_2.setBorder(border_1);
		panel_7.add(lblNewLabel_9_2);
		
		JLabel lblNewLabel_9_2_1;
		if (dataRecord.get(vnindex).getNewCases().equals("")) {
			lblNewLabel_9_2_1 = new JLabel("0");
			lblNewLabel_9_2_1.setForeground(Color.GREEN);
		} else {
			lblNewLabel_9_2_1 = new JLabel(dataRecord.get(vnindex).getNewCases());
			lblNewLabel_9_2_1.setForeground(Color.RED);
		}
		lblNewLabel_9_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_2_1.setBounds(125, 170, 125, 19);
		lblNewLabel_9_2_1.setBorder(border_1);
		panel_7.add(lblNewLabel_9_2_1);
		
		JLabel lblNewLabel_9_3 = new JLabel("Total Deaths");
		lblNewLabel_9_3.setForeground(Color.WHITE);
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_3.setBounds(0, 189, 125, 20);
		lblNewLabel_9_3.setBorder(border_1);
		panel_7.add(lblNewLabel_9_3);
		
		JLabel lblNewLabel_9_3_1 = new JLabel("New Deaths");
		lblNewLabel_9_3_1.setForeground(Color.WHITE);
		lblNewLabel_9_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_3_1.setBounds(125, 189, 125, 20);
		lblNewLabel_9_3_1.setBorder(border_1);
		panel_7.add(lblNewLabel_9_3_1);
		
		JLabel lblNewLabel_9_2_2 = new JLabel(dataRecord.get(vnindex).getTotalDeaths());
		lblNewLabel_9_2_2.setForeground(Color.WHITE);
		lblNewLabel_9_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_2_2.setBounds(0, 209, 125, 19);
		lblNewLabel_9_2_2.setBorder(border_1);
		panel_7.add(lblNewLabel_9_2_2);
		
		JLabel lblNewLabel_9_2_3;
		if (dataRecord.get(vnindex).getNewDeaths().equals("")) {
			lblNewLabel_9_2_3 = new JLabel("0");
			lblNewLabel_9_2_3.setForeground(Color.GREEN);
		} else {
			lblNewLabel_9_2_3 = new JLabel(dataRecord.get(vnindex).getNewDeaths());
			lblNewLabel_9_2_3.setForeground(Color.ORANGE);
		}
		lblNewLabel_9_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_2_3.setBounds(125, 209, 125, 19);
		lblNewLabel_9_2_3.setBorder(border_1);
		panel_7.add(lblNewLabel_9_2_3);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(995, 5, 200, 241);
		panel_8.setBackground(new Color(34, 34, 34));
		desktopPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Global Deaths");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(55, 5, 90, 20);
		panel_8.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(dataRecord.get(7).getTotalDeaths());
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(6, 25, 188, 30);
		panel_8.add(lblNewLabel_7);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(1, 6, 183, 230);
		panel_9.setBackground(new Color(34, 34, 34));
		panel_9.setLayout(new GridLayout(numOfCountries, 1, 0, 0));
		panel_9.setBorder(border_1);
		panel_8.add(panel_9);
		
		JLabel[] numOfDeathsCasesArray = new JLabel[numOfCountries];
		
		for (int i = 8; i <= (dataRecord.size()-1); i++) {
			if (dataRecord.get(i).getTotalDeaths().equals("")) {
				numOfDeathsCasesArray[(i-8)] = new JLabel("<html> 0 deaths <br/>" + dataRecord.get(i).getCountryName() + "</html>" );
			} else if (dataRecord.get(i).getTotalDeaths().equals("N/A")) {
				numOfDeathsCasesArray[(i-8)] = new JLabel("<html> ? deaths <br/>" + dataRecord.get(i).getCountryName() + "</html>" );
			} else {
				numOfDeathsCasesArray[(i-8)] = new JLabel("<html>" + dataRecord.get(i).getTotalDeaths() + " deaths <br/>" + dataRecord.get(i).getCountryName() + "</html>" );
			}
			numOfDeathsCasesArray[(i-8)].setForeground(Color.LIGHT_GRAY);
			numOfDeathsCasesArray[(i-8)].setBorder(border);
			panel_9.add(numOfDeathsCasesArray[(i-8)]);
		}
		
		JScrollPane scrollPane_11 = new JScrollPane(panel_9);
		scrollPane_11.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_11.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_11.setBounds(0, 63, 200, 237);
		scrollPane_11.setBorder(border);
		panel_8.add(scrollPane_11);
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setLayout(null);
		panel_8_1.setBackground(new Color(34, 34, 34));
		panel_8_1.setBounds(995, 251, 200, 241);
		desktopPane.add(panel_8_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Global Recovered");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setBounds(45, 5, 110, 20);
		panel_8_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel(dataRecord.get(7).getTotalRecovered());
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.GREEN);
		lblNewLabel_7_1.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblNewLabel_7_1.setBounds(6, 25, 188, 30);
		panel_8_1.add(lblNewLabel_7_1);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setBackground(new Color(34, 34, 34));
		panel_9_1.setBounds(0, 0, 183, 235);
		panel_9_1.setBorder(border_1);
		panel_9_1.setLayout(new GridLayout(numOfCountries, 1, 0, 0));
		
		JLabel[] numOfRecoveredCasesArray = new JLabel[numOfCountries];
		
		for (int i = 8; i <= (dataRecord.size()-1); i++) {
			if (dataRecord.get(i).getTotalRecovered().equals("")) {
				numOfRecoveredCasesArray[(i-8)] = new JLabel("<html> 0 recovered <br/>" + dataRecord.get(i).getCountryName() + "</html>" );
			} else if (dataRecord.get(i).getTotalRecovered().equals("N/A")) {
				numOfRecoveredCasesArray[(i-8)] = new JLabel("<html> ? recovered <br/>" + dataRecord.get(i).getCountryName() + "</html>" );
			} else {
				numOfRecoveredCasesArray[(i-8)] = new JLabel("<html>" + dataRecord.get(i).getTotalRecovered() + " recovered <br/>" + dataRecord.get(i).getCountryName() + "</html>" );
			}
			numOfRecoveredCasesArray[(i-8)].setForeground(Color.GREEN);
			numOfRecoveredCasesArray[(i-8)].setBorder(border);
			panel_9_1.add(numOfRecoveredCasesArray[(i-8)]);
		}
		
		JScrollPane scrollPane_1_1 = new JScrollPane(panel_9_1);
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1_1.setBounds(0, 63, 200, 237);
		scrollPane_1_1.setBorder(border);
		panel_8_1.add(scrollPane_1_1);
		
		JPanel panel_8_2 = new JPanel();
		panel_8_2.setLayout(null);
		panel_8_2.setBackground(new Color(34, 34, 34));
		panel_8_2.setBounds(995, 497, 200, 243);
		desktopPane.add(panel_8_2);
		
		JLabel lblNewLabel_6_2 = new JLabel("Global Active Cases");
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_2.setForeground(Color.WHITE);
		lblNewLabel_6_2.setBounds(30, 5, 140, 20);
		panel_8_2.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_7_2 = new JLabel(dataRecord.get(7).getActiveCases());
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_2.setForeground(Color.ORANGE);
		lblNewLabel_7_2.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblNewLabel_7_2.setBounds(6, 25, 188, 30);
		panel_8_2.add(lblNewLabel_7_2);
		
		JPanel panel_9_2 = new JPanel();
		panel_9_2.setBackground(new Color(34, 34, 34));
		panel_9_2.setBounds(1, 1, 183, 240);
		panel_8_2.add(panel_9_2);
		panel_9_2.setBorder(border_1);
		panel_9_2.setLayout(new GridLayout(numOfCountries, 1, 0, 0));
		
		JLabel[] numOfActiveCasesArray = new JLabel[numOfCountries];
		
		for (int i = 8; i <= (dataRecord.size()-1); i++) {
			if (dataRecord.get(i).getActiveCases().equals("")) {
				numOfActiveCasesArray[(i-8)] = new JLabel("<html> 0 active cases <br/>" + dataRecord.get(i).getCountryName() + "</html>" );
			} else if (dataRecord.get(i).getActiveCases().equals("N/A")) {
				numOfActiveCasesArray[(i-8)] = new JLabel("<html> ? active cases <br/>" + dataRecord.get(i).getCountryName() + "</html>" );
			} else {
				numOfActiveCasesArray[(i-8)] = new JLabel("<html>" + dataRecord.get(i).getActiveCases() + " active cases <br/>" + dataRecord.get(i).getCountryName() + "</html>" );
			}
			numOfActiveCasesArray[(i-8)].setForeground(Color.ORANGE);
			numOfActiveCasesArray[(i-8)].setBorder(border);
			panel_9_2.add(numOfActiveCasesArray[(i-8)]);
		}
		
		JScrollPane scrollPane_1_2 = new JScrollPane(panel_9_2);
		scrollPane_1_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1_2.setBounds(0, 63, 200, 237);
		scrollPane_1_2.setBorder(border);
		panel_8_2.add(scrollPane_1_2);
		
		DefaultPieDataset dataset_1 = new DefaultPieDataset();
		double recentVolume_1 = 0;
		for (int i = 8; i < 13; i++) {
			dataset_1.setValue(dataRecord.get(i).getCountryName(), 100*(dataRecord.get(i).getNumberTotalCases())/(dataRecord.get(7).getNumberTotalCases()));
			recentVolume_1 += 100*(dataRecord.get(i).getNumberTotalCases())/(dataRecord.get(7).getNumberTotalCases());
		}
		dataset_1.setValue("Other countries", 100-recentVolume_1);
		
		JFreeChart jchart_1 = ChartFactory.createPieChart(
				"COVID-19 Charts",
				dataset_1,
				true,
				true,
				true
		);
		jchart_1.setBackgroundPaint(new Color(43,43,43));
		jchart_1.setBorderVisible(false);
		jchart_1.getPlot().setBackgroundPaint(new Color(43,43,43));
		jchart_1.getLegend().setBackgroundPaint(new Color(43,43,43));
		jchart_1.getLegend().setItemPaint(Color.WHITE);
		jchart_1.getPlot().setOutlineVisible(false);
		jchart_1.getTitle().setPaint(Color.WHITE);
		jchart_1.getTitle().setWidth(100);
		jchart_1.getTitle().setHeight(50);
		jchart_1.getTitle().setFont(new Font("Lucida Grande", Font.BOLD, 36));
		
		ChartPanel panel_1_1 = new ChartPanel(jchart_1);
		panel_1_1.setBackground(new Color(43,43,43));
		panel_1_1.setBounds(260, 59, 365, 351);
		desktopPane.add(panel_1_1);
		
		DefaultCategoryDataset dataset_2 = new DefaultCategoryDataset();
		String csvFile = "/Users/levietdung/Downloads/COVID-19-master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
        File file = new File(csvFile);
        try {
        	Scanner inputStream = new Scanner(file);
        	while (inputStream.hasNext()) {
            	String data = inputStream.next();
            	
            	if (inputStream.hasNext() == false) {
                	String arrayData[] = data.split(",");
            		for (int i = 4; i < arrayData.length; i++) {
        			dataset_2.addValue(CountryData.stringToNumberic(arrayData[i]), "Global", " " + i);
            		}
            	}
        	}
        	inputStream.close();
        } catch(FileNotFoundException e) {
        	e.printStackTrace();
        }
				
		JFreeChart jchart_2 = ChartFactory.createLineChart(
				"",
				"Time",
				"Millions",
		        dataset_2,          
		        PlotOrientation.VERTICAL,
		        true,
		        true,
		        false
		        );
		jchart_2.setBackgroundPaint(new Color(43,43,43));
		jchart_2.setBorderVisible(false);
		jchart_2.getPlot().setBackgroundPaint(new Color(43,43,43));
		jchart_2.getPlot().setOutlineVisible(false);
		jchart_2.getLegend().setBackgroundPaint(new Color(43,43,43));
		jchart_2.getLegend().setItemPaint(Color.WHITE);
		jchart_2.getCategoryPlot().getDomainAxis().setLabelPaint(Color.WHITE);
		jchart_2.getCategoryPlot().getRangeAxis().setLabelPaint(Color.WHITE);
		jchart_2.getCategoryPlot().getDomainAxis().setAxisLinePaint(Color.WHITE);
		jchart_2.getCategoryPlot().getRangeAxis().setAxisLinePaint(Color.WHITE);
		jchart_2.getCategoryPlot().getDomainAxis().setTickMarkPaint(Color.WHITE);
		jchart_2.getCategoryPlot().getRangeAxis().setTickMarkPaint(Color.WHITE);
		jchart_2.getCategoryPlot().getDomainAxis().setTickLabelPaint(Color.WHITE);
		jchart_2.getCategoryPlot().getRangeAxis().setTickLabelPaint(Color.WHITE);

		ChartPanel panel_1_2 = new ChartPanel(jchart_2);
		panel_1_2.setBackground(new Color(43,43,43));
		panel_1_2.setBounds(260, 415, 730, 325);
		panel_1_2.setBorder(border_1);
		desktopPane.add(panel_1_2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(630, 5, 360, 405);
		panel_11.setBackground(new Color(43,43,43));
		desktopPane.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("This Building");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Lucida Grande", Font.BOLD, 36));
		lblNewLabel_10.setBounds(50, 0, 260, 55);
		lblNewLabel_10.setForeground(Color.WHITE);
		panel_11.add(lblNewLabel_10);
		
		JLabel lblNewLabel_111 = new JLabel("Infected");
		lblNewLabel_111.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_111.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_111.setBounds(0, 53, 120, 72);
		lblNewLabel_111.setForeground(Color.WHITE);
		lblNewLabel_111.setBorder(border_1);
		panel_11.add(lblNewLabel_111);
		
		JLabel lblNewLabel_11_1 = new JLabel("Total Cases");
		lblNewLabel_11_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_11_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_1.setBounds(120, 53, 120, 72);
		lblNewLabel_11_1.setForeground(Color.WHITE);
		lblNewLabel_11_1.setBorder(border_1);
		panel_11.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11_2 = new JLabel("19");
		lblNewLabel_11_2.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lblNewLabel_11_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_2.setBounds(0, 125, 120, 105);
		lblNewLabel_11_2.setForeground(UIManager.getColor("Button.select"));
		lblNewLabel_11_2.setBorder(border_1);
		panel_11.add(lblNewLabel_11_2);
		
		JLabel lblNewLabel_11_2_1 = new JLabel("51");
		lblNewLabel_11_2_1.setFont(new Font("Lucida Grande", Font.BOLD, 56));
		lblNewLabel_11_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_2_1.setBounds(120, 125, 120, 105);
		lblNewLabel_11_2_1.setForeground(Color.RED);
		lblNewLabel_11_2_1.setBorder(border_1);
		panel_11.add(lblNewLabel_11_2_1);
		
		JLabel lblNewLabel_11_3 = new JLabel("Deaths");
		lblNewLabel_11_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_11_3.setForeground(Color.WHITE);
		lblNewLabel_11_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_3.setBounds(0, 230, 120, 72);
		lblNewLabel_11_3.setBorder(border_1);
		panel_11.add(lblNewLabel_11_3);
		
		JLabel lblNewLabel_11_3_1 = new JLabel("Recovered");
		lblNewLabel_11_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_11_3_1.setForeground(Color.WHITE);
		lblNewLabel_11_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_3_1.setBounds(120, 230, 120, 72);
		lblNewLabel_11_3_1.setBorder(border_1);
		panel_11.add(lblNewLabel_11_3_1);
		
		JLabel lblNewLabel_11_2_2 = new JLabel("0");
		lblNewLabel_11_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lblNewLabel_11_2_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_11_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_2_2.setBounds(0, 302, 120, 105);
		lblNewLabel_11_2_2.setBorder(border_1);
		panel_11.add(lblNewLabel_11_2_2);
		
		JLabel lblNewLabel_11_2_2_1 = new JLabel("40");
		lblNewLabel_11_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lblNewLabel_11_2_2_1.setForeground(Color.GREEN);
		lblNewLabel_11_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_2_2_1.setBounds(120, 302, 120, 105);
		lblNewLabel_11_2_2_1.setBorder(border_1);
		panel_11.add(lblNewLabel_11_2_2_1);
		
		JLabel lblNewLabel_11_1_1 = new JLabel("Isolated");
		lblNewLabel_11_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_11_1_1.setForeground(Color.WHITE);
		lblNewLabel_11_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_1_1.setBounds(240, 53, 120, 72);
		lblNewLabel_11_1_1.setBorder(border_1);
		panel_11.add(lblNewLabel_11_1_1);
		
		JLabel lblNewLabel_11_2_1_1 = new JLabel("32");
		lblNewLabel_11_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lblNewLabel_11_2_1_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_11_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_2_1_1.setBounds(240, 125, 120, 105);
		lblNewLabel_11_2_1_1.setBorder(border_1);
		panel_11.add(lblNewLabel_11_2_1_1);
		
		JLabel lblNewLabel_11_3_1_1 = new JLabel("Active");
		lblNewLabel_11_3_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_11_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_11_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_3_1_1.setBounds(240, 230, 120, 72);
		lblNewLabel_11_3_1_1.setBorder(border_1);
		panel_11.add(lblNewLabel_11_3_1_1);
		
		JLabel lblNewLabel_11_2_2_1_1 = new JLabel("11");
		lblNewLabel_11_2_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lblNewLabel_11_2_2_1_1.setForeground(Color.ORANGE);
		lblNewLabel_11_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_2_2_1_1.setBounds(240, 302, 120, 105);
		lblNewLabel_11_2_2_1_1.setBorder(border_1);
		panel_11.add(lblNewLabel_11_2_2_1_1);

				
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			@Override
	        protected JButton createDecreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        @Override    
	        protected JButton createIncreaseButton(int orientation) {
	            return createZeroButton();
	        }
	        private JButton createZeroButton() {
	            JButton jbutton = new JButton();
	            jbutton.setPreferredSize(new Dimension(0, 0));
	            jbutton.setMinimumSize(new Dimension(0, 0));
	            jbutton.setMaximumSize(new Dimension(0, 0));
	            return jbutton;
	        }
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(75, 75, 75);
		        this.trackColor = new Color(64, 64, 64);
		        this.scrollBarWidth = 5;
		    }
		});
		
		scrollPane_11.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			@Override
	        protected JButton createDecreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        @Override    
	        protected JButton createIncreaseButton(int orientation) {
	            return createZeroButton();
	        }
	        private JButton createZeroButton() {
	            JButton jbutton = new JButton();
	            jbutton.setPreferredSize(new Dimension(0, 0));
	            jbutton.setMinimumSize(new Dimension(0, 0));
	            jbutton.setMaximumSize(new Dimension(0, 0));
	            return jbutton;
	        }
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(75, 75, 75);
		        this.trackColor = new Color(64, 64, 64);
		        this.scrollBarWidth = 5;
		    }
		});
		
		scrollPane_1_1.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			@Override
	        protected JButton createDecreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        @Override    
	        protected JButton createIncreaseButton(int orientation) {
	            return createZeroButton();
	        }
	        private JButton createZeroButton() {
	            JButton jbutton = new JButton();
	            jbutton.setPreferredSize(new Dimension(0, 0));
	            jbutton.setMinimumSize(new Dimension(0, 0));
	            jbutton.setMaximumSize(new Dimension(0, 0));
	            return jbutton;
	        }
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(75, 75, 75);
		        this.trackColor = new Color(64, 64, 64);
		        this.scrollBarWidth = 5;
		    }
		});
		
		scrollPane_1_2.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
			@Override
	        protected JButton createDecreaseButton(int orientation) {
	            return createZeroButton();
	        }

	        @Override    
	        protected JButton createIncreaseButton(int orientation) {
	            return createZeroButton();
	        }
	        private JButton createZeroButton() {
	            JButton jbutton = new JButton();
	            jbutton.setPreferredSize(new Dimension(0, 0));
	            jbutton.setMinimumSize(new Dimension(0, 0));
	            jbutton.setMaximumSize(new Dimension(0, 0));
	            return jbutton;
	        }
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(75, 75, 75);
		        this.trackColor = new Color(64, 64, 64);
		        this.scrollBarWidth = 5;
		    }
		});
		
//		JLabel nameLabel = new JLabel("Hello, " + App.user.getName() + "|");
//		nameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
//		nameLabel.setBounds(712, 4, 186, 23);
//		frame.getContentPane().add(nameLabel);

//		
//		btnNewButton.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				String sql_1 = "Update `Resident` Set `Name` = '" + textField.getText() + 
//						 "', `Gender` = '" + comboBox.getSelectedItem() + 
//						 "', `Birthday` = '" + textField_1.getText() + 
//						 "', `Phone Number` = '" + textField_2.getText() +
//						 "', `Address` = '" + textField_3.getText() +
//						 "' Where `RID` = '" + App.user.getRID() + "'";
//				try {
//					Statement st = App.connection.makeConnection().createStatement();
//					st.executeUpdate(sql_1);
//					JOptionPane.showMessageDialog(tab_1, "Cập nhật thành công!");
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {}
//			@Override
//			public void mouseReleased(MouseEvent e) {}
//			@Override
//			public void mouseEntered(MouseEvent e) {}
//			@Override
//			public void mouseExited(MouseEvent e) {}
//		});
		
//		JLabel lblNewLabel = new JLabel("Logout");
//		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
//		lblNewLabel.setBounds(897, 4, 57, 23);
//		frame.getContentPane().add(lblNewLabel);
		
		menuButton_1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				accountInfoPane.setVisible(true);
				desktopPane.setVisible(false);
				scrollPane_1.setVisible(false);
				infoPanel_1.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
			
		});
		
		menuButton_2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				desktopPane.setVisible(false);
				accountInfoPane.setVisible(false);
				scrollPane_1.setVisible(true);
				infoPanel_1.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		
		menuButton_3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				accountInfoPane.setVisible(false);
				desktopPane.setVisible(true);
				infoPanel_1.setVisible(false);
				scrollPane_1.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}
}
