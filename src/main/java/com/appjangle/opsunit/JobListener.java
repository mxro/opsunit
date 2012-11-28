package com.appjangle.opsunit;

/**
 * Listener to handle important events, which might occur during running jobs.
 * 
 * @author Max
 * 
 */
public interface JobListener {

	/**
	 * Called when a job's test cases fail and none of the responses were able
	 * to fix it.
	 * 
	 * @param j
	 */
	public void onJobFailed(final Job j);

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
	 * When a reponse could not be executed.
	 * 
	 * @param j
	 * @param r
	 * @param t
	 */
	public void onResponseFailed(Job j, Response r, Throwable t);

	/**
	 * Called whenever execution for a job is started.
	 * 
	 * @param j
	 */
	public void onStartJob(final Job j);

	/**
	 * Called when a job has been successfully completed.
	 * 
	 * @param j
	 */
	public void onJobSuccessfullyCompleted(final Job j);

	/**
	 * Called right before a test is started.
	 * 
	 * @param j
	 *            The job the test is embedded in
	 * @param test
	 */
	public void onStartTest(Job j, Class<?> test);

	/**
	 * Called whenever a test fails.
	 * 
	 * @param j
	 * @param test
	 * @param message
	 * @param t
	 */
	public void onTestFailed(Job j, Class<?> test, String message, Throwable t);

}
