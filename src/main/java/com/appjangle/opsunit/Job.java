package com.appjangle.opsunit;

/**
 * Defines a job to be run periodically.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 * 
 */
public interface Job {

	/**
	 * Frequency for job execution in ms.
	 * 
	 * @return
	 */
	public int getFrequency();

}
