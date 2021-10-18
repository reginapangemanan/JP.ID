import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignIn extends JFrame implements ActionListener{
	 JPanel topPnl, midPnl, botPnl;
	 JLabel titleLbl, emailLbl,noteLbl, passLbl;
	 JButton signInBtn, backBtn;
	 JTextField emailField;
	 JPasswordField passField;
//	 JLabel bg= new JLabel(new ImageIcon("400x300.png"));
//	 JPanel pn = new JPanel();
	 BufferedImage img, imgkotak;
	 
public SignIn(){
	//init();

	  topPnl = new JPanel(new GridLayout());
	  midPnl = new JPanel(new GridLayout(8,1,15,15));
	  midPnl.setBorder(new EmptyBorder(50,330,130,330));//
	  botPnl = new JPanel(new FlowLayout());

	  titleLbl = new JLabel("Sign In to JP.ID");
	  titleLbl.setFont(new Font("Arial", Font.BOLD, 18));
	  
	  emailLbl = new JLabel("Email");
	  passLbl = new JLabel("Password");
	  noteLbl = new JLabel("No account?");
	  
	  emailField = new JTextField();
	  
	  passField = new JPasswordField();
	  
	  backBtn = new JButton("Back");
	  signInBtn = new JButton("Sign in");
	  signInBtn.addActionListener(this);
	  
	  topPnl.setLayout(new FlowLayout(ABORT));
	  topPnl.add(backBtn); 
	  midPnl.add(titleLbl); 
	  titleLbl.setBorder(new EmptyBorder(0,45,0,0));
	  titleLbl.setLayout(new FlowLayout());
	  
	  midPnl.add(emailLbl);
	  midPnl.add(emailField);
	  midPnl.add(passLbl);
	  midPnl.add(passField);
	  midPnl.add(noteLbl);  
	 // midPnl= new JPanel(new FlowLayout());
	 // midPnl.setLayout(new FlowLayout());
	  midPnl.add(signInBtn);
	  
	  add(topPnl, BorderLayout.NORTH);
	  add(midPnl, BorderLayout.CENTER);
	  add(botPnl, BorderLayout.SOUTH);
	  loadImage("400x300.png");
	 
	  initFrame();
}

//public void init() {
//	pn.add(bg,BorderLayout.CENTER);
//	add(pn);
//}

public void resetData() {
	emailField.setText("");
	passField.setText("");
}

public void validateData() {
	String email = emailField.getText();
	String password = new String(passField.getPassword());
	
	if(email.isEmpty()){
		errorMessage("Email must be filled");
	}else if(password.isEmpty()) {
		errorMessage("Password must be filled");
	}else {
		String str = "Email : " + email;
		int result = JOptionPane.showConfirmDialog(null, str, "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			resetData();
			}
		}
	}
@Override
public void actionPerformed(ActionEvent arg0) {
	if(arg0.getSource() == signInBtn) {
		validateData();
		}else {
			resetData();
		}
	}

@Override
public void paint(Graphics g) {
super.paint(g);
Graphics2D g2d = (Graphics2D)g;
g2d.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
g2d.setColor(Color.decode("#fff9f4"));
g2d.fillRect(230, 120,450, 380);
g2d.drawImage(imgkotak, 100, 60, 30, 50, null);
}

public void loadImage(String path) {
File imgFile = new File(path);
try {
  img =  ImageIO.read(imgFile);
 } catch (IOException arg0) {
  arg0.printStackTrace();
 }
}
public void loadImg1(String p){
	File filei = new File(p);
	try {
		imgkotak = ImageIO.read(filei);
	} catch (IOException e) {
		e.printStackTrace();
	}

}

private void errorMessage(String str) {
	JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.ERROR_MESSAGE);
}

private void initFrame() {
 setSize(900, 600);
 setTitle("JP.ID Sign Up");
 setLocationRelativeTo(null);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setResizable(true);
 setVisible(true);
}	  

	public static void main(String[] args) {
		new Main();
	}


}
