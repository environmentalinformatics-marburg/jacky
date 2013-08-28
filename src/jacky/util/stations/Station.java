/* jacky: Utilities for climate station data sets.

Copyright (C) 2013-2013 Thomas Nauss, Spaska Forteva
                        Environmental Informatics
                        University of Marburg
                        Germany

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

Please send any comments, suggestions, criticism, or (for our sake) bug
reports to nausst@googlemail.com

    http://environmentalinformatics-marburg.de
 */

package jacky.util.stations;

import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;


/**
 */
public class Station {

	public Station() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Identifier of the station (coded).
	 * @uml.property  name="stationID"
	 */
	private String stationID = new java.lang.String();

	/**
	 * Getter of the property <tt>stationID</tt>
	 * @return  Returns the stationID.
	 * @uml.property  name="stationID"
	 */
	public String getStationID() {
		return stationID;
	}

	/**
	 * Setter of the property <tt>stationID</tt>
	 * @param stationID  The stationID to set.
	 * @uml.property  name="stationID"
	 */
	public void setStationID(String stationID) {
		this.stationID = stationID;
	}
	/**
	 * Date/time where the station/primary logger/sensor has been installed.
	 * @uml.property   name="installationDateTime"
	 */
	private Calendar installationDateTime = new java.util.Calendar();

	/** 
	 * Getter of the property <tt>installationDateTime</tt>
	 * @return  Returns the installationDateTime.
	 * @uml.property  name="installationDateTime"
	 */
	public Calendar getInstallationDateTime() {
		return installationDateTime;
	}

	/** 
	 * Setter of the property <tt>installationDateTime</tt>
	 * @param installationDateTime  The installationDateTime to set.
	 * @uml.property  name="installationDateTime"
	 */
	public void setInstallationDateTime(Calendar installationDateTime) {
		this.installationDateTime = installationDateTime;
	}

	/**
	 * Date/time where the station/primary logger has been uninstalled. If the station is still running, the date will be in the future.
	 * @uml.property   name="uninstallationDateTime"
	 */
	private Calendar uninstallationDateTime = new java.util.Calendar();

	/** 
	 * Getter of the property <tt>uninstallationDateTime</tt>
	 * @return  Returns the uninstallationDateTime.
	 * @uml.property  name="uninstallationDateTime"
	 */
	public Calendar getUninstallationDateTime() {
		return uninstallationDateTime;
	}

	/** 
	 * Setter of the property <tt>uninstallationDateTime</tt>
	 * @param uninstallationDateTime  The uninstallationDateTime to set.
	 * @uml.property  name="uninstallationDateTime"
	 */
	public void setUninstallationDateTime(Calendar uninstallationDateTime) {
		this.uninstallationDateTime = uninstallationDateTime;
	}

	/**
	 * Identifier of the location (plot) where the station is installed/the data has been collected.
	 * @uml.property  name="plotID"
	 */
	private String plotID = new java.lang.String();

	/**
	 * Getter of the property <tt>plotID</tt>
	 * @return  Returns the plotID.
	 * @uml.property  name="plotID"
	 */
	public String getPlotID() {
		return plotID;
	}

	/**
	 * Setter of the property <tt>plotID</tt>
	 * @param plotID  The plotID to set.
	 * @uml.property  name="plotID"
	 */
	public void setPlotID(String plotID) {
		this.plotID = plotID;
	}

	/**
	 * @uml.property   name="stationSensor"
	 * @uml.associationEnd   multiplicity="(1 -1)" inverse="station:jacky.util.stations.Sensor"
	 */
	private Collection stationSensor;

	/**
	 * Getter of the property <tt>stationSensor</tt>
	 * @return  Returns the stationSensor.
	 * @uml.property  name="stationSensor"
	 */
	public Collection getStationSensor() {
		return stationSensor;
	}

	/**
	 * Returns an iterator over the elements in this collection. 
	 * @return  an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property  name="stationSensor"
	 */
	public Iterator stationSensorIterator() {
		return stationSensor.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * @return  <tt>true</tt> if this collection contains no elements
	 * @see java.util.Collection#isEmpty()
	 * @uml.property  name="stationSensor"
	 */
	public boolean isStationSensorEmpty() {
		return stationSensor.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. 
	 * @param element  whose presence in this collection is to be tested.
	 * @see java.util.Collection#contains(Object)
	 * @uml.property  name="stationSensor"
	 */
	public boolean containsStationSensor(Sensor stationSensor) {
		return this.stationSensor.contains(stationSensor);
	}

	/**
	 * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
	 * @param elements  collection to be checked for containment in this collection.
	 * @see java.util.Collection#containsAll(Collection)
	 * @uml.property  name="stationSensor"
	 */
	public boolean containsAllStationSensor(Collection stationSensor) {
		return this.stationSensor.containsAll(stationSensor);
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return  the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property  name="stationSensor"
	 */
	public int stationSensorSize() {
		return stationSensor.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property  name="stationSensor"
	 */
	public Sensor[] stationSensorToArray() {
		return (Sensor[]) stationSensor.toArray(new Sensor[stationSensor.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this collection;  the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this collection are to be stored.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray(Object[])
	 * @uml.property  name="stationSensor"
	 */
	public Sensor[] stationSensorToArray(Sensor[] stationSensor) {
		return (Sensor[]) this.stationSensor.toArray(stationSensor);
	}

	/**
	 * Ensures that this collection contains the specified element (optional operation). 
	 * @param element  whose presence in this collection is to be ensured.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="stationSensor"
	 */
	public boolean addStationSensor(Sensor stationSensor) {
		return this.stationSensor.add(stationSensor);
	}

	/**
	 * Setter of the property <tt>stationSensor</tt>
	 * @param stationSensor  the stationSensor to set.
	 * @uml.property  name="stationSensor"
	 */
	public void setStationSensor(Collection stationSensor) {
		this.stationSensor = stationSensor;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation).
	 * @param element  to be removed from this collection, if present.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="stationSensor"
	 */
	public boolean removeStationSensor(Sensor stationSensor) {
		return this.stationSensor.remove(stationSensor);
	}

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * @see java.util.Collection#clear()
	 * @uml.property  name="stationSensor"
	 */
	public void clearStationSensor() {
		this.stationSensor.clear();
	}

	/**
	 * Serial number of the station. This is generally the serial number of the primariy data logger.
	 * @uml.property  name="serialNumber"
	 */
	private String serialNumber = new java.lang.String();

	/** 
	 * Getter of the property <tt>stationSerialNumber</tt>
	 * @return  Returns the stationSerialNumber.
	 * @uml.property  name="serialNumber"
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/** 
	 * Setter of the property <tt>stationSerialNumber</tt>
	 * @param stationSerialNumber  The stationSerialNumber to set.
	 * @uml.property  name="serialNumber"
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}