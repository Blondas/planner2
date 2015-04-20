package pl.edu.agh.planner.client.applayout.menu.forms;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import pl.edu.agh.planner.client.Context;
import pl.edu.agh.planner.client.common.validators.MailAddressValidator;
import pl.edu.agh.planner.shared.AllString;
import pl.edu.agh.planner.shared.Teacher;

import java.util.ArrayList;

public class AddNewTeacher extends Window {

	private ArrayList<FormItem> formItems = new ArrayList<FormItem>();
	private DynamicForm dynamicForm = null;

	public AddNewTeacher() {
		setTitle(AllString.addNewConductorWindowTitle);
		setWidth(350);
		setHeight(200);

		dynamicForm = new DynamicForm();
		dynamicForm.setWidth100();
		dynamicForm.setAlign(Alignment.CENTER);

		createTextItems();

		addItem(dynamicForm);
		addItem(createButtons());

		show();
		centerInPage();
	}

	private void createTextItems() {
		TextItem firstName = new TextItem("firstName", AllString.firstName);
		firstName.setRequired(true);
		firstName.setValue("TestName");
		formItems.add(firstName);

		TextItem surname = new TextItem("lastName", AllString.lastname);
		surname.setRequired(true);
		surname.setValue("TestSurname");
		formItems.add(surname);

		TextItem mailAddress = new TextItem("mailAddress", AllString.mainAddress);
		mailAddress.setRequired(true);
		mailAddress.setValidators(new MailAddressValidator());
		mailAddress.setValue("test@test.test");
		formItems.add(mailAddress);

		dynamicForm.setFields(firstName, surname, mailAddress);
	}

	private Canvas createButtons() {
		Canvas buttonCanvas = new Canvas();

		IButton cleanButton = new IButton();
		cleanButton.setTop(10);
		cleanButton.setWidth(80);
		cleanButton.setLeft(80);
		cleanButton.setTitle(AllString.cleanButtonText);
		cleanButton.addClickHandler(new CleanButton_ClickHandler());
		buttonCanvas.addChild(cleanButton);

		IButton confirmButton = new IButton();
		confirmButton = new IButton();
		confirmButton.setTop(cleanButton.getTop());
		confirmButton.setWidth(cleanButton.getWidth());
		confirmButton.setLeft(cleanButton.getLeft() + confirmButton.getWidth() + 10);
		confirmButton.setTitle(AllString.confirmButtonText);
		confirmButton.addClickHandler(new ConfirmButton_ClickHandler());
		buttonCanvas.addChild(confirmButton);

		return buttonCanvas;
	}

	private class CleanButton_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			for (FormItem formItem : formItems) {
				formItem.clearValue();
			}
		}

	}

	private class ConfirmButton_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			try {
				if (dynamicForm.validate(false)) {
					Teacher teacher = new Teacher();
					teacher.setName(formItems.get(0).getValue().toString());
					teacher.setLastName(formItems.get(1).getValue().toString());
					teacher.setEmailAddress(formItems.get(2).getValue().toString());

					Context.getInstance().getPlannerServiceAsync().addTeacher(teacher, new AsyncCallback<Void>() {
						@Override
						public void onFailure(Throwable caught) {
							caught.printStackTrace();
						}

						@Override
						public void onSuccess(Void result) {
							SC.say(AllString.addNewTeacherSuccesful);
						}
					});
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
