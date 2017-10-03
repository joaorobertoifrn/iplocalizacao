package br.edu.ifrn.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Localizacao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String region;
	
	private String valid;
	
	private String hostname;
	
	private String longitude;
	
	private String latitude;
	
	@SerializedName("country-code")
	private String countrycode;
	
	private String city;
	
	private String country;
	
	@SerializedName("api-error-msg")
	private String apierrormsg;
	
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getApierrormsg() {
		return apierrormsg;
	}
	public void setApierrormsg(String apierrormsg) {
		this.apierrormsg = apierrormsg;
	}
	
	
	
	
}
