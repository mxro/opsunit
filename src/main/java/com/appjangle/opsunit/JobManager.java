package com.appjangle.opsunit;

import one.utils.server.ShutdownCallback;

public interface JobManager {

	/**
	 * Start running the jobs configured for this manager in their respective
	 * intervals.
	 * 
	 * @param jobs
	 */
	public void start();

	/**
	 * Stop executing test jobs.
	 * 
	 * @param callback
	 *            Callback that will be called when all tests are stopped
	 */
	public void stop(ShutdownCallback callback);

}
