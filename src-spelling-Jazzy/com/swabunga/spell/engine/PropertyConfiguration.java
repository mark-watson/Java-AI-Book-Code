/*
Jazzy - a Java library for Spell Checking
Copyright (C) 2001 Mindaugas Idzelis
Full text of license can be found in LICENSE.txt

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
*/
package com.swabunga.spell.engine;

import java.io.*;
import java.net.URL;
import java.util.Properties;


/**
 * Implementation class to read the properties controlling the spell engine. 
 * The properties are read form the <code>configuration.properties</code> file.
 *
 * @author aim4min
 */
public class PropertyConfiguration extends Configuration {

  /**
   * The persistent set of properties supported by the spell engine
   */
  public Properties prop;
  /**
   * The name of the file containing spell engine properties
   */
  public URL filename;

  /**
   * Constructs and loads spell engine properties configuration.
   */
  public PropertyConfiguration() {
    prop = new Properties();
    try {
      filename = getClass().getClassLoader().getResource("com/swabunga/spell/engine/configuration.properties");
      InputStream in = filename.openStream();
      prop.load(in);
    } catch (Exception e) {
      System.out.println("Could not load Properties file :\n" + e);
    }
  }

  /**
   * @see com.swabunga.spell.engine.Configuration#getBoolean(String)
   */
  public boolean getBoolean(String key) {
    return new Boolean(prop.getProperty(key)).booleanValue();
  }

  /**
   * @see com.swabunga.spell.engine.Configuration#getInteger(String)
   */
  public int getInteger(String key) {
    return new Integer(prop.getProperty(key)).intValue();
  }

  /**
   * @see com.swabunga.spell.engine.Configuration#setBoolean(String, boolean)
   */
  public void setBoolean(String key, boolean value) {
    String string = null;
    if (value)
      string = "true";
    else
      string = "false";

    prop.setProperty(key, string);
    save();
  }

  /**
   * @see com.swabunga.spell.engine.Configuration#setInteger(String, int)
   */
  public void setInteger(String key, int value) {
    prop.setProperty(key, Integer.toString(value));
    save();
  }

  /**
   * Writes the property list (key and element pairs) in the 
   * PropertyConfiguration file.
   */
  public void save() {
    try {
      File file = new File(filename.getFile());
      FileOutputStream fout = new FileOutputStream(file);
      prop.store(fout, "HEADER");
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    }
  }

}
