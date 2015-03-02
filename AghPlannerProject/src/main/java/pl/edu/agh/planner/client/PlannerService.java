package pl.edu.agh.planner.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PlannerService")
public interface PlannerService extends RemoteService {
	/**
	 * Utility/Convenience class.
	 * Use PlannerService.App.getInstance() to access static instance of PlannerServiceAsync
	 */
	public static class App {
		private static PlannerServiceAsync ourInstance = GWT.create(PlannerService.class);

		public static synchronized PlannerServiceAsync getInstance() {
			return ourInstance;
		}
	}
}
