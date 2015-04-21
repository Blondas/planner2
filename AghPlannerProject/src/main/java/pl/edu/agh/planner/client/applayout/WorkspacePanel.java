package pl.edu.agh.planner.client.applayout;

import com.smartgwt.client.widgets.layout.VLayout;
import pl.edu.agh.planner.client.applayout.menu.MainMenuPlanner;
import pl.edu.agh.planner.client.applayout.menu.forms.calendar.PlannerCalendar;

public class WorkspacePanel extends VLayout {

	private static volatile WorkspacePanel instance = null;

	public static WorkspacePanel getInstance() {
		if (instance == null) {
			synchronized (WorkspacePanel.class) {
				if (instance == null) {
					instance = new WorkspacePanel();
				}
			}
		}
		return instance;
	}

	private WorkspacePanel() {
		setWidth100();
		setHeight100();
		setBackgroundImage("wallpaper.png");
		setShowEdges(false);
		addMembers(new MainMenuPlanner(), PlannerCalendar.getInstance());
		show();
	}


}
