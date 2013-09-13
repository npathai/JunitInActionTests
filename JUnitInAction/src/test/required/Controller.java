package test.required;

public interface Controller {
	public Response processRequest(Request request);
	public void addHandler(Request request, RequestHandler requestHandler);
}
