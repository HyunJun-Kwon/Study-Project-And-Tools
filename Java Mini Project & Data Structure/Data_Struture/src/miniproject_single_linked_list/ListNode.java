package miniproject_single_linked_list;

public class ListNode {
	private String data;
	ListNode link;
	
	public ListNode() {
		this.data=null;
		this.link=null;			
	}
	
	public ListNode(String data) {
		this.data=data;
		this.link=null;
	}
	
	public ListNode(String data, ListNode link) {
		this.data=data;
		this.link=link;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ListNode getLink() {
		return link;
	}
	public void setLink(ListNode link) {
		this.link = link;
	}
	
}
