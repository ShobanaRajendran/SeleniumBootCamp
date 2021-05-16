package javaCodingChallenge;

public class ReverseTheInteger {

	public static void main(String[] args) {
		// Reverse the Integer
		
		int n=123456;
		int reverse=0;
		int temp=0;
		while(n!=0)
		{
			
			temp=n%10;
			reverse=reverse*10+temp;
			n=n/10;
		}
		System.out.println(reverse);

	}

}
