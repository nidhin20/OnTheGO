package com.project.onthego.view;

import javax.validation.constraints.NotEmpty;

public class ServiceProviderview {
	@NotEmpty
	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
