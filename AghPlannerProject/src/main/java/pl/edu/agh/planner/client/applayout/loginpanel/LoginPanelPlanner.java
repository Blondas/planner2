package pl.edu.agh.planner.client.applayout.loginpanel;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;
import pl.edu.agh.planner.client.applayout.RootPanelPlanner;
import pl.edu.agh.planner.shared.AllString;

public class LoginPanelPlanner extends VLayout {

	private static volatile LoginPanelPlanner instance = null;

	private TextItem loginItem = null;
	private PasswordItem passwordItem = null;

	private IButton cleanButton = null;
	private IButton confirmButton = null;

	public static LoginPanelPlanner getInstance() {
		if (instance == null) {
			synchronized (LoginPanelPlanner.class) {
				if (instance == null) {
					instance = new LoginPanelPlanner();
				}
			}
		}
		return instance;
	}

	private LoginPanelPlanner() {
		setWidth(350);
		setHeight(300);
		setLayoutMargin(10);
		setAlign(Alignment.CENTER);
		setBorder("1px solid #6F8197");

		addMembers(createLogo(), createText(), createLoginAndPasswordBox(), createButtons());
		show();
	}

	private Canvas createButtons() {
		Canvas buttonCanvas = new Canvas();
		cleanButton = new IButton();
		cleanButton.setTop(10);
		cleanButton.setWidth(80);
		cleanButton.setLeft(80);
		cleanButton.setTitle(AllString.cleanButtonText);
		cleanButton.addClickHandler(new Clean());
		buttonCanvas.addChild(cleanButton);

		confirmButton = new IButton();
		confirmButton.setTop(cleanButton.getTop());
		confirmButton.setWidth(cleanButton.getWidth());
		confirmButton.setLeft(cleanButton.getLeft() + confirmButton.getWidth() + 10);
		confirmButton.setTitle(AllString.confirmButtonText);
		confirmButton.addClickHandler(new Confirm());
		buttonCanvas.addChild(confirmButton);

		return buttonCanvas;
	}

	private DynamicForm createLoginAndPasswordBox() {
		DynamicForm dynamicForm = new DynamicForm();

		loginItem = new TextItem();
		loginItem.setRequired(true);
		loginItem.setTitle(AllString.login);

		passwordItem = new PasswordItem();
		passwordItem.setRequired(true);
		passwordItem.setTitle(AllString.password);
		dynamicForm.setFields(loginItem, passwordItem);

		//TODO: usunąć! tylko tymczasowo
		loginItem.setValue("root");
		passwordItem.setValue("root");

		return dynamicForm;
	}

	private Canvas createText() {
		final Canvas textCanvas = new Canvas();
		textCanvas.setPrefix(AllString.loginPanelTitle);
		textCanvas.setPadding(5);
		textCanvas.setHeight(1);
		textCanvas.setAlign(Alignment.CENTER);
		textCanvas.setContents(textCanvas.getPrefix() + AllString.loginPanelText);

		return textCanvas;
	}

	private Img createLogo() {
		//TODO: logo do podmiany
		Img img = new Img("http://www.simplybathroomsmerseyside.co.uk/wp-content/uploads/2014/05/simply-logo-600x100.jpg");
		img.setHeight(100);
		img.setWidth(LoginPanelPlanner.this.getWidth());

		return img;
	}

	private class Confirm implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			if (loginItem.getValueAsString().equals("root") && passwordItem.getValueAsString().equals("root")) {
				LoginPanelPlanner.this.destroy();
				RootPanelPlanner.getInstance();
			}
		}

	}

	private class Clean implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			loginItem.clearValue();
			passwordItem.clearValue();
		}

	}

}
