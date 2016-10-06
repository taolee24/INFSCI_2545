package hw2;
import java.util.Random;

public class Visitor {
	int num=0;
	String identify;
	String[] type={"Student","Professor","Business Person","Blogger"};
	public Visitor(){
		
	}
	
	public void setNum(int num){
		if (num<=5 && num>0){
		this.num=num;}
	}
		public int getNum(){
		return num;
	}
	public void setType(Random ran){
		this.identify=type[ran.nextInt(4)];
	}
	
	public void setType(String a){
		 if (a.equals("Student") || a.equals("Professor") || a.equals("Business Person") ||a.equals("Blogger"))
		this.identify=a;
	}

	public String getType(){
		return identify;
	}
	
}
