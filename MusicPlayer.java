package task;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class MusicPlayer {

	public static void main(String[] args) throws IOException, URISyntaxException {
		Desktop d=Desktop.getDesktop();
		d.browse(new URI("https://www.youtube.com/watch?v=NaXSlw0Fbbw"));
	}

}