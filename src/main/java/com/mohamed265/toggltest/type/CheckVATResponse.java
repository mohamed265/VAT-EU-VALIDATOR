package com.mohamed265.toggltest.type;

import javax.xml.datatype.XMLGregorianCalendar;

public class CheckVATResponse {

	private String countryCode;
	private String vatNumber;
	private XMLGregorianCalendar requestDate;
	private boolean valid;
	private String name;
	private String address;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public XMLGregorianCalendar getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(XMLGregorianCalendar requestDate) {
		this.requestDate = requestDate;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
