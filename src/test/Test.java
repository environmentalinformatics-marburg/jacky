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
import jacky.util.stations.Sensor;
import jacky.util.stations.Station;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Test class for whatsoever.
 *  
 * @version 0.1 2013-08-31
 * @author Thomas Nauss (tnauss)
 */public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

        StationDataFilesToController station = null; 
        String classname = "jacky.util.datafiles.stationdatafiles.dk.DKPu";
        try {
            Class<?> stationClass = Class.forName(classname);
            station = (StationDataFilesToController) stationClass.newInstance();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        station.calibrateData();
        
    }

}

/*
List<String> l = new ArrayList<String>();
l.add("Hallo");
l.add("Spaska");
System.out.println(l.indexOf("Spaska"));
System.out.println(l.toString());
List<String> l1 = new LinkedList<String>();
l1.add("Hallo1");
l1.add("Spaksa1");
System.out.println(l1.indexOf("Spaska1"));
System.out.println(l1.toString());
DKRug rug = new DKRug(); 
System.out.println(rug.getTimeInterval());
rug.setStation(new Station());
rug.getStation().setPlotID("0000gra1");
System.out.println(rug.getStation().getPlotID());
Map<String,Sensor> sensor = new HashMap<String, Sensor>();
sensor.put("ta200", new Sensor());
sensor.put("rh200", new Sensor());
rug.getStation().setSensor(sensor);
rug.getStation().getSensor().containsKey("ta200");
rug.getStation().getSensor().put("wd", new Sensor());
rug.getStation().addSensor("wv", new Sensor());
System.out.println(rug.getStation().isSensorEmpty());
System.out.println(rug.getStation().sensorSize());
System.out.println(rug.getStation().getSensor().get("ta200"));
rug.getStation().getSensor().get("ta200").setSerialNumber("ta200-01");
rug.getStation().getSensor().get("wv").setSerialNumber("wv-01");
Iterator iterator = rug.getStation().getSensor().keySet().iterator();
while(iterator.hasNext()){
    Object key = iterator.next();
    Sensor sen = rug.getStation().getSensor().get(key);
    System.out.println(key);
    System.out.println(sen.getSerialNumber());
}

*/
