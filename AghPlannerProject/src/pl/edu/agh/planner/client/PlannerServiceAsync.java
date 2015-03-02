package pl.edu.agh.planner.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PlannerServiceAsync {
	void getMessage(String msg, AsyncCallback<String> async);
}
