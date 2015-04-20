package pl.edu.agh.planner.client.applayout.menu.forms;

import com.smartgwt.client.widgets.grid.ListGridRecord;

class TeacherRecord extends ListGridRecord {


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