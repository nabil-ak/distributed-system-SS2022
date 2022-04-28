package main;

public class participant {
	
	private String name;
	private String company;
	private String country;
	
	public participant(String name, String company, String country) {
		this.name = name;
		this.company = company;
		this.country = country;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}
	

}
