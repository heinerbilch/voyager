package com.bilch.voyager;

import java.util.List;

public interface SeedStarterService {

	public List<SeedStarter> findAll();

	public SeedStarter add(SeedStarter seedStarter);

}