package com.melshconsult;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

	private static Scanner scanner = new Scanner(System.in);

	ArrayList<Contact> contacts;

	public MobilePhone() {
		contacts = new ArrayList<>();
	}

	protected void printContacts() {
		for (Contact contact : contacts) {
			System.out.println("Name: " + contact.getName() + " - " + "Number: " + contact.getNumber());
		}
	}

	protected void storeContact(String name, int number) {
		Contact newContact = new Contact(name, number);
		contacts.add(newContact);
	}

	protected int searchContact(String name) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				return findContact(contact);
			}
		}
		return -1;
	}

	protected void modifyContact(String searchName) {
		if (searchContact(searchName) >= 0) {
			System.out.print("Enter replacement name: ");
			String newName = scanner.next().trim().toLowerCase();

			System.out.print("Enter replacement number: ");
			int newNumber = scanner.nextInt();

			int currentContactPosition = searchContact(searchName);
			Contact replacementContact = new Contact(newName, newNumber);

			modifyContact(currentContactPosition, replacementContact);
		}
	}

	private void modifyContact(int currentContactPosition, Contact replacementContact) {
		contacts.set(currentContactPosition, replacementContact);
	}

	private int findContact(Contact searchContact) {
		return contacts.indexOf(searchContact);
	}
}
