package shownotes;

import java.io.File;

public class Linkmanager 
{
	
	FileManager fm;
	File file;
	
	public Linkmanager()
	{
		this.fm = new FileManager();
		this.file = new File( "test.html" );
		fm.writeInFile( file, "<div>Die Shownotes wurden mit der Software <a href='https://github.com/todestoast/shownotes/'>shownotes</a> "
				+ "erstellt. Die Lizenzen der verwendeten Logos finden sich <a href='https://github.com/todestoast/shownotes/blob/master/LOGOS.md'>hier</a></div><br />");
	}
	
	public void addLink( String url, String text )
	{
		final String linkhtml = "<img src='" + this.getIcon(url) + "' alt='logo' /> <a href='" + url.toString() + "'>"
				+ text.toString() + "</a> ";
		
		fm.writeInFile( file, linkhtml.toString() );
	}
	
	public String  getIcon( String url )
	{
		final CharSequence imdb = "imdb.com";
		final CharSequence amazon = "amazon.de";
		final CharSequence twitter = "twitter.com";
		final CharSequence wikipedia = "wikipedia.org";
		final CharSequence youtube = "youtube.com";
		
		final String domain = "http://files.tuximail.de/pics/";
		final String wwwlogo = "www.png";
		final String imdblogo = "imdb.png";
		final String amazonlogo = "amazon.png";
		final String twitterlogo = "twitter.png";
		final String wikipedialogo = "wikipedia.png";
		final String youtubelogo = "youtube.png";
		
		String returnstring = wwwlogo;
		
		if( url.contains(imdb) )
		{
			returnstring = imdblogo;
		}
		if( url.contains(amazon) )
		{
			returnstring = amazonlogo;
		}
		if( url.contains(twitter) )
		{
			returnstring = twitterlogo;
		}
		if( url.contains(wikipedia) )
		{
			returnstring = wikipedialogo;
		}
		if( url.contains(youtube) )
		{
			returnstring = youtubelogo;
		}
		
		return domain + returnstring;
	}

}
