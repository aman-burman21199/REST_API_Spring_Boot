package com.rest.webservices.restful_web_services.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
//	@GetMapping("/filtering")
//	public SomeBean filtering() {
//		return new SomeBean("Val1","Val2","Val3");
//	}

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
//		return new SomeBean("Val1","Val2","Val3");
		SomeBean bean = new SomeBean("Val1","Val2","Val3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("f1","f2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter );
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}
