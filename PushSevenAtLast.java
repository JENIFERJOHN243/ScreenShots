package task;

public class PushSevenAtLast {

	public static void main(String[] args) {
		int[] array = {1, 9, 8, 4, 7, 7, 2, 0, 7, 6, 7};
		//int[] array = {3, 7, 3, 7, 3, 7, 3, 7};
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 7) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				j++;
				}
			}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			}
		}
	}
