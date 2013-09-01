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

package test;

import jacky.util.magic.DateTime;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.crypto.Data;
import javax.xml.datatype.Duration;

import org.w3c.dom.ranges.Range;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Test class for date/time operations.
 *  
 * @version 0.1 2013-08-31
 * @author Thomas Nauss (tnauss)
 */
public class TestDateTime {
    /**
     * @param args
     * @throws IOException 
     * @throws InterruptedException 
     * @throws ParseException 
     */
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        Date runStartTime = null;
        Date runEndTime = null;
        String actDateTime = "01.04.2012 14:01:32";
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date startDateTime = (Date) formatter.parse(actDateTime);
        Date[] monthlyTimeSpan = DateTime.getMonthlyTimeSpan(startDateTime);
        long duration = 5 * 60 * 1000;
        
        /* time step list - deprecated
        List<Date> dateTimeSteps = DateTime.getDateTimeStepsList(monthlyTimeSpan[0], monthlyTimeSpan[1], duration);
        System.out.println(dateTimeSteps.size());
        System.out.println("1: " + monthlyTimeSpan[0]);
        System.out.println("2: " + dateTimeSteps.get(0));
        System.out.println("   " + dateTimeSteps.get(1));
        System.out.println("   " + dateTimeSteps.get(2));
        System.out.println("3: " + monthlyTimeSpan[1]);
        System.out.println("4: " + dateTimeSteps.get(dateTimeSteps.size()-1));
        */
        
        NavigableMap<Date, Date> dateTimeStepsMap = DateTime.getDateTimeStepsMap(monthlyTimeSpan[0], monthlyTimeSpan[1], duration);
        List<Date> dateTimeList = new ArrayList<Date>();
        runStartTime = new Date();
        for (int i = 0; i < 100; i ++) {
            startDateTime.setTime(startDateTime.getTime() + 60 * 5 * 1000);
            dateTimeList.add((Date) startDateTime.clone());
            /* map individual dates - deprecated
            Date mapDate = DateTime.mapDate(startDateTime, dateTimeStepsMap);
            if (i % 100 == 0) {
                System.out.println(i + " startDateTime :" + startDateTime.toString());
                System.out.println("  --> mapDate   :" + mapDate.toString());
            }
            */
        }
        runEndTime = new Date();
        System.out.println("Start:   " + runStartTime.toString());
        System.out.println("End:     " + runEndTime.toString());
        System.out.println("Elapsed: " + (runEndTime.getTime() - runStartTime.getTime()));
        
        /* maped date list - deprecated
        runStartTime = new Date();
        List<Date> mapDateList = DateTime.mapDateListToDate(dateTimeList, dateTimeStepsMap);
        runEndTime = new Date();
        System.out.println("Start:   " + runStartTime.toString());
        System.out.println("End:     " + runEndTime.toString());
        System.out.println("Elapsed: " + (runEndTime.getTime() - runStartTime.getTime()));
        System.out.println("dateTimeList: " + dateTimeList.get(99));
        System.out.println("mapDateList:  " + mapDateList.get(99));
        */
        
        System.out.println();
        System.out.println();
        /* This is it: The date/time values of the csv file are mapped to a
         * regular grid using the following approach:
         * 1.) A navigable map is constructed with the regular date/time 
         *     interval as key and a running index as value
         *     (DateTime.getDateTimeStepsIndexMap)
         * 2.) The date/time values are mapped against the navigable map
         *     (DateTime.mapDateListToIndex) and the index position of the 
         *     closest date/time value in the map is returned for each input
         *     date/time value as a list
         * 3.) The key set of the navigable map is converted to an array. Hence,
         *     the index values returned in step 2 now directly correspond to
         *     the position of the corresponding key in this array (i.e. a
         *     date/time value). 
         *     THIS ARRAY FORMS THE BASIS FOR THE CONSTRUCTION OF THE REGULARLY
         *     SPACED TIME SERIES DATA SETS.
         * 4.) TODO: Attach the input data values to the respective date/time
         *     using the index positions. Index positions which are not included
         *     in the list of step 2 have to be filled with dummy values.
         *     
         */
        NavigableMap<Date, Long> dateTimeStepsIndexMap = DateTime.getDateTimeStepsIndexMap(monthlyTimeSpan[0], monthlyTimeSpan[1], duration);
        System.out.println("dateTimeStepsIndexMap: " + dateTimeStepsIndexMap.firstEntry()); 
        System.out.println("dateTimeStepsIndexMap: " + dateTimeStepsIndexMap.lastEntry());
        
        List<Long> mapDateIndexList = DateTime.mapDateListToIndex(dateTimeList, dateTimeStepsIndexMap);
        Object[] dateArray = dateTimeStepsIndexMap.keySet().toArray();
        System.out.println();
        System.out.println("Length of mapDateIndexList: " + mapDateIndexList.size());
        System.out.println("Length of dateArray: " + dateArray.length);
        System.out.println();
        System.out.println("dateTimeList: " + dateTimeList.get(0));
        System.out.println("mapDateIndexList:  " + mapDateIndexList.get(0));
        System.out.println("dateArray: " + dateArray[mapDateIndexList.get(0).intValue()]);
        System.out.println();
        System.out.println("dateTimeList: " + dateTimeList.get(99));
        System.out.println("mapDateIndexList:  " + mapDateIndexList.get(99));
        System.out.println("dateArray: " + dateArray[mapDateIndexList.get(99).intValue()]);
        
    }
    
}
 