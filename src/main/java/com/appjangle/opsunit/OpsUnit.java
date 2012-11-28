package com.appjangle.opsunit;

import java.util.List;

import one.utils.jre.concurrent.JreConcurrency;

import com.appjangle.opsunit.internal.DefaultJobManager;

public class OpsUnit {

	public static JobManager createManager(final List<Job> jobs,
			final JreConcurrency concurrency,
			final JobExecutorFactory executorFactory, final JobListener listener) {
		return new DefaultJobManager(jobs, concurrency, executorFactory,
				listener);
	}

}
