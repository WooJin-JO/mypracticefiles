package student_information_management;

import java.util.Scanner;

public class Person {
	Scanner s = new Scanner(System.in);
	private String name;
	private String gender;
	private String address;
	private String tel;
	public Person(String name, String gender, String address, String tel){
		name = "";
		gender = "";
		address = "";
		tel = "";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
