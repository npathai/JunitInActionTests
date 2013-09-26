package test.chapter7;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Listing7_7 {

	private static final int EOS = -1;

	public String getContent(URL url){

		StringBuffer content = new StringBuffer();

		try{
			HttpURLConnection conn = createHTTPURLConnection(url); //making this method makes code extensible
			
			conn.setDoInput(true);
			InputStream inputStream = conn.getInputStream();

			int count;
			byte[] buffer = new byte[2048];
			while(EOS != (count = inputStream.read(buffer))){
				content.append(new String(buffer,0,count));
			}
		}catch (IOException e) {
			return null;
		}
		return content.toString();
	}

	//Allow mock to override this
	protected HttpURLConnection createHTTPURLConnection(URL url) throws IOException {
		return (HttpURLConnection) url.openConnection();
	}
}

