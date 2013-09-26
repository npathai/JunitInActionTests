package test.required;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.AssertionFailedError;

public class MockInputStream extends InputStream{

	private String buffer;
	private int position;
	private int closeCount;
	
	@Override
	public int read() throws IOException {
		if(position == buffer.length())
			return -1;
		
		return buffer.charAt(position++);
	}
		
	public void setBuffer(String buffer){
		this.buffer = buffer;
	}
	
	@Override
	public void close() throws IOException {
		closeCount++;
		super.close();
	}
	
	public void verifyCloseCount(){
		if(closeCount != 1)
			throw new AssertionFailedError("close() not called or should have been called once and only once. Count: " + closeCount);
	}
}
