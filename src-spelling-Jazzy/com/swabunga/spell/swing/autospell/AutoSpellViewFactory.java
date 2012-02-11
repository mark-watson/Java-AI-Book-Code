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
/*
 * Created on 2004-apr-23
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.swabunga.spell.swing.autospell;

import javax.swing.text.Element;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

/**
 * Gets the views from the original ViewFactory and but all of them in a
 * AutoSpellView to support the waved line style. (Maybe this should only
 * be done for elements actually marked as misspelled, maybe...)
 * 
 * @author Robert Gustavsson (robert@lindesign.se)
 */
public class AutoSpellViewFactory implements ViewFactory{

	private ViewFactory	viewFactory=null;
	
	public AutoSpellViewFactory(ViewFactory wf){
		viewFactory=wf;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.text.ViewFactory#create(javax.swing.text.Element)
	 */
	public View create(Element arg0) {
		View view=viewFactory.create(arg0);
		return new AutoSpellView(view);
	}
}
