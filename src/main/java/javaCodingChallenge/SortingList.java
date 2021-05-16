package javaCodingChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;

public class SortingList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Arrays str= new Arrays();
		String array[]= {"Shobana","Saarah","Karthick","Baba","Pappu"};//<String> list= new ArrayList();
		Arrays.sort(array);
		
		List<String> listToSort= new ArrayList();
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		
			

	}

}