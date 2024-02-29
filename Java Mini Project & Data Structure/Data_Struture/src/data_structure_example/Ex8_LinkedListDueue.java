package data_structure_example;

public class Ex8_LinkedListDueue {
	
}

class DQNode {
	char data;
	DQNode rlink;
	DQNode llink;
}

class DQDueue {
	DQNode front;
	DQNode rear;
	
	public DQDueue() {
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return(front == null);
	}
	
	public void insertFront(char item) {
		DQNode newNode = new DQNode();
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			newNode.rlink = null;
			newNode.llink = null;
		} else {
			front.llink = newNode;
			newNode.rlink = front;
			newNode.llink = null;
			front = newNode;
		}
		System.out.println("Front Inserted Item : " + item);
	}
	
	public void insertRear(char item) {
		DQNode newNode = new DQNode();
		newNode.data = item;
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			newNode.rlink = null;
			newNode.llink = null;
		} else {
			rear.rlink = newNode;
			newNode.rlink = null;
			newNode.llink = rear;
			rear = newNode;
		}
		System.out.println("Rear Inserted Item : " + item);
	}
	
	public char deleteFront() {
		if(isEmpty()) {
			System.out.println("Front Deleting fail! Dqueue is empty");
			return 0;
		} else {
			char item = front.data;
			if(front.rlink == null) {
				front = null;
				rear = null;
			} else {
				front = front.rlink;
				front.llink = null;
			}
			return item;
		}
	}
	
	public char deleteRear() {
		if(isEmpty()) {
			System.out.println("Rear Deleting fail ! Dqueue is empty !!");
			return 0;
		} else {
			char item = rear.data;
			if(rear.llink == null) {
				rear = null;
				front = null;
			} else {
				rear = rear.llink;
				rear.rlink = null;
			}
			return item;
		}
	}
}