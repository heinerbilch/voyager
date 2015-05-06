package com.bilch.voyager;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Voyager.class) 
public class VarietyServiceTest {
	
	@Autowired
	VarietyRepository varietyRepository;
	@Autowired
	VarietyService varietyService;

	@Before
	public void setUp() {
		varietyService.add(new Variety("Testus testus"));		
	}

	@Test
	public void testFindAll() {
		assertTrue(varietyService.findAll().size() > 0);
	}

	@Test
	public void testFindById() {
		assertTrue(!varietyService.findById(1L).getName().isEmpty());
	}

	@Test
	public void testSave() {
		assertTrue(varietyService.add(new Variety("Fungus")).getId() > 0);
	}
}
