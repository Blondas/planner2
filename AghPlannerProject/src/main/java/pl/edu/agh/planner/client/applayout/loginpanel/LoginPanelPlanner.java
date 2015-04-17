package pl.edu.agh.planner.client.applayout.loginpanel;

import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import pl.edu.agh.planner.client.applayout.RootPanelPlanner;
import pl.edu.agh.planner.shared.AllString;

public class LoginPanelPlanner extends Window {

	private static volatile LoginPanelPlanner instance = null;
    private static final String JSON_STOCK_PRICES_URL = "rest/jsonStockPrices";


	private TextItem loginItem = null;
	private PasswordItem passwordItem = null;

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
		setWidth(400);
		setAlign(Alignment.CENTER);

		setAutoSize(true);
		setShowTitle(false);
		setCanDragResize(false);
		setCanDragReposition(false);
		setShowCloseButton(false);
		setShowMinimizeButton(false);
		setShowMaximizeButton(false);

		addItem(createLogo());
		addItem(createText());
		addItem(createLoginAndPasswordBox());
		addItem(createButtons());

		centerInPage();
	}

	private Canvas createButtons() {
		Canvas buttonCanvas = new Canvas();

		IButton cleanButton = new IButton();
		cleanButton.setTop(10);
		cleanButton.setWidth(80);
		cleanButton.setLeft(80);
		cleanButton.setTitle(AllString.cleanButtonText);
		cleanButton.addClickHandler(new CleanButtonAction());
		buttonCanvas.addChild(cleanButton);

		IButton confirmButton = new IButton();
		confirmButton.setTop(cleanButton.getTop());
		confirmButton.setWidth(cleanButton.getWidth());
		confirmButton.setLeft(cleanButton.getLeft() + confirmButton.getWidth() + 10);
		confirmButton.setTitle(AllString.confirmButtonText);
		confirmButton.addClickHandler(new ConfirmButtonAction());
		buttonCanvas.addChild(confirmButton);

		IButton helpButton = new IButton();
		helpButton.setTitle(AllString.helpButtonText);
		helpButton.setTop(cleanButton.getTop());
		helpButton.setWidth(cleanButton.getWidth());
		helpButton.setLeft(confirmButton.getLeft() + helpButton.getWidth() + 10);
		helpButton.addClickHandler(new HelpButtonAction());
		buttonCanvas.addChild(helpButton);

		return buttonCanvas;
	}

	private DynamicForm createLoginAndPasswordBox() {
		DynamicForm dynamicForm = new DynamicForm();
		dynamicForm.setWidth100();

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
		textCanvas.setWidth100();
		textCanvas.setAlign(Alignment.CENTER);
		textCanvas.setContents(textCanvas.getPrefix() + AllString.loginPanelText);

		return textCanvas;
	}

	private Img createLogo() {
		//TODO: logo do podmiany
		Img img = new Img("http://www.simplybathroomsmerseyside.co.uk/wp-content/uploads/2014/05/simply-logo-600x100.jpg");
		img.setHeight(100);
		img.setWidth(400);

		return img;
	}

	private class ConfirmButtonAction implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {


            String url = JSON_STOCK_PRICES_URL;
//            url = URL.encode(url);
//            GWT.log("url = " + url);
            // Send request to server and catch any errors.
//            RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

            JSONObject request = new JSONObject();
            request.put("hello", new JSONString("world"));



            String postData = request.toString();

            RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
//            String s = ("  {\n") +
//                      ("    \"symbol\": \" \n")
//                    + ("test\n")
//                    + ("  }\n")
//                +("]\n");

            try
            {
                builder.sendRequest(postData, new RequestCallback()
                {

                    public void onResponseReceived(Request request, Response response)
                    {
                        if (200 == response.getStatusCode())
                        {
                            System.out.println("UDALO SIE TO JEST ODPOWIEDZ : " + response.getText());
                        }

                    }

                    @Override
                    public void onError(Request request, Throwable exception) {

                    }
                });
            }
            catch (RequestException e)
            {

            }


			if (loginItem.getValueAsString().equals("root") && passwordItem.getValueAsString().equals("root")) {
				LoginPanelPlanner.this.destroy();
				RootPanelPlanner.getInstance();
			} else {
				SC.warn(AllString.loginWarningMsg);
			}
		}

	}

	private class CleanButtonAction implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			loginItem.clearValue();
			passwordItem.clearValue();
		}

	}

	private class HelpButtonAction implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			LoginPanelPlanner.this.destroy();
			instance = null;
			RootPanel.get().add(HelpPanel.getInstance());
		}

	}

}
