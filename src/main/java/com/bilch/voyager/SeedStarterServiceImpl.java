package com.bilch.voyager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeedStarterServiceImpl implements SeedStarterService {
	Logger logger = LoggerFactory
			.getLogger(SeedStarterServiceImpl.class);

	@Autowired
	private SeedStarterRepository seedstarterRepository;

	/* (non-Javadoc)
	 * @see com.bilch.voyager.SeedStarterService#findAll()
	 */
	@Override
	public List<SeedStarter> findAll() {
		logger.debug("Find all SeedStarter");
		return (List<SeedStarter>) this.seedstarterRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.bilch.voyager.SeedStarterService#add(com.bilch.voyager.SeedStarter)
	 */
	@Override
	public SeedStarter add(final SeedStarter seedStarter) {
		logger.debug("Save: " + seedStarter);
		return this.seedstarterRepository.save(seedStarter);
	}

}
