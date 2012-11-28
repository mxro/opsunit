package com.appjangle.opsunit.jre.internal;

import com.appjangle.opsunit.Job;
import com.appjangle.opsunit.JobListener;

public class JUnitJobExecutor implements Runnable {

	private final Job job;
	private final JobListener listener;

	@Override
	public void run() {

	}

	public JUnitJobExecutor(final Job job, final JobListener listener) {
		super();
		this.job = job;
		this.listener = listener;
	}

}
