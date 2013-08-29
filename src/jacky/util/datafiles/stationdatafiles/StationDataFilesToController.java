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

package jacky.util.datafiles.stationdatafiles;

/** 
 * @author tnauss
 */
public interface StationDataFilesToController {

    	
    	
    	/** 
         * Write a station data set to a csv file following the level 0005 processing definitions of the research group.
         */
    	public abstract void writeLevel0005();
    	

    	
    	/** 
         * Write a station data set to a csv file following the level 0050 processing definitions of the research group.
         */
    	public abstract void writeLevel0050();
    	

    /** 
     * This method ensures that unique and meaningfull column headers are assigned to the station data files. This is necessary since some logger data file headers can not be user defined and are also ambiguous. Hence, they have to be converted to the standards of the research group.
     */
    public abstract void setStandardHeader();
                	
    	
    	/** 
         * Calibrate those data set parameters which have no physical meaning in the sense of environmental sciences (e. g. convert voltage to soil moisture).
         */
    	public abstract void calibrateData();
    	
                	
}
