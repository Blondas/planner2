package pl.edu.agh.planner.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import pl.edu.agh.planner.client.applayout.loginpanel.LoginPanelPlanner;

public class Planner implements EntryPoint {

	public void onModuleLoad() {
		RootPanel.get().add(LoginPanelPlanner.getInstance());
	}

}
