package javaCodingChallenge;

import java.util.HashMap;
import java.util.Iterator;

public class OccurencesOfCharacterInString {

	public static void main(String[] args) {
		// Occurences of Char in a string
		
		String str="abracadabra";
		
		HashMap<Character,Integer> map=new HashMap();
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(!map.containsKey(ch))
			{
				map.put(ch, 1);
			}
			else
			{
				int temp;
				temp=map.get(ch);
				map.put(ch, temp+1);
		
			}
		}
		
		for(char ch:map.keySet())
		{
			System.out.println(ch+"  "+map.get(ch));
		}
		for(int	ch:map.values())
		{
			System.out.println(ch+"  "+map.get(ch));
		}

}
}
