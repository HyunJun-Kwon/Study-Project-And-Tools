package MiniProjectFive;

public class Addr {
	
	private String name;
	private String phoneNum;
	private String email;
	private String num;
	private String address;
	private String group;
	
	public Addr(String phoneNum, String name, String num, String email, String address, String group){
		this.phoneNum = phoneNum;
		this.name = name;
		this.num = num;
		this.email = email;
		this.address = address;
		this.group = group;
	}
	
	public Addr(String name, String num, String email, String address, String group) {
		this.name = name;
		this.num = num;
		this.email = email;
		this.address = address;
		this.group = group;
	}
	
	public Addr() {}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Addr) {
			Addr addr = (Addr) obj;
			return(this.phoneNum.equals(addr.phoneNum));
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return phoneNum.hashCode();
	}
}
