package miniproject_bubble_sort;



public class BubbleSortMain {

	public static void main(String[] args) {
		BubbleSort sort2 = new BubbleSort();
		int[] intList = {69,10,30,2,16,8,31,22};
			
		System.out.print("Input Data :");
		for(int i=0 ; i<intList.length;i++) { System.out.print(intList[i]+" ");}
		System.out.println();
		sort2.bubbleSort(intList);
		
		}
				
	}


