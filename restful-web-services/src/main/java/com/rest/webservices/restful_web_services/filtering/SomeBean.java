package com.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Alternative to JsonIgnore but at class level.
//@JsonIgnoreProperties("f2")
//@JsonIgnoreProperties({"f2","f1"})

@JsonFilter("someBeanFilter")
public class SomeBean {
	
	private String f1;
	
	// Static filtering; not return field as JSON field
//	@JsonIgnore
	private String f2;
	private String f3;

	public String getF1() {
		return f1;
	}

	public String getF2() {
		return f2;
	}

	public String getF3() {
		return f3;
	}

	public SomeBean(String f1, String f2, String f3) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
	}

	@Override
	public String toString() {
		return "SomeBean [f1=" + f1 + ", f2=" + f2 + ", f3=" + f3 + "]";
	}

}
