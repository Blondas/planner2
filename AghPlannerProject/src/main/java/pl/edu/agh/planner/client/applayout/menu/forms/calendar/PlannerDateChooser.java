package pl.edu.agh.planner.client.applayout.menu.forms.calendar;

import com.smartgwt.client.widgets.DateChooser;
import com.smartgwt.client.widgets.events.DataChangedEvent;
import com.smartgwt.client.widgets.events.DataChangedHandler;

public class PlannerDateChooser extends DateChooser {

	private static volatile PlannerDateChooser instance = null;

	public static PlannerDateChooser getInstance() {
		if (instance == null) {
			synchronized (PlannerDateChooser.class) {
				if (instance == null) {
					instance = new PlannerDateChooser();
				}
			}
		}
		return instance;
	}

	private PlannerDateChooser() {
		setShowCancelButton(true);

		addDataChangedHandler(new DataChangedHandler() {
			@Override
			public void onDataChanged(DataChangedEvent event) {
				try {
					PlannerCalendar.getInstance().setChosenDate(PlannerDateChooser.getInstance().getData());
				} finally {
					PlannerDateChooser.getInstance().destroy();
					instance = null;
				}
			}
		});

		show();
	}

}
