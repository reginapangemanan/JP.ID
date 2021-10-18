import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.color.ColorSpace;
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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PromoEvent extends JFrame implements ActionListener{
	
//	Image image;	
	BufferedImage image, lapimg, imgbg;
	JButton backbutt, usevoucher, pshowcase;
	JPanel toppanel;
	JPanel panel;
	JPanel pnl = new JPanel();
//	JLabel gambar = new JLabel(new ImageIcon("voucherpage.PNG"));
	
	public PromoEvent() {
		// TODO Auto-generated constructor stub
		
		backbutt = new JButton("Back");
		backbutt.setFont(new Font("Calibri", Font.PLAIN, 16));
		backbutt.setBackground(Color.decode("#fffef2"));
		backbutt.setForeground(Color.decode("#AB4659"));
		
		toppanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		toppanel.add(backbutt);
		add(toppanel, BorderLayout.NORTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 750);
		setLocationRelativeTo(null);
		setResizable(true);
//		usevoucher = new JButton("Use Voucher");
//		usevoucher.setFont(new Font("Calibri", Font.PLAIN, 16));
//		usevoucher.setBackground(Color.decode("#fffef2"));
//		usevoucher.setForeground(Color.decode("#AB4659"));
//		
//		panel = new JPanel(new GridLayout(2, 4));
//		panel.add(usevoucher);
//		add(panel);
//		
//		init();
		bg("voucherpage.PNG");
		loadImg("Y540.jpg");
		loadImg1("Y740.jpg");
		loadImg("Y540.jpg");
		
		backbutt.addActionListener(this);
//		System.out.println(image.getHeight());
	
//		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
//	public void init() {
//		// TODO Auto-generated method stub
//		pnl.add(gambar, BorderLayout.CENTER);
//		add(pnl);
//	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		Graphics2D g2d =  (Graphics2D) g;
		
		g2d.drawImage(imgbg, 0, 0, imgbg.getWidth(), imgbg.getHeight(), null);
		
		g2d.setFont(new Font("Arial", Font.PLAIN, 20));
		g2d.setColor(Color.white);
		g2d.drawString("JP.ID Promo Event Item", 500, 60);
		
		g2d.setColor(Color.GRAY);
		g2d.fillRect(230, 75, 700, 630);
		
		g2d.setColor(Color.black);
		g2d.fillRect(280, 90, 600, 600);
		
		
		g2d.drawImage(image, 320, 90, 550, 300, null);
		
		g2d.setFont(new Font("Arial", Font.BOLD, 12));
		g2d.setColor(Color.WHITE);
		g2d.drawString("Name : Lelegion Y540", 380, 400);
		
		g2d.setFont(new Font("Arial", Font.BOLD, 12));
		g2d.setColor(Color.WHITE);
		g2d.drawString("Price : Rp. 17999999", 382, 430);
		
		g2d.setFont(new Font("Arial", Font.BOLD, 12));
		g2d.setColor(Color.WHITE);
		g2d.drawString("Ongkir : Rp. 20000", 387, 460);
		
		g2d.drawImage(lapimg, 600, 530, 270, 150, null);
		
		g2d.drawImage(image, 300, 530, 270, 150, null);
		
	}
	
	public void bg(String b){
		File filebg = new File(b);
		try {
			imgbg = ImageIO.read(filebg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImg(String path){
		File fileimg = new File(path);
		try {
			image = ImageIO.read(fileimg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImg1(String p){
		File filei = new File(p);
		try {
			lapimg = ImageIO.read(filei);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PromoEvent();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	

		
	}



}
