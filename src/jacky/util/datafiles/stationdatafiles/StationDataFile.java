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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import jacky.util.datafiles.DataFile;
import jacky.util.stations.Station;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/** 
 * This class provides general methods for station data files.
 *  
 * @version 0.1 2013-08-28
 * @author Thomas Nauss (tnauss)
 */
public abstract class StationDataFile extends DataFile implements StationDataFilesToController {

    /** 
     * Time zone of the date and time information.
     * @uml.property name="timeZone"
     */
    private TimeZone timeZone; ;

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
    private int timeInterval = 5;

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

    /** 
     * Entire header information of the station data file as defined by headerExtension.
     * @uml.property name="headerSection"
     */
    private List<String> headerSection = new ArrayList<String>();

    /** 
     * Getter of the property <tt>header</tt>
     * @return  Returns the header.
     * @uml.property  name="headerSection"
     */
    public List<String> getHeaderSection() {
        return headerSection;
    }

    /** 
     * Setter of the property <tt>header</tt>
     * @param header  The header to set.
     * @uml.property  name="headerSection"
     */
    public void setHeaderSection(List<String> headerSection) {
        this.headerSection = headerSection;
    }

    /**
     * Number of lines of the station data file header.
     * @uml.property  name="headerExtension"
     */
    private int headerExtension = 1;

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
     * Column header which defines the meaning of the data columns.
     * @uml.property name="dataSectionHeader"
     */
    private String[] dataSectionHeader = null;

    /** 
     * Getter of the property <tt>columnHeader</tt>
     * @return  Returns the columnHeader.
     * @throws IOException 
     * @uml.property  name="dataSectionHeader"
     */
    public String[] getDataSectionHeader() throws IOException {
        return dataSectionHeader;
    }

    /**
     * Number of the line which gives the column header information (only relevant for table-style files).
     * @uml.property  name="dataSectionHeaderLine"
     */
    private int dataSectionHeaderLine = 0;

    /** 
     * Getter of the property <tt>headerLine</tt>
     * @return  Returns the headerLine.
     * @uml.property  name="dataSectionHeaderLine"
     */
    public int getDataSectionHeaderLine() {
        return dataSectionHeaderLine;
    }

    /** 
     * Setter of the property <tt>headerLine</tt>
     * @param headerLine  The headerLine to set.
     * @uml.property  name="dataSectionHeaderLine"
     */
    public void setDataSectionHeaderLine(int dataSectionHeaderLine) {
        this.dataSectionHeaderLine = dataSectionHeaderLine;
    }

    /**
     * Read the content of the station data file (i.e. the column header and
     * the data lines).
     * @throws IOException 
     */
    public void readStationDataFileContent(String filepath)
            throws IOException{
        CSVReader csvReader = new CSVReader(
                new FileReader (filepath), this.delimiter,this.quoter,
                this.dataSectionHeaderLine);
	this.dataSectionHeader = csvReader.readNext();
	this.setDataSectionContent(csvReader.readAll());
        csvReader.close();
    }

    /**
     * Data section of the station data file (i.e. everything within dataSectionLines).
     * @uml.property  name="dataSectionContent"
     */
    private List<String[]> dataSectionContent = new java.util.ArrayList<String[]>();

    /** 
     * Getter of the property <tt>data</tt>
     * @return  Returns the data.
     * @uml.property  name="dataSectionContent"
     */
    public List<String[]> getDataSectionContent() {
        return dataSectionContent;
    }

    /** 
     * Setter of the property <tt>data</tt>
     * @param data  The data to set.
     * @uml.property  name="dataSectionContent"
     */
    public void setDataSectionContent(List<String[]> dataSectionContent) {
        this.dataSectionContent = dataSectionContent;
    }

    /** 
     * Setter of the property <tt>columnHeader</tt>
     * @param columnHeader  The columnHeader to set.
     * @uml.property  name="dataSectionHeader"
     */
    public void setDataSectionHeader(String[] dataSectionHeader) {
        this.dataSectionHeader = dataSectionHeader;
    }

    /**
     * Delimiter of the data columns in the station data file (csv format).
     * @uml.property  name="dataSectionContent"
     */
    private Character delimiter = ',';

    /** 
     * Getter of the property <tt>delimiter</tt>
     * @return  Returns the delimiter.
     * @uml.property  name="delimiter"
     */
    public Character getDelimiter() {
        return delimiter;
    }

    /** 
     * Setter of the property <tt>delimiter</tt>
     * @param data  The delimiter to set.
     * @uml.property  name="delimiter"
     */
    public void setDelimiter(Character delimiter) {
        this.delimiter = delimiter;
    }
    
    /**
     * Quoter of the data columns in the station data file (csv format).
     * @uml.property  name="quoter"
     */
    private Character quoter = '\'';

    /** 
     * Getter of the property <tt>quoter</tt>
     * @return  Returns the quoter.
     * @uml.property  name="quoter"
     */
    public Character getQuoter() {
        return quoter;
    }

    /** 
     * Setter of the property <tt>delimiter</tt>
     * @param data  The quoter to set.
     * @uml.property  name="quoter"
     */
    public void setQuoter(Character quoter) {
        this.quoter = quoter;
    }    
    
}
