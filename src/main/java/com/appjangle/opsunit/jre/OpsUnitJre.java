package com.appjangle.opsunit.jre;

import java.util.List;

import one.utils.jre.OneUtilsJre;

import com.appjangle.opsunit.Job;
import com.appjangle.opsunit.JobExecutor;
import com.appjangle.opsunit.JobExecutorFactory;
import com.appjangle.opsunit.JobListener;
import com.appjangle.opsunit.JobManager;
import com.appjangle.opsunit.OpsUnit;
import com.appjangle.opsunit.jre.internal.JUnitJobExecutor;

public class OpsUnitJre {

	public static JobManager createManager(final List<Job> jobs,
			final JobListener listener) {
		return OpsUnit.createManager(jobs, OneUtilsJre.newJreConcurrency(),
				new JobExecutorFactory() {

					@Override
					public JobExecutor createExecutor(final Job job,
							final JobListener listener) {
						return new JUnitJobExecutor(job, listener);
					}
				}, listener);
	}

}
