/*
 * @(#)jacky: Utilities for climate station data sets.
 * 
 * Copyright (C) 2013-2013 Thomas Nauss, Spaska Forteva
 *         				   Environmental Informatics
 *                         University of Marburg
 *                         Germany
 * 
 * This file is part of jacky.
 * 
 * jacky is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * jacky is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with jacky.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Please send any comments, suggestions, criticism, or (for our sake) bug
 * reports to nausst@googlemail.com
 * 
 * http://environmentalinformatics-marburg.de
 */

package jacky.util.datafiles.stationdatafiles;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import jacky.util.datafiles.DataFile;
import jacky.util.stations.Station;

/** 
 * @author tnauss
 */
public abstract class StationDataFile extends DataFile implements StationDataFilesToController {

	/** 
	 * Time zone of the date and time information.
	 * @uml.property name="timeZone"
	 */
	private TimeZone timeZone = new TimeZone() {
        
        @Override
        public boolean useDaylightTime() {
            // TODO Auto-generated method stub
            return false;
        }
        
        @Override
        public void setRawOffset(int offsetMillis) {
            // TODO Auto-generated method stub
            
        }
        
        @Override
        public boolean inDaylightTime(Date date) {
            // TODO Auto-generated method stub
            return false;
        }
        
        @Override
        public int getRawOffset() {
            // TODO Auto-generated method stub
            return 0;
        }
        
        @Override
        public int getOffset(int era, int year, int month, int day, int dayOfWeek,
                int milliseconds) {
            // TODO Auto-generated method stub
            return 0;
        }
    }; ;

	/** 
	 * Getter of the property <tt>timeZone</tt>
	 * @return  Returns the timeZone.
	 * @uml.property  name="timeZone"
	 */
	public TimeZone getTimeZone() {
        return timeZone;
    }

	/**
	 * Time interval of the data entries.
	 * @uml.property  name="timeInterval"
	 */
	private int timeInterval = 0;

	/**
	 * Getter of the property <tt>timeInterval</tt>
	 * @return  Returns the timeInterval.
	 * @uml.property  name="timeInterval"
	 */
	public int getTimeInterval() {
        return timeInterval;
    }

	/**
	 * Setter of the property <tt>timeInterval</tt>
	 * @param timeInterval  The timeInterval to set.
	 * @uml.property  name="timeInterval"
	 */
	public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

				
	/**
	 * Get time interval of data entries as ISO string.
	 */
	public String getTimeIntervalISO(){
		return "";	
	}

	/** 
	 * Processing level of the data set.
	 * @uml.property name="processLevel"
	 */
	private String processLevel = new java.lang.String();

	/** 
	 * Getter of the property <tt>processLevel</tt>
	 * @return  Returns the processLevel.
	 * @uml.property  name="processLevel"
	 */
	public String getProcessLevel() {
        return processLevel;
    }

	/** 
	 * Setter of the property <tt>processLevel</tt>
	 * @param processLevel  The processLevel to set.
	 * @uml.property  name="processLevel"
	 */
	public void setProcessLevel(String processLevel) {
        this.processLevel = processLevel;
    }
	
	/**
	 * Identifier of the project within which the data is collected.
	 * @uml.property  name="projectID"
	 */
	private String projectID = new java.lang.String();

	/**
	 * Getter of the property <tt>projectID</tt>
	 * @return  Returns the projectID.
	 * @uml.property  name="projectID"
	 */
	public String getProjectID() {
        return projectID;
    }

	/**
	 * Setter of the property <tt>projectID</tt>
	 * @param projectID  The projectID to set.
	 * @uml.property  name="projectID"
	 */
	public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

	/** 
	 * Setter of the property <tt>timeZone</tt>
	 * @param timeZone  The timeZone to set.
	 * @uml.property  name="timeZone"
	 */
	public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
	
	/**
	 * Number of lines of the station data file header.
	 * @uml.property  name="headerExtension"
	 */
	private int headerExtension = 0;

	/**
	 * Getter of the property <tt>headerExtension</tt>
	 * @return  Returns the headerExtension.
	 * @uml.property  name="headerExtension"
	 */
	public int getHeaderExtension() {
        return headerExtension;
    }

	/**
	 * Setter of the property <tt>headerExtension</tt>
	 * @param headerExtension  The headerExtension to set.
	 * @uml.property  name="headerExtension"
	 */
	public void setHeaderExtension(int headerExtension) {
        this.headerExtension = headerExtension;
    }
	
	/** 
     * Number of the line which gives the column header information (only relevant for table-style files).
     * @uml.property name="headerLine"
     */
	private int headerLine = 0;

	/** 
     * Getter of the property <tt>headerLine</tt>
     * @return  Returns the headerLine.
     * @uml.property  name="headerLine"
     */
	public int getHeaderLine() {
        return headerLine;
    }

	/** 
     * Setter of the property <tt>headerLine</tt>
     * @param headerLine  The headerLine to set.
     * @uml.property  name="headerLine"
     */
	public void setHeaderLine(int headerLine) {
        this.headerLine = headerLine;
    }
	
	/**
	 * Number of the first line of data.
	 * @uml.property  name="firstDataLine"
	 */
	private int firstDataLine = 0;

	/**
	 * Getter of the property <tt>firstDataLine</tt>
	 * @return  Returns the firstDataLine.
	 * @uml.property  name="firstDataLine"
	 */
	public int getFirstDataLine() {
        return firstDataLine;
    }

	/**
	 * Setter of the property <tt>firstDataLine</tt>
	 * @param firstDataLine  The firstDataLine to set.
	 * @uml.property  name="firstDataLine"
	 */
	public void setFirstDataLine(int firstDataLine) {
        this.firstDataLine = firstDataLine;
    }
	
	/**
	 * Additional identifier of the process level which is derived from the file name conventions of some working groups at Marburg University.
	 * @uml.property  name="processLevelID"
	 */
	private String processLevelID = new java.lang.String();

	/**
	 * Getter of the property <tt>processLevelID</tt>
	 * @return  Returns the processLevelID.
	 * @uml.property  name="processLevelID"
	 */
	public String getProcessLevelID() {
        return processLevelID;
    }

	/**
	 * Setter of the property <tt>processLevelID</tt>
	 * @param processLevelID  The processLevelID to set.
	 * @uml.property  name="processLevelID"
	 */
	public void setProcessLevelID(String processLevelID) {
        this.processLevelID = processLevelID;
    }
	
	/** 
	 * Code for the temporal aggregation (i.e. the temporal resolution) of the data set which also indicates if the present temporal resolution is the original recording interval or if it is aggregated to a lower resolution afterwards.
	 * @uml.property name="aggregationLevel"
	 */
	private String aggregationLevel = new java.lang.String();

	/** 
	 * Getter of the property <tt>aggregationLevel</tt>
	 * @return  Returns the aggregationLevel.
	 * @uml.property  name="aggregationLevel"
	 */
	public String getAggregationLevel() {
        return aggregationLevel;
    }

	/** 
	 * Setter of the property <tt>aggregationLevel</tt>
	 * @param aggregationLevel  The aggregationLevel to set.
	 * @uml.property  name="aggregationLevel"
	 */
	public void setAggregationLevel(String aggregationLevel) {
        this.aggregationLevel = aggregationLevel;
    }
	
    /** 
     * @uml.property name="station"
     * @uml.associationEnd multiplicity="(1 1)" inverse="stationDataFile:jacky.util.stations.Station"
     */
    private Station station = new jacky.util.stations.Station();

    /** 
     * Getter of the property <tt>station</tt>
     * @return  Returns the station.
     * @uml.property  name="station"
     */
    public Station getStation() {
        return station;
    }

    /** 
     * Setter of the property <tt>station</tt>
     * @param station  The station to set.
     * @uml.property  name="station"
     */
    public void setStation(Station station) {
        this.station = station;
    }
    
    /**
     * Header of the station data file (i.e. the meaning of the columns).
     * @uml.property  name="header"
     */
    private String header = new java.lang.String();

    /**
     * Getter of the property <tt>header</tt>
     * @return  Returns the header.
     * @uml.property  name="header"
     */
    public String getHeader() {
        return header;
    }

    /**
     * Setter of the property <tt>header</tt>
     * @param header  The header to set.
     * @uml.property  name="header"
     */
    public void setHeader(String header) {
        this.header = header;
    }
        		
	/** 
     * Implements the respective method of the StationDataFilesToController interface. This method writes a station data set to a csv file following the level 0005 processing definitions of the research group.
     */
	public void writeLevel0005(){
	}

	
	/**
	 * Implements the respective method of the StationDataFilesToController interface. This method writes a station data set to a csv file following the level 0050 processing definitions of the research group.
	 */
	public void writeLevel0050(){
	}
     
	/**
     * Date/time of the first data entry in the station data file.
     * @uml.property  name="startDateTime"
     */
    private Calendar startDateTime = Calendar.getInstance();
        
    /**
     * Getter of the property <tt>startDateTime</tt>
     * @return  Returns the startDateTime.
     * @uml.property  name="startDateTime"
     */
    public Calendar getStartDateTime() {
        return startDateTime;
    }

    /**
     * Setter of the property <tt>startDateTime</tt>
     * @param startDateTime  The startDateTime to set.
     * @uml.property  name="startDateTime"
     */
    public void setStartDateTime(Calendar startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * Date and time of the last data entry in the station data file.
     * @uml.property  name="endDateTime"
     */
    private Calendar endDateTime = Calendar.getInstance();

    /**
     * Getter of the property <tt>endDateTime</tt>
     * @return  Returns the endDateTime.
     * @uml.property  name="endDateTime"
     */
    public Calendar getEndDateTime() {
        return endDateTime;
    }

    /**
     * Setter of the property <tt>endDateTime</tt>
     * @param endDateTime  The endDateTime to set.
     * @uml.property  name="endDateTime"
     */
    public void setEndDateTime(Calendar endDateTime) {
        this.endDateTime = endDateTime;
    }

}
