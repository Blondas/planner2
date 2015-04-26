package pl.edu.agh.planner.client.applayout;

import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import pl.edu.agh.planner.client.applayout.menu.MainMenuPlanner;
import pl.edu.agh.planner.client.applayout.menu.forms.calendar.PlannerCallendarEventsList;
import pl.edu.agh.planner.client.applayout.menu.forms.calendar.PlannerCalendar;
import pl.edu.agh.planner.shared.AllGraphic;

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
		setBackgroundImage(AllGraphic.backgroundImage);
		setShowEdges(false);

		HLayout hLayout = new HLayout();
		hLayout.addMembers(PlannerCalendar.getInstance(), PlannerCallendarEventsList.getInstance());

		addMembers(new MainMenuPlanner(), hLayout);

		show();
	}


}
