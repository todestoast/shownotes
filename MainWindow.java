package shownotes;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.jar.Attributes.Name;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainWindow extends JFrame implements ItemListener, DocumentListener
{
	JPanel panel;
	JTextField textfield;
	JTextField linkfield;
	JLabel textlabel;
	JLabel linklabel;
	JButton button;
	Linkmanager lm;
	Checkbox checkbox;
	JLabel checklabel;
	Boolean wasset;
	int vorher;
	boolean autocomplete;
	
	File file;
	
	
	public MainWindow( Dimension dimension, File file, final boolean newline, final boolean autocomplete )
	{
		
		this.lm = new Linkmanager(file);
		this.wasset = false;
		vorher = 0;
		this.autocomplete = autocomplete;
		
		this.setSize( dimension );
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		this.setLayout( new BorderLayout() );
		this.file = file;
		
		this.panel = new JPanel();
		this.textfield = new JTextField( 30 );
		this.linkfield = new JTextField( 30 );
		this.textlabel = new JLabel( "Text:" );
		this.linklabel = new JLabel( "Link:" );
		this.button = new JButton( "Add" );
		
		this.checkbox = new Checkbox();
		this.checklabel = new JLabel("New Chapter: ");
		
		this.panel.setVisible( true );
		this.textfield.setVisible( true );
		this.linkfield.setVisible( true );
		this.textlabel.setVisible( true );
		this.linklabel.setVisible( true );
		
		this.panel.setLayout( new FlowLayout() );
		this.panel.add( this.linklabel );
		this.panel.add( this.linkfield );
		this.panel.add( this.textlabel );
		this.panel.add( this.textfield );
		this.panel.add( this.button );
		this.panel.add( this.checklabel );
		this.panel.add( this.checkbox );
		
		this.add( this.panel , BorderLayout.CENTER );
		
		this.setVisible( true );
		
		
		this.linkfield.getDocument().addDocumentListener( this );
		
		this.button.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				lm.addLink( linkfield.getText(), textfield.getText(), !checkbox.getState(), newline );
				checkbox.setState( false );
				
				linklabel.setText( "Link:" );
				linkfield.setText( "" );
				
				textlabel.setText( "Text:" );
				textfield.setText( "" );
				linkfield.requestFocus();
				
				vorher=0;
			}
		});
		
		this.checkbox.addItemListener( this ); 
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) 
	{

		if( this.wasset )
		{
			linklabel.setText( "Link:" );
			linkfield.setText( "" );
			
			textlabel.setText( "Text:" );
			textfield.setText( "" );
			linkfield.requestFocus();
			this.wasset = false;
		}else
		{
			linklabel.setText( "Time:" );
			textlabel.setText( "Title:" );
			linkfield.requestFocus();
			this.wasset = true;
		}
		
		
		
	}


	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insertUpdate(DocumentEvent e) 
	{
		if(autocomplete)
		{
		
		this.vorher++;
		String text = linkfield.getText();
		
		
	//	System.out.println( "Aktion im linkfeld" );
		if( text.length() > 5 && !checkbox.getState() && vorher < 2 )
		{
			
			if( !(text.contains("http")) )
			{
				text = "http://" + text;
			}
			textfield.setText( lm.getHeader(text) );
			vorher = 0;
		}
		}
		
	}


	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
