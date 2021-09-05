package Others;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main
{
	public static void main(String[]args) throws FileNotFoundException, IOException
	{
		File file= new File("D:/test1.txt");
		int j=0;
		
		double ws1;
		double ws2;
		double ws3;
		double ws4;
		double ws5;
		double ws6;
		double ws7;
		
		int k=5;
		Double accuracy=0.0;
		
		System.out.println("Input signals");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("1st router signal:");
			ws1=sc.nextDouble();
			
			System.out.println("2nd router signal:");
			ws2=sc.nextDouble();
			
			System.out.println("3rd router signal:");
			ws3=sc.nextDouble();
			
			System.out.println("4th router signal:");
			ws4=sc.nextDouble();

			System.out.println("5th router signal:");
			ws5=sc.nextDouble();
			
			System.out.println("6th router signal:");
			ws6=sc.nextDouble();
			
			System.out.println("7th router signal:");
			ws7=sc.nextDouble();
		} 
		
		Data[] Db= new Data[2000];
		Data[] Db1= new Data[2000];
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
		  String st;
			
			while((st=br.readLine())!= null)
			{
				
				String[] s=st.split("\t");
				double foo1 =Double.parseDouble(s[0]);
				double foo2 =Double.parseDouble(s[1]);
				double foo3 =Double.parseDouble(s[2]);
				double foo4 =Double.parseDouble(s[3]);
				double foo5 =Double.parseDouble(s[4]);
				double foo6 =Double.parseDouble(s[5]);
				double foo7 =Double.parseDouble(s[6]);
				double foo8 =Double.parseDouble(s[7]);  
							
				Db[j]=new Data(foo1,foo2,foo3,foo4,foo5,foo6,foo7,foo8);
				
				j++;	
				
			 }
		}
		
		Random rand = new Random();  		
		 
		for (int i=0; i<2000; i++)
		{
		    int randomPosition = rand.nextInt(Db.length);
		    Db1[i] = Db[i];
		    Db[i] = Db[randomPosition];
		    Db[randomPosition] = Db1[i];
		}
		
		
		
		KNN_Calc c=new KNN_Calc(Db,k,ws1,ws2,ws3,ws4,ws5,ws6,ws7);
		c.print();
		
		
        int fold=5;
        int size=2000;      
	    int folddata=size/fold;
	  
	    Double []arr=new Double[fold];
	    
		for(int i=0;i<fold;i++)
		{
			KNN_Calc tr=new KNN_Calc(i,Db,k,folddata,i*folddata,i*folddata+folddata) ;
		    arr[i]=tr.accuracy();			
		}
		
		for(int i=0;i<fold;i++)
		{
			accuracy+=arr[i];
		}
		
		System.out.println("Accuracy: "+(accuracy/fold)*100 +"%");
			
		
	}
}
