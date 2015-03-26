package pl.edu.agh.planner.client.applayout.menu.menu_windows;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import pl.edu.agh.planner.shared.AllString;

public class AboutAghWindow extends Window {
    public AboutAghWindow() {
        setWidth(400);
//        setHeight(400);
        setAlign(Alignment.CENTER);

        setAutoSize(true);

        setCanDragResize(false);

        addItem(createLogo());
        addItem(createText());
        addItem(createButtons());

        centerInPage();
    }

    private Img createLogo() {
        //TODO: logo do podmiany
        Img img = new Img("http://www.simplybathroomsmerseyside.co.uk/wp-content/uploads/2014/05/simply-logo-600x100.jpg");
        img.setHeight(100);
        img.setWidth(400);

        return img;
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
            AboutAghWindow.this.destroy();
        }

    }
}
