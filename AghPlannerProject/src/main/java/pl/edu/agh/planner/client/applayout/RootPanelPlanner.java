package pl.edu.agh.planner.client.applayout;

import com.smartgwt.client.widgets.layout.VLayout;
import pl.edu.agh.planner.client.applayout.loginpanel.LoginPanelPlanner;
import pl.edu.agh.planner.client.applayout.menu.MainMenuPlanner;

public class RootPanelPlanner extends VLayout {

	private static volatile RootPanelPlanner instance = null;

	public static RootPanelPlanner getInstance() {
		if (instance == null) {
			synchronized (RootPanelPlanner.class) {
				if (instance == null) {
					instance = new RootPanelPlanner();
				}
			}
		}
		return instance;
	}

	private RootPanelPlanner() {
		setWidth100();
		setHeight100();
		addMember(new MainMenuPlanner());
		show();
	}

}
