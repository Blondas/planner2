package pl.edu.agh.planner.client.applayout.menu.forms.calendar;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import pl.edu.agh.planner.shared.AllString;

public class PlannerCallendarEventsListTool extends ListGrid {

	private static volatile PlannerCallendarEventsListTool instance = null;

	public static PlannerCallendarEventsListTool getInstance() {
		if (instance == null) {
			synchronized (PlannerCallendarEventsListTool.class) {
				if (instance == null) {
					instance = new PlannerCallendarEventsListTool();
				}
			}
		}
		return instance;
	}

	private PlannerCallendarEventsListTool() {
		setWidth("20%");
		setVisible(false);
		setLayoutAlign(Alignment.RIGHT);
		setCanExpandRecords(true);
		setExpansionMode(ExpansionMode.DETAILS);
		setAutoFetchData(true);

		ListGridField itemNameField = new ListGridField("itemName", AllString.callendarListItemTitle);

		setFields(itemNameField);
	}

	private class Data extends DataSource {

		public Data() {

			DataSourceIntegerField pkField = new DataSourceIntegerField("itemID");
			pkField.setHidden(true);
			pkField.setPrimaryKey(true);

		}

	}


}
