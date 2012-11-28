package com.appjangle.opsunit.internal;

import java.util.List;

import one.utils.jre.concurrent.JreConcurrency;
import one.utils.server.ShutdownCallback;

import com.appjangle.opsunit.Job;
import com.appjangle.opsunit.JobManager;

public class DefaultJobManager implements JobManager {

	private final List<Job> jobs;
	private final JreConcurrency concurrency;

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop(final ShutdownCallback callback) {
		// TODO Auto-generated method stub

	}

	public DefaultJobManager(final List<Job> jobs,
			final JreConcurrency concurrency) {
		super();
		this.jobs = jobs;
		this.concurrency = concurrency;
	}

}
