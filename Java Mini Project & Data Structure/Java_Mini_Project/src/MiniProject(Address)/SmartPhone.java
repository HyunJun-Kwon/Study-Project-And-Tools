package MiniProjectOne;

import java.util.Scanner;
import java.util.*;

public class SmartPhone {

	Addr[] addrs;
	Scanner in;
	int numOfCount = 0;
	

	public SmartPhone() {
		addrs = new Addr[10];
		in = new Scanner(System.in);
		
	}

	public Addr inputData() {
		System.out.print("이름 : ");
		String name = in.nextLine();
		System.out.print("전화번호 : ");
		String phoneNum = in.nextLine();
		System.out.print("이메일 : ");
		String email = in.nextLine();
		System.out.print("주소 : ");
		String address = in.nextLine();
		System.out.print("그룹(친구/가족) : ");
		String group = in.nextLine();

		return new Addr(name, phoneNum, email, address, group);
	}

	public void addAddr(Addr addr) {
		addrs[numOfCount] = addr;
		numOfCount++;
		System.out.println(">>>데이터가 저장되었습니다. (" + numOfCount + ")");
	}

	public void printAddr(Addr addr) {
		System.out.println("-------------------");
		System.out.println("이름 : " + addr.getName());
		System.out.println("전화번호 : " + addr.getPhoneNum());
		System.out.println("이메일 : " + addr.getEmail());
		System.out.println("주소 : " + addr.getAddress());
		System.out.println("그룹(친구/가족) : " + addr.getGroup());
		System.out.println("-------------------");
	}

	public void printAllAddr() {
		for (int i = 0; i < numOfCount; i++) {
			printAddr(addrs[i]);
		}
	}

	public void searchAddr(String name) {
		for (int i = 0; i < numOfCount; i++) {
			Addr addr = addrs[i];
			System.out.println(addr);
			if(addr.getName().contentEquals(name)) {
				printAddr(addr);
				return;
			}
		}
		System.out.println("검색 결과가 없습니다.");
	}

	public void deleteAddr(String name) {
		for (int i = 0; i < numOfCount; i++) {
			Addr addr = addrs[i];
			if (addr.getName().contentEquals(name)) {
				for (int j = i; j < numOfCount; j++) {
					addrs[j] = addrs[j + 1];	
				}
				numOfCount--;
				return;
			}
		}
		System.out.println("검색 결과가 없습니다.");
	}

	public void editAddr(String name, Addr newData) {
		for (int i = 0; i < numOfCount; i++) {
			if (addrs[i].getName().contentEquals(name)) {
				addrs[i] = newData;
				return;
			}
		}
	}

}
