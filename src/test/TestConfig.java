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
import jacky.util.datafiles.stationdatafiles.StationDataFile;
import jacky.util.datafiles.stationdatafiles.StationDataFilesToController;
import jacky.util.datafiles.stationdatafiles.dk.DKRug;
import jacky.util.meta.ConfigFile;
import jacky.util.stations.Sensor;
import jacky.util.stations.Station;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
 * This class provides basic test functionality.
 * 
 * @version 0.1 2013-08-28
 * @author tnauss
 */
public class TestConfig {


    /**
     * @param args
     */
    public static void main(String[] args) {
        Date runStartTime = new Date();

        String filepath = "/media/permanent/development/released/github/jacky/src/test/config.properties";
    	ConfigFile conf = ConfigFile.getInstance(filepath);
    	
    	Map<String, String> map = new HashMap<String, String>();
    	try {
			PrintStream errstr;
			// Der Aufruf von e.printStackTrace() in allen try und catch Fälle schreibt in die 
			// error.log Datei, falls in dem Constructor FileOutputStream true übergeben wird, ansonsten in der Konsole unten;  - 
			errstr = new PrintStream( new FileOutputStream( conf.get("scrPath")+ "error.log",true));
			String today="=============================================================================\n"
				+ DateFormat.getDateTimeInstance
				( DateFormat.LONG,DateFormat.FULL).format( Calendar.getInstance().getTime())+"\n\n";
			errstr.write( today.getBytes(),0,today.length());
			System.setErr( errstr);
			String gebiete = conf.get( "LOGGER-80081025279", "NAN");
			args =  gebiete.split("#");
			for (String entry : args[0].split(",")) {
			    map.put(entry.split("=")[0], entry.split("=")[1]);
			}
			System.out.println(map.get("Landcover"));
			
		} catch ( FileNotFoundException e) {
			e.printStackTrace();
		}
        Date runEndTime = new Date();
        System.out.println();
        System.out.println("Start:    " + runStartTime.toString());
        System.out.println("End:      " + runEndTime.toString());
        System.out.println("Elapsed:  " + (runEndTime.getTime() - runStartTime.getTime()));
    }
    	

}