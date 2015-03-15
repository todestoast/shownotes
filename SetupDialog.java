package shownotes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SetupDialog extends JFrame
{
	JTextField number;
	JTextField project;
	
	JLabel name;
	JLabel nummer; 
	
	JPanel panel;
	JButton button;
	
	public SetupDialog( Dimension dimension )
	{
		this.setSize( dimension );
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		this.setLayout( new BorderLayout() );
		
		this.number = new JTextField( 3 );
		this.project = new JTextField( 10 );
		this.name = new JLabel( "Projekt:" );
		this.nummer = new JLabel( "Nummer:" );
		this.panel = new JPanel();
		this.button = new JButton( "Start shownoting" );
		
		this.panel.setLayout( new FlowLayout() );
		this.panel.add( name );
		this.panel.add( project );
		this.panel.add( nummer );
		this.panel.add( number );
		this.panel.add( this.button );
		this.panel.setVisible( true );
		
		
		this.add( panel );
		
		this.setVisible( true );
		
		this.button.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File file = new File ( number.getText() + "-" + project.getText() + ".html" );
				MainWindow mainwindow = new MainWindow( new Dimension(400, 130), file );
				
			}
		});
		
	}
	
	
	
}
