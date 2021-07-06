package Lab2;

public class Person{
	private String firstName;
	private String lastName;
	private String fullName = firstName + " " + lastName;
	private String email;
	private long phoneNumber;
	
	Person(){}//initialize//empty it
	Person(String fName, String lName, String email, long phoneNumber) {//this stores name, email, phone no. infos
		firstName=fName;
		lastName=lName;
		this.email=email;
		this.phoneNumber=phoneNumber;
	}
	public String getName() {//store name, email, phoneNumber (using getter)
		return firstName + "" + lastName;
	}
	public String getEmail() {
		return email;
	}
	public long getPhoneNumber() {
		return phoneNumber;	
	}
}//class Person end
