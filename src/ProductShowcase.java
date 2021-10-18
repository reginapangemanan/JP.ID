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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class ProductShowcase extends JFrame implements ActionListener {
	
	JPanel topPnl,botPnl;
	JButton rotateLBtn, rotateRBtn, zoomInBtn, zoomOutBtn, closeBtn;
	BufferedImage img;
//	JLabel img = new JLabel(new ImageIcon("Y740.jpg"));
	int x=0;
	int y =0;
	
	public ProductShowcase() {
		topPnl = new JPanel();
		botPnl= new JPanel(new GridLayout(1,1));

		
		rotateLBtn = new JButton("Rotate Left");
		rotateRBtn = new JButton("Rotate Right");
		zoomInBtn = new JButton("Zoom In");
		zoomOutBtn = new JButton("Zoom Out");
		closeBtn = new JButton("Close");
		
//		topPnl.add(img, BorderLayout.CENTER);
		botPnl.setLayout(new FlowLayout());
		botPnl.add(rotateLBtn);
		botPnl.add(rotateRBtn);
		botPnl.add(zoomInBtn);
		botPnl.add(zoomOutBtn);
		botPnl.add(closeBtn);
		
		
		rotateLBtn.addActionListener(this);
		rotateRBtn.addActionListener(this);
		zoomInBtn.addActionListener(this);
		zoomOutBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		
		
		add(topPnl,BorderLayout.NORTH);
//		add(botPnl, FlowLayout.CENTER);
		add(botPnl, BorderLayout.SOUTH);
		
		topPnl.setBackground(Color.black);
		botPnl.setBackground(Color.black);
		
		loadImage("Y740.jpg");
		initFrame();
		
		
	}
	
	double degree = 0;
	double scale = 1;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(x,y);
		g2d.rotate(degree,img.getWidth()/2,img.getHeight()/2);
		g2d.scale(scale, scale);
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
		setSize(1070, 605);
		setTitle("Product Showcase Pop Up");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(zoomInBtn)) {
			scale+=0.1;
			repaint();
		} else if (e.getSource().equals(zoomOutBtn)) {
			scale-=0.1;
			repaint();
		} else if (e.getSource().equals(rotateLBtn)) {
			degree += Math.PI / 100;
			repaint();
		} else if (e.getSource().equals(rotateRBtn)) {
			degree -= Math.PI / 100;
			repaint();
		} else if (e.getSource().equals(closeBtn)) {
			new PromoEvent();
		}
		
	}
}
