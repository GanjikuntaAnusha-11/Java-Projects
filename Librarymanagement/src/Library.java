import java.util.*;

public class Library {
    public static void main(String[] args) {
        System.out.println("WELCOME TO LIBRARY");
        System.out.println("How can i help you?");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        HashSet<String> set = new HashSet<>();
        String[] parts = userInput.trim().split("[.+, !@#$%^&*~`]");
        for(int i=0;i<parts.length;i++) {
            set.add(parts[i]);
        }
        int userInput1 = 0;
        if(set.contains("looks") || set.contains("look") || set.contains("looking") || set.contains("get") || set.contains("want")) {
            userInput1 = 1;
        }
        else if(set.contains("return") || set.contains("give") || set.contains("back")) {
            userInput1 = 2;
        }
        else {
            System.out.println("enter valid information");
        }
        if(userInput1 == 1) {
            Books.lookingForBook();
        }
        else if(userInput1 == 2){
            Books.returnBook();
        }
        else {
            System.out.println("Enter a valid number");
        }
        sc.close();
    }
}