package com.mukhar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComboMakerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	private ComboMaker cm;

	@Before
	public void setUp() throws Exception {
		cm = new ComboMaker();
	}

	@Test
	public void test01() {
		cm.makeCombos(15);
	}
}
