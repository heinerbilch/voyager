package com.bilch.voyager;

import java.util.List;

public interface VarietyService {

	public List<Variety> findAll();

	public Variety findById(Long id);

	public Variety add(Variety variety);

}