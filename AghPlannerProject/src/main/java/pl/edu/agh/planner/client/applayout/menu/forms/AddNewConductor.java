package pl.edu.agh.planner.client.applayout.menu.forms;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import pl.edu.agh.planner.client.common.validators.MailAddressValidator;
import pl.edu.agh.planner.shared.AllString;
import pl.edu.agh.planner.shared.Conductor;

import java.util.ArrayList;

public class AddNewConductor extends Window {

	private ArrayList<FormItem> formItems = new ArrayList<FormItem>();
	private DynamicForm dynamicForm = null;

	public AddNewConductor() {
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
		formItems.add(firstName);

		TextItem surname = new TextItem("lastName", AllString.surname);
		surname.setRequired(true);
		formItems.add(surname);

		TextItem mailAddress = new TextItem("mailAddress", AllString.mainAddress);
		mailAddress.setRequired(true);
		mailAddress.setValidators(new MailAddressValidator());
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
					Conductor conductor = new Conductor();
					conductor.setFirstName(formItems.get(0).getValue().toString());
					conductor.setLastName(formItems.get(1).getValue().toString());
					conductor.setMailAddress(formItems.get(2).getValue().toString());

					//TODO: dodac przekazanie prowadzacego dalej.
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
