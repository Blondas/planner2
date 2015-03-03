package pl.edu.agh.planner.client.applayout.menu;

import com.smartgwt.client.widgets.layout.VLayout;

public class MainMenuPlanner extends VLayout {

	public MainMenuPlanner() {
		setWidth100();
		setAutoHeight();
		setShowEdges(false);
		addMember(new MainMenuBar());
		show();
	}

}
