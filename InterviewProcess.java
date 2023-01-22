package com.linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class InterviewProcess {

	static int id = 1;
	static Queue<Candidate> reception = new LinkedList<>();
	static Queue<Candidate> WaitingLobby = new LinkedList<>();
	static Queue<Candidate> history = new LinkedList<>();
	static final int maxSize = 5;

	public static void main(String[] args) {
		while (true) {
			System.out.println("Welcome!");

			Scanner s = new Scanner(System.in);
			System.out.println("Enter your name: ");
			String name = s.next();

			/*
			 * if HR wants to see the registers for the candidates , enter "HR" while asking
			 * the name. it displays the candidate details
			 */

			if (name.equals("HR")) {
				System.out.println("id\tname\tmobileNumber\tqualification\tposition");
				HR.registers();
				/*
				 * the above function register is in the HR class
				 */
				continue;
			}
			System.out.println("Enter your mobile number: ");
			long mobile = s.nextLong();
			System.out.println("Enter your Qualification: ");
			String qualification = s.next();

			Candidate candidate = new Candidate(mobile, name, qualification, id++);
			history.add(candidate);
			if (WaitingLobby.size() < maxSize) {

				candidate.setPosistion("WaitingLobby");
				WaitingLobby.add(candidate);
				System.out.println("you are in waiting lobby!");

			} else if (reception.size() < maxSize) {

				candidate.setPosistion("reception");
				reception.add(candidate);
				System.out.println("you are in reception!");

			} else {

				candidate.setPosistion("reception");
				WaitingLobby.remove().setPosistion("out");
				WaitingLobby.add(reception.remove());
				reception.add(candidate);
				System.out.println("you are in reception!");
			}
		}

	}
}
