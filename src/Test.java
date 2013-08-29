import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

/**
 * @author tnauss
 *
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
        
        /* Nacheinander alle Dateien in einem Verzeichnisbaum abarbeiten */
        
        for Datei in Verzeichnis do
        
            
            /* 1. Header Standardisieren */
            meineDatei.Standard();
            /* 2. Stationsdatensatz im DB-Format ausschreiben */
            meineDatei.Ausschreiben();
        
        
    }

}
