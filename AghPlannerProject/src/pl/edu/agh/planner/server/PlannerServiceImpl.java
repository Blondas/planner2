package pl.edu.agh.planner.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pl.edu.agh.planner.client.PlannerService;

public class PlannerServiceImpl extends RemoteServiceServlet implements PlannerService {
	// Implementation of sample interface method
	public String getMessage(String msg) {
		return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
	}
}