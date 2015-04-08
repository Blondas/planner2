package pl.edu.agh.planner.client.applayout.menu;

import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IconButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.menu.IconMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.toolbar.RibbonBar;
import com.smartgwt.client.widgets.toolbar.RibbonGroup;
import pl.edu.agh.planner.client.applayout.menu.menu_windows.AddProgrammeUnitWindow;
import pl.edu.agh.planner.client.applayout.menu.menu_windows.AddStudentGroupWindow;
import pl.edu.agh.planner.client.applayout.menu.menu_windows.AddTeacherWindow;
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
		artifactGroup.addControl(createIconMenuButton(AllString.newAdd, "add", new ArtifactsMenu(), true));
		artifactGroup.addControl(createIconMenuButton(AllString.options, "settings", new ArtifactsMenu(), false));
		artifactGroup.addControl(createIconButton(AllString.options, "settings", false, new TYMCZASOWO_ClickHandler()));
		artifactGroup.addControl(createIconButton(AllString.options, "settings", false, new TYMCZASOWO_ClickHandler()));
		artifactGroup.addControl(createIconButton(AllString.options, "settings", true, new TYMCZASOWO_ClickHandler()));

		RibbonGroup viewGroup = new RibbonGroup();
		ribbonGroups.add(viewGroup);
		viewGroup.setTitle(AllString.menuViewProgramTitle);
		viewGroup.setTitleAlign(Alignment.LEFT);
		viewGroup.setNumRows(3);
		viewGroup.setRowHeight(GROUP_ROW_HEIGHT);
		viewGroup.addControl(createIconMenuButton(AllString.viewList, "view", new ListsMenu(), true));

		RibbonGroup optionGroup = new RibbonGroup();
		ribbonGroups.add(optionGroup);
		optionGroup.setTitle(AllString.menuOptionsProgramTitle);
		optionGroup.setTitleAlign(Alignment.CENTER);
		optionGroup.setNumRows(3);
		optionGroup.setRowHeight(GROUP_ROW_HEIGHT);
		optionGroup.addControl(createIconButton(AllString.options, "settings", true, new TYMCZASOWO_ClickHandler()));

		RibbonGroup addSubject = new RibbonGroup();
		ribbonGroups.add(addSubject);
		addSubject.setTitle(AllString.menuAboutProgramTitle);
		addSubject.setTitleAlign(Alignment.LEFT);
		addSubject.setNumRows(3);
		addSubject.setRowHeight(GROUP_ROW_HEIGHT);
		addSubject.addControl(createIconButton(AllString.aboutAuthors, "authors", false, new TYMCZASOWO_ClickHandler()));
		addSubject.addControl(createIconButton(AllString.aboutProgram, "cli", false, new TYMCZASOWO_ClickHandler()));

		RibbonGroup userActions = new RibbonGroup();
		ribbonGroups.add(userActions);
		userActions.setTitle(AllString.menuUserActionsTitle);
		userActions.setTitleAlign(Alignment.LEFT);
		userActions.setNumRows(3);
		userActions.setRowHeight(GROUP_ROW_HEIGHT);
		userActions.addControl(buttonWithUserInfo("root", "God system"));
		userActions.addControl(createIconButton(AllString.userLogout, "exit", true, new TYMCZASOWO_ClickHandler()));


		// Agregat:
		RibbonGroup aggregateGroup = new RibbonGroup();
		ribbonGroups.add(aggregateGroup);
		aggregateGroup.setTitle(AllString.aggregateGroupTitle);
		aggregateGroup.setTitleAlign(Alignment.LEFT);
		aggregateGroup.setNumRows(3);
		aggregateGroup.setRowHeight(GROUP_ROW_HEIGHT);

		aggregateGroup.addControl(createIconButton(AllString.addStudentGroup, "authors",
				false, new AddStudentGroupWindow_ClickHandler()));
		aggregateGroup.addControl(createIconButton(AllString.addProgrammeUnit, "addProgrammeUnit",
				false, new AddProgrammeUnitWindow_ClickHandler()));
		aggregateGroup.addControl(createIconButton(AllString.addAvatar, "addAvatar",
				false, new AddProgrammeUnitWindow_ClickHandler()));
		aggregateGroup.addControl(createIconButton(AllString.addTeacher, "addTeacher",
				false, new AddTeacherWindow_ClickHandler()));


		addMembers(artifactGroup, viewGroup, optionGroup, addSubject, userActions, aggregateGroup);

		setLeft(0);
		setWidth100();
		setMembersMargin(2);
		setLayoutLeftMargin(2);
	}

	private IconButton buttonWithUserInfo(String userName, String userRole) {
		//TODO: zastanowic sie co z tym zrobic, to nie jest miejsce na ta metode.
		String htmlNewline = "<BR>";
		String htmlBoldStart = "<b>";
		String htmlBoldEnd = "</b>";
		String logged = htmlBoldStart + "Zalogowany: " + htmlBoldEnd;
		String status = htmlBoldStart + "Status: " + htmlBoldEnd;

		IconButton iconButton = new IconButton();
		iconButton.setOrientation("vertical");
		iconButton.setTitle(logged + userName + htmlNewline + status + userRole);
		iconButton.setWidth(150);
		iconButton.setAlign(Alignment.LEFT);
		iconButton.setCanDrop(false);

		return iconButton;
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

	private class AddProgrammeUnitWindow_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			RootPanel.get().add(new AddProgrammeUnitWindow());
		}

	}

	private class AddStudentGroupWindow_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			RootPanel.get().add(new AddStudentGroupWindow());
		}

	}

	private class AddTeacherWindow_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			RootPanel.get().add(new AddTeacherWindow());
		}

	}
}