package shownotes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public MainWindow( Dimension dimension )
	{
		this.lm = new Linkmanager();
		
		this.setSize( dimension );
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		this.setLayout( new BorderLayout() );
		
		this.panel = new JPanel();
		this.textfield = new JTextField( 30 );
		this.linkfield = new JTextField( 30 );
		this.textlabel = new JLabel( "Text:" );
		this.linklabel = new JLabel( "Link:" );
		this.button = new JButton( "Add" );
		
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
		panel.add( this.button );
		
		this.add( this.panel , BorderLayout.CENTER );
		
		this.setVisible( true );
		
		this.button.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				lm.addLink( linkfield.getText(), textfield.getText() );
				
			}
		});
		
	}
	
	
}
