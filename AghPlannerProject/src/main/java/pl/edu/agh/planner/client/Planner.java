package pl.edu.agh.planner.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import pl.edu.agh.planner.server.hibernate.entity.TeacherEntity;
import pl.edu.agh.planner.shared.Teacher;

import java.util.ArrayList;

public class Planner implements EntryPoint {

	public void onModuleLoad() {
//		RootPanel.get().add(LoginPanelPlanner.getInstance());

		HLayout layout = new HLayout(20);

		final DynamicForm form = new DynamicForm();
		form.setWidth(250);

		final TextItem usernameItem = new TextItem();
		usernameItem.setTitle("Username");
		usernameItem.setRequired(true);
		usernameItem.setDefaultValue("bob");

		final TextItem emailItem = new TextItem();
		emailItem.setTitle("Email");
		emailItem.setRequired(true);
		emailItem.setDefaultValue("bob@isomorphic.com");

		form.setFields(new FormItem[] {usernameItem, emailItem});

		IButton swapButton = new IButton("Krystian BOOM!");
		swapButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Context.getInstance().getPlannerServiceAsync().getTeachers(new AsyncCallback<ArrayList<Teacher>>() {
					@Override
					public void onFailure(Throwable throwable) {
						throwable.printStackTrace();
					}

					@Override
					public void onSuccess(ArrayList<Teacher> teachers) {
						for (Teacher teacher : teachers.toArray(new Teacher[teachers.size()])) {
							System.out.println(teacher.getName());
						}
					}
				});

			}
		});
		swapButton.setLeft(300);

		layout.addMember(form);
		layout.addMember(swapButton);

		layout.show();

	}

}
