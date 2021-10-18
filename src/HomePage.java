import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class HomePage extends JFrame implements ActionListener{
	
	BufferedImage img;
	
	JButton signbtn;
	JButton extbtn;
	
	JMenuBar menubar;
	JMenu voumenu;
	JMenu evnmenu;
	JMenu promenu;
	
	JPanel panel = new JPanel();
	JPanel footer = new JPanel();
	
	public EmbeddedMediaPlayer music;
	
//	public JPanel createbtnpanel() {
//		signbtn = new JButton("Sign in");
//		extbtn = new JButton("Exit");
//		JPanel btnpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JPanel butonpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		btnpanel.add(signbtn);
//		butonpanel.add(extbtn);
//		
//
//		return btnpanel;
//		
//	}
	
	public HomePage() {
		
		//add(createbtnpanel(), BorderLayout.SOUTH);
		loadImage("red.png");
		setSize(950,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		voumenu = new JMenu("Voucher");
		evnmenu = new JMenu("Event");
		promenu = new JMenu("Promo");
		
		signbtn = new JButton("Sign in");
		extbtn = new JButton("Exit");
		
		voumenu.setMnemonic(KeyEvent.VK_V);
		evnmenu.setMnemonic(KeyEvent.VK_E);
		promenu.setMnemonic(KeyEvent.VK_P);
		
		menubar.add(voumenu);
		menubar.add(evnmenu);
		menubar.add(promenu);
		
		menubar.setBackground(new Color(170, 68, 86));
		voumenu.setForeground(Color.white);
		evnmenu.setForeground(Color.white);
		promenu.setForeground(Color.white);
		
		init();
//		Jbutton btnpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JPanel butonpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		footer.add(signbtn);
//		butonpanel.add(extbtn);
		
//		signbtn.setLayout(new FlowLayout(FlowLayout.LEFT));
//		extbtn.setLayout(new FlowLayout(FlowLayout.RIGHT));

		footer.setLayout(new GridLayout(1,2));
		
		footer.add(signbtn);
		footer.add(extbtn);
		
		signbtn.setBackground(new Color(170, 68, 86));
		extbtn.setBackground(new Color(170, 68, 86));
		
		signbtn.setForeground(Color.white);
		extbtn.setForeground(Color.white);
		
		signbtn.addActionListener(this);
		extbtn.addActionListener(this);
		
		add(footer, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}
	
	private void init() {
		music = new MediaPlayerFactory().mediaPlayers().newEmbeddedMediaPlayer();
		try {
			music.media().prepare(new File(getClass().getResource("./home.mp3").toURI()).getAbsolutePath());
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, 0, 0, 950,600, null);
	}
	
	public void loadImage(String path) {
		File imgFile = new File(path);
		try {
			img = ImageIO.read(imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signbtn) {
			new SignIn();
		} else if(e.getSource() == voumenu) {
			new VoucherPage();
		} else{
			setVisible(false);
		}
		
	}

}
