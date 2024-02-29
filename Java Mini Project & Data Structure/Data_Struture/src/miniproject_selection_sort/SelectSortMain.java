package miniproject_selection_sort;

import java.util.ArrayList;
import java.util.List;

public class SelectSortMain {

	public static void main(String[] args) {
		int[] list = {69,10,30,2,16,8,31,22};
		
		List<Integer> intList = new ArrayList<>();
		SelectSort sort = new SelectSort();
		sort.add(intList, list);		
		System.out.print("INPUT DATA :");
		for(int i=0 ; i<intList.size(); i++) {
		System.out.print(intList.get(i)+"  ");
	}
		System.out.println();
	
		sort.selectionSort(intList, 0);
				
	}

} 
