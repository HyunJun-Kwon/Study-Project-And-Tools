package MiniProjectFour;

import java.util.Scanner;
import java.util.*;

public class SmartPhone {

	List<Addr> list;
	int numOfCount = 0;
	Scanner in;

	public SmartPhone() {
		list = new ArrayList<Addr>();
		in = new Scanner(System.in); // 이것이랑 위에 필드에 한번에 선언하는 것과의 차이점
	}

	public Addr inputData(String value) {
		System.out.print("이름 : ");
		String name = in.nextLine();
		System.out.print("전화번호 : ");
		String phoneNumber = in.nextLine();
		System.out.print("이메일 : ");
		String email = in.nextLine();
		System.out.print("주소 : ");
		String address = in.nextLine();
		System.out.print("그룹(회사/거래처/가족) : ");
		String group = in.nextLine();
		if (value.contentEquals("회사")) {
			System.out.print("회사이름 : ");
			String companyName = in.nextLine();
			System.out.print("부서 : ");
			String department = in.nextLine();
			System.out.print("직급 : ");
			String position = in.nextLine();

			return new CompanyAddr(name, phoneNumber, email, address, group, companyName, department, position);
		} else {
			System.out.print("거래처이름 : ");
			String customerName = in.nextLine();
			System.out.print("거래품목 : ");
			String trsItem = in.nextLine();
			System.out.print("직급 : ");
			String position = in.nextLine();

			return new CustomerAddr(name, phoneNumber, email, address, group, customerName, trsItem, position);
		} 
	}

//	배열에 연락처 객체 저장
	public void addAddr(Addr addr) {

		list.add(addr);

		System.out.println(">>>데이터가 저장되었습니다.(" + list.size() + ")");
	}

	public void printAddr(Addr addr) {
		if (addr instanceof CompanyAddr) {
			addr.printinfo();
		} else {
			addr.printinfo();
		}

	}

	// 모든 연락처 출력
	public void printAllAddr() {
		for (int i = 0; i < list.size(); i++) {
			printAddr(list.get(i));
		}
	}

	// 연락처 검색
	public void searchAddr(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contentEquals(name)) {
				printAddr(list.get(i));
				return;
			}
		}
		System.out.println("검색 결과가 없습니다.");
	}

	// 연락처 삭제
	public void deleteAddr(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contentEquals(name)) {
				list.remove(list.get(i));
			}
		}

	}

	// 연락처 수정
	public void editAddr(String name, Addr newContact) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contentEquals(name)) {

				list.remove(i);
				list.add(i, newContact);
//				}

			}
		}

	}

	public void printGroup() {
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i) instanceof CompanyAddr) {
				System.out.println("회사");
				printAddr(list.get(i));
			} 
			
			if(list.get(i) instanceof CustomerAddr) {
				System.out.println("거래처");
				printAddr(list.get(i));
			}
		}
	}

}
