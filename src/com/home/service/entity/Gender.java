package com.home.service.entity;

public enum Gender {
MALE("MALE"), FEMALE ("FEMALE");
	
	private String field;

	private Gender(String field) {
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
