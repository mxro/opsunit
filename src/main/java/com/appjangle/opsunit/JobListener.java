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

	/**
	 * Called right before a test is started.
	 * 
	 * @param j
	 *            The job the test is embedded in
	 * @param test
	 */
	public void onStartTest(Job j, Class<?> test);

	public void onTestFailed(Job j, Class<?> test, Throwable t);

}
