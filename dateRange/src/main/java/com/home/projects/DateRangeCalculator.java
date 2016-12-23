package com.home.projects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by chatti on 22/12/2016.
 */
public class DateRangeCalculator {

	public static final String BETWEEN = "Between ";
	public static final String AND = " and ";
	public static final String SPACE = " ";
	public static final String COMMA = ", ";
	public static final String THE = "the ";
	private Calendar begin;

	private Calendar end;

	private Calendar today;

	private SimpleDateFormat monthFormater = new SimpleDateFormat("MMMM", Locale.US);

	private SimpleDateFormat dayOfWeekFormater = new SimpleDateFormat("EEEE", Locale.US);

	public DateRangeCalculator from(Date date) {
		begin = Calendar.getInstance();
		begin.setTime(date);
		return this;
	}

	public DateRangeCalculator today(Date date) {
		today = Calendar.getInstance();
		today.setTime(date);
		return this;
	}

	public DateRangeCalculator to(Date date) {
		end = Calendar.getInstance();
		end.setTime(date);
		return this;
	}

	public String buildMessage() {
		if (end != null) {
			StringBuilder firstPart = new StringBuilder();
			StringBuilder lastPart = new StringBuilder();

			lastPart.append(AND);

			firstPart.append(BETWEEN).append(monthFormater.format(begin.getTime()));
			firstPart.append(SPACE).append(begin.get(Calendar.DAY_OF_MONTH));

			if (!isSomeMonth()) {
				lastPart.append(monthFormater.format(end.getTime())).append(SPACE);
			}
			lastPart.append(end.get(Calendar.DAY_OF_MONTH));

			if (!isSomeYear()) {
				firstPart.append(COMMA).append(begin.get(Calendar.YEAR));
				lastPart.append(COMMA).append(end.get(Calendar.YEAR));
			}
			return firstPart.append(lastPart).toString();
		} else {
			StringBuilder msg = new StringBuilder();
			msg.append(dayOfWeekFormater.format(begin.getTime())).append(COMMA).append(THE)
					.append(begin.get(Calendar.DAY_OF_MONTH)).append(getNthDayOfMonth()).append(" of ")
					.append(monthFormater.format(begin.getTime()));
			if (begin.get(Calendar.YEAR) != today.get(Calendar.YEAR)) {
				msg.append(SPACE).append(begin.get(Calendar.YEAR));
			}

			return msg.toString();
		}
	}

	private String getNthDayOfMonth(){
        int dayOfMonth = begin.get(Calendar.DAY_OF_MONTH);
        return dayOfMonth == 1 ? "st" : dayOfMonth == 2 ? "nd" : dayOfMonth == 3 ? "rd" : "th";
    }

	public boolean isSomeMonth() {
		return begin.get(Calendar.YEAR) == end.get(Calendar.YEAR)
				&& begin.get(Calendar.MONTH) == end.get(Calendar.MONTH);
	}

	public boolean isSomeYear() {
		return begin.get(Calendar.YEAR) == end.get(Calendar.YEAR);
	}

}
