package javaCodingChallenge;

import java.util.HashMap;

public class StringCompress {

	public static void main(String[] args) {
		// String Compress
		//aaaabbcd
		String str="aaaabbcd";
		HashMap<Character,Integer> map=new HashMap();
		//STep1
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
		String compress="";
		for (char ch : map.keySet()) {
			compress=compress+ch+map.get(ch);
		}
		System.out.println("The Compressed String is "+compress);

	}

}
