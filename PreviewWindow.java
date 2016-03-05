package shownotes;

import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class PreviewWindow extends JFrame 
{
	
	JEditorPane edit;
	
	public PreviewWindow( String text)
	{
		this.edit = new JEditorPane( "text/html", text );
		this.setSize( 600, 600 );
		this.setVisible( true );
		this.edit.setEditable( false );
		JScrollPane scrollPane = new JScrollPane(edit);
		this.add(scrollPane);
		
	}
	
	public void refreshContent( String text )
	{
		this.edit.setText( text);
	}

}
