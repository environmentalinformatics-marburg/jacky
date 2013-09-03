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

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;




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

    private static void csv() throws IOException, ParseException, InterruptedException{
        boolean print = false;
        
        String filepath = "/media/permanent/development/test/jacky/ki_0000mwh0_000pu2_201210151400_201212031035_mez_ra01_nai05_0000.asc";
        String outfilepath = "/media/permanent/development/test/jacky/ki_0000mwh0_000pu2_out.asc";

        Date runStartTime = new Date();

        Object[] fileContent = jacky.util.datafiles.stationdatafiles.StationDataFile.readStationDataFileContent(filepath);
        String[] header = (String[]) fileContent[0];        
        List<String[]> content = (List<String[]>) fileContent[1];        
        System.out.println(content.getClass());
        
        if (print) {
            System.out.println("Header");
            System.out.println(header.getClass());
            System.out.println(header.length);
            System.out.println(Arrays.toString(header));
            System.out.println(header[0]);
            System.out.println(Arrays.asList(header).indexOf("Time"));
        }
        
        String[] row = (String[]) content.get(0);
        if (print) {
            System.out.println();
            System.out.println("Content");
            System.out.println(content.getClass());
            System.out.println(content.size());
            System.out.println(row.length);
            System.out.println(row[0]);
            System.out.println(row[Arrays.asList(header).indexOf("Time")]);
            System.out.println(Arrays.toString(row));
        }
        
        
        String tempDate = null;
        List<Date> dateTimeList = new ArrayList<Date>(); 
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        
        for (Object object : content) {
            row = (String[]) object;
            tempDate = row[Arrays.asList(header).indexOf("Date")] + " " +  
                    row[Arrays.asList(header).indexOf("Time")];
            dateTimeList.add((Date) formatter.parse(tempDate));
        }
        
        if (print) {
            System.out.println(dateTimeList.size());
            System.out.println("First: " + dateTimeList.get(0));
            System.out.println("Last:  " + dateTimeList.get(dateTimeList.size()-1));
        }
        
        
        long duration = 6 * 60 * 1000;
        NavigableMap<Date, Long> dateTimeStepsIndexMap = DateTime.getDateTimeStepsIndexMap(dateTimeList.get(0), dateTimeList.get(dateTimeList.size()-1), duration);

        if (print) {
            System.out.println("dateTimeStepsIndexMap: first entry: " + dateTimeStepsIndexMap.firstEntry()); 
            System.out.println("dateTimeStepsIndexMap last entry:   " + dateTimeStepsIndexMap.lastEntry());
            System.out.println("dateTimeStepsIndexMap size:         " + dateTimeStepsIndexMap.size());
        }
        
        List<Long> mapDateIndexList = DateTime.mapDateListToIndex(dateTimeList, dateTimeStepsIndexMap);
        Object[] dateArray = dateTimeStepsIndexMap.keySet().toArray();

        if (print) {
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
        
        int version = 3; // maybe best option is option 3
        if (version == 1) {
            System.out.println("V1 - csvWriter.writeNext(); String.valueOf");
            List<Object[]> finalDataSet = new ArrayList<Object[]>();
            Object[] tempRow = new Object[3];
            for (int i = 0; i < content.size()-1; i++) {
                tempRow[0] = dateArray[mapDateIndexList.get(i).intValue()];
                tempRow[1] = (String) content.get(i)[2];
                tempRow[2] = (String) content.get(i)[3];
                finalDataSet.add(tempRow.clone());
            }
            CSVWriter csvWriter = new CSVWriter(new FileWriter(outfilepath), ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER);
            String[] outLine = new String[3];
            for (Object[] outRow : finalDataSet) {
                outLine[0] = '"' + String.valueOf(outRow[0]) + '"' ;
                for (int i = 1; i < outRow.length; i++) {
                    outLine[i] = String.valueOf(outRow[i]);
                }
                csvWriter.writeNext(outLine);
                }
            csvWriter.close();
        } else if (version == 2) {
            System.out.println("V2 - csvWriter.writeNext(); dateArray.toString");
            // the foor loop is not necessary, just for time coparison
            List<Object[]> finalDataSet = new ArrayList<Object[]>();
            Object[] tempRowO = new Object[3];
            for (int i = 0; i < content.size()-1; i++) {
                tempRowO[0] = dateArray[mapDateIndexList.get(i).intValue()];
                tempRowO[1] = (String) content.get(i)[2];
                tempRowO[2] = (String) content.get(i)[3];
                finalDataSet.add(tempRowO.clone());
            }
            CSVWriter csvWriter = new CSVWriter(new FileWriter(outfilepath), ',', CSVWriter.NO_ESCAPE_CHARACTER, CSVWriter.NO_QUOTE_CHARACTER);
            String[] tempRow = new String[3];
            for (int i = 0; i < content.size()-1; i++) {
                tempRow[0] = '"' + dateArray[mapDateIndexList.get(i).intValue()].toString() + '"';
                tempRow[1] = (String) content.get(i)[2];
                tempRow[2] = (String) content.get(i)[3];
                csvWriter.writeNext(tempRow);
            }
            csvWriter.close();
        } else if (version == 3) {
            System.out.println("V3 - buffWriter.write(line); String.valueOf");
            List<Object[]> finalDataSet = new ArrayList<Object[]>();
            Object[] tempRow = new Object[3];
            for (int i = 0; i < content.size()-1; i++) {
                tempRow[0] = dateArray[mapDateIndexList.get(i).intValue()];
                tempRow[1] = (String) content.get(i)[2];
                tempRow[2] = (String) content.get(i)[3];
                finalDataSet.add(tempRow.clone());
            }
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(outfilepath));
            String outLine = null;
            for (Object[] outRow : finalDataSet) {
                outLine = '"' + String.valueOf(outRow[0]) + '"';
                for (int i = 1; i < outRow.length; i++) {
                    outLine = outLine + "," + String.valueOf(outRow[i]);
                }
                buffWriter.write(outLine + "\n");
            }
            buffWriter.close();
        } else if (version == 4) {
            System.out.println("V4 - Writer.write(line); String.valueOf");
            List<Object[]> finalDataSet = new ArrayList<Object[]>();
            Object[] tempRow = new Object[3];
            for (int i = 0; i < content.size()-1; i++) {
                tempRow[0] = dateArray[mapDateIndexList.get(i).intValue()];
                tempRow[1] = (String) content.get(i)[2];
                tempRow[2] = (String) content.get(i)[3];
                finalDataSet.add(tempRow.clone());
            }
            FileWriter fileWriter = new FileWriter(outfilepath);
            String outLine = null;
            for (Object[] outRow : finalDataSet) {
                outLine = '"' + String.valueOf(outRow[0]) + '"';
                for (int i = 1; i < outRow.length; i++) {
                    outLine = outLine + "," + String.valueOf(outRow[i]);
                }
                fileWriter.write(outLine + "\n");
            }
            fileWriter.close();
    }
        Date runEndTime = new Date();
        System.out.println("Start:   " + runStartTime.toString());
        System.out.println("End:     " + runEndTime.toString());
        System.out.println("Elapsed: " + (runEndTime.getTime() - runStartTime.getTime()));
        
        /*
        Object[] finalDataSetArray = (Object[]) finalDataSet.toArray();
        System.out.println();
        System.out.println("dateTimeStepsIndexMap: first entry: " + dateTimeStepsIndexMap.firstEntry()); 
        System.out.println("dateTimeStepsIndexMap last entry:   " + dateTimeStepsIndexMap.lastEntry());
        System.out.println(finalDataSetArray[0].getClass());
        System.out.println(Arrays.toString((Object[]) finalDataSetArray[0]));
        System.out.println(Arrays.toString((Object[]) finalDataSetArray[finalDataSet.size()-1]));
        */
    }
    
}
