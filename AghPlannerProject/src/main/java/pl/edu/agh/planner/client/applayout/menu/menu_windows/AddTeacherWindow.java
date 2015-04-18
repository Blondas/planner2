package pl.edu.agh.planner.client.applayout.menu.menu_windows;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import pl.edu.agh.planner.shared.AllString;

import java.util.ArrayList;

public class AddTeacherWindow extends Window {
    private ArrayList<FormItem> formItems = new ArrayList<FormItem>();
    private TextItem firstName;
    private TextItem lastName;
    private DynamicForm dynamicForm = null;

    public AddTeacherWindow() {
        setTitle(AllString.addTeacher);
        setWidth(400);
        setAutoSize(true);

        dynamicForm = new DynamicForm();
        dynamicForm.setWidth100();
        dynamicForm.setAlign(Alignment.CENTER);

        createDynamicFormItems();

        addItem(dynamicForm);
        addItem(createButtons());

        show();
        centerInPage();
    }

    private void createDynamicFormItems() {
        firstName = new TextItem("firstName", AllString.firstName);
        firstName.setRequired(true);

        formItems.add(firstName);

        lastName = new TextItem("lastName", AllString.lastname);
        lastName.setRequired(true);
        formItems.add(lastName);

        dynamicForm.setFields(firstName, lastName);
    }

    private Canvas createButtons() {
        Canvas buttonCanvas = new Canvas();

        IButton saveButton = new IButton();
        saveButton.setTop(10);
        saveButton.setWidth(90);
        saveButton.setTitle(AllString.saveButtonText);
        saveButton.addClickHandler(new SaveButton_ClickHandler());
        buttonCanvas.addChild(saveButton);

        IButton saveAndCloseButton = new IButton();
        saveAndCloseButton.setTop(saveButton.getTop());
        saveAndCloseButton.setWidth(saveButton.getWidth());
        saveAndCloseButton.setLeft(saveButton.getLeft() + saveAndCloseButton.getWidth() + 10);
        saveAndCloseButton.setTitle(AllString.saveAndCloseButtonText);
        saveAndCloseButton.addClickHandler(new SaveAndCloseButton_ClickHandler());
        buttonCanvas.addChild(saveAndCloseButton);

        return buttonCanvas;
    }

    private class SaveButton_ClickHandler implements ClickHandler {


        @Override
        public void onClick(ClickEvent event) {
//            String url = TEACHER_ADD;
//            url = URL.encode(url);

            // Send request to server and catch any errors.
//            RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
//            System.out.println(firstName.getEnteredValue());
//            System.out.println(lastName.getEnteredValue());
//            Teacher teacher = new Teacher();
//            teacher.setName(firstName.getEnteredValue());
//            teacher.setName(lastName.getEnteredValue());

//            String teacherJson = JsonFactory.serializeTeacherToJson(teacher);

//            JSONObject jsonObj = new JSONObject( teacher );

//            System.out.println("super json kurwa:"+jsonObj);


//            try
//            {
//                builder.sendRequest("{\"lastName\":null,\"name\":\"ala\",\"id\":0,\"avatar\":null}", new RequestCallback()
//                {
//
//                    public void onResponseReceived(Request request, Response response)
//                    {
//                        if (200 == response.getStatusCode())
//                        {
//                            System.out.println("UDALO SIE TO JEST ODPOWIEDZ : " + response.getText());
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(Request request, Throwable exception) {
//
//                    }
//                });
//            }
//            catch (RequestException e)
//            {
//
//            }



            for (FormItem formItem : formItems) {
                formItem.clearValue();
            }
        }

    }

    private class SaveAndCloseButton_ClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            AddTeacherWindow.this.destroy();
        }

    }


}
