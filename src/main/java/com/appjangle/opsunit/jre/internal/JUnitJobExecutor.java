package com.appjangle.opsunit.jre.internal;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import com.appjangle.opsunit.Job;
import com.appjangle.opsunit.JobListener;
import com.appjangle.opsunit.Response;

public class JUnitJobExecutor implements Runnable {

	private final Job job;
	private final JobListener listener;

	@Override
	public void run() {
		runTests(job.getResponses());

	}

	private final void runTests(final List<Response> availableResponses) {
		for (final Class<?> test : job.getTests()) {
			listener.onStartTest(job, test);

			final Result result = JUnitCore.runClasses((Class<?>[]) job
					.getTests().toArray());

			if (result.getFailureCount() > 0) {
				listener.onTestFailed(job, test, result.getFailures().get(0)
						.getException());
				attemptFix(availableResponses);
				return;
			}

		}
	}

	private final void attemptFix(final List<Response> responses) {

	}

	public JUnitJobExecutor(final Job job, final JobListener listener) {
		super();
		this.job = job;
		this.listener = listener;
	}

}
