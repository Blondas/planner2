package pl.edu.agh.planner.client.applayout.menu.forms.calendar;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.grid.ListGrid;

public class CallendarEventsListTool extends ListGrid {

	private static volatile CallendarEventsListTool instance = null;

	public static CallendarEventsListTool getInstance() {
		if (instance == null) {
			synchronized (CallendarEventsListTool.class) {
				if (instance == null) {
					instance = new CallendarEventsListTool();
				}
			}
		}
		return instance;
	}

	private CallendarEventsListTool() {
		setWidth("20%");
		setMaxWidth(250);
		setLayoutAlign(Alignment.RIGHT);


	}

}
