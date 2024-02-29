package miniproject_selection_sort;

import java.util.List;

public class SelectSort {
	int count = 1;

	public void add(List<Integer> list, int[] i) {
		for (int j = 0; j < i.length; j++) {
			list.add(i[j]);
		}
	}

	public int min(List<Integer> list, int n) {
		int min = 10000;
		for (int i = n; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
			}

		}
		return min;

	}

	public void selectionSort(List<Integer> list, int n) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > min(list, i)) {
				int b = list.get(i);
				int idx = list.indexOf(min(list, i));
				list.set(i, min(list, i));
				list.set(idx, b);
				System.out.print((n + 1) + "단계   : ");
				for (int j = 0; j < list.size(); j++) {
					System.out.print(list.get(j) + "  ");

				}
				n++;
				System.out.println();
			}
			
		}
	}

}
