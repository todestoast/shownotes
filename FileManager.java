package shownotes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileManager 
{
	public FileManager()
	{
		
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
	    	System.out.println( "Error while trying to read from secret file!" );
	    }
	    return this.removeComment( new StringBuffer(returnstring) );
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
	
	public void writeInFile( File file, String text )
	{
			try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter( file, true)))) 
			{
			    out.print( text );
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
	
	public void rewriteFile( File file, String text )
	{
		this.emptyFile(file);
		this.writeInFile(file, "################################## \n"
				+ "##CAUTION! Don't edit this file manually! \n"
				+ "##passer will not work if you destroy the assumed structure of this file! \n" + text);
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
