package javaCodingChallenge;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JaVaTojAvA {

	public static void main(String[] args) {
		// To find the case of the char and convert it 
		String str="JaVa", str1="",temp="";
		for (Character  ch : str.toCharArray()) {
		//	ch.isLowerCase(ch)
		
			Character ch2=ch;
			if(ch2>='A'&&ch2<='Z')
			{
				temp=temp+ch2.toLowerCase(ch2);				
			}
			else if(ch2>='a'&&ch2<='z')
			{
				temp=temp+ch2.toUpperCase(ch2);
			}
			str1=temp;
		}
		System.out.println(str1);
		
		

	}

}
