package hw2;

import java.util.Random;

public class CitySim9002 {
	
	static String[] location={"The Cathedral of Learning","Squirrel Hill","The Point","Downtown","left"};

	public boolean placelike(Visitor people,String loc){
		if(people.getType()=="Student"){
			if(loc=="The Cathedral of Learning")
				return false;
			else
				return true;
		}
		if(people.getType()=="Professor"){
			if(loc=="left the city")
				return false;
			else
				return true;
		}
		if(people.getType()=="Business Person"){
			if(loc=="Squirrel Hill"||loc=="Downtown")
				return true;
			else
				return false;
		}
		
		if(people.getType()=="Blogger")
			return false;
		else
			return false;
	}	

	public String output(Visitor n, String l){
		if(placelike(n,l)){
			return "Visitor "+n.getNum()+" did like "+l+".";
		}
		else{
			return "Visitor "+n.getNum()+" did not like "+l+".";
		}
	}

	public void visiting(Visitor n,Random ran) {
		String l=location[ran.nextInt(5)];
		while(l=="left the city"){
			l=location[ran.nextInt(5)];
		}
		while(l!="left the city"){
			System.out.println("Visitor "+n.getNum()+" is going to "+l+"!");
			System.out.println(output(n,l));
			l=location[ran.nextInt(5)];
		}
		System.out.println("Visitor "+n.getNum()+" has "+l);
	}
	
	
	public boolean checkInput(String a)
	{
	    try{
	        Integer.parseInt(a);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}

	public static void main(String[] args){
		CitySim9002 city=new CitySim9002();
		if(args.length!=1||!city.checkInput(args[0])){
			System.out.println("Please enter one integer argument, seed");
			System.exit(0);
		}
		System.out.println("Welcome to CitySim!	Your seed is "+args[0]+".");
		Random ran=new Random(Long.parseLong(args[0]));
		for(int i=1;i<=5;i++){
			Visitor person=new Visitor();
			person.setNum(i);
			person.setType(ran);
			System.out.println("Visitor "+person.getNum()+" is a "+person.getType());
			city.visiting(person,ran);
			System.out.println("***");
		}
	}
}