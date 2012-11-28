package com.appjangle.opsunit;

/**
 * Listener to handle important events, which might occur during running jobs.
 * 
 * @author Max
 * 
 */
public interface JobListener {

	/**
	 * Whenever an unexpected failure occurs.
	 * 
	 * @param j
	 *            Job, for which failure occurred.
	 * @param t
	 *            The exception reported for the failure.
	 */
	public void onUnexpectedFailure(Job j, Throwable t);

}
