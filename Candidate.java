package com.linkedlist;

public class Candidate {
	long mobileNumber;
	String name;
	String qualification;
	int id;
	String position;

	Candidate(long mobileNumber, String name, String qualification, int id) {
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.qualification = qualification;
		this.id = id;
	}

	void setPosistion(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + mobileNumber + "\t\t" + qualification + "\t\t" + position;
	}

}

