import java.util.*;

public class Main {
    static void reverseDisplayLoop(int n){
        //Takes a number as an input and prints it backwards
        //loops and prints the first digit in the number, while the number is greater than 0
        while(n > 0){
            //creates a new number by dividing the number by ten, and truncating it to an integer.   125 -> 12.5 -> 12
            int newnum = n/10;
            //prints the number minus the new number times 10.   125 - 12(10) = 5 which is the last number.
            System.out.print(n - newnum*10);
            //Sets the number to the new number.   number = 12
            n = newnum;
            //Then it repeats until the number is 0.   (12 -> 1.2 -> 1,  12 - 1(10) = 2,  number = 1) (1 -> 0.1 -> 0,  1 - 0(10) = 1, number = 0)  end loop
        }
        System.out.println("");
    }
    static void reverseDisplayRecursion(int n){
        //Takes a number as an input and prints it backwards recursively
        //checks if the number is greater than zero, this is the end condition of the recursion
        if(n > 0){
            //Finds the number of digits and creates a power of ten with the same number of digits.   log(125) -> 2.0969 -> 2,  10^2 = 100
            int dig = (int)(Math.pow(10,(int)Math.log10(n)));
            //Finds the first number by dividing the number by the power of ten, and then truncating it into an integer. 125/100 -> 1.25 -> 1
            int firstnum = n/dig;
            //Repeats this process with the first number removed. 125 - 1(100) = 25
            reverseDisplayRecursion(n - (firstnum * dig));
            //Prints the first number, as this is after the recursion call, this will be printed last.
            System.out.print(firstnum);

        }
    }
    static void reverseDisplaySLoop(String s){
        for(int i = s.length()-1; i >= 0; i--){
            System.out.print(s.charAt(i));
        }
        System.out.println("");
    }
    static void reverseDisplaySRecursion(String s){
        if(1 < s.length()){
            reverseDisplaySRecursion(s.substring(1));
        }
        System.out.print(s.charAt(0));
    }
    static int intinput(int max){
        System.out.println("Please enter input");
        Scanner input = new Scanner(System.in);
        while(true) {
            String choiceS = input.nextLine();
            try{
                int choice = Integer.parseInt(choiceS);
                if((max == -1) || ((choice > 0) && (choice <= max))){
                    return choice;
                } else{
                    System.out.println("Invalid integer input");
                }
            }catch(Exception e){
                System.out.println("Input is not an integer");
            }
        }
    }
    static String strinput(){
        System.out.println("Please enter input");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        return choice;
    }
    public static void main(String[] args){
        while(true){
            //conveys options to the user, as well as the inputs associated with them
            System.out.println("Please select an option");
            System.out.println("1: Reverse integer");
            System.out.println("2: Reverse integer recursively");
            System.out.println("3: Reverse string");
            System.out.println("4: Reverse string recursively");
            //Takes user input
            int choice = intinput(4);
            //performs the desired operation depending on user input
            if(choice == 1){
                reverseDisplayLoop(intinput(-1));
            }else if (choice == 2) {
                reverseDisplayRecursion(intinput(-1));
                System.out.println("");
            }else if (choice == 3) {
                reverseDisplaySLoop(strinput());
            }else {
                reverseDisplaySRecursion(strinput());
                System.out.println("");
            }
        }
    }
}
