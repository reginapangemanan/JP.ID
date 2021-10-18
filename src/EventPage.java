import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

public class EventPage extends JFrame implements ActionListener {

	JPanel header, header1;
	JButton backbutton;
	JLabel title;
	
	private static String VLCpath = "C:\\Program Files\\VideoLAN\\VLC";
	private String Videopath = "legion.mp4";
	 
	 private EmbeddedMediaPlayerComponent mediaplayer = new EmbeddedMediaPlayerComponent();
	
	public EventPage() {
		
		add(mediaplayer);
		setSize(1200, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		
		backbutton = new JButton("Back");
		backbutton.setFont(new Font("Calibri", Font.PLAIN, 16));
		backbutton.setBackground(Color.decode("#fffef2"));
		backbutton.setForeground(Color.decode("#AB4659"));
		
		title = new JLabel("JP.ID Promo Event Item");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setForeground(Color.WHITE);
		
//		header = new JPanel(new GridLayout(1,2));
//		header.setBackground(Color.BLACK);
//		header.add(backbutton);
//		header.add(title);
		
		backbutton.addActionListener(this);
		
		header = new JPanel(new FlowLayout(FlowLayout.CENTER));
		header.setBackground(Color.BLACK);
		header.add(backbutton);
		header1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		header1.add(title);
		header.add(title);
		add(header, BorderLayout.NORTH);
		
	//	add(header1, BorderLayout.CENTER);
		
//		mediaplayer.getMediaPlayer().prepareMedia(Videopath);
//	    mediaplayer.getMediaPlayer().play();
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backbutton) {
			new HomePage();
		}

		
	}
	
	public static void loadLibrary(){
		 
		 NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), VLCpath);
		 Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		  
		 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadLibrary();
		new EventPage();
		
	}

}
