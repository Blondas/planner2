package pl.edu.agh.planner.client.applayout.menu;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;
import pl.edu.agh.planner.client.applayout.menu.forms.TeachersList;
import pl.edu.agh.planner.shared.AllString;

class ListsMenu extends Menu {

	public ListsMenu() {
		addItem(addMenuItemButton(AllString.viewListSale, "16/add.png", new ViewListSale()));
		addItem(addMenuItemButton(AllString.viewListConductors, "16/add.png", new ViewListConductors()));
	}

	private MenuItem addMenuItemButton(String title, String iconPath, ClickHandler clickHandler) {
		MenuItem menuItem = new MenuItem();
		menuItem.setTitle(title);
		menuItem.setIcon(iconPath);
		menuItem.addClickHandler(clickHandler);

		return menuItem;
	}

	private class ViewListSale implements ClickHandler {

		@Override
		public void onClick(MenuItemClickEvent event) {
			SC.say("Dostępne już niebawem.");
		}

	}

	private class ViewListConductors implements ClickHandler {

		@Override
		public void onClick(MenuItemClickEvent event) {
			new TeachersList();
		}

	}

}
