package pl.edu.agh.planner.client.applayout.menu.forms.calendar;

import com.smartgwt.client.types.DateDisplayFormat;
import com.smartgwt.client.types.TimeFormatter;
import com.smartgwt.client.types.TimeUnit;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.HeaderLevel;
import com.smartgwt.client.widgets.calendar.Lane;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import pl.edu.agh.planner.shared.Aggregate;

import java.time.Instant;
import java.util.Date;

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
		setWidth("80%");
		setTimeFormatter(TimeFormatter.TOSHORT24HOURTIME);
		setDateFormatter(DateDisplayFormat.TOEUROPEANSHORTDATE);
		setFirstDayOfWeek(1);
		setVisible(false);
		setShowWeekends(true);
		setDisableWeekends(false);
		setShowControlsBar(false);

		setData(PlannerCalendarEventsLoader.getRecords());
	}

	private static class PlannerCalendarEventsLoader {

		private static CalendarEvent[] records;

		public static CalendarEvent[] getRecords() {
			if (records == null) {
				records = getNewRecords();
			}
			return records;
		}

		public static CalendarEvent[] getNewRecords() {
			return new CalendarEvent[]{
					new PlannerCalendarEvent()
			};
		}

	}

	private static class PlannerCalendarEvent extends CalendarEvent {

		private Aggregate aggregate = null;

		private Date today = new Date();
		private int year = today.getYear();
		private int month = today.getMonth();
		private int start = today.getDate() - today.getDay();

		public PlannerCalendarEvent() {

//			setTitle("");
			setDescription("OPIS");

			setStartDate(new Date(year, month, start + 3, 8, 0, 0));
			setEndDate(new Date(year, month, start + 3, 9, 30, 0));

		}

		public PlannerCalendarEvent(Aggregate aggregate) {
			this();
			this.aggregate = aggregate;
		}




	}

}
