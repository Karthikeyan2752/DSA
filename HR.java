package com.linkedlist;

public class HR {
	public static void registers() {
		for (Candidate c : InterviewProcess.history) {
			System.out.println(c.toString());
		}
	}
}
