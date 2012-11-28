package com.appjangle.opsunit.jre.templates;

import org.junit.Assert;
import org.junit.Test;

public class AlwaysPass {

	@Test
	public void test_all_okay() {
		Assert.assertTrue(true);
	}

	@Test
	public void test_still_okay() {
		Assert.assertTrue(true);
	}

}