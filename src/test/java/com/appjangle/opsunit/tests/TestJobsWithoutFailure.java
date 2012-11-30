package com.appjangle.opsunit.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.appjangle.opsunit.Job;
import com.appjangle.opsunit.JobManager;
import com.appjangle.opsunit.Response;
import com.appjangle.opsunit.jre.OpsUnitJre;
import com.appjangle.opsunit.jre.templates.AlwaysPass;
import com.appjangle.opsunit.listener.DefaultJobListener;

public class TestJobsWithoutFailure {

	@Test
	public void test_run_jobs_without_failures() throws InterruptedException {

		final LinkedList<Job> jobs = new LinkedList<Job>();

		jobs.add(new Job() {

			@Override
			public List<Class<?>> getTests() {
				final LinkedList<Class<?>> tests = new LinkedList<Class<?>>();

				tests.add(AlwaysPass.class);

				return tests;
			}

			@Override
			public List<Response> getResponses() {
				final ArrayList<Response> responses = new ArrayList<Response>(1);
				responses.add(new Response() {

					@Override
					public void run(final Callback callback) {
						callback.onFailure(new Exception(
								"Response should not be triggered in this test case."));
					}

				});
				return responses;
			}

			@Override
			public String getName() {
				return "test job";
			}

			@Override
			public int getFrequency() {
				return 50;
			}
		});

		final List<Class<?>> testsDone = Collections
				.synchronizedList(new ArrayList<Class<?>>(0));
		final JobManager manager = OpsUnitJre.createManager(jobs,
				new DefaultJobListener() {

					@Override
					public void onStartTest(final Job j, final Class<?> test) {
						testsDone.add(test);
					}

				});

		manager.start();

		Thread.sleep(1000);

		Assert.assertTrue(testsDone.size() > 3);
	}
}
