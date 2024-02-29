package MiniProjectOne;

import java.util.Scanner;

public class SmartPhoneMain {
	public static void main(String[] args) {
		
		SmartPhone smartPhone = new SmartPhone();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			printMenu();
			String selectMenu = scanner.nextLine();
			
			if(selectMenu.equals("1")) {
				smartPhone.addAddr(smartPhone.inputData());
			} else if(selectMenu.equals("2")) {
				smartPhone.printAllAddr();
			} else if(selectMenu.equals("3")) {
				System.out.println("찾고자하는 이름을 입력해주세요.");
				smartPhone.searchAddr(scanner.nextLine());
			} else if(selectMenu.equals("4")) {
				System.out.println("삭제하고자 하는 이름을 입력해주세요.");
				smartPhone.deleteAddr(scanner.nextLine());
			} else if(selectMenu.equals("5")) {
				System.out.println("수정하고자 하는 이름을 입력해주세요.");
				String name = scanner.nextLine();
				smartPhone.searchAddr(name);
				System.out.println("새로운 연락처를 입력해주세요.");
				smartPhone.editAddr(name, smartPhone.inputData());
			} else if(selectMenu.equals("6")) {
				System.out.println("프로그램을 종료합니다.");
				return;
			} else {
				System.out.println("잘못된 메뉴를 선택하였습니다. 다시 선택해주세요.");
			}
			
		
		}
		
		
	}
	
	public static void printMenu() {
		System.out.println("--------------------");
		System.out.println(">>1. 연락처 추가");
		System.out.println(">>2. 모든 연락처 출력");
		System.out.println(">>3. 연락처 검색");
		System.out.println(">>4. 연락처 삭제");
		System.out.println(">>5. 연락처 수정");
		System.out.println("--------------------");
	}
	
}
