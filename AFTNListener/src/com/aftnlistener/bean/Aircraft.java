package com.aftnlistener.bean;

/**
 * Aircraft entity. @author MyEclipse Persistence Tools
 */

public class Aircraft implements java.io.Serializable {

	// Fields

	private String aircraftRegistration;
	private String colourCode;
	private String otherColour;
	private Integer numberofAircraft;
	private String significantMarkings;
	private String wakeTurbulenceCategory;
	private Integer aircraftTypeNumberofAircraft;
	private String icaoAircraftTypeReference;
	private String otherAircraftTypeReference;
	private String aircraftApproachCategory;
	private String aircraftAddress;

	// Constructors

	/** default constructor */
	public Aircraft() {
	}

	/** minimal constructor */
	public Aircraft(String aircraftRegistration) {
		this.aircraftRegistration = aircraftRegistration;
	}

	/** full constructor */
	public Aircraft(String aircraftRegistration, String colourCode, String otherColour, Integer numberofAircraft,
			String significantMarkings, String wakeTurbulenceCategory, Integer aircraftTypeNumberofAircraft,
			String icaoAircraftTypeReference, String otherAircraftTypeReference, String aircraftApproachCategory,
			String aircraftAddress) {
		this.aircraftRegistration = aircraftRegistration;
		this.colourCode = colourCode;
		this.otherColour = otherColour;
		this.numberofAircraft = numberofAircraft;
		this.significantMarkings = significantMarkings;
		this.wakeTurbulenceCategory = wakeTurbulenceCategory;
		this.aircraftTypeNumberofAircraft = aircraftTypeNumberofAircraft;
		this.icaoAircraftTypeReference = icaoAircraftTypeReference;
		this.otherAircraftTypeReference = otherAircraftTypeReference;
		this.aircraftApproachCategory = aircraftApproachCategory;
		this.aircraftAddress = aircraftAddress;
	}

	// Property accessors

	public String getAircraftRegistration() {
		return this.aircraftRegistration;
	}

	public void setAircraftRegistration(String aircraftRegistration) {
		this.aircraftRegistration = aircraftRegistration;
	}

	public String getColourCode() {
		return this.colourCode;
	}

	public void setColourCode(String colourCode) {
		this.colourCode = colourCode;
	}

	public String getOtherColour() {
		return this.otherColour;
	}

	public void setOtherColour(String otherColour) {
		this.otherColour = otherColour;
	}

	public Integer getNumberofAircraft() {
		return this.numberofAircraft;
	}

	public void setNumberofAircraft(Integer numberofAircraft) {
		this.numberofAircraft = numberofAircraft;
	}

	public String getSignificantMarkings() {
		return this.significantMarkings;
	}

	public void setSignificantMarkings(String significantMarkings) {
		this.significantMarkings = significantMarkings;
	}

	public String getWakeTurbulenceCategory() {
		return this.wakeTurbulenceCategory;
	}

	public void setWakeTurbulenceCategory(String wakeTurbulenceCategory) {
		this.wakeTurbulenceCategory = wakeTurbulenceCategory;
	}

	public Integer getAircraftTypeNumberofAircraft() {
		return this.aircraftTypeNumberofAircraft;
	}

	public void setAircraftTypeNumberofAircraft(Integer aircraftTypeNumberofAircraft) {
		this.aircraftTypeNumberofAircraft = aircraftTypeNumberofAircraft;
	}

	public String getIcaoAircraftTypeReference() {
		return this.icaoAircraftTypeReference;
	}

	public void setIcaoAircraftTypeReference(String icaoAircraftTypeReference) {
		this.icaoAircraftTypeReference = icaoAircraftTypeReference;
	}

	public String getOtherAircraftTypeReference() {
		return this.otherAircraftTypeReference;
	}

	public void setOtherAircraftTypeReference(String otherAircraftTypeReference) {
		this.otherAircraftTypeReference = otherAircraftTypeReference;
	}

	public String getAircraftApproachCategory() {
		return this.aircraftApproachCategory;
	}

	public void setAircraftApproachCategory(String aircraftApproachCategory) {
		this.aircraftApproachCategory = aircraftApproachCategory;
	}

	public String getAircraftAddress() {
		return this.aircraftAddress;
	}

	public void setAircraftAddress(String aircraftAddress) {
		this.aircraftAddress = aircraftAddress;
	}

}