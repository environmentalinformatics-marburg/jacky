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

import javax.xml.crypto.Data;
import javax.xml.datatype.Duration;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author tnauss
 *
 */
public class TestDateTime {
    /**
     * @param args
     * @throws IOException 
     * @throws InterruptedException 
     * @throws ParseException 
     */
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        String actDateTime = "13.04.2012 14:05:00";
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date startDateTime = (Date) formatter.parse(actDateTime);
        Date[] monthlyTimeSpan = DateTime.getMonthlyTimeSpan(startDateTime);
        long duration = 5 * 60 * 1000;
        List<Date> dateTimeSteps = DateTime.getDateTimeSteps(monthlyTimeSpan[0], monthlyTimeSpan[1], duration);
        System.out.println(dateTimeSteps.size());
        System.out.println("1: " + monthlyTimeSpan[0]);
        System.out.println("2: " + dateTimeSteps.get(0));
        System.out.println("   " + dateTimeSteps.get(1));
        System.out.println("   " + dateTimeSteps.get(2));
        System.out.println("3: " + monthlyTimeSpan[1]);
        System.out.println("4: " + dateTimeSteps.get(dateTimeSteps.size()-1));
        
    }
}
