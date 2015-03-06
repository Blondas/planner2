package pl.edu.agh.planner.client.applayout.menu;

import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import pl.edu.agh.planner.shared.AllString;

class ArtifactsMenu extends Menu {

	public ArtifactsMenu() {

		addItem(new MenuItem(AllString.addItem1, "16/add.png"));
		addItem(new MenuItem(AllString.addItem2, "16/add.png"));
		addItem(new MenuItem(AllString.addItem3, "16/add.png"));
		
	}

}
