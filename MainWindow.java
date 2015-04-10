package shownotes;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow extends JFrame 
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
	
	File file;
	
	
	public MainWindow( Dimension dimension, File file )
	{
		
		this.lm = new Linkmanager(file);
		
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
		this.panel.add( this.textlabel );
		this.panel.add( this.textfield );
		this.panel.add( this.linklabel );
		this.panel.add( this.linkfield );
		this.panel.add( this.button );
		this.panel.add( this.checklabel );
		this.panel.add( this.checkbox );
		
		this.add( this.panel , BorderLayout.CENTER );
		
		this.setVisible( true );
		
		this.button.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				lm.addLink( linkfield.getText(), textfield.getText(), !checkbox.getState() );
				checkbox.setState( false );
				
				linklabel.setText( "Link:" );
				linkfield.setText( "" );
				
				textlabel.setText( "Text:" );
				textfield.setText( "" );
				textfield.requestFocus();
			}
		});
		
		this.checkbox.addItemListener( new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) 
			{
				linklabel.setText( "Timestamp:" );
				textlabel.setText( "Title:" );
				textfield.requestFocus();
			}
		});
		
	}
	
	
}
