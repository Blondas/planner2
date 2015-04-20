package pl.edu.agh.planner.client.applayout.menu.forms;

import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import pl.edu.agh.planner.shared.AllString;

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
//		listGrid.setData(new TeacherDataLoader().getTeacherRecords());

		addItem(listGrid);

		show();
		centerInPage();

	}


}
