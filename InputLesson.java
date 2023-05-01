import java.util.Scanner;

public class InputLesson {
	public static void main(String[] args) {
		System.out.print("name ?");
		Scanner inputName = new Scanner(System.in); 
		String nameStr = inputName.nextLine();
		
		System.out.print("age ?");
		Scanner inputAge = new Scanner(System.in); 
		String ageStr = inputAge.nextLine();
		int age = Integer.parseInt(ageStr);
		
		System.out.println(nameStr + "さんは、80才まであと" + (80 - age) + "年です");
		
	}

}
