package pl.edu.agh.planner.client.applayout.loginpanel;

import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import pl.edu.agh.planner.client.common.validators.MailAddressValidator;
import pl.edu.agh.planner.shared.AllString;

import java.util.ArrayList;

class HelpPanel extends Window {

	private static volatile HelpPanel instance = null;

	private ArrayList<FormItem> formItems = new ArrayList<FormItem>();

	public static HelpPanel getInstance() {
		if (instance == null) {
			synchronized (HelpPanel.class) {
				if (instance == null) {
					instance = new HelpPanel();
				}
			}
		}
		return instance;
	}

	private HelpPanel() {
		setWidth(400);
		setAlign(Alignment.CENTER);

		setAutoSize(true);
		setShowTitle(false);
		setCanDragResize(false);
		setCanDragReposition(false);
		setShowCloseButton(false);
		setShowMinimizeButton(false);
		setShowMaximizeButton(false);

		setShowHeader(false);
		setShowStatusBar(false);
		setLayoutMargin(0);
		setAttribute("styleName", "", true);

		addItem(createLogo());
		addItem(createText());
		addItem(createForm());
		addItem(createButtons());
		centerInPage();
	}

	private Canvas createButtons() {
		Canvas buttonCanvas = new Canvas();

		IButton backButton = new IButton();
		backButton = new IButton();
		backButton.setTop(10);
		backButton.setWidth(80);
		backButton.setLeft(80);
		backButton.setTitle(AllString.backButtonText);
		backButton.addClickHandler(new BackButton_ClickHandler());
		buttonCanvas.addChild(backButton);

		IButton cleanButton = new IButton();
		cleanButton.setTop(backButton.getTop());
		cleanButton.setWidth(backButton.getWidth());
		cleanButton.setLeft(backButton.getLeft() + backButton.getWidth() + 10);
		cleanButton.setTitle(AllString.cleanButtonText);
		cleanButton.addClickHandler(new CleanButton_ClickHandler());
		buttonCanvas.addChild(cleanButton);

		//TODO: dodanie akcji przycisku, dopiero gdy bedziemy mieli baze z user'em i jego mailem
		IButton confirmButton = new IButton();
		confirmButton = new IButton();
		confirmButton.setTop(backButton.getTop());
		confirmButton.setWidth(backButton.getWidth());
		confirmButton.setLeft(cleanButton.getLeft() + confirmButton.getWidth() + 10);
		confirmButton.setTitle(AllString.confirmButtonText);
		buttonCanvas.addChild(confirmButton);

		return buttonCanvas;
	}

	private DynamicForm createForm() {
		DynamicForm dynamicForm = new DynamicForm();
		dynamicForm.setWidth100();
		dynamicForm.setAlign(Alignment.CENTER);

		TextItem firstName = new TextItem("firstName", AllString.firstName);
		firstName.setMask(">?<??????????????");
		formItems.add(firstName);

		TextItem surname = new TextItem("lastName", AllString.lastname);
		surname.setMask(">?<??????????????");
		surname.setHint("<nobr>>?<??????????????</nobr>");
		formItems.add(surname);

		TextItem mailAddress = new TextItem("mailAddress", AllString.mainAddress);
		mailAddress.setMask(">?<??????????????");
		mailAddress.setHint("<nobr>>?<??????????????</nobr>");
		mailAddress.setValidators(new MailAddressValidator());
		formItems.add(mailAddress);

		DateItem dateField = new DateItem("dateItem", AllString.dateOfBirth);
		dateField.setUseTextField(true);
		dateField.setUseMask(true);
		formItems.add(dateField);

		dynamicForm.setFields(firstName, surname, mailAddress, dateField);

		return dynamicForm;
	}

	private Canvas createText() {
		final Canvas textCanvas = new Canvas();
		textCanvas.setPrefix(AllString.helpPanelTitle);
		textCanvas.setPadding(5);
		textCanvas.setHeight(1);
		textCanvas.setWidth100();
		textCanvas.setAlign(Alignment.CENTER);
		textCanvas.setContents(textCanvas.getPrefix() + AllString.helpPanelText);

		return textCanvas;
	}

	private Img createLogo() {
		//TODO: logo do podmiany
		Img img = new Img("http://www.simplybathroomsmerseyside.co.uk/wp-content/uploads/2014/05/simply-logo-600x100.jpg");
		img.setHeight(100);
		img.setWidth(400);

		return img;
	}

	private class BackButton_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			HelpPanel.this.destroy();
			instance = null;
			RootPanel.get().add(LoginPanelPlanner.getInstance());
		}

	}

	private class CleanButton_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			for (FormItem formItem : formItems) {
				formItem.clearValue();
			}
		}

	}
}
