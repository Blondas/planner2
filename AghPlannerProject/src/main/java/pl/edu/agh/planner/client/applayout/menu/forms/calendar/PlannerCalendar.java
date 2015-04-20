package pl.edu.agh.planner.client.applayout.menu.forms.calendar;

import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.DateDisplayFormat;
import com.smartgwt.client.types.TimeFormatter;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.events.CalendarEventClick;
import com.smartgwt.client.widgets.calendar.events.EventClickHandler;

public class PlannerCalendar extends Calendar {

	public PlannerCalendar() {
		setTimeFormatter(TimeFormatter.TOSHORT24HOURTIME);
		setDateFormatter(DateDisplayFormat.TOEUROPEANSHORTDATE);
		setFirstDayOfWeek(1);
		setShowWeekends(true);
		setDisableWeekends(false);

		SC.say("Jesli otworzyles kalendarz musisz zrestartowac apke. Jeszcze nie jest dopracowany.");

		RootPanel.get().add(this);
	}


}
