package pl.edu.agh.planner.client.applayout.menu;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IconButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.menu.IconMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.toolbar.RibbonBar;
import com.smartgwt.client.widgets.toolbar.RibbonGroup;
import pl.edu.agh.planner.shared.AllString;

import java.util.ArrayList;

class MainMenuBar extends RibbonBar {

	private static final int GROUP_ROW_HEIGHT = 26;

	private ArrayList<RibbonGroup> ribbonGroups = new ArrayList<RibbonGroup>();

	public MainMenuBar() {
			RibbonGroup artifactGroup = new RibbonGroup();
			ribbonGroups.add(artifactGroup);
			artifactGroup.setTitle(AllString.menuNewArtifactProgramTitle);
			artifactGroup.setTitleAlign(Alignment.LEFT);
			artifactGroup.setNumRows(3);
			artifactGroup.setRowHeight(GROUP_ROW_HEIGHT);
			artifactGroup.addControl(createIconMenuButton(AllString.options, "settings", new ArtifactsMenu(), true));
			artifactGroup.addControl(createIconMenuButton(AllString.options, "settings", new ArtifactsMenu(), false));
			artifactGroup.addControl(createIconButton(AllString.options, "settings", false, new TYMCZASOWO_ClickHandler()));
			artifactGroup.addControl(createIconButton(AllString.options, "settings", false, new TYMCZASOWO_ClickHandler()));
			artifactGroup.addControl(createIconButton(AllString.options, "settings", true, new TYMCZASOWO_ClickHandler()));

			RibbonGroup optionGroup = new RibbonGroup();
			ribbonGroups.add(optionGroup);
			optionGroup.setTitle(AllString.menuOptionsProgramTitle);
			optionGroup.setTitleAlign(Alignment.CENTER);
			optionGroup.setNumRows(3);
			optionGroup.setRowHeight(GROUP_ROW_HEIGHT);
			optionGroup.addControl(createIconButton(AllString.options, "settings", true, new TYMCZASOWO_ClickHandler()));

			RibbonGroup aboutGroup = new RibbonGroup();
			ribbonGroups.add(aboutGroup);
			aboutGroup.setTitle(AllString.menuAboutProgramTitle);
			aboutGroup.setTitleAlign(Alignment.CENTER);
			aboutGroup.setNumRows(3);
			aboutGroup.setRowHeight(GROUP_ROW_HEIGHT);
			aboutGroup.addControl(createIconButton(AllString.authors, "chrome", false, new TYMCZASOWO_ClickHandler()));
			aboutGroup.addControl(createIconButton(AllString.authors, "chrome", false, new TYMCZASOWO_ClickHandler()));
			aboutGroup.addControl(createIconButton(AllString.authors, "chrome", false, new TYMCZASOWO_ClickHandler()));

			addMembers(artifactGroup, optionGroup, aboutGroup);

			setLeft(0);
			setWidth100();
			setMembersMargin(2);
			setLayoutLeftMargin(2);
		}

	private IconButton createIconButton(String title, String iconName, boolean isVertical, ClickHandler clickHandler) {
		String path16 = "16/";
		String path48 = "48/";
		String extend = ".png";

		IconButton iconButton = new IconButton();
		iconButton.setTitle(title);
		iconButton.addClickHandler(clickHandler);

		if (iconName == null || iconName.equals("")) {
			throw new IllegalArgumentException(AllString.exceptionMessage);
		} else {
			iconButton.setIcon(path16 + iconName + extend);
			iconButton.setLargeIcon(path48 + iconName + extend);
			if (isVertical)
				iconButton.setOrientation("vertical");
		}

		return iconButton;
	}

	private IconMenuButton createIconMenuButton(String title, String iconName, Menu menu, boolean isVertical) {
		String path16 = "16/";
		String path48 = "48/";
		String extend = ".png";

		IconMenuButton iconMenuButton = new IconMenuButton();
		iconMenuButton.setTitle(title);
		iconMenuButton.setShowMenuIcon(true);

		if (iconName == null || iconName.equals("")) {
			throw new IllegalArgumentException(AllString.exceptionMessage);
		} else {
			iconMenuButton.setIcon(path16 + iconName + extend);
			iconMenuButton.setLargeIcon(path48 + iconName + extend);
			if (isVertical)
				iconMenuButton.setOrientation("vertical");
			if (menu != null)
				iconMenuButton.setMenu(menu);
		}

		return iconMenuButton;
	}

	private class TYMCZASOWO_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			SC.say("Dostępne już niebawem.");
		}

	}
}