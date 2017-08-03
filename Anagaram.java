import java.util.*;

public class Anagaram{
	private static Map<Character, Integer> frequencyMap(String str)
	{
		Map<Character, Integer> main = new HashMap<Character,Integer>();
		for(int i = 0; i < str.length(); i++){
			if (str.charAt(i) != ' ') {
				if (main.containsKey(str.charAt(i))) {
					main.put(str.charAt(i), main.get(str.charAt(i) + 1));
				} else {
					main.put(str.charAt(i), 1);
				}
			}
		}
		return main;
	}
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Main or Parent String");
		String parent = sc.nextLine();
		System.out.println("Enter The Sub String");
		String sub = sc.nextLine();
		String temp = sub;
		if(parent.length()<sub.length()){
			sub = parent;
			parent = temp;
		}
		boolean b = true;
		for(int i = 0; i <= parent.length() - sub.length() && b; i++){
			String checkSub = parent.substring(i, i + sub.length());
			boolean d = frequencyMap(checkSub).equals(frequencyMap(sub));
			if(d){
				System.out.println(checkSub);
				System.out.println("Yes String has an Anagaram");
				b = false;
			}
		}
	}
}
