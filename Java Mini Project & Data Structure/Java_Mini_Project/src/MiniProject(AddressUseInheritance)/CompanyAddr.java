package MiniProjectFour;

public class CompanyAddr extends Addr{
	
	private String companyName;
	private String department;
	private String position;
	
	
	
	public CompanyAddr(String name, String phone, String email, String address, 
			String group, String companyName, String department, String position) {
		super(name, phone, email, address, group);
		this.companyName = companyName;
		this.department = department;
		this.position = position;
	}
	
	public CompanyAddr() {
		
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public void printinfo() {
		System.out.println("--------------------------");
		System.out.println("이름 : " + getName());
		System.out.println("전화번호 : " + getPhone());
		System.out.println("이메일 : " + getEmail());
		System.out.println("주소 : " + getAddress());
		System.out.println("그룹 : " + getGroup());
		System.out.println("회사이름 : " + companyName);
		System.out.println("부서 : " + department);
		System.out.println("직급 : " + position);
		System.out.println("---------------------------");
	}
	
}
