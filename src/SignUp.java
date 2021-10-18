import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import javax.imageio.ImageIO;
//import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame implements ActionListener{
	JPanel topPnl, midPnl, botPnl, radioPnl, panel;
	JLabel titleLbl, usernameLbl, genderLbl, emailLbl, passLbl, confirmPassLbl, addressLbl, dobLbl;
	JButton signUpBtn, backBtn;
	JRadioButton maleRB, femaleRB;
	JTextField usernameField, emailField, addressField;
	JPasswordField passField, confirmField;
	JDateChooser DOB;
//	JLabel img = new JLabel(new ImageIcon("600x400.png"));
	
	
	BufferedImage img;
	
	public SignUp() {
//		loadImage("600x400.png");

//		panel = new JPanel();
		topPnl = new JPanel();
		midPnl = new JPanel(new GridLayout(7,2,15,15));
		midPnl.setBorder(new EmptyBorder(10,30,10,8));
		botPnl = new JPanel(new FlowLayout());
		radioPnl = new JPanel();
		
		titleLbl = new JLabel("Sign up to JP.ID");
		
		usernameLbl = new JLabel("UserName"); 
		genderLbl = new JLabel("Gender");
		emailLbl = new JLabel("Email");
		passLbl = new JLabel("Password");
		confirmPassLbl = new JLabel("Confirm Password");
		addressLbl = new JLabel("Address");
		dobLbl = new JLabel("DOB");
		
		usernameField = new JTextField();
		emailField = new JTextField();
		addressField = new JTextField();
		
		passField = new JPasswordField();
		confirmField = new JPasswordField();
		
		DOB = new JDateChooser();
		
		femaleRB = new JRadioButton("Female"); femaleRB.setBackground(new Color(170, 68, 86));
		maleRB = new JRadioButton("Male");maleRB.setBackground(new Color(170, 68, 86));
		
		backBtn = new JButton("Back");
		signUpBtn = new JButton("Sign up");
		
//		panel.add(img, set);
		topPnl.setLayout(new FlowLayout(ABORT));
		topPnl.add(backBtn); 
		topPnl.add(titleLbl); titleLbl.setBorder(new EmptyBorder(0,60,0,0));
		
	
		midPnl.add(usernameLbl); 
		midPnl.add(usernameField);
		midPnl.add(genderLbl);
		
		radioPnl.add(femaleRB);
		radioPnl.add(maleRB);
		
		ButtonGroup genderGrup = new ButtonGroup();
		genderGrup.add(maleRB);
		genderGrup.add(femaleRB);
		
		
		midPnl.add(radioPnl);
		midPnl.add(emailLbl);
		midPnl.add(emailField);
		midPnl.add(passLbl);
		midPnl.add(passField);
		midPnl.add(confirmPassLbl);
		midPnl.add(confirmField);
		midPnl.add(addressLbl);
		midPnl.add(addressField);
		midPnl.add(dobLbl);
		midPnl.add(DOB);
		
		botPnl.setLayout(new FlowLayout());
		botPnl.add(signUpBtn);
		
//		add(panel);
		add(topPnl, BorderLayout.NORTH);
		add(midPnl, BorderLayout.WEST);
		add(botPnl, BorderLayout.SOUTH);
		
		signUpBtn.addActionListener(this);
		backBtn.addActionListener(this);

//		loadImage("600x400.png");
		initFrame();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
	}
	
	public void loadImage(String path) {
		File imgFile = new File(path);
		try {
			img =  ImageIO.read(imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initFrame() {
		setSize(600, 400);
		setTitle("JP.ID Sign Up");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signUpBtn) {
			validateData();
		}else {
			resetData();
			
		}
	}
	
	private void resetData() {
		usernameField.setText("");
		maleRB.setSelected(false);
		femaleRB.setSelected(false);
		emailField.setText("");
		passField.setText("");
		confirmField.setText("");
		addressField.setText("");
		DOB.setCalendar(null);
	}


	private void validateData() {
		String username = usernameField.getText();
		String gender = (maleRB.isSelected())? maleRB.getText() : femaleRB.getText();
		String email = emailField.getText();
		String pass = new String(passField.getText());
		String confirmpass =  new String(confirmField.getText());
		String address = addressField.getText();
		java.util.Date dob;
		dob = DOB.getDate();
		
		Calendar c = Calendar.getInstance();
        c.setTime(dob);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, date);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(l1, now1);
        int tanggal = diff1.getDays();
        
    	
        
		if (username.isEmpty()) {
			errorMessage("Username must be filled!");
		}else if ((username.length()<= 5) || (username.length()>=50)) {
			errorMessage("Username length must be between 5 and 50!");
		} else if (!maleRB.isSelected() && !femaleRB.isSelected()) {
			errorMessage("Please select your gender!");
		} else if (email.isEmpty()) {
			errorMessage("Email must be filled!");
		} else if (!email.contains("@")) {
			errorMessage("Email must be valid");
		} else if (!email.contains(".com")) {
			errorMessage("Email must be valid");
		} else if (pass.isEmpty()) {
			errorMessage("Password must be filled!");
		} else if ((pass.length()<= 8) || (pass.length()>=50)) {
			errorMessage("Password length must be between 8 and 50!");
		} else if (!isAlphannumeric(pass)||!isAlphannumeric(confirmpass)) {
			errorMessage("Password must be alphanumeric");
		} else if (confirmpass.isEmpty()) {
			errorMessage("Confirm password must be filled!");
		} else if (!confirmpass.matches(pass)) {
			errorMessage("Confirm password don't match password!");
		} else if ((address.length()<=8) || (address.length()>=50)) {
			errorMessage("Address must more than 8 character");
		}else if (tanggal < (tanggal-1)) {
			errorMessage("DOB must be at least yesterday");
		} else {
//			int temp = JOptionPane.showConfirmDialog(null, "Your data has been submitted!","Message", JOptionPane.OK_OPTION);
//			if(temp == JOptionPane.OK_OPTION) {
//			resetData();
//			}
			
			new HomePage();
		}
	}

	private boolean isAlphannumeric(String pass) {
		boolean hasAlpha = false;
		boolean hasNumeric = false;
		
		String temp = pass.toLowerCase();
		for (int i=0; i<temp.length(); i++) {
			if(temp.charAt(i)>='a' && temp.charAt(i)<='z') {
				hasAlpha = true;
			}else if(temp.charAt(i)>='0' && temp.charAt(i)<='9') {
				hasNumeric= true;
			}else {
				return false;
			}
		}
		return hasAlpha && hasNumeric;
		
	}
	
	private void errorMessage(String str) {
		JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.ERROR_MESSAGE);
	}
	

}
