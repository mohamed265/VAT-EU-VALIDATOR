package com.mohamed265.toggltest;

import java.util.Scanner;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import com.mohamed265.toggltest.eu.europa.ec.taxud.vies.services.checkvat.CheckVatPortType;
import com.mohamed265.toggltest.eu.europa.ec.taxud.vies.services.checkvat.CheckVatService;
import com.mohamed265.toggltest.type.CheckVATResponse;

public class App {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("No args found");
		} else {

			String countryCodeStr = args[0].substring(0, 2);
			String vatNumberStr = args[0].substring(2);

			System.out.println("Country Code is: " + countryCodeStr);
			System.out.println("VAT Number Code is: " + vatNumberStr);

			CheckVATResponse checkVATResponse = validateVATnumber(
					countryCodeStr, vatNumberStr);
			System.out.println("\tValid: " + checkVATResponse.isValid());
			System.out.println("\tName: " + checkVATResponse.getName());
			System.out.println("\tAddress: "
					+ checkVATResponse.getAddress().replace('\n', ' '));
			System.out.println("\tRequest Date: "
					+ checkVATResponse.getRequestDate());
		}

	}

	static CheckVatService checkVatService = new CheckVatService();
	static CheckVatPortType checkVatPortType = checkVatService
			.getCheckVatPort();

	static CheckVATResponse validateVATnumber(String countryCodeStr,
			String vatNumberStr) {

		Holder<String> countryCode = new Holder<String>(countryCodeStr);
		Holder<String> vatNumber = new Holder<String>(vatNumberStr);
		Holder<XMLGregorianCalendar> requestDate = new Holder<XMLGregorianCalendar>();
		Holder<Boolean> valid = new Holder<Boolean>();
		Holder<String> name = new Holder<String>();
		Holder<String> address = new Holder<String>();

		checkVatPortType.checkVat(countryCode, vatNumber, requestDate, valid,
				name, address);

		CheckVATResponse checkVATResponse = new CheckVATResponse();
		checkVATResponse.setCountryCode(countryCodeStr);
		checkVATResponse.setVatNumber(vatNumberStr);
		checkVATResponse.setRequestDate(requestDate.value);
		checkVATResponse.setAddress(address.value);
		checkVATResponse.setName(name.value);
		checkVATResponse.setValid(valid.value);

		return checkVATResponse;
	}

	public static void AppForMultInput() {
		Scanner scanner = new Scanner(System.in);
		String input;
		String countryCodeStr, vatNumberStr;

		while (true) {
			System.out.println("=================================");
			System.out.println("Enter validate to call webservice");
			System.out.println("Enter exit to exit");
			System.out.println("=================================");
			input = scanner.next();
			if (input.equalsIgnoreCase("exit")) {
				break;
			} else if (input.equalsIgnoreCase("validate")) {
				System.out.println("Enter Country Code");
				countryCodeStr = scanner.next();
				System.out.println("Enter VAT Number Code");
				vatNumberStr = scanner.next();
				CheckVATResponse checkVATResponse = validateVATnumber(
						countryCodeStr, vatNumberStr);
				System.out.println("\tValid: " + checkVATResponse.isValid());
				System.out.println("\tName: " + checkVATResponse.getName());
				System.out.println("\tAddress: "
						+ checkVATResponse.getAddress().replace('\n', ' '));
				System.out.println("\tRequest Date: "
						+ checkVATResponse.getRequestDate());
			} else {
				System.out.println("Not Recognized input");
			}
		}
		scanner.close();
	}
}
