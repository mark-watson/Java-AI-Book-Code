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

import java.awt.*;

import javax.swing.event.DocumentEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import javax.swing.text.Position.Bias;

/**
 * This View just forward all calls to the original view but also paints
 * the waved line if the Elements is marked as misspelled.
 * 
 * @author Robert Gustavsson (robert@lindesign.se)
 */
public class AutoSpellView extends View implements AutoSpellConstants{

	private View	view=null;
	private int[]	wavePoints=new int[10];
	
	public AutoSpellView(View view){
		super(view.getElement());
		this.view=view;
		for(int i=0;i<wavePoints.length;i++){
			wavePoints[i]=(int)Math.round(Math.cos(2*i*(2*Math.PI/wavePoints.length)));
		}
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.text.View#append(javax.swing.text.View)
	 */
	public void append(View arg0) {
		view.append(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#breakView(int, int, float, float)
	 */
	public View breakView(int arg0, int arg1, float arg2, float arg3) {
		return view.breakView(arg0, arg1, arg2, arg3);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#changedUpdate(javax.swing.event.DocumentEvent, java.awt.Shape, javax.swing.text.ViewFactory)
	 */
	public void changedUpdate(
		DocumentEvent arg0,
		Shape arg1,
		ViewFactory arg2) {
		view.changedUpdate(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#createFragment(int, int)
	 */
	public View createFragment(int arg0, int arg1) {
		return view.createFragment(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object arg0) {
		return view.equals(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getAlignment(int)
	 */
	public float getAlignment(int arg0) {
		return view.getAlignment(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getAttributes()
	 */
	public AttributeSet getAttributes() {
		return view.getAttributes();
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getBreakWeight(int, float, float)
	 */
	public int getBreakWeight(int arg0, float arg1, float arg2) {
		return view.getBreakWeight(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getChildAllocation(int, java.awt.Shape)
	 */
	public Shape getChildAllocation(int arg0, Shape arg1) {
		return view.getChildAllocation(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getContainer()
	 */
	public Container getContainer() {
		return view.getContainer();
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getDocument()
	 */
	public Document getDocument() {
		return view.getDocument();
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getElement()
	 */
	public Element getElement() {
		return view.getElement();
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getEndOffset()
	 */
	public int getEndOffset() {
		return view.getEndOffset();
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getGraphics()
	 */
	public Graphics getGraphics() {
		return view.getGraphics();
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getMaximumSpan(int)
	 */
	public float getMaximumSpan(int arg0) {
		return view.getMaximumSpan(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getMinimumSpan(int)
	 */
	public float getMinimumSpan(int arg0) {
		return view.getMinimumSpan(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getNextVisualPositionFrom(int, javax.swing.text.Position.Bias, java.awt.Shape, int, javax.swing.text.Position.Bias[])
	 */
	public int getNextVisualPositionFrom(
		int arg0,
		Bias arg1,
		Shape arg2,
		int arg3,
		Bias[] arg4)
		throws BadLocationException {
		return view.getNextVisualPositionFrom(arg0, arg1, arg2, arg3, arg4);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getParent()
	 */
	public View getParent() {
		return view.getParent();
	}

	/**
	 * @param arg0
	 * @return
	 */
	public float getPreferredSpan(int arg0) {
		return view.getPreferredSpan(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getResizeWeight(int)
	 */
	public int getResizeWeight(int arg0) {
		return view.getResizeWeight(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getStartOffset()
	 */
	public int getStartOffset() {
		return view.getStartOffset();
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getToolTipText(float, float, java.awt.Shape)
	 */
	public String getToolTipText(float arg0, float arg1, Shape arg2) {
		return view.getToolTipText(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getView(int)
	 */
	public View getView(int arg0) {
		return view.getView(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getViewCount()
	 */
	public int getViewCount() {
		return view.getViewCount();
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getViewFactory()
	 */
	public ViewFactory getViewFactory() {
		return view.getViewFactory();
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getViewIndex(float, float, java.awt.Shape)
	 */
	public int getViewIndex(float arg0, float arg1, Shape arg2) {
		return view.getViewIndex(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#getViewIndex(int, javax.swing.text.Position.Bias)
	 */
	public int getViewIndex(int arg0, Bias arg1) {
		return view.getViewIndex(arg0, arg1);
	}


	/* (non-Javadoc)
	 * @see javax.swing.text.View#insert(int, javax.swing.text.View)
	 */
	public void insert(int arg0, View arg1) {
		view.insert(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#insertUpdate(javax.swing.event.DocumentEvent, java.awt.Shape, javax.swing.text.ViewFactory)
	 */
	public void insertUpdate(DocumentEvent arg0, Shape arg1, ViewFactory arg2) {
		view.insertUpdate(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#isVisible()
	 */
	public boolean isVisible() {
		return view.isVisible();
	}

	/*public Shape modelToView(int arg0, Shape arg1)
		throws BadLocationException {
		return view.modelToView(arg0, arg1);
	}*/

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @return
	 * @throws javax.swing.text.BadLocationException
	 */
	public Shape modelToView(int arg0, Shape arg1, Bias arg2)
		throws BadLocationException {
		return view.modelToView(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#modelToView(int, javax.swing.text.Position.Bias, int, javax.swing.text.Position.Bias, java.awt.Shape)
	 */
	public Shape modelToView(int arg0, Bias arg1, int arg2, Bias arg3, Shape arg4)
		throws BadLocationException {
		return view.modelToView(arg0, arg1, arg2, arg3, arg4);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public void paint(Graphics arg0, Shape arg1) {
		Graphics	g=arg0;
		Rectangle	r;
		Color		c;
		view.paint(arg0, arg1);
		if(getAttributes().containsAttribute(wordMisspelled, wordMisspelledTrue)){
			r=arg1.getBounds();
			c=g.getColor();
			g.setColor(Color.red);
			for(int x=r.x;x<r.x+r.width;x++){
				g.drawLine(x,r.y+r.height-2-wavePoints[x%wavePoints.length],x,r.y+r.height-2-wavePoints[x%wavePoints.length]);
			}
			//g.setColor(c);
		}
			
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#preferenceChanged(javax.swing.text.View, boolean, boolean)
	 */
	public void preferenceChanged(View arg0, boolean arg1, boolean arg2) {
		view.preferenceChanged(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#remove(int)
	 */
	public void remove(int arg0) {
		view.remove(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#removeAll()
	 */
	public void removeAll() {
		view.removeAll();
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#removeUpdate(javax.swing.event.DocumentEvent, java.awt.Shape, javax.swing.text.ViewFactory)
	 */
	public void removeUpdate(
		DocumentEvent arg0,
		Shape arg1,
		ViewFactory arg2) {
		view.removeUpdate(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#replace(int, int, javax.swing.text.View[])
	 */
	public void replace(int arg0, int arg1, View[] arg2) {
		view.replace(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#setParent(javax.swing.text.View)
	 */
	public void setParent(View arg0) {
		view.setParent(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.View#setSize(float, float)
	 */
	public void setSize(float arg0, float arg1) {
		view.setSize(arg0, arg1);
	}

	/*public int viewToModel(float arg0, float arg1, Shape arg2) {
		return view.viewToModel(arg0, arg1, arg2);
	}*/

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @return
	 */
	public int viewToModel(float arg0, float arg1, Shape arg2, Bias[] arg3) {
		return view.viewToModel(arg0, arg1, arg2, arg3);
	}

}
