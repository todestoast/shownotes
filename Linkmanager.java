package shownotes;

import java.io.File;

public class Linkmanager 
{
	
	FileManager fm;
	File file;
	
	public Linkmanager( File file )
	{
		this.fm = new FileManager();
		this.file = file;
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
		final CharSequence amazon = "://amazon.de";
		final CharSequence amazonwww = "www.amazon.de";
		final CharSequence twitter = "://twitter.com";
		final CharSequence twitterwww = "www.twitter.com";
		final CharSequence wikipedia = "wikipedia.org";
		final CharSequence youtube = "youtube.com";
		final CharSequence tvtropes = "tvtropes.org";
		final CharSequence vimeo = "vimeo.com";
		
		final String domain = "http://files.tuximail.de/pics/";
		final String wwwlogo = "www.png";
		final String imdblogo = "imdb.png";
		final String amazonlogo = "amazon.png";
		final String twitterlogo = "twitter.png";
		final String wikipedialogo = "wikipedia.png";
		final String youtubelogo = "youtube.png";
		final String tvtropeslogo = "tvtropes.png";
		final String vimeologo = "vimeo.png";
		
		String returnstring = wwwlogo;
		
		if( url.contains(imdb) )
		{
			returnstring = imdblogo;
		}
		if( url.contains(amazon) || url.contains(amazonwww) )
		{
			returnstring = amazonlogo;
		}
		if( url.contains(twitter) || url.contains(twitterwww) )
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
		if( url.contains(tvtropes) )
		{
			returnstring = tvtropeslogo;
		}
		if( url.contains(vimeo) )
		{
			returnstring = vimeologo;
		}
		
		return domain + returnstring;
	}

}
