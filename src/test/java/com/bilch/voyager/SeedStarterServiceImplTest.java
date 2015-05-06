package com.bilch.voyager;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Voyager.class)
public class SeedStarterServiceImplTest {
	@Autowired
	SeedStarterService seedStarterService;
	private SeedStarter seedStarter;

	@Before
	public void setUp() throws Exception {
		seedStarter = new SeedStarter("Testsaat", new Date(), true, Type.WOOD);
	}

	@Test
	public void testFindAll() {
		seedStarterService.add(seedStarter);
		assertTrue(seedStarterService.findAll().size() > 0);
	}

	@Test
	public void testAdd() {
		assertTrue(seedStarterService.add(seedStarter).getCovered()
				.booleanValue());
	}

	@Test
	public void testAddWithRow() {
		seedStarter.setRow(new Row(new Variety("Fungus"), 2));
		assertTrue(seedStarterService.add(seedStarter).getCovered()
				.booleanValue());
	}
	
	@Test
	public void testAddRowName() {
		seedStarter.setRow(new Row(new Variety("Maxi"), 2));
		assertTrue(seedStarterService.add(seedStarter).getRows().get(0).getVariety().getName().compareTo("Maxi") == 0);		
	}
}
