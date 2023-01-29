package com.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatBotOld {


	static List<Subscriber> subs = new ArrayList<>();
	static List<String> complaints = new ArrayList<>();
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
	public static void main(String[] args) {
		boolean bool = true;
		while (bool) {

			System.out.println("1. Available Offer Plans! \n2. new user "
					+ "\n3. Report network issues \n4.Change plans \n5. chat history \n6. Exit\n7. decativate your account\n");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				printPlans();
				break;

			case 2:
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
				break;

			case 3:
				System.out.println("Enter your ID: ");
				int id3 = sc.nextInt();
				Subscriber temp3 = subs.get(id3);
				System.out.println("Write your problem here: ");
				String complaint = sc.next();
				temp3.pushInStack("reported a problem - " + complaint);
				complaints.add("id - " + id3 + ": " + complaint);
				System.out.println("we will solve your problem as soon as possible!");
				break;
			case 4:
				System.out.println("Enter your ID: ");
				int id = sc.nextInt();
				if (id >= subs.size()) {
					System.out.println("id not found! ");
					break;
				}
				Subscriber temp = subs.get(id);
				System.out.println("select your plan!\n");
				printPlans();
				int pc = sc.nextInt();
				temp.pushInStack("changed your plan to " + pc);
				setPlan(pc, temp);
				System.out.println("plan changed successfully!");
				break;
			case 5:
				System.out.println("Enter your ID: ");
				int id5 = sc.nextInt();
				Subscriber temp5 = subs.get(id5);
				while (!temp5.chats.isEmpty()) {
					System.out.println(temp5.chats.pop());
					System.out.println("-------------------------------");
				}
				break;
			case 6:
				bool = false;
				break;

			case 7:
				System.out.println("enter your ID: ");
				int id7 = sc.nextInt();
				Subscriber temp7 = subs.get(id7);
				temp7.setStatus("inactive");
				System.out.println("deactivated!..");
				break;
			}

		}
	}
}
