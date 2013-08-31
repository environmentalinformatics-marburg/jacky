/* 
 * @(#)jacky: Utilities for climate station data sets.
 * 
 * Copyright (C) 2013-2013 Thomas Nauss, Spaska Forteva
 *                         Environmental Informatics
 *                         University of Marburg
 *                         Germany
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Please send any comments, suggestions, criticism, or (for our sake) bug
 * reports to nausst@googlemail.com
 * 
 * http://environmentalinformatics-marburg.de
 */

package jacky.util.magic;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author tnauss
 *
 */
public class DateTime {
	/** 
     * This method takes a date object and returns the date/time of the
     * beginning and end of the month of this object. The time of the first day
     * of the month is set to 00:00:00, the one of the last day is set to
     * 23:59:59.
     */
	public static Date[] getMonthlyTimeSpan(Date dateTime) 
	    throws ParseException {
	    Date[] monthlyTimeSpan = new Date[2];
	    Calendar dateTimeMonth = Calendar.getInstance();
	    dateTimeMonth.setTime(dateTime);
	    dateTimeMonth.set(Calendar.HOUR_OF_DAY, 00);
	    dateTimeMonth.set(Calendar.MINUTE, 00);
	    dateTimeMonth.set(Calendar.SECOND, 00);
	    dateTimeMonth.set(Calendar.DATE, 
	        dateTimeMonth.getActualMinimum(Calendar.DATE));
	    monthlyTimeSpan[0] = dateTimeMonth.getTime();
	    dateTimeMonth.set(Calendar.HOUR_OF_DAY, 23);
	    dateTimeMonth.set(Calendar.MINUTE, 59);
	    dateTimeMonth.set(Calendar.DATE, 
	        dateTimeMonth.getActualMaximum(Calendar.DATE));
	    monthlyTimeSpan[1] = dateTimeMonth.getTime();
	    return monthlyTimeSpan;
	}
	
    /** 
     * This method generates a list of date/time values between a start and
     * end date/time with the increment given by duration in milliseconds.
     */
    public static List<Date> getDateTimeSteps(Date startDateTime, 
        Date endDateTime, long duration) throws ParseException {
        List<Date> dateTimeSteps = new ArrayList<Date>();
	    Date lastDateTimeStep = (Date) endDateTime.clone();
	    lastDateTimeStep.setTime(lastDateTimeStep.getTime() - duration);
	    Date timeStep = (Date) startDateTime.clone();
	    while (lastDateTimeStep.after(timeStep)) {
	        dateTimeSteps.add((Date) timeStep.clone()); 
	        timeStep.setTime(timeStep.getTime() + duration);
	    }
	    return dateTimeSteps;
	}

}
