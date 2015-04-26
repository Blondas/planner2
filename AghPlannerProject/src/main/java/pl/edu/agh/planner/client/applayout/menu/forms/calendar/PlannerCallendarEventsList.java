package pl.edu.agh.planner.client.applayout.menu.forms.calendar;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import pl.edu.agh.planner.shared.AllString;

public class PlannerCallendarEventsList extends ListGrid {

	private static volatile PlannerCallendarEventsList instance = null;

	public static PlannerCallendarEventsList getInstance() {
		if (instance == null) {
			synchronized (PlannerCallendarEventsList.class) {
				if (instance == null) {
					instance = new PlannerCallendarEventsList();
				}
			}
		}
		return instance;
	}

	private PlannerCallendarEventsList() {
		setWidth("20%");
		setLayoutAlign(Alignment.RIGHT);
		setExpansionMode(ExpansionMode.DETAILS);
		setVisible(false);
		setAutoFetchData(true);
		setCanExpandRecords(true);

		setCanReorderFields(true);
		setCanDragRecordsOut(true);
		setDragDataAction(DragDataAction.MOVE);


		ListGridField itemNameField = new ListGridField("itemName", AllString.callendarListItemTitle);

		setFields(itemNameField);
	}

	private static class PartData {

		private static ListRecord[] records;

		public static ListRecord[] getRecords() {
			if (records == null) {
				records = getNewRecords();
			}
			return records;
		}

		public static ListRecord[] getNewRecords() {
			return new ListRecord[]{
					new ListRecord("Blue", "cube_blue.png", 1),
					new ListRecord("Yellow", "cube_yellow.png", 2),
					new ListRecord("Green", "cube_green.png", 3),
					new ListRecord("Blue", "cube_blue.png", 4),
					new ListRecord("Yellow", "cube_yellow.png", 5),
					new ListRecord("Green", "cube_green.png", 6),
					new ListRecord("Blue", "cube_blue.png", 7),
					new ListRecord("Yellow", "cube_yellow.png", 8),
					new ListRecord("Green", "cube_green.png", 9),
			};
		}
	}

	private static class ListRecord extends ListGridRecord {

		public ListRecord(String partName, String partSrc, int partNum) {
			setPartName(partName);
			setPartSrc(partSrc);
			setPartNum(partNum);
		}

		public void setPartName(String partName) {
			setAttribute("partName", partName);
		}

		public void setPartSrc(String partSrc) {
			setAttribute("partSrc", partSrc);
		}

		public void setPartNum(int partNum) {
			setAttribute("partNum", partNum);
		}

	}

}
