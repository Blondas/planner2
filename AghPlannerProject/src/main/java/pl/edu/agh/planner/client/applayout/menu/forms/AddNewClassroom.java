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
import pl.edu.agh.planner.shared.AllString;
import pl.edu.agh.planner.shared.Classroom;

import java.util.ArrayList;

public class AddNewClassroom extends Window {

	private ArrayList<FormItem> formItems = new ArrayList<FormItem>();
	private DynamicForm dynamicForm = null;

	public AddNewClassroom() {
		setTitle(AllString.addNewClassroom);
		setWidth(350);
		setHeight(150);

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
		TextItem classroom = new TextItem("classroom", AllString.addNewClassroomNumber);
		classroom.setRequired(true);
		classroom.setValue("3.1");
		formItems.add(classroom);

		TextItem numberOfSeats = new TextItem("numberOfSeats", AllString.lastname);
		numberOfSeats.setRequired(true);
		numberOfSeats.setValue("123");
		//TODO: dodac validator only numbers
		formItems.add(numberOfSeats);

		dynamicForm.setFields(classroom, numberOfSeats);
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
			Classroom classroom = new Classroom();
			//TODO: dodac reszte atrybutow
			classroom.setNumberOfSeats(new Integer(formItems.get(1).getValue().toString()));

			Context.getInstance().getPlannerServiceAsync().addClassroom(classroom, new AsyncCallback<Void>() {
				@Override
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
				}

				@Override
				public void onSuccess(Void result) {
					SC.say(AllString.addNewClassroomSuccess);
				}
			});

		}

	}
}
