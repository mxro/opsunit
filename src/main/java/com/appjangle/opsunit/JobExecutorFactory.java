package com.appjangle.opsunit;

/**
 * A factory to created {@link JobExecutor}s.
 * 
 * @author mroh004
 * 
 */
public interface JobExecutorFactory {

	public JobExecutor createExecutor(Job job, JobListener listener);

}
