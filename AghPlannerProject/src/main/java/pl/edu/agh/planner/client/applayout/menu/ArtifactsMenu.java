package pl.edu.agh.planner.client.applayout.menu;

import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import pl.edu.agh.planner.client.applayout.menu.forms.AddNewTeacher;
import pl.edu.agh.planner.shared.AllString;

class ArtifactsMenu extends Menu {

	public ArtifactsMenu() {

		addItem(new MenuItem(AllString.addItem1, "16/add.png"));
		addItem(new MenuItem(AllString.addItem2, "16/add.png"));
		addItem(new MenuItem(AllString.addItem3, "16/add.png"));
		addItem(addMenuItemButton(AllString.addNewConductorTitle, "16/add.png", new AddNewConductor_ClickHandler()));
	}

	private MenuItem addMenuItemButton(String title, String iconPath, ClickHandler clickHandler) {
		MenuItem menuItem = new MenuItem();
		menuItem.setTitle(title);
		menuItem.setIcon(iconPath);
		menuItem.addClickHandler(clickHandler);

		return menuItem;
	}

	private class AddNewConductor_ClickHandler implements ClickHandler {

		@Override
		public void onClick(MenuItemClickEvent event) {
			new AddNewTeacher();
		}

	}

}
