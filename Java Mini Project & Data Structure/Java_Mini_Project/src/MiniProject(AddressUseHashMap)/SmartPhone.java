package MiniProjectFive;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class SmartPhone {
	Map<String, Addr> map = new HashMap<String, Addr>();
	Scanner in;
	int numOfCount = 0;

	public SmartPhone() {

		in = new Scanner(System.in);

	}

	public Addr inputData() {

		System.out.print("핸드폰 번호를 입력하세요. ");
		String phoneNum = in.nextLine();
		System.out.print("이름을 입력해주세요. ");
		String name = in.nextLine();
		System.out.print("번호를 입력해주세요. ");
		String num = in.nextLine();
		System.out.print("이메일을 입력해주세요. ");
		String email = in.nextLine();
		System.out.print("주소를 입력해주세요. ");
		String address = in.nextLine();
		System.out.print("그룹을 입력해주세요. ");
		String group = in.nextLine();

		return new Addr(phoneNum, name, num, email, address, group);

	}

	public void addAddr(Addr addr) {
			
		if(addr.equals(map.get(addr.getPhoneNum()))) {
			System.out.println("중복---------------");
			addAddr(inputData());
			return;
		}
		
		map.put(addr.getPhoneNum(), addr);
		System.out.println("데이터가 저장되었습니다. (" + map.size() + ")");
	}

	public void printAddr(Addr addr) {
		System.out.println("-------------------");
		System.out.println("전화번호 : " + addr.getPhoneNum());
		System.out.println("이름 : " + addr.getName());
		System.out.println("번호 : " + addr.getNum());
		System.out.println("이메일 : " + addr.getEmail());
		System.out.println("주소 : " + addr.getAddress());
		System.out.println("그룹(친구/가족) : " + addr.getGroup());
		System.out.println("-------------------");
	} 

	public void printAllAddr() {

		Set<Map.Entry<String, Addr>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Addr>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Map.Entry<String, Addr> entry = entryIterator.next();
			String key = entry.getKey();
			Addr value = entry.getValue();
			printAddr(value);
		}
	}

	public void searchAddr(String name) {
			
		Set<Map.Entry<String, Addr>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Addr>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Map.Entry<String, Addr> entry = entryIterator.next();
			Addr value = entry.getValue();
			if (value.getName().contentEquals(name)) {
				printAddr(value);
				return;
			}
		}

	}

	public void deleteAddr(String name) {

		Set<Map.Entry<String, Addr>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Addr>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Map.Entry<String, Addr> entry = entryIterator.next();
			Addr value = entry.getValue();
			if (value.getName().contentEquals(name)) {
				String key = entry.getKey();
				map.remove(key);
			}
		}
	}

	public void editAddr(String name, Addr newData) {
		Set<Map.Entry<String, Addr>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Addr>> entryIterator = entrySet.iterator();
		while (entryIterator.hasNext()) {
			Map.Entry<String, Addr> entry = entryIterator.next();
			Addr value = entry.getValue();
			if (value.getName().contentEquals(name)) {
				String key = entry.getKey();
				value = map.put(key, newData);
				return;
			}
		}
	}

}
