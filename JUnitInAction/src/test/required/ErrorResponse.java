package test.required;

public class ErrorResponse implements Response{

	private Request originalRequest;
	private Exception originalException;
	
	public ErrorResponse(Request originalRequest, Exception originalException){
		this.originalException = originalException;
		this.originalRequest = originalRequest;
	}
	
	public Request getOriginalRequest(){
		return originalRequest;
	}
	
	public Exception getOriginalException(){
		return originalException;
	}

	@Override
	public String getName() {
		return "ERROR";
	}
}
