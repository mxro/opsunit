package com.appjangle.opsunit.internal;

import com.appjangle.opsunit.Job;

public class JobExecutor implements Runnable {

	private final Job job;

	@Override
	public void run() {

	}

	public JobExecutor(final Job job) {
		super();
		this.job = job;
	}

}
