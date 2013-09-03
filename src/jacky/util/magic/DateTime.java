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
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * This class provides useful methods for date and time handling in the context
 * of data time series. See method descriptions for details.
 *  
 * @version 0.1 2013-08-31
 * @author Thomas Nauss (tnauss)
 */
public abstract class DateTime {
	/** 
     * Generates a list of date/time values between a start and end date/time 
     * with the increment given by duration in milliseconds.
     * This method is similar to {@link getDateTimeStepsMap(Date startDateTime, 
     * Date endDateTime, long duration)  getDateTimeStepsMap} except it returns 
     * an ArrayList.
     */
    public static List<Date> getDateTimeStepsList(Date startDateTime, 
            Date endDateTime, long duration) throws ParseException {
        List<Date> dateTimeSteps = new ArrayList<Date>();
	Date lastDateTimeStep = (Date) endDateTime.clone();
	//lastDateTimeStep.setTime(lastDateTimeStep.getTime() - duration);
	Date timeStep = (Date) startDateTime.clone();
        while ((lastDateTimeStep.after(timeStep)) || 
                (lastDateTimeStep.equals(timeStep))) {
	    dateTimeSteps.add((Date) timeStep.clone()); 
	    timeStep.setTime(timeStep.getTime() + duration);
	}
	return dateTimeSteps;
    }

    /** 
     * Generate a TreeMap of date/time and date/time values between a start and
     * end date/time with the increment given by duration in milliseconds. 
     * This method is similar to {@link getDateTimeStepsList(Date startDateTime,
     * Date endDateTime, long duration)  getDateTimeStepsList} except it returns
     * a navigable map.
     * It is quite identical to {@link getDateTimeStepsIndexMap(Date 
     * startDateTime, Date endDateTime, long duration) getDateTimeStepsIndexMap}
     * except it returns a date object equal to the key element.
     */
    public static NavigableMap<Date, Date> getDateTimeStepsMap(
            Date startDateTime, Date endDateTime, long duration)
                    throws ParseException {
	NavigableMap<Date, Date> dateTimeSteps = new TreeMap<Date, Date>();
        Date lastDateTimeStep = (Date) endDateTime.clone();
        //lastDateTimeStep.setTime(lastDateTimeStep.getTime() - duration);
        Date timeStep = (Date) startDateTime.clone();
        while ((lastDateTimeStep.after(timeStep)) || 
                (lastDateTimeStep.equals(timeStep))) {
            dateTimeSteps.put((Date) timeStep.clone(), (Date) timeStep.clone()); 
            timeStep.setTime(timeStep.getTime() + duration);
        }
        return dateTimeSteps;
    }

    /** 
     * Generate a TreeMap of date/time and index values between a start and end 
     * date/time with the increment given by duration in milliseconds. 
     * This method is similar to {@link getDateTimeStepsList(Date startDateTime,
     * Date endDateTime, long duration)  getDateTimeStepsList} except it returns
     * a navigable map.
     * It is quite identical to {@link getDateTimeStepsMap( Date startDateTime,
     * Date endDateTime, long duration) getDateTimeStepsMap} except it returns
     * the index of the position of the key element, not a date object. 
     */
    public static NavigableMap<Date, Long> getDateTimeStepsIndexMap(
            Date startDateTime, Date endDateTime, long duration)
                    throws ParseException {
        NavigableMap<Date, Long> dateTimeSteps = new TreeMap<Date, Long>();
        Date lastDateTimeStep = (Date) endDateTime.clone();
        //lastDateTimeStep.setTime(lastDateTimeStep.getTime() - duration);
        Date timeStep = (Date) startDateTime.clone();
        long index = 0;
        while ((lastDateTimeStep.after(timeStep)) || 
                (lastDateTimeStep.equals(timeStep))) {
            dateTimeSteps.put((Date) timeStep.clone(), index); 
            timeStep.setTime(timeStep.getTime() + duration);
            index++;
        }
        return dateTimeSteps;
    }

    /** 
     * Take a date object and return the date/time of the beginning and end of 
     * the month of this object. The time of the first day of the month is set 
     * to 00:00:00, the one of the last day is set to 23:59:59.
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
            dateTimeMonth.set(Calendar.SECOND, 59);
            dateTimeMonth.set(Calendar.DATE, 
                dateTimeMonth.getActualMaximum(Calendar.DATE));
            monthlyTimeSpan[1] = dateTimeMonth.getTime();
            return monthlyTimeSpan;
        }

    /** 
     * Map a given date/time to the closest date/time given in a
     * navigable map. One can use 
     * {@link getDateTimeStepsMap(Date startDateTime, Date endDateTime, 
     * long duration) getDateTimeStepsMap} to generate such a map.
     * This method is similar to  {@link mapDateListToDate(List<Date> date, 
     * NavigableMap<Date, Date> dateTimeStepsMap)  mapDateList} except it 
     * takes only one date to be mapped and returns only this one mapped date. 
     */
    public static Date mapDate(Date date, 
	    NavigableMap<Date, Date> dateTimeStepsMap) throws ParseException {
        Date result = null;
        if (!(date.after((Date) dateTimeStepsMap.firstKey())) ||
                !(date.before((Date) dateTimeStepsMap.lastKey()))) {
            Date lower = dateTimeStepsMap.floorEntry(date).getValue();
            Date higher = dateTimeStepsMap.ceilingEntry(date).getValue();
            if (lower != null && higher != null) {
                result = Math.abs(date.getTime() - lower.getTime()) < 
                         Math.abs(date.getTime() - higher.getTime())
                ?   lower
                :   higher;
            } else if (lower != null || higher != null) {
                result = lower != null ? lower : higher;
            }
        }
        return result;
    }

    /** 
     * Map a list of given date/time to the closest date/time given in a
     * navigable map. One can use
     * {@link getDateTimeStepsMap(Date startDateTime, Date endDateTime, 
     * long duration) getDateTimeStepsMap} to generate such a map. 
     * This method is similar to {@link mapDate(Date date, 
     * NavigableMap<Date, Date> dateTimeStepsMap)  mapDate) except it 
     * takes a list of dates and returns a list of mapped dates. 
     * This method is quite identical to {@link mapDateListToIndex(List<Date> 
     * date, NavigableMap<Date, Long> dateTimeStepsMap) mapDateListToIndex)
     * except it returns a list of date objects which equal the respective 
     * date/time which is closest to each input value. Hence it needs a map with
     * a date/time key and the same date/time as value.
     */
    public static List<Date> mapDateListToDate(List<Date> date, 
            NavigableMap<Date, Date> dateTimeStepsMap) throws ParseException {
        List<Date> mapDateListToDate = new ArrayList<Date>();
        for (Date actDate: date) {
            if (actDate.before((Date) dateTimeStepsMap.firstKey()) ||
                    actDate.after((Date) dateTimeStepsMap.lastKey())) {
                continue;
            } else {
                Date lower = dateTimeStepsMap.floorEntry(actDate).getValue();
                Date higher = dateTimeStepsMap.ceilingEntry(actDate).getValue();
                Date result = null;
                if (lower != null && higher != null) {
                    result = Math.abs(actDate.getTime() - lower.getTime()) < 
                            Math.abs(actDate.getTime() - higher.getTime())
                    ?   lower
                    :   higher;
                } else if (lower != null || higher != null) {
                    result = lower != null ? lower : higher;
                }
                mapDateListToDate.add(result);
            }
        }
        return mapDateListToDate;
    }

    /** 
     * Map a list of given date/time to the closest date/time given in a
     * navigable map. One can use
     * {@link getDateTimeStepsMap(Date startDateTime, Date endDateTime, 
     * long duration) getDateTimeStepsMap} to generate such a map. 
     * This method is similar to {@link mapDate(Date date, 
     * NavigableMap<Date, Date> dateTimeStepsMap)  mapDate) except it 
     * takes a list of dates and returns a list of mapped dates. 
     * This method is quite identical to {@link mapDateListToDate(List<Date> 
     * date, NavigableMap<Date, Date> dateTimeStepsMap) mapDateListToDate)
     * except it returns a list of the index values of the respective date/time
     * positions in the date/time map and hence needs a map with a date/time key
     * and an index as value. 
     * The returned index values i can be used to retrieve the corresponding
     * date/time information using 
     *     Object[] dateArray = dateTimeStepsIndexMap.keySet().toArray()[i];
     */
    public static List<Long> mapDateListToIndex(List<Date> date, 
            NavigableMap<Date, Long> dateTimeStepsMap) throws ParseException {
        List<Long> mapDateListToIndex = new ArrayList<Long>();
        long result = -1;
        for (Date actDate: date) {
            if (actDate.before((Date) dateTimeStepsMap.firstKey()) ||
                    actDate.after((Date) dateTimeStepsMap.lastKey())) {
                continue;
            } else {
                Date lower = dateTimeStepsMap.floorEntry(actDate).getKey();
                Date higher = dateTimeStepsMap.ceilingEntry(actDate).getKey();
                if (lower != null && higher != null) {
                    result = Math.abs(actDate.getTime() - lower.getTime()) < 
                            Math.abs(actDate.getTime() - higher.getTime())
                    ?   dateTimeStepsMap.get(lower)
                    :   dateTimeStepsMap.get(higher);
                } else if (lower != null || higher != null) {
                    result = lower != null 
                        ? dateTimeStepsMap.get(lower) 
                        : dateTimeStepsMap.get(higher);
                }
                mapDateListToIndex.add(result);
            }
        }
        return mapDateListToIndex;
    }

}
