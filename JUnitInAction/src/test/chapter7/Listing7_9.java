package test.chapter7;

import java.io.IOException;
import java.io.InputStream;

import test.required.ConnectionFactory;

public class Listing7_9 {

	private static final int EOS = -1;

	public String getContent(ConnectionFactory connectionFactory){

		StringBuffer content = new StringBuffer();

		try{
			InputStream inputStream = connectionFactory.getData();

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
