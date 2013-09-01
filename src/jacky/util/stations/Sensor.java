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

package jacky.util.stations;

import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @version 0.1 2013-08-28
 * @author Thomas Nauss (tnauss)
 */
public class Sensor {


	
		
    		
        		
            	/** 
                 * This class represents an environmental monitoring sensor which is generally attached to a station.
                 */
            	public Sensor(){
            	
            	        	
            	        	    	
            	        	    			// TODO Auto-generated constructor stub
            	        	    		   }

	/** 
	 * Calibration coefficient(s) of the sensor.
	 * @uml.property name="calibrationCoefficients"
	 */
	private List<Float> calibrationCoefficients = new ArrayList<Float>();

	/** 
	 * Getter of the property <tt>calibrationCoefficients</tt>
	 * @return  Returns the calibrationCoefficients.
	 * @uml.property  name="calibrationCoefficients"
	 */
	public List getCalibrationCoefficients() {
        return calibrationCoefficients;
    }

	/** 
	 * Setter of the property <tt>calibrationCoefficients</tt>
	 * @param calibrationCoefficients  The calibrationCoefficients to set.
	 * @uml.property  name="calibrationCoefficients"
	 */
	public void setCalibrationCoefficients(List calibrationCoefficients) {
        this.calibrationCoefficients = calibrationCoefficients;
    }

	/**
	 * Serial number of the sensor.
	 * @uml.property  name="serialNumber"
	 */
	private String serialNumber = new java.lang.String();

	/**
	 * Getter of the property <tt>serialNumber</tt>
	 * @return  Returns the serialNumber.
	 * @uml.property  name="serialNumber"
	 */
	public String getSerialNumber() {
        return serialNumber;
    }

	/**
	 * Setter of the property <tt>serialNumber</tt>
	 * @param serialNumber  The serialNumber to set.
	 * @uml.property  name="serialNumber"
	 */
	public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
