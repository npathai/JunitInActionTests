package test.required;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient {

	private static final int EOS = -1;
	
	public String getContent(URL url){

		StringBuffer content = new StringBuffer();
		
		try{
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
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
}
