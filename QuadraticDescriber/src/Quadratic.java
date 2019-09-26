/*
Nathan Cohn
9/17/19

*/

public class Quadratic {
	/*
	 Must return the direction it opens, the vertex, and the intercepts
	 */
	public static String quadrDescriber(double a, double b, double c) {
		String openDirection;
		if(a < 0) {
			openDirection = "Down";
		} else {
			openDirection = "Up";
		}
		
		double vertexX = round2((-b)/(2 * a));
		double vertexY = round2(a * square(vertexX)) + (b * vertexX) + c;
		String vertex = "(" + vertexX + ", " + vertexY + ")";
		
		String xIntercepts = quadForm(a, b, c);
		String equation = "y = " + a + "x^2 + " + b + "x + " + c;
			
		return "Description of the graph of:\n" + equation + "\n\nOpening direction: " + openDirection + "\nAxis of Symmetry: " + vertexX + "\nVertex: " + vertex + "\nx-intercept(s): " + xIntercepts + "\ny-intercept: " + c;
	}
	
	public static double yValue(double a, double b, double c, double xValue) {
		return (a * square(xValue)) + (b * xValue) + c;
	}
	
	public static String toCoordinate(double x, double y) {
		return "(" + x + ", " + y + ")";
	}
	
	public static double absValue(double num) {
		if(num < 0) {
			return -num;
		} else {
			return num;
		}
	}
	
	public static double square(double squared) {
		return exponent(squared, 2);
	}
	
	public static double exponent(double num, int power) {
		if (power < 0) {
			return exponent(1/num, (int) absValue(power));
		}
		double numToPower = num;
		for (int i = 1; i <= power - 1; i++) {
			numToPower *= num;
		}
		return numToPower;
	}
	
	public static double sqrt(double numToRoot) {
		if (numToRoot < 0) {
			throw new IllegalArgumentException("The number you input must be positive");
		}
		return findRoot(numToRoot, 2);
	}
	
	public static double findRoot(double numToRoot, int rootBy) {
		if(numToRoot < 0) {
			throw new IllegalArgumentException("Input must be positive");
		} else {
		double root = 0;
		while(exponent(root, rootBy) <= numToRoot) {
			root += 0.001;
		}
		return round2(root);
		}
	}
	
	public static String foil(int a, int b, int c, int d, String var) {
		String part1 = (a * c) + var + "^2";
		String part2 = " + " + ((a * d) + (b * c)) + var;
		String part3 = " + " + (b * d);
		return part1 + part2 + part3;
	}
	
	public static double round(double a, int decimalPlace) {
		a *= exponent(10, decimalPlace);
		if (a < 0) {
			a -= 0.5;
		} else {
			a += 0.5;
		}
		a = (int) a;
		a /= exponent(10, decimalPlace);
		return a;
	}
	
	public static double round2(double a) {
		return round(a, 2);
	}
	
	public static double discriminant(double a, double b, double c) {
		return square(b) - (4 * a * c);
	}
	
	public static String quadForm(double a, double b, double c) {
		double dis = discriminant(a, b, c);
		if (dis < 0) {
			return "no real roots";
		}

		double root1 = round2(((-b) - sqrt(dis)) / (2 * a));
		if (dis == 0) {
			return root1 + "";
		}

		double root2 = round2(((-b) + sqrt(dis)) / (2 * a));
		return root1 + " and " + root2;
	}
}