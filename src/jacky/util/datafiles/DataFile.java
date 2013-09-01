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

package jacky.util.datafiles;

/** 
 * This class provides basic meta information for data files.
 *  
 * @version 0.1 2013-08-31
 * @author Thomas Nauss (tnauss)
 */
public abstract class DataFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** 
	 * File name of the data file.
	 * @uml.property name="filename"
	 */
	private String filename = new java.lang.String();

	/** 
	 * Getter of the property <tt>filename</tt>
	 * @return  Returns the filename.
	 * @uml.property  name="filename"
	 */
	public String getFilename() {
        return filename;
    }

	/** 
	 * Setter of the property <tt>filename</tt>
	 * @param filename  The filename to set.
	 * @uml.property  name="filename"
	 */
	public void setFilename(String filename) {
        this.filename = filename;
    }

	/** 
	 * Full path and name of the data file.
	 * @uml.property name="filepath"
	 */
	private String filepath = new java.lang.String();

	/** 
	 * Getter of the property <tt>filepath</tt>
	 * @return  Returns the filepath.
	 * @uml.property  name="filepath"
	 */
	public String getFilepath() {
        return filepath;
    }

	/** 
	 * Setter of the property <tt>filepath</tt>
	 * @param filepath  The filepath to set.
	 * @uml.property  name="filepath"
	 */
	public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

	/** 
	 * Extension of the data file.
	 * @uml.property name="extension"
	 */
	private String extension = new java.lang.String();

	/** 
	 * Getter of the property <tt>extension</tt>
	 * @return  Returns the extension.
	 * @uml.property  name="extension"
	 */
	public String getExtension() {
        return extension;
    }

	/** 
	 * Setter of the property <tt>extension</tt>
	 * @param extension  The extension to set.
	 * @uml.property  name="extension"
	 */
	public void setExtension(String extension) {
        this.extension = extension;
    }

	/** 
	 * Path of the data file.
	 * @uml.property name="path"
	 */
	private String path = new java.lang.String();

	/** 
	 * Getter of the property <tt>path</tt>
	 * @return  Returns the path.
	 * @uml.property  name="path"
	 */
	public String getPath() {
        return path;
    }

	/** 
	 * Setter of the property <tt>path</tt>
	 * @param path  The path to set.
	 * @uml.property  name="path"
	 */
	public void setPath(String path) {
        this.path = path;
    }

	/**
	 * Post-extension of the file which follows the actual file extension (e. g. *.txt.processed).
	 * @uml.property  name="postExtension"
	 */
	private String postExtension = new java.lang.String();

	/**
	 * Getter of the property <tt>postExtension</tt>
	 * @return  Returns the postExtension.
	 * @uml.property  name="postExtension"
	 */
	public String getPostExtension() {
        return postExtension;
    }

	/**
	 * Setter of the property <tt>postExtension</tt>
	 * @param postExtension  The postExtension to set.
	 * @uml.property  name="postExtension"
	 */
	public void setPostExtension(String postExtension) {
        this.postExtension = postExtension;
    }

	/**
	 * Type of the data file.
	 * @uml.property  name="filetype"
	 */
	private String filetype = new java.lang.String();

	/**
	 * Getter of the property <tt>filetype</tt>
	 * @return  Returns the filetype.
	 * @uml.property  name="filetype"
	 */
	public String getFiletype() {
        return filetype;
    }

	/**
	 * Setter of the property <tt>filetype</tt>
	 * @param filetype  The filetype to set.
	 * @uml.property  name="filetype"
	 */
	public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

}
