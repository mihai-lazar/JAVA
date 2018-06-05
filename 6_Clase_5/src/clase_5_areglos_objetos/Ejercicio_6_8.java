package clase_5_areglos_objetos;

public class Ejercicio_6_8 {
	
	public static void main(String[] args) {
		System.out.println(prod(1, 4));
	}
	
	public static int prod(int m, int n) {
		if (m == n) {
			return n;
		} else {
			int recurse = prod(m, n - 1);
			int result = n * recurse;
			return result;
		}
	}

}

	/**
	public static int prod(int 1, int 3) {
		if (m == n) {
			return n;
		} else {
			int recurse = prod(m, n - 1);
			int result = n * recurse;
			return result;
		}
	}

	public static int prod(int 1, int 2) {
		if (m == n) {
			return n;
		} else {
			int recurse = prod(m, n - 1);
			int result = n * recurse;
			return result;
		}
	}

	public static int prod(int 1, int 1) {
		if (m == n) {
			return n;
		} else {
			int recurse = prod(m, n - 1);
			int result = n * recurse;
			return result;
		}
	}
	 */