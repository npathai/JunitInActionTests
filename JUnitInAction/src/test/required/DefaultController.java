package test.required;

import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller{

	private Map<String, RequestHandler> handlers = new HashMap<String, RequestHandler>();
	
	public RequestHandler getHandler(Request request){
		if(!handlers.containsKey(request.getName())){
			throw new RuntimeException("Cannot find handler for request name: " + request.getName());
		}
		return handlers.get(request.getName());
	}
	
	@Override
	public Response processRequest(Request request) {
		Response response;
		try {
			response = getHandler(request).process(request);
		} catch (Exception e) {
			 response = new ErrorResponse(request, e);
		}
		return response;
	}

	@Override
	public void addHandler(Request request, RequestHandler requestHandler) {
		if(handlers.containsKey(request.getName())){
			throw new RuntimeException("Request handler already registered for name: " 
					+ request.getName());
		}
		handlers.put(request.getName(), requestHandler);
	}

}
