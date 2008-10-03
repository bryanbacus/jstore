/**
 * 
 */
package com.shenming.sms.util;

import java.util.Locale;
import java.util.TimeZone;

/**
 * @author justin
 *
 */
public class AlCalendar extends java.util.Calendar {

	/**
	 * 
	 */
	public AlCalendar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param zone
	 * @param aLocale
	 */
	public AlCalendar(TimeZone zone, Locale aLocale) {
		super(zone, aLocale);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.util.Calendar#computeTime()
	 */
	@Override
	protected void computeTime() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.Calendar#computeFields()
	 */
	@Override
	protected void computeFields() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.Calendar#add(int, int)
	 */
	@Override
	public void add(int field, int amount) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.Calendar#roll(int, boolean)
	 */
	@Override
	public void roll(int field, boolean up) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.util.Calendar#getMinimum(int)
	 */
	@Override
	public int getMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.util.Calendar#getMaximum(int)
	 */
	@Override
	public int getMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.util.Calendar#getGreatestMinimum(int)
	 */
	@Override
	public int getGreatestMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.util.Calendar#getLeastMaximum(int)
	 */
	@Override
	public int getLeastMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

}
