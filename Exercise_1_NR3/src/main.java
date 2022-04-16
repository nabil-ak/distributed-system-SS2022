import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		for(String word: line.split(" ")) {
			set.add(word);
		}
		
		Iterator iter = set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
