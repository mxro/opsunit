package com.appjangle.opsunit;

import java.util.List;

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

	/**
	 * An arbitrary name for this job.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Unit tests to be performed for this job.
	 * 
	 * @return
	 */
	public List<Class<?>> getTests();

	/**
	 * Possible responses in case of a failure. Ordered from lowest to highest
	 * escalation level.
	 * 
	 * @return
	 */
	public List<Response> getResponses();

}
