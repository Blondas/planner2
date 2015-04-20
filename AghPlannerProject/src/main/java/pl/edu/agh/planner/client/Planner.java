package pl.edu.agh.planner.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import pl.edu.agh.planner.client.applayout.loginpanel.LoginPanelPlanner;
import pl.edu.agh.planner.client.applayout.menu.forms.TeachersList;
import pl.edu.agh.planner.shared.Teacher;

import javax.persistence.criteria.Root;
import java.util.List;

public class Planner implements EntryPoint {

	public void onModuleLoad() {
		RootPanel.get().add(LoginPanelPlanner.getInstance());
	}

}
