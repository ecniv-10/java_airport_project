import java.util.Scanner;

public class airport {
    public static void main(String[] args) throws Exception {
        airplane airplane1 = new airplane();
        airplane airplane2 = new airplane("AAA02", 15.8, 128, 30000);
        
        System.out.println("Enter the details of the third airplane (call-sign, distance, bearing and altitude):");
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        String callSign = input.nextLine();  // Read user input
        double distance = input.nextDouble();  // Read user input
        int bearing_3 = input.nextInt();
        int altitude_3 = input.nextInt();


        airplane airplane3 = new airplane(callSign.toUpperCase(), distance, bearing_3, altitude_3);

        System.out.println(airplane3);
        System.out.println("\nInitial Positions:");
        System.out.println("\"Airplane 1\": " + airplane1);
        System.out.println("\"Airplane 2\": " + airplane2);
        System.out.println("\"Airplane 3\": " + airplane3);

        System.out.println("\nInitial Distances:");
        System.out.println("The distance between Airplane 1 and Airplane 2 is " + airplane1.distTo(airplane2) + " miles.");
        System.out.println("The distance between Airplane 1 and Airplane 3 is " + airplane1.distTo(airplane3) + " miles.");
        System.out.println("The distance between Airplane 2 and Airplane 3 is " + airplane2.distTo(airplane3) + " miles.");

        System.out.println("\nInitial Height Differences:");
        System.out.println("The difference in height between Airplane 1 and Airplane 2 is " + 
                            Math.abs(airplane1.getAlt() - airplane2.getAlt()) + " feet.");
        System.out.println("The difference in height between Airplane 1 and Airplane 3 is " + 
                            Math.abs(airplane1.getAlt() - airplane3.getAlt()) + " feet.");
        System.out.println("The difference in height between Airplane 2 and Airplane 3 is " + 
                            Math.abs(airplane3.getAlt() - airplane2.getAlt()) + " feet.");



        //Increaase alt of airplane1 by 3000ft
        airplane1.gainAlt();
        airplane1.gainAlt();
        airplane1.gainAlt();

        System.out.println("\nNew Positions:");
        System.out.println("\"Airplane 1\": " + airplane1);
        System.out.println("\"Airplane 2\": " + airplane2);





    }
}
