package shownotes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileManager 
{
	public FileManager()
	{
		
	}
	public List<String> getheaderlines( String filename)
	{
		String returnstring = "";
		CharSequence header = "<h1";
		CharSequence headerend = "</h1>";
		List<String> returns = new ArrayList<String>();
		 String temp = "";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename),
                    Charset.defaultCharset());
            for (String line : lines) {
                
            	StringBuffer linebuffer = new StringBuffer( line );
            	//System.out.println(line + "\n");
            	
            	
            	char[] array = new char[500];
            	String tempus = "";
            	
            	while( linebuffer.length() > 500 )
            	{
            		linebuffer.getChars(0, 500, array, 0);
            		
                	linebuffer.delete(0, 500);
                	tempus = new String( array );
                	if( tempus.contains(header) || tempus.contains(headerend) )
                	{
                		temp = new String ( array );
                		returns.add( temp );
                	}
                	
            	}
            	
            	
            
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return returns;
	}
	public String getContentofFile( File file )
	{
		String returnstring = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) 
	    {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	       returnstring  = sb.toString();
	    } catch( Exception e )
	    {
	    	System.out.println( "Error while trying to read from file!" );
	    }
	    return new StringBuffer(returnstring).toString();
	}
	
	public String removeComment( StringBuffer string )
	{
		//den disclaimer rausschneiden
				while( string.indexOf("#") != -1)
				{
					string.delete( string.indexOf("#"), (string.indexOf("\n")+1) );
				}
				return string.toString().trim();
	}
	
	public boolean fileExists( File file )
	{
		return file.exists();
	}
	
	public void writeInFile( File file, String text, boolean newline )
	{
			try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter( file, true)))) 
			{
			    out.print( fixUmlaute(text, newline) );
			}catch (IOException e) 
			{
			    System.out.println( "Couldn't write in File" );
			}
	}

	public void emptyFile( File file )
	{
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public String fixUmlaute( String umlauttext, boolean newline )
	{
		umlauttext = umlauttext.replaceAll( "ö", "&ouml;" );
		umlauttext = umlauttext.replaceAll( "ä", "&auml;" );
		umlauttext = umlauttext.replaceAll( "ü", "&uuml;" );
		umlauttext = umlauttext.replaceAll( "Ä", "&Auml;" );
		umlauttext = umlauttext.replaceAll( "Ö", "&Ouml;" );
		umlauttext = umlauttext.replaceAll( "Ü", "&Uuml;" );
		umlauttext = umlauttext.replaceAll( "ß", "&szlig;" );
		//editorpane creates html tags which need to be removed
		umlauttext =  umlauttext.replaceAll( "<html>", "" );
		umlauttext =  umlauttext.replaceAll( "<head>", "" );
		umlauttext =  umlauttext.replaceAll( "<body>", "" );
		umlauttext =  umlauttext.replaceAll( "</html>", "" );
		umlauttext =  umlauttext.replaceAll( "</head>", "" );
		umlauttext =  umlauttext.replaceAll( "</body>", "" );
		if( !newline )
			umlauttext = umlauttext.replaceAll( "\n", " " );
		
		
		
		return umlauttext;
	}
	
	public void deleteFile( String filename )
	{
		try{
			 
    		File file = new File( filename );
 
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
 
    	}catch(Exception e){
 
    		e.printStackTrace();
 
    	}
	}
}
