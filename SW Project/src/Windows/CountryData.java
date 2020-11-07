package Windows;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CountryData {
    private String countryName;
    private String totalCases;
    private String totalDeaths;
    private String newCases;
    private String newDeaths;
    private String totalRecovered;
    private String activeCases;
    
    public CountryData(String cn, String tc, String nc, String td, String nd, String tr, String ac) {
    	this.countryName = cn;
    	this.totalCases = tc;
    	this.totalDeaths = td;
    	this.newCases = nc;
    	this.newDeaths = nd;
    	this.totalRecovered = tr;
    	this.activeCases = ac;
    }
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getTotalCases() {
		return totalCases;
	}
	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
	}
	public String getTotalDeaths() {
		return totalDeaths;
	}
	public void setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
	}
	public String getNewCases() {
		return newCases;
	}
	public void setNewCases(String newCases) {
		this.newCases = newCases;
	}
	public String getNewDeaths() {
		return newDeaths;
	}
	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
	}
	public String getTotalRecovered() {
		return totalRecovered;
	}
	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}
	public String getActiveCases() {
		return activeCases;
	}
	public void setActiveCases(String activeCases) {
		this.activeCases = activeCases;
	}
	public long getNumberTotalCases() {
		if (totalCases.length() < 3) {
			long result = Long.parseLong(totalCases);
			return result;
		} else {
			long result = 0;
			String[] parts = totalCases.split(",");
			for (int i = 0; i < parts.length; i++) {
				result += (Long.parseLong(parts[i])*((long) Math.pow(10, 3*(parts.length-i-1))));
			}
			return result;
		} 
	}
	public long getNumberActiveCases() {
		if (activeCases.length() < 3) {
			long result = Long.parseLong(activeCases);
			return result;
		} else {
			long result = 0;
			String[] parts = activeCases.split(",");
			for (int i = 0; i < parts.length; i++) {
				result += (Long.parseLong(parts[i])*((long) Math.pow(10, 3*(parts.length-i-1))));
			}
			return result;
		} 
	}
	public static long stringToNumberic(String a) {
		if (a.length() < 3) {
			long result = Long.parseLong(a);
			return result;
		} else {
			long result = 0;
			String[] parts = a.split(",");
			for (int i = 0; i < parts.length; i++) {
				result += (Long.parseLong(parts[i])*((long) Math.pow(10, 3*(parts.length-i-1))));
			}
			return result;
		} 
	}
}