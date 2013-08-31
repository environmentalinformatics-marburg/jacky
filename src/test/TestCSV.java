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

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author tnauss
 *
 */
public class TestCSV {
    /**
     * @param args
     * @throws IOException 
     * @throws InterruptedException 
     * @throws ParseException 
     */
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        String filepath = "/media/permanent/development/test/jacky/ki_0000mwh0_000pu2_201210151400_201212031035_mez_ra01_nai05_0000.asc";
        
        String[] row = null;
        String csvFilename = "C:\\work\\sample.csv";
         
        CSVReader csvReader = new CSVReader(new FileReader (filepath), '\t','\'', 4);
        String[] header = csvReader.readNext();
        System.out.println(Arrays.toString(header));
        System.out.println(header.length);
        System.out.println(header[1]);
        System.out.println(Arrays.asList(header).indexOf("Time"));
        
        String datestring = "13.04.2012 14:05:10";
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date convertedDate = (Date) formatter.parse(datestring);
        System.out.println(convertedDate);
        
        Calendar c = Calendar.getInstance(); 
        c.setTime(convertedDate); 
        int minute = 1;
        c.add(Calendar.MINUTE, minute);
        Calendar addDate = (Calendar) c.clone();
        System.out.println(addDate.getTime());
        
        Calendar cal = Calendar.getInstance();
        cal = (Calendar) addDate.clone();
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        cal.set(cal.HOUR_OF_DAY, 23);
        Date lastDayOfMonth = cal.getTime();
        System.out.println("Last: " + lastDayOfMonth );

        String maxtime = "13.04.2012 23:59:59";
        Calendar calmax = Calendar.getInstance();
        calmax.setTime((Date) formatter.parse(maxtime));
        calmax.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        
        System.out.println("calmax: " + calmax.getTime());
        System.out.println("addDate: " + addDate.getTime());
        while (calmax.after(addDate)) {
            addDate.add(Calendar.MINUTE, 5);
            System.out.println("Zeit: " + addDate.getTime());
        }
        System.out.println("calmax: " + calmax.getTime());
        System.out.println("addDate: " + addDate.getTime());
        
        
        List content = csvReader.readAll();
        /*
        for (Object object : content) {
            row = (String[]) object;
            System.out.println(row[1]);
            Thread.sleep(2000);
            System.out.println("HI");
            
        }
        */
        csvReader.close();
        
        
    }

}
