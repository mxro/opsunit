package com.appjangle.opsunit.listener;

import com.appjangle.opsunit.Job;
import com.appjangle.opsunit.JobListener;
import com.appjangle.opsunit.Response;

public class DefaultJobListener implements JobListener {

	@Override
	public void onJobFailed(final Job j) {
		throw new RuntimeException("Job failed: " + j.getName());
	}

	@Override
	public void onUnexpectedFailure(final Job j, final Throwable t) {
		throw new RuntimeException("Unexpected failure: " + j.getName(), t);
	}

	@Override
	public void onResponseFailed(final Job j, final Response r,
			final Throwable t) {
		throw new RuntimeException("Response failed: " + j.getName()
				+ " Resonse: " + r, t);
	}

	@Override
	public void onStartJob(final Job j) {

	}

	@Override
	public void onJobSuccessfullyCompleted(final Job j) {

	}

	@Override
	public void onStartTest(final Job j, final Class<?> test) {

	}

	@Override
	public void onTestFailed(final Job j, final Class<?> test,
			final String message, final Throwable t) {
		throw new RuntimeException("Test failed: " + j.getName() + " Test: "
				+ test, t);
	}

}
