/**
 * PartyPhoto.java
 *
 * Version: 0.1
 *
 * 02.11.2015
 *
 * Copyright by danielmaclaughlin
 */

package org.wahlzeit.model;

/**
 * @author mediadon
 *
 */
@SuppressWarnings("serial")
public class PartyPhoto extends Photo {
	
	private Party party;
	
	/**
	 * @methodtype constructor
	 */
	public PartyPhoto(){
		super();
	}

	/**
	 * @methodtype get
	 */
	public Party getParty() {
		return party;
	}

	/**
	 * @methodtype set
	 */
	public void setParty(Party party) {
		this.party = party;
	}
	
	
	
	
}
