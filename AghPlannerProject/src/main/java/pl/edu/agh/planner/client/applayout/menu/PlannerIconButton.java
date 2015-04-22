package pl.edu.agh.planner.client.applayout.menu;

import com.smartgwt.client.widgets.IconButton;
import com.smartgwt.client.widgets.events.ClickHandler;
import pl.edu.agh.planner.shared.AllString;

class PlannerIconButton extends IconButton {

	private static String path16 = "16/";
	private static String path48 = "48/";

	private String iconNameWithExtendAfterClick = null;

	public PlannerIconButton(String title, String iconNameWithExtend, boolean isVertical, ClickHandler clickHandler) {
		setTitle(title);
		addClickHandler(clickHandler);

		if (iconNameWithExtend == null || iconNameWithExtend.equals("")) {
			throw new IllegalArgumentException(AllString.exceptionMessage);
		} else {
			setIcon(path16 + iconNameWithExtend);
			setLargeIcon(path48 + iconNameWithExtend);
			if (isVertical)
				setOrientation("vertical");
		}
	}

	public PlannerIconButton(String title, String iconNameWithExtend, String iconNameWithExtendAfterClick, boolean isVertical, ClickHandler clickHandler) {
		this(title, iconNameWithExtend, isVertical, clickHandler);
		this.iconNameWithExtendAfterClick = iconNameWithExtendAfterClick;
	}

}
