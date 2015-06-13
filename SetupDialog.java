package shownotes;

import java.awt.BorderLayout;
import java.awt.Checkbox;
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
	
	JFrame hier = this;
	
	JLabel name;
	JLabel nummer; 
	
	JLabel umbruch;
	JLabel umbruchzusatz;
	Checkbox check;
	
	JPanel namenpanel;
	JPanel nummerpanel;
	JPanel panel2;
	JPanel panel3;
	JPanel autopanel;
	JLabel autolabel;
	Checkbox autobox;
	JButton button;
	
	public SetupDialog( Dimension dimension )
	{
		this.setSize( dimension );
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		this.setLayout( new FlowLayout() );
		
		this.number = new JTextField( 3 );
		this.project = new JTextField( 10 );
		this.name = new JLabel( "Projekt:" );
		this.nummer = new JLabel( "Nummer:" );
		this.namenpanel = new JPanel();
		this.panel2 = new JPanel();
		this.button = new JButton( "Start shownoting" );
		this.nummerpanel = new JPanel();
		this.panel3 = new JPanel();
		this.autopanel = new JPanel();
		this.autobox = new Checkbox();
		this.autolabel = new JLabel( "Autodetect titles?" );
		this.umbruch = new JLabel( "New line after each entry?" );
		this.umbruchzusatz = new JLabel( "(may not work under wordpress)" );
		this.check = new Checkbox();
		
		this.namenpanel.setLayout( new FlowLayout() );
		this.namenpanel.add( name );
		this.namenpanel.add( project );
		this.nummerpanel.add( nummer );
		this.nummerpanel.add( number );
		//this.panel.add( this.button );
		//this.panel.setVisible( true );
		
		this.panel2.setLayout( new FlowLayout() );
		this.panel2.add( this.umbruch );
		this.panel2.add( this.check );
		this.panel3.add( this.umbruchzusatz );
		this.panel2.setVisible( true );
		
		this.autopanel.add( this.autolabel );
		this.autopanel.add( this.autobox );
		
		this.add( namenpanel );
		this.add( nummerpanel );
		this.add( panel2 );
		this.add( panel3 );
		this.add( autopanel );
		this.add( button );
		this.setVisible( true );
		
		this.button.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File file = new File ( number.getText() + "-" + project.getText() + ".html" );
				MainWindow mainwindow = new MainWindow( new Dimension(400, 130), file, check.getState(), autobox.getState() );
				hier.setVisible(false);
			}
		});
		
	}
	
	
	
}
