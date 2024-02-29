package MiniProjectFour;

public class Addr {
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	private String name;
	private String phone;
	private String email;
	private String address;
	private String group;
	private String value1;
	private String value2;
	private String value3;
	
	Addr(){}
	
	Addr(String name, String phone, String email, String address, String group){
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.group = group;
	}

	
	
	public void printinfo() {
		System.out.println("----------------------");
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("이메일 : " + email);
		System.out.println("주소 : " + address);
		System.out.println("그룹(가족) : " + group);
		System.out.println("----------------------");
	}
	
	
	public String regroup(String group) {
		this.group = group;
		group = "가족";
		return group;
	}
}

