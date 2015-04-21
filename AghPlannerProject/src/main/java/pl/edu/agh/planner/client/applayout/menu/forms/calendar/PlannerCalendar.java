package pl.edu.agh.planner.client.applayout.menu.forms.calendar;

import com.smartgwt.client.types.DateDisplayFormat;
import com.smartgwt.client.types.TimeFormatter;
import com.smartgwt.client.widgets.calendar.Calendar;

public class PlannerCalendar extends Calendar {

	private static volatile PlannerCalendar instance = null;

	public static PlannerCalendar getInstance() {
		if (instance == null) {
			synchronized (PlannerCalendar.class) {
				if (instance == null) {
					instance = new PlannerCalendar();
				}
			}
		}
		return instance;
	}

	private PlannerCalendar() {
		setTimeFormatter(TimeFormatter.TOSHORT24HOURTIME);
		setDateFormatter(DateDisplayFormat.TOEUROPEANSHORTDATE);
		setFirstDayOfWeek(1);
		setVisible(false);
		setShowWeekends(true);
		setDisableWeekends(false);
		setShowControlsBar(false);

	}

}
