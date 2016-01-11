package org.wahlzeit.model;

public class PartyType {

	private String locationName;
	private String operator;
	private String locationAddress;

	/**
	 * @methodtype constructor
	 */
	public PartyType(String locationName, String operator, String locationAddress) {

		this.locationName = locationName;
		this.operator = operator;
		this.locationAddress = locationAddress;
	}

	public Party createInstance() {
		return new Party(this);
	}

	/**
	 * @methodtype get
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @methodtype set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @methodtype get
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @methodtype set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @methodtype get
	 */
	public String getLocationAddress() {
		return locationAddress;
	}

	/**
	 * @methodtype set
	 */
	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

}
