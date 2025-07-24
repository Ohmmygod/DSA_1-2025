import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Dukdui obj1 = new Dukdui();
		Dukdui obj2 = new Dukdui();
		Dukdui obj3 = new Dukdui();
		Dukdui obj4 = new Dukdui();
		Dukdui obj5 = new Dukdui();

		obj1.data = 9;
		obj2.data = 2;
		obj3.data = 6;
		obj4.data = 5;
		obj5.data = 7;

		obj1.torpai = obj2;
		obj2.torpai = obj3;
		obj3.torpai = obj4;
		obj4.torpai = obj5;
		obj5.torpai = null;

		printList(obj1); // 9 2 6 5 7
		printList(obj3); // 6 5 7

		System.out.printf("The sum of list = %d\n", sumList(obj1)); // 29

		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int	enter = sc.nextInt();
		Dukdui obj6 = new Dukdui();
		obj6.data = enter;
		insertList(obj5, obj6);
		printList(obj1); // 9 2 6 5 7 enter
		
	}


	public static void  printList(Dukdui head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.torpai;
		}
		System.out.println();
	}

	public static int sumList(Dukdui head) {
		int	sum = 0;
		while (head != null) {
			sum += head.data;
			head = head.torpai;
		}
		return (sum);
	}

	public static void insertList(Dukdui tail, Dukdui newNum) {
		tail.torpai = newNum;
		newNum.torpai = null;
	}
}
