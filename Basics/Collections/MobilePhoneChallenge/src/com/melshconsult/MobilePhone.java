package com.melshconsult;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

	private static final Scanner scanner = new Scanner(System.in);

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

	protected boolean searchContact(String name) {
		String cleanName = cleanInput(name);

		for (Contact contact : contacts) {
			if (contact.getName().equals(cleanName)) {
				return true;
			}
		}
		return false;
	}

	protected boolean removeContact(String name) {
		int contactPosition;
		String contactName = cleanInput(name);
		boolean foundContact = searchContact(contactName);

		if (!foundContact) {
			return false;
		}
		else {
			contactPosition = findContact(contactName);
			return contacts.remove(findContact(contactPosition));
		}
	}

	protected boolean modifyContact(String searchName, String newName, int newNumber) {
		String currentName = cleanInput(searchName);
		String replaceName = cleanInput(newName);
		int replaceNumber, currentContactPosition;

		if (!searchContact(currentName)) {
			return false;
		}
		else {
			currentContactPosition = findContact(currentName);
			Contact currentContact = findContact(currentContactPosition);

			replaceNumber = verifyNumberNotZeroOrNegative(currentContact, newNumber);

			Contact replacementContact = new Contact(replaceName, replaceNumber);
			contacts.set(currentContactPosition, replacementContact);

			return true;
		}
	}

	private int verifyNumberNotZeroOrNegative(Contact contact, int number) {
		if (number > 0) {
			contact.setNumber(number);
		}
		return contact.getNumber();
	}

	private void modifyContact(int currentContactPosition, String searchName) {
		System.out.print("Enter replacement name: ");
		String newName = cleanInput(scanner.next());

		System.out.print("Enter replacement number: ");
		int newNumber = scanner.nextInt();

		Contact replacementContact = new Contact(newName, newNumber);
		contacts.set(currentContactPosition, replacementContact);
	}

	private String cleanInput(String name) {
		return name.trim().toLowerCase();
	}

	private Contact findContact(int contactPosition) {
		return contacts.get(contactPosition);
	}

	private int findContact(String contactName) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(contactName)) {
				return contacts.indexOf(contact);
			}
		}
		return -1;
	}
}
