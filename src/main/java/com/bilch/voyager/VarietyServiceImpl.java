package com.bilch.voyager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class VarietyServiceImpl implements VarietyService {

	private Logger logger = LoggerFactory.getLogger(VarietyServiceImpl.class); 
    @Autowired
    private VarietyRepository varietyRepository;

    /* (non-Javadoc)
	 * @see com.bilch.voyager.VarietyService#findAll()
	 */
    @Override
	public List<Variety> findAll() {
        return (List<Variety>) this.varietyRepository.findAll();
    }

    /* (non-Javadoc)
	 * @see com.bilch.voyager.VarietyService#findById(java.lang.Long)
	 */
    @Override
	public Variety findById(final Long id) {
        return this.varietyRepository.findOne(id);
    }
    
    /* (non-Javadoc)
	 * @see com.bilch.voyager.VarietyService#add(com.bilch.voyager.Variety)
	 */
    @Override
	public Variety add(Variety variety) {
    	logger.info("Save: " + variety);
    	return varietyRepository.save(variety);
    }

}
