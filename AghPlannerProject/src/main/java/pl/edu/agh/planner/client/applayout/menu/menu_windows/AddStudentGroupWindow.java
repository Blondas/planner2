package pl.edu.agh.planner.client.applayout.menu.menu_windows;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import pl.edu.agh.planner.shared.AllString;

import java.util.ArrayList;

public class AddStudentGroupWindow extends Window {
    private ArrayList<FormItem> formItems = new ArrayList<FormItem>();
    private DynamicForm dynamicForm = null;

    public AddStudentGroupWindow() {
        setTitle(AllString.addStudentGroup);
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
        TextItem name = new TextItem("name", AllString.name);
        name.setRequired(true);
        formItems.add(name);

        DateItem startDate = new DateItem();
        startDate.setTitle("Początek");
        startDate.setUseTextField(true);
        formItems.add(startDate);

        DateItem endDate = new DateItem();
        endDate.setTitle("Koniec");
        endDate.setUseTextField(true);
        formItems.add(endDate);

        dynamicForm.setFields(name, startDate, endDate);
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
            for (FormItem formItem : formItems) {
                formItem.clearValue();
            }
        }

    }

    private class SaveAndCloseButton_ClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            AddStudentGroupWindow.this.destroy();
        }

    }
}
