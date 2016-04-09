package shownotes;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.omg.PortableServer.ServantRetentionPolicyValue;

public class UpdateHandler {
	
	FileManager fm = new FileManager();
	public boolean startanyway = false;
	JFrame frame;
	
 public String getMd5()
 { 
		URL url;
 
		try {
			// get URL content
			url = new URL("http://files.tuximail.de/software/shownotes.md5");
			URLConnection conn = url.openConnection();
 
			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));
 
			String inputLine;
 
			//save to this filename
			String fileName = "shownotes.md5";
			File file = new File(fileName);
 
			if (!file.exists()) {
				file.createNewFile();
			}
 
			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
 
			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
			}
 
			bw.close();
			br.close();
 
			System.out.println("Done");
 
			FileManager fm = new FileManager();
			
			return fm.getContentofFile(file).trim();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "null";
 }
 
 public String getmd5ofFile( String file )
 {
	        String checksum = null;
	        try {
	            FileInputStream fis = new FileInputStream(file);
	            MessageDigest md = MessageDigest.getInstance("MD5");
	          
	            //Using MessageDigest update() method to provide input
	            byte[] buffer = new byte[8192];
	            int numOfBytesRead;
	            while( (numOfBytesRead = fis.read(buffer)) > 0){
	                md.update(buffer, 0, numOfBytesRead);
	            }
	            byte[] hash = md.digest();
	            checksum = new BigInteger(1, hash).toString(16); //don't use this, truncates leading zero
	        } catch (IOException ex) {
	        } catch (NoSuchAlgorithmException ex) {
	        }
	          
	       return checksum;
}
 
 public boolean checkforUpdate()
 {
	// System.out.println( this.getMd5() + " - " + this.getMd5().length() );
	// System.out.println( this.getmd5ofFile("shownotes.jar") + " - " + this.getmd5ofFile("shownotes.jar").length() );
	 
	 if( this.getMd5().equals(this.getmd5ofFile("shownotes.jar")) )
	 {
		 return false;
	 }else
	 {
		 return true;
	 }
 }
 
 public void doUpdate()
 {
	 if( checkforUpdate() )
	 {
		 
	 
	 	frame = new JFrame("Links");
		try {
			final URI uri = new URI("http://files.tuximail.de/software");
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 100);
	    Container container = frame.getContentPane();
	    container.setLayout(new GridBagLayout());
	    JButton button = new JButton();
	    JButton start = new JButton( "Start anyway" );
	    start.setVisible( true );
	    start.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SetupDialog setupDialog = new SetupDialog( new Dimension (300,340) );
				frame.setVisible( false );
			}
		});
	    button.setText("<HTML>There's an update available. Please download it from <FONT color=\"#000099\"><U>http://files.tuximail.de/software</U></FONT></HTML>");
	    button.setHorizontalAlignment(SwingConstants.LEFT);
	    button.setBorderPainted(false);
	    button.setBorder(null);
	    button.setOpaque(false);
	    button.setBackground(Color.WHITE);
	    button.setToolTipText(uri.toString());
	    button.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				open(uri);
				
			}
		});
	    container.add(button);
	    container.add( start ); 
	    frame.setVisible(true);

 } catch (URISyntaxException e1) {
		System.out.println( "Browser could not be opened" );
		
	}
	 }else
	 {
		 SetupDialog setupDialog = new SetupDialog( new Dimension (300,340) ); 
	 }
}
	/** if( checkforUpdate() )
	 {
		 JFrame updateFrame = new JFrame( "Update" );
		 updateFrame.setLayout( new FlowLayout() );
		 //updateFrame.setDefaultCloseOperation( EXIT_ON_CLOSE );
		 JLabel updatetext = new JLabel( "There's an update available. Please download it from http://files.tuximail.de/software" );
		 
		 updateFrame.setSize(new Dimension(700,100));
		 updateFrame.add(updatetext);
		 updateFrame.setVisible( true );
		 
		 fm.deleteFile( "soundboard.md5" );
		 
	 }**/


 private static void open(URI uri) {
    if (Desktop.isDesktopSupported()) {
      try {
        Desktop.getDesktop().browse(uri);
      } catch (IOException e) { /* TODO: error handling */ }
    }
  }
 
}