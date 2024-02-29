package miniproject_bubble_sort;

public class BubbleSort {
	public void bubbleSort(int[] list) {
		int number = 1;

		for (int i = number; i < list.length; i++) {

			for (int j = 0; j < list.length - number; j++) {
				System.out.println("Sorted Data : " + number + "단계 :");

				for (int k = 0; k < list.length - number; k++) {

					if (list[k] > list[k + 1]) {
						int a = list[k];
						list[k] = list[k + 1];
						list[k + 1] = a;

					}
					for (int l = 0; l < list.length; l++) {
						System.out.print(list[l] + "\t");

					}
					System.out.println();
				}
				number++;
				System.out.println();
			}

		}
	}
}
