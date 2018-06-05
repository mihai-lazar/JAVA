package exercise11;

public class Ex71 {
	
	public static void main(String[] args) {
		loop(1);
	}
	
	public static void loop(int n) {
		int i = n;
		while (i > 1) {
			System.out.println(i);
			if (i % 2 == 0) {
				i = i / 2;
			} else {
				i = i + 1;
			}
		
		}
	}

}


/* 10 10
 * 5  10
 * 6  10
 * 3  10
 * 4  10
 * 2  10
 * 
 * The out put is
 * 10
 * 5
 * 6
 * 3
 * 4
 * 2
 * 
 * Yes, if the number is divisible by 2, divide it, if not it means that you have to sum 1 to the number, that makes it divisible by 2 (because if we sum 1 to a impair number
 * the resulting number will be pair), it will keep on going till the number is 2, and 2/2 is 1, and the while cicle will end.
 */
