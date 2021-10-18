import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VoucherPage extends JFrame implements ActionListener{
	 JPanel topPnl, midPnl;
	 JPanel pnl = new JPanel();
	 JLabel titleLbl;
	 JButton backBtn;
	 BufferedImage imgbg, imgtrans, img1, img2, img3, img4, img5,img6,img7, img8 ;
	  
	public VoucherPage() {
		backBtn = new JButton("Back");
		backBtn.setFont(new Font("Calibri", Font.PLAIN, 16));
		backBtn.setBackground(Color.decode("#f2e2d5"));
		backBtn.setForeground(Color.decode("#AB4659"));// fffef2
		
		topPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topPnl.add(backBtn);
		add(topPnl, BorderLayout.NORTH);
		
		backBtn.addActionListener(this);
		
		bg("voucherpage.PNG");
		loadImg("ongkir 10.jpg");
		loadImga("ongkir 20.jpg");
		loadImgb("ongkir 30.jpg");
		loadImgc("ongkir 40.jpg");
		loadImgd("cashback 10.jpg");
		loadImge("cashback 20.jpg");
		loadImgf("cashback 30.jpg");
		loadImgg("cashback 40.jpg");
		initFrame();
		
	}
	@Override
	public void paint(Graphics g) {
	 super.paint(g);
	 Graphics2D g2d = (Graphics2D)g;
	 
	 g2d.drawImage(imgbg, 0, 0, imgbg.getWidth(), imgbg.getHeight(), null);
	 
	 g2d.setFont(new Font("Arial", Font.PLAIN, 40));
	 g2d.setColor(Color.white);
	 g2d.drawString("Vouchers", 530, 120);
	 
	 g2d.setColor(Color.white);
	 g2d.fillRect(150, 130, 900, 580);
	
	 g2d.drawImage(img1, 260, 220, 130, 220, null);//3 kebelakang sama semua
	 g2d.drawImage(img2, 440, 220, 130, 220, null);
	 g2d.drawImage(img3, 620, 220, 130, 220, null);
	 g2d.drawImage(img4, 800, 220, 130, 220, null);
	 
	 g2d.drawImage(img5, 260, 460, 130, 220, null);
	 g2d.drawImage(img6, 440, 460, 130, 220, null);
	 g2d.drawImage(img7, 620, 460, 130, 220, null);
	 g2d.drawImage(img8, 800, 460, 130, 220, null);
	 
	 g2d.drawImage(imgtrans, 600, 530, 270, 150, null);
		
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
			img1 = ImageIO.read(fileimg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImga(String path){
		File fileimg = new File(path);
		try {
			img2 = ImageIO.read(fileimg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImgb(String path){
		File fileimg = new File(path);
		try {
			img3 = ImageIO.read(fileimg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImgc(String path){
		File fileimg = new File(path);
		try {
			img4 = ImageIO.read(fileimg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImgd(String path){
		File fileimg = new File(path);
		try {
			img5 = ImageIO.read(fileimg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImge(String path){
		File fileimg = new File(path);
		try {
			img6 = ImageIO.read(fileimg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImgf(String path){
		File fileimg = new File(path);
		try {
			img7 = ImageIO.read(fileimg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImgg(String path){
		File fileimg = new File(path);
		try {
			img8 = ImageIO.read(fileimg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadImg1(String p){
		File filei = new File(p);
		try {
			imgtrans = ImageIO.read(filei);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	

	 private void initFrame() {
		  setSize(1200, 750);
		  setTitle("Voucher");
		  setLocationRelativeTo(null);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  setResizable(true);
		  setVisible(true);
		 }	  
	public static void main(String[] args) {
	

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn) {
			new HomePage();
		}
		
	}

}
