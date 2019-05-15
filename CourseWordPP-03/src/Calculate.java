import java.util.*;

public class Calculate {
	
	public int fnlOvrlAvg=0;
	
	//calculating final marks of the components
	//using switch to calculate different component marks
	public int calFinalMrk(String type,int sComp1, int sComp2, int sComp3){
		double sComp3F;
		int finalMrk=0;
		switch(type){
			case "Pro01Ict":sComp3F=(sComp3/5.0)*100.0; 
						  	finalMrk = (int)Math.round(sComp1*0.2 + sComp2*0.7 + sComp3F*0.1);
						break;
						
			case "CaIct":sComp3F=(sComp3/4.0)*100.0; 
						 finalMrk = (int)Math.round(sComp1*0.5 + sComp2*0.4 + sComp3F*0.1);
						break;
						
			case "Pro02Ict":sComp3F=(sComp3/3.0)*100.0;  
							finalMrk = (int)Math.round(sComp1*0.6 + sComp2*0.3 + sComp3F*0.1);
						break;
						
			default:
		
		}
		
		return finalMrk;
		
		
	}
	
	//calculation of class average for different components using switch
	public int calClassAvg(String type){
		int total=0;
		int count=0;
		int avgPro01Ict,avgCaIct,avgPro02Ict;
		int fnlAvg = 0;
		
		switch(type){
			case "avgPro01" :for(Student record : Menu.recordList){
								if(record.isDeferredComp01()){
									continue;
								}
								total+=record.getFnlPro01Ict();
								count++;
							 }
							 avgPro01Ict=total/count;
							 fnlAvg=avgPro01Ict;
							break; 
							
			case "avgCa" :for(Student record : Menu.recordList){
							if(record.isDeferredComp02()){
								continue;
							}
							total+=record.getFnlCaIct();
							count++;
			 			  }
			 			  avgCaIct=total/count;
			 			  fnlAvg=avgCaIct;
			 			   break;
			 			   
			case "avgPro02" :for(Student record : Menu.recordList){
								if(record.isDeferredComp03()){
									continue;
								}
								total+=record.getFnlPro02Ict();
								count++;
				 		  }
				 		  avgPro02Ict=total/count;
				 		  fnlAvg=avgPro02Ict;
				 		  break;
			default:	 	
		
		}
		
		return fnlAvg;
		
	}
	
	
	//calculation of final overall mark
	public int calOvrlFinalMrk(int mComp1, int mComp2, int mComp3){
		int finalMrk=(int)Math.round(mComp1*0.3 + mComp2*0.35 + mComp3*0.35);
		return finalMrk;
		
	}
	
	//calculation of overall class average
	public int calOvrlClassAvg(){
		int total=0;
		int count=0;
		
		for(Student record : Menu.recordList){
			if(record.isDeferred()){
				continue;
			}
			total+=record.getFnlOvrlMark();
			count++;
		}
		fnlOvrlAvg=total/count;
		
		return fnlOvrlAvg;
		
	}
	
	//checking whether less than average
	public boolean lessThanAvg(){
		boolean lessThanAvg = false;
		Student record = new Student();
		if(!record.isDeferred() && (fnlOvrlAvg>record.getFnlOvrlMark()) ){
			lessThanAvg=true;
		}
		return lessThanAvg;
		
	}
	
	//choosing high scorers
	public static int highScoreIndex(String type){
		int high=0;
		int index = 0;
		int indexFound=0;
		switch(type){
			case "Comp01":for(Student record : Menu.recordList){
								if(record.getFnlPro01Ict()>high){
									high=record.getFnlPro01Ict();
									indexFound=index;
									
								}
								index++;
						  }
						break;
			case "Comp02":for(Student record : Menu.recordList){
								if(record.getFnlCaIct()>high){
									high=record.getFnlCaIct();
									indexFound=index;
								}
								index++;
			 			  }
						break;
			case "Comp03":for(Student record : Menu.recordList){
								if(record.getFnlCaIct()>high){
									high=record.getFnlCaIct();
									indexFound=index;
								}
								index++;
						  }
						break;
		}
		
		return indexFound;
		
		
		
	}
	
	
}
