package pl.edu.agh.planner.client.applayout.menu.forms;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import pl.edu.agh.planner.shared.AllString;

import java.util.ArrayList;

public class AddNewConductor extends Window {

	private ArrayList<FormItem> formItems = new ArrayList<FormItem>();

	public AddNewConductor() {
		setTitle(AllString.addNewConductorWindowTitle);

		setWidth(400);
		setHeight(200);

		DynamicForm dynamicForm = new DynamicForm();
		dynamicForm.setWidth100();
		dynamicForm.setAlign(Alignment.CENTER);

		TextItem firstName = new TextItem("firstName", AllString.name);
		firstName.setMask(">?<??????????????");
		formItems.add(firstName);

		TextItem surname = new TextItem("lastName", AllString.surname);
		surname.setMask(">?<??????????????");
		surname.setHint("<nobr>>?<??????????????</nobr>");
		formItems.add(surname);

		TextItem mailAddress = new TextItem("mailAddress", AllString.mainAddress);
		mailAddress.setMask(">?<??????????????");
		mailAddress.setHint("<nobr>>?<??????????????</nobr>");
		formItems.add(mailAddress);

		DateItem dateField = new DateItem("dateItem", AllString.dateOfBirth);
		dateField.setUseTextField(true);
		dateField.setUseMask(true);
		formItems.add(dateField);

		dynamicForm.setFields(firstName, surname, mailAddress, dateField);

		addItem(dynamicForm);

		show();
		centerInPage();
	}

}
