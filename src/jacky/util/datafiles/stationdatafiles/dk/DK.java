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

import jacky.util.datafiles.stationdatafiles.StationDataFile;
import jacky.util.datafiles.stationdatafiles.StationDataFilesToController;


/** 
 * This class provides more specific methods for station data files collected using loggers from Driesen and Kern.
 */
public abstract class DK extends StationDataFile implements StationDataFilesToController {

    /** 
         * Implements the respective method of the StationDataFilesToController interface. This method ensures that unique and meaningfull column headers are assigned to the station data files. This is necessary since some logger data file headers can not be user defined and are also ambiguous. Hence, they have to be converted to the standards of the research group.
         */
    	public void setStandardHeader(){
    	}


        /**
         * Original header information of the station data file (i.e. the meaning of the columns). The individual header variables will be replaced by standardized variable names.
         * @uml.property  name="orgColumnHeader"
         */
        private String orgColumnHeader = new java.lang.String();

        /** 
         * Getter of the property <tt>orgHeader</tt>
         * @return  Returns the orgHeader.
         * @uml.property  name="orgColumnHeader"
         */
        public String getOrgColumnHeader() {
            return orgColumnHeader;
        }

        /** 
         * Setter of the property <tt>orgHeader</tt>
         * @param orgHeader  The orgHeader to set.
         * @uml.property  name="orgColumnHeader"
         */
        public void setOrgColumnHeader(String orgColumnHeader) {
            this.orgColumnHeader = orgColumnHeader;
        }
   
}
