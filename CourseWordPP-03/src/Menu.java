import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
	//creating array list
	public static ArrayList<Student> recordList = new ArrayList<Student>();
	public static int COUNT =0;
	
	
	public static void main(String[] args) {
		menu();//running menu
	}
	
	public static void menu(){
		//display menu options
		System.out.println(" Main Menu");
		System.out.println("-----------");
		System.out.println("1. Enter Student Record");
		System.out.println("2. Display Students\'s Final Marks");
		System.out.println("3. Display students with marks below 40 for components");
		System.out.println("4. Display Overall Class average");
		System.out.println("5. Display students with marks below class average");
		System.out.println("6. Display high scorers for each component");
		System.out.println("7. Display the details of retake students");
		System.out.println("8. Display re-sit students");
		System.out.println("9. Display Graded student list");
		System.out.println("00. Exit");
		
		//getting input
		System.out.println("Press the number to choose...");
		Scanner userIn = new Scanner(System.in);
		Validate val = new Validate();
		
		String Choice;
		
		
		do{
			Choice = userIn.nextLine();
			if(Choice.equals("00")){
				System.out.println("Exiting...");
				System.exit(0);
			}
		}while(!val.validate("input", Choice));
		
		if(!Choice.equals("1")&&COUNT==0){
			System.err.println("Please enter records first");
			Choice="1";
		}
		
		
		System.out.println();
		
		Report rpt = new Report();
		
		//switching to the choosen number by the user 
		switch(Choice){
			
			case "1":rpt.setInfo();
					break;
			case "2":rpt.getInfo(2);
					break; 
			case "3":rpt.getInfo(3);
			break; 
			
			case "4":rpt.getInfo(4);
			break; 
			
			case "5":rpt.getInfo(5);
			break; 
			
			case "6":rpt.getInfo(6);
			break; 
			
			case "7":rpt.getInfo(7);
			break; 
			
			case "8":rpt.getInfo(8);
			break; 
		
			case "9":rpt.getInfo(9);
			break;
			
			default:
		
		}
		
	}

}
