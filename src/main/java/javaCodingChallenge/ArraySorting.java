package javaCodingChallenge;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraySorting {
	public static boolean validateArray(String[] a, String[] b)
	{ 
		boolean result;
		if(Arrays.equals(a, b)) {
			System.out.println("True");
			result=true;
		}
		else
		{	System.out.println("False");
			result=false;}
		return result;
		
	}

	public static void main(String[] args) {

	// Java Coding Challenge
	//Validate Given Array is sorted or not
	//If sorted function should return true else false
		
		
		String[] str =new String[]{"asda","sdfs","asdf","qwe","zxcv","wewer","poiut"};
		String[] compare=new String[]{"asda","sdfs","asdf","qwe","zxcv","wewer","poiut"};
		String[] str2 = new String[str.length];//=str;
		  System.arraycopy(str, 0, str2, 0, str.length);

		//Arrays.copyOf(str)
		Arrays.sort(str);
		validateArray(str,compare);
		validateArray(str,str2);
		for (String string : str2) {
			System.out.println(string);
		}
		for (String string : compare) {
			System.out.println(string);
		}
	}

}
