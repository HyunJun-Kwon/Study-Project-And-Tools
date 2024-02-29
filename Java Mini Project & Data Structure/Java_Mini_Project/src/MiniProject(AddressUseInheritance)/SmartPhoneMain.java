package MiniProjectFour;

import java.util.Scanner;

public class SmartPhoneMain {
	public static void main(String[] args) {

		SmartPhone smartphone = new SmartPhone();
		Scanner in = new Scanner(System.in);

//		System.out.println("#2개의 데이터를 입력하세요.");
//		for(int i =0; i<2; i++) {
//			smartphone.addAddr(smartphone.inputContactData());
//		}

		while (true) {
			printMenu();
			String selectMenu = in.nextLine();

			if (selectMenu.equals("1")) {
				System.out.println("회사 연락처를 등록합니다.");
				smartphone.addAddr(smartphone.inputData("회사"));
			} else if (selectMenu.equals("2")) {
				System.out.println("거래처 연락처를 등록합니다.");
				smartphone.addAddr(smartphone.inputData("거래처"));
			} else if (selectMenu.equals("3")) {
				smartphone.printAllAddr();
			} else if (selectMenu.equals("4")) {
				System.out.println("검색하고자 하는 이름을 입력해주세요.");
				smartphone.searchAddr(in.nextLine());
			} else if (selectMenu.equals("5")) {
				System.out.println("삭제하고자 하는 이름을 입력해주세요.");
				smartphone.deleteAddr(in.nextLine());
			} else if (selectMenu.equals("6")) {
				System.out.println("수정하고자 하는 이름을 입력해주세요.");
				String name = in.nextLine();
				smartphone.searchAddr(name);
				System.out.println("이동하실 그룹을 입력해주세요.");
				String group = in.nextLine();
				System.out.println("새로운 정보를 입력해주세요.");
				smartphone.editAddr(name, smartphone.inputData(group));
			} else if (selectMenu.equals("7")) {
				System.out.println("그룹의 정보 전체를 출력합니다.");
				smartphone.printGroup();
			} else if (selectMenu.equals("8")) {
				System.out.println("프로그램을 종료합니다.");
				return;
			} else {
				System.out.println("잘못된 메뉴입니다. 다시 선택해주세요.");
			}
		}

	}

	public static void printMenu() {
		System.out.println("주소관리 메뉴-------------");
		System.out.println(">>1. 회사 연락처 등록");
		System.out.println(">>2. 거래처 연락처 등록");
		System.out.println(">>3. 모든 연락처 출력");
		System.out.println(">>4. 연락처 검색");
		System.out.println(">>5. 연락처 삭제");
		System.out.println(">>6. 연락처 수정");
		System.out.println(">>7. 선택 그룹 연락처 출력");
		System.out.println(">>8. 프로그램 종료");
		System.out.println("---------------------");
	}
}
