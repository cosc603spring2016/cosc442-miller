package bond;

public class JamesBond {
	public static Boolean bondRegex(String input){
		String pattern = "([(\\d)[(][)]]*)"+"[(]"+"([(\\d)[(][)]]*)"+"007"+"([(\\d)[(][)]]*)" +"[)]" + "([(\\d)[(][)]]*)";
		return input.matches(pattern);
	}
}
