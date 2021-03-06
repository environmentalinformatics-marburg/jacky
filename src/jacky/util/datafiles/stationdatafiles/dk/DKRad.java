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

package jacky.util.datafiles.stationdatafiles.dk;

import jacky.util.datafiles.stationdatafiles.StationDataFilesToController;

/**
 * 
 *  
 * @version 0.1 2013-08-28
 * @author Thomas Nauss (tnauss)
 */
public class DKRad extends DK implements StationDataFilesToController {

    	
    	/** 
         * Implements the respective method of the StationDataFilesToController interface. This method calibrates those data set parameters which have no physical meaning in the sense of environmental sciences (e. g. convert voltage to soil moisture).
         */
    	public void calibrateData(){
    	
    	        // TODO Auto-generated method stub
    	
    	     }

        	
        	/**
        	 * This class represents a Driesen and Kern RAD logger with two voltage inputs which can (but do not have to be) attached to radiation sensors.
        	 */
        	public DKRad(){
        	}

}
