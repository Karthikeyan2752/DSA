package com.linkedlist;

import java.util.Stack;

public class Subscriber {
	int subId;
	String name;
	String plan;
	long aadhaar;
	long mobile;
	String status;
	Stack<String> chats = new Stack<>();

	Subscriber(int subId, long aadhaar, String name, long mobile) {
		this.subId = subId;
		this.name = name;
		this.mobile = mobile;
		this.aadhaar = aadhaar;
	}

	void setPlan(String plan) {
		this.plan = plan;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void pushInStack(String chat) {
		chats.push(chat);
	}

	@Override
	public String toString() {
		return subId + "\t" + name + "\t" + plan + "\t" + mobile + "\t" + status;
	}
}
