package javaCodingChallenge;

public class ReverseTheString {

	public static void main(String[] args) {
		
		// Reverse the string
		//Step1
		String str="string", strrev= "";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			strrev=strrev+str.charAt(i);
		}
		System.out.println(strrev);
		//Step 2
		String rev="",str2="Shobana";
		StringBuffer buffer= new StringBuffer(str2);
		rev=buffer.reverse().toString();
		System.out.println("\n"+rev);
		//Step 3
		StringBuilder builder= new StringBuilder("SaarahKarthick");
		String reverse=builder.reverse().toString();
		System.out.println("\n"+reverse);
		//Step 4
		String s5="KSSLove";
		char[] s=s5.toCharArray();String srev="";int n=0;
		for (int k=s.length-1;k>=0;k--)
		{
			srev=srev+s[k];
			n++;
		}
		System.out.println(srev);
		
		
		
	}

}
