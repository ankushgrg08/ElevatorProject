package com.elevator.operator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElevatorOperationApplication {
	
	static int lift1;
	static int lift2;


	public static void main(String[] args) {
		SpringApplication.run(ElevatorOperationApplication.class, args);
		

	       
        lift1 = (int)(Math.random()*10 +1);
        lift2 = (int)(Math.random()*10 +1);

        System.out.println("The elevator1 is now on floor " +lift1);
        System.out.println("The elevator2 is now on floor " +lift2);
        System.out.print("Which floor are you at now (0-10) where 0 = basement: ");
        
        try
        {
        	Scanner sc= new Scanner(System.in);
            int current_floor= sc.nextInt();
            
            final int dist1 = Math.abs(current_floor - lift1);
            final int dist2 = Math.abs(current_floor - lift2);
            
            if(lift1 == current_floor & lift2 == current_floor)
            {	
            	System.out.println("Both the lifts are on same floor\n Please enter which lift you want to choose 1 or 2");
            	
            	
            	Scanner sc2= new Scanner(System.in);
                int userinput= sc2.nextInt();
                if(userinput == 1)
                {
                	System.out.println("Please enter into the lift1");
                	System.out.println("To which floor would you want to go (0-10) where 0 = basement");
                    Scanner sc3= new Scanner(System.in);
                    int target_floor= sc3.nextInt();
                    Movelift1Elevator(target_floor);
                }
                else if(userinput ==2)
                {	
                	System.out.println("Please enter into the lift2");
                	System.out.println("To which floor would you want to go (0-10) where 0 = basement");
                    Scanner sc3= new Scanner(System.in);
                    int target_floor= sc3.nextInt();
                    Movelift2Elevator(target_floor);
                }
                else
                {
                	System.out.println("Please enter a valid integer value 1 or 2");
                }
                
            }
            else if (dist1 < dist2) {
               // posA = current_floor;
            	Movelift1Elevator(current_floor);
            	System.out.println("To which floor would you want to go (0-10) where 0 = basement");
                Scanner sc1= new Scanner(System.in);
                int target_floor= sc1.nextInt();
                Movelift1Elevator(target_floor);
            } else if (dist1 == dist2) {
                if (lift1 < lift2) {
                	Movelift1Elevator(current_floor);
                	System.out.println("To which floor would you want to go (0-10) where 0 = basement");
                    Scanner sc1= new Scanner(System.in);
                    int target_floor= sc1.nextInt();
                    Movelift1Elevator(target_floor);
                } else {
                	Movelift2Elevator(current_floor);
                	System.out.println("To which floor would you want to go (0-10) where 0 = basement");
                    Scanner sc1= new Scanner(System.in);
                    int target_floor= sc1.nextInt();
                    Movelift2Elevator(target_floor);
                }
            } else {
               // pos2 = current_floor;
            	Movelift2Elevator(current_floor);
            	System.out.println("To which floor would you want to go (0-10) where 0 = basement");
                Scanner sc1= new Scanner(System.in);
                int target_floor= sc1.nextInt();
                Movelift2Elevator(target_floor);
            }
        }catch(Exception e){
        	//
        }
        
    }
	

    public static void Movelift1Elevator(int target_floor)
    {
        int direction;
        int count =0;
        if( target_floor > lift1 )
        {
            System.out.println("The elevator1 is on it's way up...");
            direction = 1;
        }else{
            System.out.println("The elevator1 is on it's way down...");
            direction = -1;
        }

        while(target_floor != lift1)
        {
        	lift1 += direction;
            System.out.println(lift1);
            count++;
        }
        System.out.println("The elevator1 has arrived");
        System.out.println("Elevator1 moved number of floor " +count);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        System.out.print("Elevator moved datetime ");
        System.out.println(dtf.format(now));
    }
    
    public static void Movelift2Elevator(int target_floor)
    {
        int direction;
        int count =0;
        if( target_floor > lift2 )
        {
            System.out.println("The elevator2 is on it's way up...");
            direction = 1;
        }else{
            System.out.println("The elevator2 is on it's way down...");
            direction = -1;
        }

        while(target_floor != lift2)
        {
        	lift2 += direction;
            System.out.println(lift2);
            count++;
        }
        System.out.println("The elevator2 has arrived");
        System.out.println("Elevator2 moved number of floor " +count);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        System.out.print("Elevator moved datetime ");
        System.out.println(dtf.format(now));
    }
}
