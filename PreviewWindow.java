package shownotes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class PreviewWindow extends JFrame 
{
	
	JEditorPane edit;
	FileManager fm;
	File filex;
	
	public PreviewWindow( File file)
	{
		this.filex = file;
		this.fm = new FileManager();
		this.edit = new JEditorPane( "text/html", fm.getContentofFile(file) );
		this.setSize( 600, 600 );
		this.setVisible( true );
		JScrollPane scrollPane = new JScrollPane(edit);
		this.add(scrollPane);
		
		
		this.edit.addKeyListener( new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) 
			{
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) 
			{
				fm.emptyFile(filex);
				fm.writeInFile(filex, edit.getText());
			}
			
			@Override
			public void keyPressed(KeyEvent e) 
			{
				
			}
		});
		
	}
	
	public void refreshContent( String text )
	{
		this.edit.setText( text);
	}
	
	

}
