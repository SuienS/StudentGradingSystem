import java.util.*;

public class Report {
	//ANSWER FOR THE 2 QUESTION 
	//setting information
	public void setInfo(){
		
		Scanner sc = new Scanner(System.in);
		
		Validate val = new Validate();//creating object from Validate class
		
		String nameFirst,nameLast,regNo,age,Pro01,Ict01,Pro01AP,Ca,Ict02,CaAP,Ict03,Pro02,Pro02AP,exit;
		//getting the information from the user
		//check if validated using Validate class
		do{

			Menu.recordList.add(new Student());

			do{
				System.out.println("Enter Registration Number(7-digit):-");
				regNo=sc.nextLine();

			}while(!val.validate("regNo", regNo));
			Menu.recordList.get(Menu.COUNT).setRegNo(regNo);


			do{
				System.out.println("Enter Student First Name");
				nameFirst=sc.nextLine();
			}while(!val.validate("Name", nameFirst));
			Menu.recordList.get(Menu.COUNT).setNameFirst(nameFirst);


			do{
				System.out.println("Enter Student Last Name");
				nameLast=sc.nextLine();
			}while(!val.validate("Name", nameLast));
			Menu.recordList.get(Menu.COUNT).setNameLast(nameLast);

			
			do{
				System.out.println("Enter Student Age");
				age=sc.nextLine();
			}while(!val.validate("age", age));
			Menu.recordList.get(Menu.COUNT).setAge(age);

			do{
				System.out.println("Enter Student's Project 01 Marks(Enter \'M\' if Mitigated)");
				Pro01=sc.nextLine();
				
			}while(!val.validate("marks",Pro01));
			if(!Pro01.matches("[0-9]+")&&Pro01.toUpperCase().equals("M")){
				Pro01="0";
				Menu.recordList.get(Menu.COUNT).setDeferredComp01(true); //getting deferred
			}
			Menu.recordList.get(Menu.COUNT).setPro01_I(Pro01);


			do{
				System.out.println("Enter Student's ICT 01 Marks(Enter \'M\' if Mitigated)");
				Ict01=sc.nextLine();
			}while(!val.validate("marks",Ict01));
			if(!Ict01.matches("[0-9]+")&&Ict01.toUpperCase().equals("M")){
				Ict01="0";
				Menu.recordList.get(Menu.COUNT).setDeferredComp01(true); //getting deferred
			}
			Menu.recordList.get(Menu.COUNT).setIct01_I(Ict01);

			do{
				System.out.println("Enter Student's Attendence from week 01 to week 05 in Days");
				Pro01AP=sc.nextLine();
			}while(!val.validate("days5",Pro01AP));
			Menu.recordList.get(Menu.COUNT).setPro01AP_I(Pro01AP);

			do{
				System.out.println("Enter Student's Marks for Coding Assignment(press \'M\' if Mitigated)");
				Ca=sc.nextLine();
			}while(!val.validate("marks",Ca));
			if(!Ca.matches("[0-9]+")&&Ca.toUpperCase().equals("M")){
				Ca="0";
				Menu.recordList.get(Menu.COUNT).setDeferredComp02(true); //getting deferred
			}
			Menu.recordList.get(Menu.COUNT).setCa_I(Ca);

			do{
				System.out.println("Enter Student's Marks for ICT 02(Enter \'M\' if Mitigated)");
				Ict02=sc.nextLine();
			}while(!val.validate("marks",Ict02));
			if(!Ict02.matches("[0-9]+")&&Ict02.toUpperCase().equals("M")){
				Ict02="0";
				Menu.recordList.get(Menu.COUNT).setDeferredComp02(true); //getting deferred
			}
			Menu.recordList.get(Menu.COUNT).setIct02_I(Ict02);


			do{
				System.out.println("Enter Student's Attendence from week 06 to week 09 in Days");
				CaAP=sc.nextLine();
			}while(!val.validate("days4",CaAP));
			Menu.recordList.get(Menu.COUNT).setCaAP_I(CaAP);

			do{
				System.out.println("Enter Student's Marks for ICT 03(Enter \'M\' if Mitigated)");
				Ict03=sc.nextLine();
			}while(!val.validate("marks",Ict03));
			if(!Ict03.matches("[0-9]+")&&Ict03.toUpperCase().equals("M")){
				Ict03="0";
				Menu.recordList.get(Menu.COUNT).setDeferredComp03(true);
			}
			Menu.recordList.get(Menu.COUNT).setIct03_I(Ict03);

			do{
				System.out.println("Enter Student's Marks for Project 02(Enter \'M\' if Mitigated)");
				Pro02=sc.nextLine();
			}while(!val.validate("marks",Pro02));
			if(!Pro02.matches("[0-9]+")&&Pro02.toUpperCase().equals("M")){
				Pro02="0";
				Menu.recordList.get(Menu.COUNT).setDeferredComp03(true);
			}
			Menu.recordList.get(Menu.COUNT).setPro02_I(Pro02);

			do{
				System.out.println("Enter Student's Attendence from week 10 to week 12 in Days");
				Pro02AP=sc.nextLine();
			}while(!val.validate("days3",Pro02AP));
			Menu.recordList.get(Menu.COUNT).setPro02AP_I(Pro02AP);

			Menu.COUNT++;

			System.out.println("If you want to enter another record press \'Y\' or press any other to go to menu.");
			exit = sc.nextLine();
		}while(exit.equals("Y")||exit.equals("y"));
		
		Menu.menu();
				
	}
	
	
	//displaying information got from the user after necessary calculations
	public void getInfo(int choice){
		int count =0;
		Calculate calc = new Calculate();
		Scanner sc = new Scanner(System.in);
		String scan;
		switch(choice){
		
		//ANSWER FOR THE 5TH QUESTION
		case 2:for(Student record:Menu.recordList){
				System.out.println("Regitraton Number:-");
				System.out.println(record.getRegNo());
				System.out.println("Name:-");
				System.out.println(record.getNameFirst()+" "+record.getNameLast());
				System.out.println("Age:-");
				System.out.println(record.getAge());
				System.out.println("Final Mark:-");
				System.out.println(record.getFnlOvrlMark());
				System.out.println("Grade:-");
				if(record.getGrade().equals(Grade.n)){
					System.out.println("-not awarded-");
				}else{
					System.out.println(record.getGrade());
				}
				System.out.println();
				
			   }
			   System.out.println("press 0 to go to menu or any to exit");
			   scan = sc.nextLine();
			   if(scan.equals("0")){
				   Menu.menu();
			   }
			   
			break;
		
		//ANSWER FOR THE 4TH QUESTION
		case 3:System.out.println("Students with marks below 40 for Project 01 with ICT");
				count=0;
				for(Student record:Menu.recordList){
					if(record.isLess40Comp01()){
					count++;
					System.out.println("Regitraton Number:-");
					System.out.println(record.getRegNo());
					System.out.println("Name:-");
					System.out.println(record.getNameFirst()+" "+record.getNameLast());
					System.out.println("Marks:-");
					System.out.println(record.getFnlPro01Ict());
					System.out.println();
					}
		       }
				if(count==0){
					System.out.println("No one has got blow 40 for this component");
				}
				
			   System.out.println("Students with marks below 40 for Coding Assignment with ICT");
			   count=0;
			   for(Student record:Menu.recordList){
					if(record.isLess40Comp02()){
						count++;
						System.out.println("Regitraton Number:-");
						System.out.println(record.getRegNo());
						System.out.println("Name:-");
						System.out.println(record.getNameFirst()+" "+record.getNameLast());
						System.out.println("Marks:-");
						System.out.println(record.getFnlCaIct());
						System.out.println();
					}
			   }
			   if(count==0){
					System.out.println("No one has got blow 40 for this component");
				}
			   
			   System.out.println("Studentss with marks bwlow 40 for Project 02 with ICT");
			   count=0;
			   for(Student record:Menu.recordList){
					if(record.isLess40Comp03()){
						count++;
						System.out.println("Regitraton Number:-");
						System.out.println(record.getRegNo());
						System.out.println("Name:-");
						System.out.println(record.getNameFirst()+" "+record.getNameLast());
						System.out.println("Marks:-");
						System.out.println(record.getFnlPro02Ict());
						System.out.println();
					}
			   }
			   if(count==0){
					System.out.println("No one has got blow 40 for this component");
				}
			   System.out.println("press 0 to go to menu or any to exit");
			   scan = sc.nextLine();
			   if(scan.equals("0")){
				   Menu.menu();
			   }
			   
			break;
			
		//ANSWER FOR THE 6TH QUESTION	
		case 4: System.out.println("Overall class average for the MODULE is: "+calc.calOvrlClassAvg());
				System.out.println();
		//ANSWER FOR THE 3RD QUESTION 		
				System.out.println("--Sub component averages--");
				System.out.println("Class average for the PROJECT 01 WITH ICT is: "+calc.calClassAvg("avgPro01"));
				System.out.println();
				
				System.out.println("Class average for the CODING ASSIGNMENT WITH ICT is: "+calc.calClassAvg("avgCa"));
				System.out.println();
				
				System.out.println("Class average for the PROJECT 02 WITH ICT is: "+calc.calClassAvg("avgPro02"));
				System.out.println();
				
				
		
				System.out.println("press 0 to go to menu or any to exit");
				scan = sc.nextLine();
				if(scan.equals("0")){
					Menu.menu();
				}
		   
			break;
		//ANSWER FOR THE 7TH QUESTION	
		case 5:System.out.println("--Students with marks falls below Class averge--");
			   for(Student record:Menu.recordList){
				   if(record.isLessThanAvg()){
					   System.out.println("Registration Number:-");
					   System.out.println(record.getRegNo());
					   System.out.println("Name:-");
					   System.out.println(record.getNameFirst()+" "+record.getNameLast());
					   System.out.println("Marks:-");
					   System.out.println(record.getFnlOvrlMark());
					   System.out.println();
				   }
			   }
			   System.out.println("press 0 to go to menu or any to exit");
			   scan = sc.nextLine();
			   if(scan.equals("0")){
				   Menu.menu();
			   }
			   
			break;
			
		//ANSWER FOR THE 8TH QUESTION	
		case 6:int index;
			   System.out.println("--Highest scorer for Project 01 with ICT--");
			   index = Calculate.highScoreIndex("Comp01");
			   System.out.println("Registration No:-");
		       System.out.println(Menu.recordList.get(index).getRegNo());
		       System.out.println("Name:-");
		       System.out.println(Menu.recordList.get(index).getNameFirst()+" "+Menu.recordList.get(index).getNameLast());
		       System.out.println("Marks:-");
		       System.out.println(Menu.recordList.get(index).getFnlPro01Ict());
		       System.out.println();
			
		       
		       System.out.println("--Highest scorer for Coding Assignment with ICT--");
			   index = Calculate.highScoreIndex("Comp02");
			   System.out.println("Registration No:-");
		       System.out.println(Menu.recordList.get(index).getRegNo());
		       System.out.println("Name:-");
		       System.out.println(Menu.recordList.get(index).getNameFirst()+" "+Menu.recordList.get(index).getNameLast());
		       System.out.println("Marks:-");
		       System.out.println(Menu.recordList.get(index).getFnlCaIct());
		       System.out.println();
		       
		       
		       System.out.println("--Highest scorer for Project 02 with ICT--");
			   index = Calculate.highScoreIndex("Comp03");
			   System.out.println("Registration No:-");
		       System.out.println(Menu.recordList.get(index).getRegNo());
		       System.out.println("Name:-");
		       System.out.println(Menu.recordList.get(index).getNameFirst()+" "+Menu.recordList.get(index).getNameLast());
		       System.out.println("Marks:-");
		       System.out.println(Menu.recordList.get(index).getFnlPro02Ict());
		       System.out.println();
		       
		       System.out.println("press 0 to go to menu or any to exit");
			   scan = sc.nextLine();
			   if(scan.equals("0")){
				   Menu.menu();
			   }
			   
			   break;
		       
	//ANSWER FOR THE 9TH QUESTION
		case 7: System.out.println("--Re-Take Stdents--");
				count=0;
		   		for(Student record:Menu.recordList){
		   			if(record.isReTake()){
		   				count++;
		   				System.out.println("Regitraton Number:-");
						System.out.println(record.getRegNo());
		   				System.out.println("Name:-");
		   				System.out.println(record.getNameFirst()+" "+record.getNameLast());
		   				System.out.println("Marks:-");
		   				System.out.println(record.getFnlOvrlMark());
		   				System.out.println();
		   			}
		   			if(count==0){
	   					System.out.println("No Student found for Re-Take");
	   				}
		   		}
		   		
		   		System.out.println("press 0 to go to menu or any to exit");
				   scan = sc.nextLine();
				   if(scan.equals("0")){
					   Menu.menu();
				   }
				   
		   		break;
		//ANSWER FORTHE 10TH QUESTION
		case 8: Collections.sort(Menu.recordList, Student.ComparatorStuLname);//
				System.out.println("--Re-Sit Stdents for Qualifing set 01--");
				count=0;
   				for(Student record:Menu.recordList){
   					if(record.isReSitQS01()){
   						count++;
   						System.out.println("Regitraton Number:-");
   						System.out.println(record.getRegNo());
   						System.out.println("Name:-");
   						System.out.println(record.getNameFirst()+" "+record.getNameLast());
   						System.out.println("Marks for Qualifing Set 01:-");
   						System.out.println(record.getQS01mrk());
   						System.out.println();
   					}
   				}
   				if(count==0){
   					System.out.println("No Student found for Re-Sit for Qualifing Set 01");
   				}
   				
   				
   				System.out.println("--Re-Sit Stdents for Project 02 with ICT--");
				count=0;
				Collections.sort(Menu.recordList, Student.ComparatorStuLname);

   				for(Student record:Menu.recordList){
   					if(record.isReSitComp03()){
   						count++;
   						System.out.println("Regitraton Number:-");
   						System.out.println(record.getRegNo());
   						System.out.println("Name:-");
   						System.out.println(record.getNameFirst()+" "+record.getNameLast());
   						System.out.println("Marks for Project 02 with ICT:-");
   						System.out.println(record.getFnlPro02Ict());
   						System.out.println();
   					}
   				}
   				if(count==0){
   					System.out.println("No Student found for Re-Sit for Project 02 with ICT");
   				}
   				
   				System.out.println("press 0 to go to menu or any to exit");
 			   scan = sc.nextLine();
 			   if(scan.equals("0")){
 				   Menu.menu();
 			   }
 			   
   				break;
   		//ANSWER FOR THE 11TH QUESTION	
		case 9:	System.out.println("--Graded Student List--");
				Collections.sort(Menu.recordList, Student.ComparatorStuFnlMrk);
				
				System.out.println("-Higher Distinction-");
				for(Student record:Menu.recordList){
					if(!record.isDeferred() && record.getGrade().equals(Grade.HD)){
						System.out.println("Regitraton Number:-");
						System.out.println(record.getRegNo());
						System.out.println("Name:-");
						System.out.println(record.getNameFirst()+" "+record.getNameLast());
						System.out.println("Marks:-");
						System.out.println(record.getFnlOvrlMark());
						System.out.println();
					}
				}
				System.out.println();
				
				System.out.println("-Distinction-");
				for(Student record:Menu.recordList){
					if(!record.isDeferred() && record.getGrade().equals(Grade.D)){
						System.out.println("Regitraton Number:-");
						System.out.println(record.getRegNo());
						System.out.println("Name:-");
						System.out.println(record.getNameFirst()+" "+record.getNameLast());
						System.out.println("Marks:-");
						System.out.println(record.getFnlOvrlMark());
						System.out.println();
					}
				}
				System.out.println();
				
				System.out.println("-Credit-");
				for(Student record:Menu.recordList){	
					if(!record.isDeferred() && record.getGrade().equals(Grade.C)){
						System.out.println("Regitraton Number:-");
						System.out.println(record.getRegNo());
						System.out.println("Name:-");
						System.out.println(record.getNameFirst()+" "+record.getNameLast());
						System.out.println("Marks:-");
						System.out.println(record.getFnlOvrlMark());
						System.out.println();
					}
				}
				System.out.println();
				
				System.out.println("-Pass-");
				for(Student record:Menu.recordList){
					if(!record.isDeferred() && record.getGrade().equals(Grade.S)){
						System.out.println("Regitraton Number:-");
						System.out.println(record.getRegNo());
						System.out.println("Name:-");
						System.out.println(record.getNameFirst()+" "+record.getNameLast());
						System.out.println("Marks:-");
						System.out.println(record.getFnlOvrlMark());
						System.out.println();
					}
				}
				
				System.out.println("press 0 to go to menu or any to exit");
				   scan = sc.nextLine();
				   if(scan.equals("0")){
					   Menu.menu();
				   }
				   
				break;
				
				default:
   		 
		}
		
		
	}

			
}


