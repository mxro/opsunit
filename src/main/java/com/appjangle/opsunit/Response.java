package com.appjangle.opsunit;

/**
 * Defines actions to be taken, if a unit test fails.
 * 
 * @author Max
 * 
 */
public interface Response {

	public static interface Callback {
		public void onSuccess();

		public void onFailure(Throwable t);
	}

	public void run(Callback callback);

}
