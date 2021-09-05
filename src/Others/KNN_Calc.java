package Others;


public class KNN_Calc 
{

	Data[] db=new Data[2000];
	int knn;
	
	double t1;
    double t2;
    double t3;
    double t4;
    double t5;
    double t6;
    double t7;
    
    double dist;
    double sum;
    int folddata;	
   	int foldno;
   	
    double acc=0.0;
 	double avg=0.0;
   	
   	int c3,c4;
    double[][] arr = new double[2000][2];
    
    	
	public KNN_Calc(Data[] db,int knn,double a, double b,double c, double d,double e, double f,double g)
	{
		this.db=db;
		this.knn=knn;
		this.t1=a;
		this.t2=b;
		this.t3=c;
		this.t4=d;
		this.t5=e;
		this.t6=f;
		this.t7=g;
	}
	
		
	public KNN_Calc(int fold,Data[] db,int knn, int folddata,int a, int b)
	{
		this.foldno=fold;
		this.db=db;
        this.knn=knn;
		this.folddata=folddata;
		this.c3=a;
		this.c4=b;
	}
	
	public double[][] sort(double[][]arr1,int n)
	{
	        for(int i = 0; i<n; i++)
	        {         
	                arr1[i][0]=Math.pow((double)arr1[i][0],-1);
	              
	        }
		 return arr1;
	}
	
	
	public void print()
	{
		 for(int i1=0;i1<2000;i1++)
			{   
			    dist=0.0;
			    
			    dist=Math.sqrt((db[i1].getWs1()-t1)*(db[i1].getWs1() -t1)
						        +(db[i1].getWs2()-t2)*(db[i1].getWs2() -t2)
					    		+(db[i1].getWs3()-t3)*(db[i1].getWs3()-t3)
								+(db[i1].getWs4()-t4)*(db[i1].getWs4()-t4)
								+(db[i1].getWs5()-t5)*(db[i1].getWs5()-t5)
								+(db[i1].getWs6()-t6)*(db[i1].getWs6()-t6)
								+(db[i1].getWs7()-t7)*(db[i1].getWs7()-t7));
			    		  
			    
			    
			    arr[i1][0]=dist;
			    arr[i1][1]=db[i1].getRoom_no();
			}
		 
		 java.util.Arrays.sort(arr, new java.util.Comparator<double[]>() {
             public int compare(double[] a, double[] b) {
                 return Double.compare(a[0], b[0]);
             }
         });
		 
		     arr=sort(arr,2000);
	        
	        Double[] value = new Double[4]; 
			 
			 for (int ik = 0; ik < value.length; ik++) {
				    value[ik] = (double) 0;
				}
			 
	        
	        for(int i=0;i<knn;i++)
	        {
	        	if(arr[i][1]==1.0)
	        	{
	        		value[0]=value[0]+arr[i][0];	        		
	        	}
	        		
	        	
	        	else if(arr[i][1]==2.0)
	        	{
	        		value[1]=value[1]+arr[i][0];
	        	}	
	        	
	        	else if(arr[i][1]==3.0)
	        	{
	        		value[2]=value[2]+arr[i][0];
	        	}
	        	
	        	else if(arr[i][1]==4.0)
	        	{
	        		value[3]=value[3]+arr[i][0];
	        	}
	        	
	        }
	        
	       
            if (value[0] > value[1])
            {  
                if (value[0] > value[2]) 
                {  
                    if (value[0] > value[3])
                    {  
                    	 System.out.println("Room number is: 1");  
                    }  
                    else
                    {  
                    	 System.out.println("Room number is: 4");  
                    }  
                }  
            }  
            else if (value[1] > value[2]) 
            {  
                if (value[1] > value[3])
                {  
                	 System.out.println("Room number is: 2");  
                }  
                else 
                {  
                	 System.out.println("Room number is: 4");  
                }  
            }  
            else if (value[2] > value[3])
            {  
            	 System.out.println("Room number is: 3");  
            }  
            else 
            {  
            	 System.out.println("Room number is: 4");  
            }  
	        		
	}
	
	
	
	public double accuracy()
	{
		 double r;
		 double[][]brr=new double[1600][2];
		 sum=0;
		 int c;
		 
		 for(int i=c3;i<c4;i++)
			{
				r=0.0;
				c=0;
		 
		 for(int i1=0;i1<2000;i1++)
			{   
			    dist=0.0;
				if(i1<c3 || i1>=c4)
				{
				 				
				   dist=Math.sqrt(
						          ((db[i1].getWs1()-db[i].getWs1())*(db[i1].getWs1()-db[i].getWs1()))+
						          ((db[i1].getWs2()-db[i].getWs2())*(db[i1].getWs2()-db[i].getWs2()))+
						          ((db[i1].getWs3()-db[i].getWs3())*(db[i1].getWs3()-db[i].getWs3()))+
						          ((db[i1].getWs4()-db[i].getWs4())*(db[i1].getWs4()-db[i].getWs4()))+
						          ((db[i1].getWs5()-db[i].getWs5())*(db[i1].getWs5()-db[i].getWs5()))+
						          ((db[i1].getWs6()-db[i].getWs6())*(db[i1].getWs6()-db[i].getWs6()))+
						          ((db[i1].getWs7()-db[i].getWs7())*(db[i1].getWs7()-db[i].getWs7())));
						             
						         
				   brr[c][0]=dist;
			       brr[c][1]=db[i1].getRoom_no();
			       c++;
				   			   
				}
								
			 }
		 
       
         java.util.Arrays.sort(brr, new java.util.Comparator<double[]>()
         {
             public int compare(double[] a, double[] b) 
             {
                 return Double.compare(a[0], b[0]);
             }
         });
		 
		 brr=sort(brr,1600);
	       
		 Double[] value = new Double[4]; 
		 
		 for (int ik = 0; ik < value.length; ik++)
		 {
			    value[ik] = (double) 0;
		 }
		 
        
        for(int il=0;il<knn;il++)
        {
        	if(brr[il][1]==1.0)
	        	{
	        		value[0]=value[0]+brr[il][0];	        		
	        	}
	        		
	        	
	        	else if(brr[il][1]==2.0)
	        	{
	        		value[1]=value[1]+brr[il][0];	        	   
	        	}	
	        	
	        	else if(brr[il][1]==3.0)
	        	{
	        		value[2]=value[2]+brr[il][0];	        	  
	        	}
	        	
	        	else if(brr[il][1]==4.0)
	        	{
	        		value[3]=value[3]+brr[il][0];        	 
	        	}
          }
           
           
         if (value[0] > value[1])
         {  
                if (value[0] > value[2]) 
                {  
                    if (value[0] > value[3])
                    {  
                    	 r=1;  
                    }  
                    else 
                    {  
                    	 r=4;  
                    }  
                }  
            }  
         
            else if (value[1] > value[2])
            {  
                if (value[1] > value[3])
                {  
                	 r=2; 
                }  
                else
                {  
                	 r=4;  
                }  
            }  
            else if (value[2] > value[3])
            {  
            	  r=3;
            }  
            else
            {  
            	 r=4;
            }  
        
        
        if(r==db[i].getRoom_no())
		 {
			 sum=sum+1;
		 }	 
	   }	
		
		 avg=sum/folddata; 
		 return avg;
	
      }

   }
	
	

	
	
	
