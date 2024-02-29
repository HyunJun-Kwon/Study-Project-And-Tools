package MiniProjectFour;

public class CustomerAddr extends Addr{

	private String customerName;
	private String trsItem;
	private String position;
	
	public CustomerAddr(String name, String phone, String email, String address, 
			String group, String customerName, String trsItem, String position) {
		super(name, phone, email, address, group);
		this.customerName = customerName;
		this.trsItem = trsItem;
		this.position = position;
	}
	
	public CustomerAddr() {
		
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTrsItem() {
		return trsItem;
	}
	public void setTrsItem(String trsItem) {
		this.trsItem = trsItem;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public void printinfo() {
		System.out.println("------------------------");
		System.out.println("이름 : " + getName());
		System.out.println("전화번호 : " + getPhone());
		System.out.println("이메일 : " + getEmail());
		System.out.println("주소 : " + getAddress());
		System.out.println("그룹 : " + getGroup());
		System.out.println("거래처 이름 : " + customerName);
		System.out.println("거래품목 : " + trsItem);
		System.out.println("직급 : " + position);
		System.out.println("-------------------------");
	}
	
}
