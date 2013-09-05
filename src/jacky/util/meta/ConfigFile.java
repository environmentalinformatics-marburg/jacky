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

package jacky.util.meta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/** 
 * This class provides configuration settings for the station, logger and time
 * step from a config file.
 * @version 0.1 2013-08-28
 * @author tnauss
 */
public class ConfigFile {
    /** 
     * Instance of the class {@link ConfigFile}.
     * @uml.property name="instance"
     */
    private static ConfigFile instance=null;
    
    /** 
     * Instance of the class {@link Properties}.
     * @uml.property name="properties"
     */
    private Properties properties;

    /**
     * Constructor
     */
    private ConfigFile(String filepath)
    {
        properties=new Properties();
        File input=new File(filepath);
        if (input.isFile()) {
            try {
                properties.load(new FileInputStream(input));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

/** 
 * Getter of the property <tt>instance</tt>
 * @return  Returns the instance.
 * @uml.property  name="getInstance"
 */
    public static ConfigFile getInstance(String filepath)
    {
        if (instance==null) {
            instance=new ConfigFile(filepath);
        }
    return instance;
    }

/** 
 * Clone the Instance 
 * @return  Returns the class {@link ConfigFile} instance.
 * @uml.property  name="clone"
 */
    public ConfigFile clone()
    {
        return ConfigFile.getInstance(null);
    }
    
/** 
 * Return value from config file by given key
     * @param key from the property
     * @param defaultValue if key not found
 * @return  Returns String from the property value if exist, else the default value
 * @uml.property  name="clone"
 * */
    public String get(String key,String defaultValue)
    {
        return properties.getProperty(key, defaultValue);
    }

/** 
 * Getter of the property value
     * @param key from the property
 * @return  Returns String from the property value.
 * @uml.property  name="getValueByKey"
 * */
    public String get(String key)
    {
        return get(key,null);
    }

}