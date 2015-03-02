package pl.edu.agh.planner.client;

import com.google.gwt.core.client.EntryPoint;
import pl.edu.agh.planner.client.applayout.RootPanelPlanner;

public class Planner implements EntryPoint {

	public void onModuleLoad() {
		RootPanelPlanner.getInstance();
	}

}
