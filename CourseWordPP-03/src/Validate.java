

public class Validate {
	public boolean validate(String type,String data){
		boolean validity = false;
		int marks;
		
		//validity checking of user inputted data
		
		//using a switch to validate diffrent kinds of data
		
		switch(type){
		
			case "input": if(data.matches("[0-9]+") && (data.length()==1) ){
							validity=true;
						  }
						  else{
							  System.err.println("Invalid Choice enter number from 1 to 9  ");
						  }
					break;
					
					
			case "regNo": //check if the Reg no is duplicated
						  boolean duplicated=false;
						  for (int y = 0;y<Menu.COUNT;y++) {
							  if(Menu.COUNT!=0 && data.equals(Menu.recordList.get(y).getRegNo())){
								  duplicated=true;
						  
							  	}
						  }
				
						  
						  if(data.matches("[0-9]+") && (data.length()==7) && !duplicated){  //validating reg that it has 7 digits
							validity=true;
						  }else if(duplicated){
							  System.err.println("You have entered an existing Student Number ");
							  System.err.println("Enter an diffrent Student's record ");
						  }else{
							  System.err.println("Invalid Registration number ");
						  }
			
						break;
						  
		
			case "Name" : if(data.matches("[a-zA-Z]+")){
						 	validity=true;
			  			  }else{
			  				  System.err.println("Invalid Character ");
			  			  }
						break;
			  
			case "marks": if(data.matches("[0-9]+")){
							marks=Integer.parseInt(data);
							if(marks>=0 && marks<=100){
					 		  	validity=true;
		  			 		}else{
		  			 			System.err.println("Invalid input. Please enter value from 0 to 100 ");
		  			 		}
						  }else{
							  if(data.matches("[a-zA-Z]+") && data.toUpperCase().equals("M")){  //validating 'M'for mitigation
								  validity=true;
							  }else{
								  System.err.println("Invalid input for marks. Enter an Integer ");
							  }
						  }
						  
						break;
						
						
			case "age": if(data.matches("[0-9]+")){
							validity=true;
						}else{
			  				System.err.println("Invalid input for age. Enter an Integer ");
			  			}
			  	         break;
			  	         
			  	         
			case "days5": if(data.matches("[0-9]+")){
							if(Integer.parseInt(data)<=5){
								validity=true;
							}else{
								System.err.println("Please enter integer from 0 to 5 ");
							}
						}else{
							System.err.println("Invalid input for Attendence in Days. Enter an Integer ");
						}
  	         			break;
  	         			
  	         			
			case "days4": if(data.matches("[0-9]+")){
							if(Integer.parseInt(data)<=4){
								validity=true;
							}else{
								System.err.println("Please enter integer from 0 to 4 ");
							}
						}else{
							System.err.println("Invalid input for Attendence in Days. Enter an Integer ");
						}
   						break;
   						
			case "days3": if(data.matches("[0-9]+")){
							if(Integer.parseInt(data)<=3){
								validity=true;
							}else{
								System.err.println("Please enter integer from 0 to 3 ");
							}
						}else{
							System.err.println("Invalid input for Attendence in Days. Enter an Integer ");
						}
						break;
			default: 
				
		
		}
	
		
		return validity;
		
	}

}
