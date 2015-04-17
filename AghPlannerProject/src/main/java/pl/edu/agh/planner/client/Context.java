package pl.edu.agh.planner.client;

import com.google.gwt.core.client.GWT;

public class Context {

	private static final PlannerServiceAsync PLANNER_SERVICE_ASYNC = GWT.create(PlannerService.class);

	private static Object _synch = new Object();
	private static Context context;

	private Context() {

	}

	public static Context getInstance() {
		if (context == null) {
			synchronized (_synch) {
				if (context == null) {
					context = new Context();
				}
			}
		}
		return context;
	}

	public static PlannerServiceAsync getPlannerServiceAsync() {
		return PLANNER_SERVICE_ASYNC;
	}

}
