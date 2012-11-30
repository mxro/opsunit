package com.appjangle.opsunit.internal;

import java.util.LinkedList;
import java.util.List;

import one.utils.concurrent.Concurrency;
import one.utils.concurrent.OneTimer;
import one.utils.server.ShutdownCallback;

import com.appjangle.opsunit.Job;
import com.appjangle.opsunit.JobExecutorFactory;
import com.appjangle.opsunit.JobListener;
import com.appjangle.opsunit.JobManager;

public class DefaultJobManager implements JobManager {

	private final List<Job> jobs;
	private final Concurrency concurrency;
	private final JobExecutorFactory executorFactory;
	private final JobListener listener;

	private final List<OneTimer> timers;

	private volatile boolean started = false;

	@Override
	public void start() {
		if (started) {
			throw new IllegalStateException(
					"Cannot start an already started job manager.");

		}

		for (final Job job : jobs) {

			final OneTimer jobTimer = concurrency.newTimer().scheduleRepeating(
					0, job.getFrequency(),
					executorFactory.createExecutor(job, listener));
			this.timers.add(jobTimer);
		}

		started = true;
	}

	@Override
	public void stop(final ShutdownCallback callback) {
		if (!started) {
			throw new IllegalStateException(
					"Cannot stop an already stopped job manager.");

		}

		for (final OneTimer timer : timers) {

			timer.stop();

		}

		timers.clear();

		started = false;
		callback.onShutdownComplete();

	}

	public DefaultJobManager(final List<Job> jobs,
			final Concurrency concurrency,
			final JobExecutorFactory executorFactory, final JobListener listener) {
		super();
		this.jobs = jobs;
		this.concurrency = concurrency;
		this.listener = listener;
		this.executorFactory = executorFactory;
		this.timers = new LinkedList<OneTimer>();
	}

}
