import java.util.Comparator;

public class Student{
	
	//creating needed private variables
	private String nameFirst,nameLast,regNo;
	private Grade grade;
	
	private int age,Pro01_I,Ict01_I,Pro01AP_I,Ca_I,Ict02_I,CaAP_I,Ict03_I,Pro02_I,Pro02AP_I;
	private int QS01mrk,fnlPro01Ict,fnlCaIct,fnlPro02Ict,fnlOvrlMark;
	private boolean less40Comp01,less40Comp02,less40Comp03,lessThanAvg,deferred,deferredComp01,deferredComp02,deferredComp03,reTake,reSit,reSitComp03,reSitQS01;
	
	
	//setters and getters
	Validate val = new Validate();
	public String getNameFirst() {
		return nameFirst;
	}
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}	
	
	public String getNameLast() {
		return nameLast;
	}
	public void setNameLast(String nameLast) {
		if(nameLast.matches("[a-zA-Z]+")){
			this.nameLast = nameLast;
			
		}else{
			System.out.println("erorrrStunameL");
		}
	}
	
	public String getRegNo() {
		return regNo;
	}
	
	public void setRegNo(String regNo) {
			this.regNo=regNo;
	}
	
	
	@Override
	public String toString() {
		return regNo; 
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = Integer.parseInt(age); //converting input to integer
		
	}
	public int getPro01_I() {
		return Pro01_I;
	}
	public void setPro01_I(String pro01_I) {
		this.Pro01_I = Integer.parseInt(pro01_I);  //converting input to integer
	}
	public int getIct01_I() {
		return Ict01_I;
	}
	public void setIct01_I(String ict01_I) {
		this.Ict01_I = Integer.parseInt(ict01_I);  //converting input to integer
	}
	public int getPro01AP_I() {
		return Pro01AP_I;
	}
	public void setPro01AP_I(String pro01ap_I) {
		this.Pro01AP_I = Integer.parseInt(pro01ap_I);  //converting input to integer
	}
	public int getCa_I() {
		return Ca_I;
	}
	public void setCa_I(String ca_I) {
		this.Ca_I = Integer.parseInt(ca_I);  //converting input to integer
	}
	public int getIct02_I() {
		return Ict02_I;
	}
	public void setIct02_I(String ict02_I) {
		this.Ict02_I = Integer.parseInt(ict02_I);  //converting input to integer
	}
	public int getCaAP_I() {
		return CaAP_I;
	}
	public void setCaAP_I(String caAP_I) {
		this.CaAP_I = Integer.parseInt(caAP_I);  //converting input to integer
	}
	public int getIct03_I() {
		return Ict03_I;
	}
	public void setIct03_I(String ict03_I) {
		this.Ict03_I = Integer.parseInt(ict03_I);  //converting input to integer
	}
	public int getPro02_I() {
		return Pro02_I;
	}
	public void setPro02_I(String pro02_I) {
		this.Pro02_I = Integer.parseInt(pro02_I);
	}
	public int getPro02AP_I() {
		return Pro02AP_I;
	}
	public void setPro02AP_I(String pro02ap_I) {
		this.Pro02AP_I = Integer.parseInt(pro02ap_I);
	}
	
	//getting qualifing set 01 marks
	public int getQS01mrk() {
		this.QS01mrk=(int) Math.round( ( (getFnlPro01Ict()*0.30 + getFnlCaIct()*0.35) /65)*100 ) ;
		return QS01mrk;
	}
	
	
	//deciding the grade
	public Grade getGrade() {
		if( !isDeferred() )
			if(getFnlOvrlMark()>=80){
				grade = Grade.HD;
			}else if (getFnlOvrlMark() >=70){
				grade = Grade.D;
			}else if(getFnlOvrlMark() >=60){
				grade = Grade.C;
			}else if(getFnlOvrlMark() >=50){
				grade = Grade.S;
			}else{
				grade = Grade.F;
			}
		else{
			grade = Grade.n;
		}
		return grade;
	}
	
	
	//decision making
	
	
	//setting deferred
	public boolean isDeferredComp01() {
		return deferredComp01;
	}
	public void setDeferredComp01(boolean deferredComp01) {
		this.deferredComp01 = deferredComp01;
	}
	
	
	
	public boolean isDeferredComp02() {
		return deferredComp02;
	}
	public void setDeferredComp02(boolean deferredComp02) {
		this.deferredComp02 = deferredComp02;
	}
	public boolean isDeferredComp03() {
		return deferredComp03;
	}
	public void setDeferredComp03(boolean deferredComp03) {
		this.deferredComp03 = deferredComp03;
	}
	
	
	
	public boolean isDeferred() {
		this.deferred=isDeferredComp01()||isDeferredComp02()||isDeferredComp03();
		return deferred;
	}
	
	
	//decision making(using Calculation class)
	
	
	//checking if less 40 for component
	public boolean isLess40Comp01() {
		if(getFnlPro01Ict()<40){
			less40Comp01=true;
		}
		return less40Comp01;
	}

	//checking if less 40 for component
	public boolean isLess40Comp02() {
		if(getFnlCaIct()<40){
			less40Comp02=true;
		}
		return less40Comp02;
	}

	//checking if less 40 for component
	public boolean isLess40Comp03() {
		if(getFnlPro02Ict()<40){
			less40Comp03=true;
		}
		return less40Comp03;
	}

	//checking if less than average for component
	public boolean isLessThanAvg() {
		this.lessThanAvg=cal.lessThanAvg();
		return lessThanAvg;
	}
	

	//deciding whether retake
	public boolean isReTake() {
		if(!isDeferred()&&getFnlOvrlMark()<50){
			reTake=true;
		}
		return reTake;
	}
	
	//deciding whether resit for component
	public boolean isReSitComp03() {
		if(!isDeferredComp03()&&!isReTake()&&(getFnlPro02Ict()<40)){
			reSitComp03=true;
		}
		return reSitComp03;
	}
	
	public boolean isReSitQS01() {
		if(!(isDeferredComp01()||isDeferredComp02()) && !isReTake() && (getQS01mrk() <40) ){
			reSitQS01=true;
		}
		return reSitQS01;
	}
	
	public boolean isReSit() {
		this.reSit=isReSitComp03()||isReSitQS01();
		return reSit;
	}
	



	//calculation part(using Calculation class)

	Calculate cal = new Calculate();
	
	public int getFnlPro01Ict() {
		if(!isDeferredComp01()){
			this.fnlPro01Ict = cal.calFinalMrk("Pro01Ict", Pro01_I, Ict01_I, Pro01AP_I);
		}else{
			this.fnlPro01Ict=0;
		}
		return fnlPro01Ict;
	}
	
	public int getFnlCaIct() {
		if(!isDeferredComp02()){
			this.fnlCaIct = cal.calFinalMrk("CaIct", Ca_I, Ict02_I, CaAP_I);
		}else{
			this.fnlCaIct=0;
		}
		return fnlCaIct;
	}
	
	public int getFnlPro02Ict() {
		if(!isDeferredComp03()){
			this.fnlPro02Ict = cal.calFinalMrk("Pro02Ict", Ict03_I, Pro02_I, Pro02AP_I);
		}else{
			this.fnlPro02Ict=0;
		}
		return fnlPro02Ict;
	}
	public int getFnlOvrlMark() {
		this.fnlOvrlMark = cal.calOvrlFinalMrk(getFnlPro01Ict(),getFnlCaIct(), getFnlPro02Ict());
		return fnlOvrlMark;
	}
	
	
	
	//sorting
	
	public static Comparator<Student> ComparatorStuLname = new Comparator<Student>() {
		//last name sorting
		public int compare(Student s1, Student s2) {
		   String StudentName1 = s1.getNameLast().toUpperCase();
		   String StudentName2 = s2.getNameLast().toUpperCase();

		   //ascending order
		   return StudentName1.compareTo(StudentName2);

		  
	    }
	};

	    //final mark sorting
	    public static Comparator<Student> ComparatorStuFnlMrk = new Comparator<Student>() {

		public int compare(Student s1, Student s2) {
			
		   int mrk1 = s1.getFnlOvrlMark();
		   int mrk2 = s2.getFnlOvrlMark();
		   
		  //decending order
		   return mrk2-mrk1;

	   }
	};
	
}


