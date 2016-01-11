package org.wahlzeit.model;

public class Party {

	private PartyType partyType;
	private String type;
	private String mainAct;
	private String date;

	/**
	 * @methodtype constructor
	 */
	public Party(PartyType partyType) {

		this.partyType = partyType;
	}

	/**
	 * @methodtype get
	 */
	public PartyType getPartyType() {
		return partyType;
	}

	/**
	 * @methodtype set
	 */
	public void setPartyType(PartyType partyType) {
		this.partyType = partyType;
	}

	/**
	 * @methodtype get
	 */
	public String getType() {
		return type;
	}

	/**
	 * @methodtype set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @methodtype get
	 */
	public String getMainAct() {
		return mainAct;
	}

	/**
	 * @methodtype set
	 */
	public void setMainAct(String mainAct) {
		this.mainAct = mainAct;
	}

	/**
	 * @methodtype get
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @methodtype set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
