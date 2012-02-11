/*

  Java API for WordNet Searching 1.0
  Copyright (c) 2007 by Brett Spell.

  This software is being provided to you, the LICENSEE, by under the following
  license.  By obtaining, using and/or copying this software, you agree that
  you have read, understood, and will comply with these terms and conditions:
   
  Permission to use, copy, modify and distribute this software and its
  documentation for any purpose and without fee or royalty is hereby granted,
  provided that you agree to comply with the following copyright notice and
  statements, including the disclaimer, and that the same appear on ALL copies
  of the software, database and documentation, including modifications that you
  make for internal use or for distribution.

  THIS SOFTWARE AND DATABASE IS PROVIDED "AS IS" WITHOUT REPRESENTATIONS OR
  WARRANTIES, EXPRESS OR IMPLIED.  BY WAY OF EXAMPLE, BUT NOT LIMITATION,  
  LICENSOR MAKES NO REPRESENTATIONS OR WARRANTIES OF MERCHANTABILITY OR FITNESS
  FOR ANY PARTICULAR PURPOSE OR THAT THE USE OF THE LICENSED SOFTWARE OR
  DOCUMENTATION WILL NOT INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS,
  TRADEMARKS OR OTHER RIGHTS.

 */
package edu.smu.tspell.wordnet.impl.file;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implements a least-recently-used (LRU) cache. In other words, it caches up
 * to some maximum number of entries and when that number has been reached
 * and a request is made to cache a new entry, the entry that was added or
 * referenced the longest time ago will be dropped.
 * <br><p>
 * This cache ensures that each data key is associated with a unique time
 * value even if the system clock returns the identical time on two successive
 * calls. That can happen when the two calls occur within one millisecond of
 * each other or may simply be a result of the system clock not providing
 * accurate resolution.
 * 
 * @author Brett Spell
 */
public class LeastRecentlyUsedCache {

	/**
	 * The maximum number of entries that are allowed to be cached.
	 */
	private int maximumEntries;

	/**
	 * The cached data. 
	 */
	private Map data;

	/**
	 * Time at which each key was most recently accessed. For each entry in
	 * this map the key corresponds to a key in the data map and the
	 * corresponding value is a timestamp that indicates when that key was
	 * last used to access (store or retrieve) data using the key.
	 * <br><p>
	 * This map is used to look up the time that a key was last referenced.
	 * 
	 * @see #timeKeys
	 */
	private Map keyTimes;

	/**
	 * Time at which each key was most recently accessed. For each entry in
	 * this map the key corresponds to a timestamp indicating when a key was
	 * last used to access (store or retrieve) data using the key and the
	 * corresponding value is the actual key that's used in the data map.
	 * <br><p>
	 * This map is used to determine which cache entry should be removed
	 * (when necessary) by keeping the times in sorted order and by being
	 * able to determine which data map entry was the one that's the least
	 * recently used.
	 * 
	 * @see #timeKeys
	 */
	private TreeMap timeKeys;

	/**
	 * The last time a map entry was accessed.
	 */
	private long lastTime = 0;

	/**
	 * Constructor that accepts a count indicating the maximum number of
	 * entries that should be cached.
	 */
	public LeastRecentlyUsedCache(int maximumEntries)
	{
		this.maximumEntries = maximumEntries;
		data = new HashMap(maximumEntries);
		keyTimes = new HashMap(maximumEntries);
		timeKeys = new TreeMap();
	}

	/**
	 * Adds an entry to the cache or mark it as referenced if it's already in
	 * the cache.
	 * 
	 * @param  key Key of the entry to store in the cache.
	 * @param  value Value for the entry to store in the cache.
	 */
	public synchronized void put(Object key, Object value)
	{
		//  Do we cache anything at all? If not, don't do anything now
		if (maximumEntries > 0)
		{
			//  Get the last time the key was stored or retrieved
			Object keyTime = keyTimes.get(key);
			//  If no entry exists we should add the pair to the cache
			if (keyTime == null)
			{
				//  Will we need to drop the least recently used entry?
				if (data.size() >= maximumEntries)
				{
					//  Get the longest time ago an entry was referenced
					Object timeKey = timeKeys.firstKey();
					//  Remove entry from time/key map and get its key
					Object dataKey = timeKeys.remove(timeKey);
					//  Remove entry from the key/time map
					keyTimes.remove(dataKey);
					//  Remove entry from the data map
					data.remove(dataKey);
				}
				//  Store the new key / value pair in the data map
				data.put(key, value);
			}
			//  Entry was already cached; remove its old time entry
			else
			{
				key = timeKeys.remove(keyTime);
			}
			//  Get a new / updated time for this pair
			keyTime = getUniqueTimeKey();
			//  Create the time/key map entry
			timeKeys.put(keyTime, key);
			//  Create the key/time entry or update old one with new time
			keyTimes.put(key, keyTime);
		}
	}

	/**
	 * Retrieves the value associated with a key, marking the entry as
	 * having been referenced if it existed in the map.
	 * 
	 * @param  key Key for which to return the value.
	 * @return Value associated with the specified key.
	 */
	public synchronized Object get(Object key)
	{
		//  Get a value for the key (if there is one)
		Object value = data.get(key);
		//  If an entry exists for the key, mark it as referenced
		if ((value != null) || (data.containsKey(key)))
		{
			markReferenced(key);
		}
		return value;
	}

	/**
	 * Markes an entry as referenced by updating the time associated with the
	 * entry.
	 * 
	 * @param  key Key to mark as referenced.
	 */
	private void markReferenced(Object key)
	{
		//  Get the previous time it was referenced
		Object keyTime = keyTimes.get(key);
		//  Remove the old time/key entry
		key = timeKeys.remove(keyTime);
		//  Get a new time value for the pair
		Object newTime = getUniqueTimeKey();
		//  Record the updated time for this entry
		timeKeys.put(newTime, key);
		//  Map the key to its updated time
		keyTimes.put(key, newTime);
	}

	/**
	 * Returns a unique key value based upon the system clock. This is done
	 * by storing the last value returned and ensuring that the next time one
	 * is returned that it's different from the previous value. If it isn't,
	 * the new timestamp becomes the previous value incremented by one.
	 * 
	 * @return Unique key value each time this method is called. 
	 */
	private Object getUniqueTimeKey()
	{
		//  Get the current time
		long time = System.currentTimeMillis();
		//  This can happen if the method is called many times very quickly
		if (time <= lastTime)
		{
			//  Make sure we get a value that's really unique
			time = lastTime + 1;
		}
		//  Remember the largest key value we've returned
		lastTime = time;
		return new Long(time);
	}

}