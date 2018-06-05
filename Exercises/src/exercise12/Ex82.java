package exercise12;

public class Ex82 {
	
	public static int banana(int[] a) {
		int kiwi = 1;
		int i = 0;
		while (i < a.length) {
			kiwi = kiwi * a[i];
			i++;
		}
		return kiwi;
	}
	//Kiwi has the value of 1, and for each number on the array multiply that number to the value of kiwi and that is the new value of kiwi, the return it.
	
	public static int grapefruit(int[] a, int grape) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == grape) {
				return i;
			}
		}
		return -1;
	}
	//checks every value of the array, if that value is the same as the value of grape, return i (the value of the index in the array), at the end return -1.	

	public static int pineapple(int[] a, int apple) {
		int pear = 0;
		for (int pine: a) {
			if (pine == apple) {
					pear++;
			}
		}
		return pear;
	}
    //for each element (pine) in the array a, if the element (pine) is has the same value as apple, we sum 1 to the value of pear, at the end return pear.

}
