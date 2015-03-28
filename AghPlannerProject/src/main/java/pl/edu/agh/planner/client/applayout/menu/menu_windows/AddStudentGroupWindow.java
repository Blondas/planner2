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
    private DynamicForm addStudentGroupForm = null;

    public AddStudentGroupWindow() {
        setTitle(AllString.addStudentGroup);
        setWidth(400);
        setAutoSize(true);

        addStudentGroupForm = new DynamicForm();
        addStudentGroupForm.setWidth100();
        addStudentGroupForm.setAlign(Alignment.CENTER);

        createAddStudentGroupElements();

        addItem(addStudentGroupForm);
        addItem(createButtons());

        centerInPage();

        addItem(dynamicForm);
        addItem(createButtons());

        show();
        centerInPage();
    }

    private void createAddStudentGroupElements() {
        TextItem name = new TextItem("name", AllString.name);
        name.setRequired(true);
        formItems.add(name);

        DateItem from = new DateItem();
        from.setTitle("Start");
        from.setUseTextField(true);
        from.setHint("<nobr>Direct date input</nobr>");

    }

    private Canvas createButtons() {
        Canvas buttonCanvas = new Canvas();

        IButton closeButton = new IButton();
        closeButton = new IButton();
        closeButton.setTop(10);
        closeButton.setWidth(80);
        closeButton.setTitle(AllString.closeButtonText);
        closeButton.addClickHandler(new CloseButton_ClickHandler());
        buttonCanvas.addChild(closeButton);

        return buttonCanvas;
    }

    private class CloseButton_ClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            AddStudentGroupWindow.this.destroy();
        }

    }
}
