import java.util.*;

public class Main {
    static void reverseDisplayLoop(int n){
        while(n > 0){
            int newnum = n/10;
            System.out.print(n - newnum*10);
            n = newnum;
        }
        System.out.println("");
    }
    static void reverseDisplayRecursion(int n){
        if(n > 0){
            int dig = (int)(Math.pow(10,(int)Math.log10(n)));
            int firstnum = n/dig;
            reverseDisplayRecursion(n - (firstnum * dig));
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
