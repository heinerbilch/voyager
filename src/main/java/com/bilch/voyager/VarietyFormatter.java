package com.bilch.voyager;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class VarietyFormatter implements Formatter<Variety> {

    @Autowired
    private VarietyService varietyService;

    public VarietyFormatter() {
		super();
	}

	@Override
	public String print(Variety object, Locale locale) {
        return (object != null ? String.valueOf(object.getId()) : "");
	}

	@Override
	public Variety parse(String text, Locale locale) throws ParseException {
        final Long varietyId = Long.valueOf(text);
        return this.varietyService.findById(varietyId);
	}

}
