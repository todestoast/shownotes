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
	
	public void addLink( String url, String text, boolean link )
	{
		if( link )
		{
			final String linkhtml = "<img src='" + this.getIcon(url) + "' alt='logo' /> <a href='" + url.toString() + "'>"
					+ text.toString() + " </a>&#8226; ";
			
			fm.writeInFile( file, linkhtml.toString() );
		}else
		{
			FileManager pcsManager = new FileManager();
			
			final String timestamp = url.toString();
			
			final String timestamphtml = "<ul><li><strong>" + text.toString() + " [" +  timestamp + "]</strong></li></ul>";
			fm.writeInFile( file, timestamphtml.toString() );
			
			File pcsFile = new File( file.getAbsolutePath().replaceAll(".html", ".pcs") );
			
			pcsManager.writeInFile(pcsFile, url + ".000" + " " + text + "\n");
			
		}
		
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
		final CharSequence moviepilot = "moviepilot.de";
		final CharSequence geocaching = "geocaching.com";
		final CharSequence coordinfo = "coord.info";
		final CharSequence soundcloud = "soundcloud.com";
		final CharSequence spon = "spiegel.de";
		final CharSequence facebook = "facebook.com";
		final CharSequence hld = "heissluftdampfer.de";
		final CharSequence bwt = "bewegtton.de";
		final CharSequence onahrung = "ohren-nahrung.de";
		final CharSequence faz = "faz.net";
		
		final String domain = "http://files.tuximail.de/pics/";
		final String wwwlogo = "www.png";
		final String imdblogo = "imdb.png";
		final String amazonlogo = "amazon.png";
		final String twitterlogo = "twitter.png";
		final String wikipedialogo = "wikipedia.png";
		final String youtubelogo = "youtube.png";
		final String tvtropeslogo = "tvtropes.png";
		final String vimeologo = "vimeo.png";
		final String moviepilotlogo = "moviepilot.png";
		final String geocachinglogo = "geocaching.png";
		final String soundcloudlogo = "soundcloud.png";
		final String sponlogo = "spon.png";
		final String facebooklogo = "facebook.png";
		final String hldlogo = "hld.png";
		final String bwtlogo = "bewegtton.png";
		final String onahrunglogo = "onahrung.png";
		final String fazlogo = "faz.png";
		
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
		if( url.contains(moviepilot) )
		{
			returnstring = moviepilotlogo;
		}
		if( url.contains(geocaching) || url.contains(coordinfo) )
		{
			returnstring = geocachinglogo;
		}
		if( url.contains(soundcloud) )
		{
			returnstring = soundcloudlogo;
		}
		if( url.contains(spon) )
		{
			returnstring = sponlogo;
		}
		if( url.contains(facebook) )
		{
			returnstring = facebooklogo;
		}
		if( url.contains(hld) )
		{
			returnstring = hldlogo;
		}
		if( url.contains(bwt) )
		{
			returnstring = bwtlogo;
		}
		if( url.contains(onahrung))
		{
			returnstring = onahrunglogo;
		}
		if( url.contains(faz) )
		{
			returnstring = fazlogo;
		}
		
		
		return domain + returnstring;
	}

}
