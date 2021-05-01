package com.melshconsult;

import java.text.MessageFormat;
import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final MobilePhone mobilePhone = new MobilePhone();

	public static void main(String[] args) {
		boolean quit = false;

		while (!quit) {
			menu();
			int option = scanner.nextInt();
			System.out.println();

			switch (option) {

				case 1 -> addContact();
				case 2 -> printContacts();
				case 3 -> removeContact();
				case 4 -> modifyContact();
				case 5 -> searchContact();
				default -> {
					quit = true;
					System.out.println("Exiting...");
				}
			}
		}
	}

	private static void menu() {
		System.out.println();
		System.out.println("Mobile phonebook");
		System.out.println();

		System.out.println("0 - quit");
		System.out.println("1 - add contact");
		System.out.println("2 - print contacts");
		System.out.println("3 - remove contact");
		System.out.println("4 - modify contact");
		System.out.println("5 - search contact");

		System.out.println();
		System.out.print("Select an option: ");
	}

	private static void addContact() {
		String name = inputName();
		int number = inputNumber();

		mobilePhone.storeContact(name, number);

		System.out.println();
		System.out.println("New contact added!");
	}

	private static void printContacts() {
		System.out.println();
		System.out.println("Contacts list...");

		mobilePhone.printContacts();

		System.out.println();
	}

	private static void removeContact() {
		String name = inputName();

		boolean removed = mobilePhone.removeContact(name);

		if (!removed) {
			System.out.println("Contact not removed.");
			System.out.println("Possible cause: contact not in list.");
		} else {
			System.out.println("Contact removed");
		}
	}

	private static void modifyContact() {
		boolean modified = false;
		int newNumber = 0;

		System.out.print("Enter current name: ");
		String currentName = scanner.next();

		System.out.print("Enter replacement name: ");
		String replacementName = scanner.next();

		System.out.print("Change number number (y/n): ");
		String answer = scanner.next();

		if (answer.equals("y")) {
			System.out.print("Enter replacement number: ");
			newNumber = scanner.nextInt();
		} else {
			modified = mobilePhone.modifyContact(currentName, replacementName, newNumber);
		}

		if (!modified) {
			String message = MessageFormat.format("Contact with {0} is not in the contacts list", currentName);
			System.out.println(message);
		}
		else {
			System.out.println("Contact updated!");
		}
	}

	private static void searchContact() {
		String name = inputName();
		boolean found = mobilePhone.searchContact(name);

		if (!found){
			System.out.println("Contact is not in contact list");
		} else {
			System.out.println("Contact found!");
		}
	}

//	private void modifyNumber(Contact contact, int number) {
//
//	}

	private static String inputName() {
		System.out.print("Enter name: ");
		return scanner.next();
	}

	private static int inputNumber() {
		System.out.print("Enter number: ");
		return scanner.nextInt();
	}
}
