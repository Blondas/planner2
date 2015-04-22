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
import pl.edu.agh.planner.client.applayout.menu.forms.AddNewClassroom;
import pl.edu.agh.planner.client.applayout.menu.forms.AddNewTeacher;
import pl.edu.agh.planner.client.applayout.menu.forms.calendar.CallendarEventsListTool;
import pl.edu.agh.planner.client.applayout.menu.forms.calendar.PlannerCalendar;
import pl.edu.agh.planner.shared.AllGraphic;
import pl.edu.agh.planner.shared.AllString;

import java.util.ArrayList;

class MainMenuBar extends RibbonBar {

	private static final int GROUP_ROW_HEIGHT = 26;
	private static final int GROUP_ROW_NUMBER = 3;

	private ArrayList<RibbonGroup> ribbonGroups = new ArrayList<RibbonGroup>();

	public MainMenuBar() {
		RibbonGroup artifactGroup = new RibbonGroup();
		ribbonGroups.add(artifactGroup);
		artifactGroup.setTitle(AllString.menuNewArtifactProgramTitle);
		artifactGroup.setTitleAlign(Alignment.LEFT);
		artifactGroup.setNumRows(GROUP_ROW_NUMBER);
		artifactGroup.setRowHeight(GROUP_ROW_HEIGHT);
		artifactGroup.addControl(new PlannerIconButton(AllString.addNewConductorTitle, AllGraphic.addNewConductorTitleIcon, false, new AddNewConductor_ClickHandler()));
		artifactGroup.addControl(new PlannerIconButton(AllString.addNewClassroom, AllGraphic.addNewClassroomIcon, false, new AddNewClassroom_ClickHandler()));

		RibbonGroup viewGroup = new RibbonGroup();
		ribbonGroups.add(viewGroup);
		viewGroup.setTitle(AllString.menuViewProgramTitle);
		viewGroup.setTitleAlign(Alignment.LEFT);
		viewGroup.setNumRows(GROUP_ROW_NUMBER);
		viewGroup.setRowHeight(GROUP_ROW_HEIGHT);
		viewGroup.addControl(createIconMenuButton(AllString.viewList, AllGraphic.menuViewShowIcon, new ListsMenu(), true));

		RibbonGroup callendarTools = new RibbonGroup();
		ribbonGroups.add(callendarTools);
		callendarTools.setTitle(AllString.callendarTitle);
		callendarTools.setTitleAlign(Alignment.CENTER);
		callendarTools.setNumRows(GROUP_ROW_NUMBER);
		callendarTools.setRowHeight(GROUP_ROW_HEIGHT);
		callendarTools.addControl(new PlannerIconButton(AllString.callendarShow, AllGraphic.callendarShowIcon, true, new ShowCalendar_ClickHandler()));
		callendarTools.addControl(new PlannerIconButton(AllString.callendarShowList, AllGraphic.callendarShowIcon, true, new ShowCalendarList_ClickHandler()));
		callendarTools.addControl(new PlannerIconButton(AllString.callendarChooseDate, AllGraphic.callendarChooseDateIcon, true, new TYMCZASOWO_ClickHandler()));
		callendarTools.addControl(new PlannerIconButton(AllString.callendarAddEvent, AllGraphic.callendarAddEventIcon, true, new TYMCZASOWO_ClickHandler()));
		callendarTools.addControl(new PlannerIconButton(AllString.callendarPrev, AllGraphic.callendarPrevIcon, true, new CalendarPrev_ClickHandler()));
		callendarTools.addControl(new PlannerIconButton(AllString.callendarToday, AllGraphic.callendarTodayIcon, true, new TYMCZASOWO_ClickHandler()));
		callendarTools.addControl(new PlannerIconButton(AllString.callendarNext, AllGraphic.callendarNextIcon, true, new CalendarNext_ClickHandler()));

		RibbonGroup exportTools = new RibbonGroup();
		ribbonGroups.add(exportTools);
		exportTools.setTitle(AllString.exportTitle);
		exportTools.setTitleAlign(Alignment.LEFT);
		exportTools.setNumRows(GROUP_ROW_NUMBER);
		exportTools.setRowHeight(GROUP_ROW_HEIGHT);

		exportTools.addControl(new PlannerIconButton(AllString.exportPdf, AllGraphic.exportPdfIcon, true, new TYMCZASOWO_ClickHandler()));
		exportTools.addControl(new PlannerIconButton(AllString.exportPrint, AllGraphic.exportPrintIcon, true, new TYMCZASOWO_ClickHandler()));


		RibbonGroup optionGroup = new RibbonGroup();
		ribbonGroups.add(optionGroup);
		optionGroup.setTitle(AllString.menuOptionsProgramTitle);
		optionGroup.setTitleAlign(Alignment.CENTER);
		optionGroup.setNumRows(GROUP_ROW_NUMBER);
		optionGroup.setRowHeight(GROUP_ROW_HEIGHT);

		optionGroup.addControl(new PlannerIconButton(AllString.options, AllGraphic.optionsIcon, true, new TYMCZASOWO_ClickHandler()));

		RibbonGroup addSubject = new RibbonGroup();
		ribbonGroups.add(addSubject);
		addSubject.setTitle(AllString.menuAboutProgramTitle);
		addSubject.setTitleAlign(Alignment.LEFT);
		addSubject.setNumRows(GROUP_ROW_NUMBER);
		addSubject.setRowHeight(GROUP_ROW_HEIGHT);
		addSubject.addControl(new PlannerIconButton(AllString.aboutAuthors, AllGraphic.aboutAuthorsIcon, false, new TYMCZASOWO_ClickHandler()));
		addSubject.addControl(new PlannerIconButton(AllString.aboutProgram, AllGraphic.aboutProgramIcon, false, new TYMCZASOWO_ClickHandler()));

		RibbonGroup userActions = new RibbonGroup();
		ribbonGroups.add(userActions);
		userActions.setTitle(AllString.menuUserActionsTitle);
		userActions.setTitleAlign(Alignment.LEFT);
		userActions.setNumRows(GROUP_ROW_NUMBER);
		userActions.setRowHeight(GROUP_ROW_HEIGHT);
		userActions.addControl(buttonWithUserInfo("root", "God system"));
		userActions.addControl(new PlannerIconButton(AllString.userLogout, AllGraphic.userLogoutIcon, true, new TYMCZASOWO_ClickHandler()));

		addMembers(artifactGroup, viewGroup, callendarTools, exportTools, optionGroup, addSubject, userActions);

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

	private class AddNewConductor_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			new AddNewTeacher();
		}
	}

	private class AddNewClassroom_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			new AddNewClassroom();
		}

	}

	private class ShowCalendar_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			if (PlannerCalendar.getInstance().isVisible()) {
				PlannerCalendar.getInstance().setVisible(false);
				CallendarEventsListTool.getInstance().setVisible(false);
			} else {
				PlannerCalendar.getInstance().setVisible(true);
			}
		}

	}

	private class ShowCalendarList_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			if (CallendarEventsListTool.getInstance().isVisible()) {
				CallendarEventsListTool.getInstance().setVisible(false);
			} else {
				PlannerCalendar.getInstance().setVisible(true);
				CallendarEventsListTool.getInstance().setVisible(true);
			}
		}

	}

	private class CalendarNext_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			PlannerCalendar.getInstance().next();
		}

	}

	private class CalendarPrev_ClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			PlannerCalendar.getInstance().previous();
		}

	}

}