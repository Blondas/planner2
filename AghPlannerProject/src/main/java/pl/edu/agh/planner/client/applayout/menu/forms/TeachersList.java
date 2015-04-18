package pl.edu.agh.planner.client.applayout.menu.forms;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import pl.edu.agh.planner.client.Context;
import pl.edu.agh.planner.shared.AllString;
import pl.edu.agh.planner.shared.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeachersList extends Window {

	public TeachersList() {
		setTitle(AllString.teacherListTitle);
		setWidth(350);
		setHeight(200);

		final ListGrid listGrid = new ListGrid();
		listGrid.setWidth100();
		listGrid.setHeight100();
		listGrid.setShowAllRecords(true);

		ListGridField namesListGridField = new ListGridField("names", AllString.firstName, 100) ;
		ListGridField lastnamesListGridField = new ListGridField("lastnames", AllString.lastname, 100) ;

		listGrid.setFields(namesListGridField, lastnamesListGridField);
		listGrid.setCanResizeFields(true);
		listGrid.setData(new TeacherDataLoader().getTeacherRecords());

		addItem(listGrid);

		show();
		centerInPage();
	}

	private class TeacherDataLoader {

		private List<TeacherRecord> teacherRecordList = new ArrayList<TeacherRecord>();

		public TeacherDataLoader() {
			Context.getInstance().getPlannerServiceAsync().getTeachersList(new AsyncCallback<List<Teacher>>() {
				@Override
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
				}

				@Override
				public void onSuccess(List<Teacher> result) {
					for (Teacher teacher : result) {
						TeacherRecord teacherRecord = new TeacherRecord();
						teacherRecord.setNameAttribute(teacher.getName());
						teacherRecord.setLastnameAttribute(teacher.getLastName());

						teacherRecordList.add(teacherRecord);
					}
				}
			});

		}

		public TeacherRecord[] getTeacherRecords() {
			return teacherRecordList.toArray(new TeacherRecord[teacherRecordList.size()]);
		}

	}

	private class TeacherRecord extends ListGridRecord {


		public TeacherRecord() {

		}

		public TeacherRecord(String name, String lastname) {
			setNameAttribute(name);
			setLastnameAttribute(lastname);
		}

		public void setNameAttribute(String name) {
			setAttribute("names", name);
		}

		public void setLastnameAttribute(String lastname) {
			setAttribute("lastnames", lastname);
		}

	}

}
