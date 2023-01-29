package com.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ChatBot {

	// static ChatBot cb = new ChatBot();
	static List<Subscriber> subs = new ArrayList<>();
	static List<String> complaints = new ArrayList<>();
	static Stack<Integer> backStack = new Stack<>();
	static long mobile = 1000000000;
	static int subId = 0;


	static final String[] plans = { "1 month data + U/L calls - 200", "3 month data + U/L calls - 600",
			"annual data + U/L calls - 2000" };

	public static void printPlans() {
		for (int i = 1; i <= plans.length; i++) {
			System.out.println(i + ". " + plans[i - 1]);
		}

	}

	public static void setPlan(int planChoice, Subscriber s) {
		System.out.println("\tChoose your plan: ");
		s.pushInStack("slected plan - " + planChoice);
		if (planChoice == 1) {
			s.setPlan(plans[0]);
			s.setStatus("active");
		} else if (planChoice == 2) {
			s.setPlan(plans[1]);
			s.setStatus("active");
		} else if (planChoice == 3) {
			s.setPlan(plans[2]);
			s.setStatus("active");
		} else {
			System.out.println("invalid choice");
		}
	}

	public static void createNewUser() {
		System.out.println("\tNew User Portal");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: \n");
		String name = sc.next();
		System.out.println("Enter your Aadhaar number: \n");
		int aadhaar = sc.nextInt();
		Subscriber s = new Subscriber(subId++, aadhaar, name, mobile++);

		System.out.println("select your plan!\n");
		printPlans();
		int planChoice = sc.nextInt();
		setPlan(planChoice, s);

		System.out.println("your details: \n");
		System.out.println(s.toString());
		s.pushInStack("given details - " + s.toString());
		subs.add(s);
	}

	public static void report() {
		System.out.println("\tReport your problem");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your ID: ");
		int id3 = sc.nextInt();
		Subscriber temp3 = subs.get(id3);
		System.out.println("Write your problem here: ");
		String complaint = sc.next();
		temp3.pushInStack("reported a problem - " + complaint);
		complaints.add("id - " + id3 + ": " + complaint);
		System.out.println("we will solve your problem as soon as possible!");
	}

	public static void planChange() {
		System.out.println("\tChange your existing plan");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your ID: ");
		int id = sc.nextInt();
		if (id >= subs.size()) {
			System.out.println("id not found! ");
			return;
		}
		Subscriber temp = subs.get(id);
		System.out.println("select your plan!\n");
		printPlans();
		int pc = sc.nextInt();
		temp.pushInStack("changed your plan to " + pc);
		setPlan(pc, temp);
		System.out.println("plan changed successfully!");
	}

	public static void deactivate() {
		System.out.println("\tDecativation portal");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your ID: ");
		int id7 = sc.nextInt();
		Subscriber temp7 = subs.get(id7);
		temp7.setStatus("inactive");
		System.out.println("deactivated!..");
	}

	public static void history() {
		System.out.println("\tHistory Portal");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your ID: ");
		int id5 = sc.nextInt();
		Subscriber temp5 = subs.get(id5);
		while (!temp5.chats.isEmpty()) {
			System.out.println(temp5.chats.pop());
			System.out.println("-------------------------------");
		}
	}

	public static void mainMenu() {
		System.out.println("\tMain Menu");
		System.out.println("1. Available Offer Plans! \n2. new user "
				+ "\n3. Report network issues \n4.Change plans \n5. chat history \n6. Exit\n7. decativate your account\n");
		stackUtil();
	}

	public static void stackUtil() {
		Scanner sc = new Scanner(System.in);
		System.out.println("press '0' to main menu\npress '9' to back\npress '6' to exit");
		int choice = sc.nextInt();
		start(choice);
	}

	public static void start(int choice) {
		backStack.push(choice);

		while (choice != 6) {

			switch (choice) {
			case 0:
				backStack.push(0);
				mainMenu();
				break;

			case 1:
				backStack.push(1);
				printPlans();
				stackUtil();
				break;

			case 2:
				backStack.push(2);
				createNewUser();
				stackUtil();
				break;

			case 3:
				backStack.push(3);
				report();
				stackUtil();
				break;

			case 4:
				backStack.push(4);
				planChange();
				stackUtil();
				break;

			case 5:
				backStack.push(5);
				history();
				stackUtil();
				break;

			case 7:
				backStack.push(7);
				deactivate();
				stackUtil();
				break;

			case 9:
				if (!backStack.isEmpty()) {
					backStack.pop();
					start(backStack.peek());
					break;
				}
			}

		}
	}

	public static void main(String[] args) {
		mainMenu();
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		start(choice);
	}
}
