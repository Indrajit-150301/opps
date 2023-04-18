import java.util.*;

class ATM{
	float Balance;
	int PIN = 5674;
	
	public void checkpin(){
		System.out.println("Enter your pin:");
		Scanner sc=new Scanner(System.in);
		int enteredpin = sc.nextInt();
		if(enteredpin==PIN){
			menu();
		}
		else{
				System.out.println("Invalid pin");
		}
	}
	
	public void menu(){
		System.out.println("Enter your choice");
		System.out.println("1.Check  A/C Balance");
		System.out.println("2.Withdraw Money");
		System.out.println("3.Deposote Money");
		System.out.println("4.Exit");
		
		Scanner sc= new Scanner(System.in);
		int option = sc.nextInt();
		
		switch(option){
			case 1:
				checkBalance();
				break;
			case 2:
				withdrawMoney();
				break;
			case 3:
				depositeMoney();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
		}
	}
	
		public void checkBalance(){
			System.out.println("Balance :" + Balance);
			menu();
		}
		
		public void withdrawMoney(){
			System.out.println("Enter the amount to withdraw");
			Scanner sc = new Scanner(System.in);
			float  amount = sc.nextFloat();
			if(amount>Balance){
				System.out.println("Insufficient Balance!!!");
			}
			else
			{
				Balance=Balance-amount;
				System.out.println("Money Withdraw Successfully");
			}
			menu();
		}
		
		public void  depositeMoney(){
			System.out.println("Enter the amount: ");
			Scanner sc = new Scanner(System.in);
			float amount = sc.nextFloat();
			Balance =Balance + amount;
			System.out.println("Money deposited Successfully");
			menu();
		}
}

	public class bank{
		public static void main(String []args){
			ATM obj= new ATM();
			obj.checkpin();
		}
	}


