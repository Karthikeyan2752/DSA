package com.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ChatBot {


	static List<Subscriber> subs = new ArrayList<>();
	static List<String> complaints = new ArrayList<>();
	static Stack<Integer> backStack = new Stack<>();
	static long mobile = 1000000000;
	static int subId = 0;


	final String[] plans = { "1 month data + U/L calls - 200", "3 month data + U/L calls - 600",
			"annual data + U/L calls - 2000" };

	public void printPlans() {
		for (int i = 1; i <= plans.length; i++) {
			System.out.println(i + ". " + plans[i - 1]);
		}

	}

	public void setPlan(int planChoice, Subscriber s) {
		System.out.println("\tChoose your plan: ");
		s.add("slected plan - " + planChoice);

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

	public void createNewUser(ChatBot chatBot) {

		System.out.println("\tNew User Portal");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: \n");
		String name = sc.next();
		System.out.println("Enter your Aadhaar number: \n");
		int aadhaar = sc.nextInt();
		Subscriber s = new Subscriber(subId++, aadhaar, name, mobile++);

		System.out.println("select your plan!\n");
		chatBot.printPlans();
		int planChoice = sc.nextInt();
		chatBot.setPlan(planChoice, s);

		System.out.println("your details: \n");
		System.out.println(s.toString());
		s.add("given details - " + s.toString());
		subs.add(s);

	}

	public void report() {

		System.out.println("\tReport your problem");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your ID: ");
		int id3 = sc.nextInt();
		Subscriber temp3 = subs.get(id3);
		System.out.println("Write your problem here: ");
		String complaint = sc.next();
		temp3.add("reported a problem - " + complaint);
		complaints.add("id - " + id3 + ": " + complaint);
		System.out.println("we will solve your problem as soon as possible!");

	}

	public void planChange(ChatBot chatBot) {

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
		chatBot.printPlans();
		int pc = sc.nextInt();
		temp.add("changed your plan to " + pc);
		chatBot.setPlan(pc, temp);
		System.out.println("plan changed successfully!");

	}

	public void deactivate() {

		System.out.println("\tDecativation portal");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your ID: ");
		int id7 = sc.nextInt();
		Subscriber temp7 = subs.get(id7);
		temp7.setStatus("inactive");
		System.out.println("deactivated!..");

	}

	public void history() {

		System.out.println("\tHistory Portal");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your ID: ");
		int id5 = sc.nextInt();

		if (id5 >= subs.size()) {
			System.out.println("id not found! ");
			return;
		}

		Subscriber temp5 = subs.get(id5);

		for (String str : temp5.chats) {
			System.out.println("-------------------------------");
			System.out.println(str);
		}
	}

	public void mainMenu(ChatBot chatBot) {

		System.out.println("\tMain Menu");
		System.out.println("1. Available Offer Plans! \n2. new user "
				+ "\n3. Report network issues \n4. Change plans \n5. chat history \n6. Exit\n7. decativate your account\n");
		chatBot.stackUtil(chatBot);

	}

	public void stackUtil(ChatBot chatBot) {
		Scanner sc = new Scanner(System.in);
		System.out.println("press '0' to main menu\npress '9' to back\npress '6' to exit");
		int choice = sc.nextInt();
		chatBot.start(choice, chatBot);
	}

	public void start(int choice, ChatBot chatBot) {
		backStack.push(choice);

		while (choice != -1) {

			switch (choice) {
			case 0:
				backStack.push(0);
				chatBot.mainMenu(chatBot);
				break;

			case 1:
				backStack.push(1);
				chatBot.printPlans();
				chatBot.stackUtil(chatBot);
				break;

			case 2:
				backStack.push(2);
				chatBot.createNewUser(chatBot);
				chatBot.stackUtil(chatBot);
				break;

			case 3:
				backStack.push(3);
				chatBot.report();
				chatBot.stackUtil(chatBot);
				break;

			case 4:
				backStack.push(4);
				chatBot.planChange(chatBot);
				chatBot.stackUtil(chatBot);
				break;

			case 5:
				backStack.push(5);
				chatBot.history();
				chatBot.stackUtil(chatBot);
				break;

			case 6:
				System.out.println("Are you sure, you want to exit? ");
				System.out.println("Enter 0 to exit/nEnter 1 to continue");
				Scanner sc = new Scanner(System.in);
				int exitChoice = sc.nextInt();
				if (exitChoice == 0) {

				}
			case 7:
				backStack.push(7);
				chatBot.deactivate();
				chatBot.stackUtil(chatBot);
				break;

			case 9:
				if (!backStack.isEmpty()) {
					backStack.pop();
					chatBot.start(backStack.peek(), chatBot);
					break;
				}
			}

		}
	}

	public static void main(String[] args) {
		ChatBot chatBot = new ChatBot();
		chatBot.mainMenu(chatBot);
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		chatBot.start(choice, chatBot);
	}
}
