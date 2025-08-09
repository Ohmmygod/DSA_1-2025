package Lab05.pack;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN_670764 {
	private static Pattern pattern = Pattern.compile("-
	?\\d+(\\.\\d+)?");
	public static boolean isNumeric(String strNum) {
	if (strNum == null)
	return false;
	return pattern.matcher(strNum).matches();
	}
	public static double computeRPN(String rpn) {
	/* your code */
	return stack.pop();
}
}
