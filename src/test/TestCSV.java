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
 * Test class for csv operations.
 *  
 * @version 0.1 2013-08-31
 * @author Thomas Nauss (tnauss)
 */
public class TestCSV {
    /**
     * @param args
     * @throws IOException 
     * @throws InterruptedException 
     * @throws ParseException 
     */
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        csv();
        
    }

    private static void csv() throws IOException{
        String filepath = "/media/permanent/development/test/jacky/ki_0000mwh0_000pu2_201210151400_201212031035_mez_ra01_nai05_0000.asc";
        
        String[] row = null;
        String csvFilename = "C:\\work\\sample.csv";
         
        CSVReader csvReader = new CSVReader(new FileReader (filepath), '\t','\'', 4);
        String[] header = csvReader.readNext();
        System.out.println(Arrays.toString(header));
        System.out.println(header.length);
        System.out.println(header[1]);
        System.out.println(Arrays.asList(header).indexOf("Time"));
        
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
