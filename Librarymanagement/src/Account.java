import java.sql.SQLException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.*;

public class Account{
    private String accountId;
    private String accountPaid;
    Scanner sc = new Scanner(System.in);

    public Account() {

    }

    public Account(String accountId,Users user, Books book){
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public long lateFeeAmount(LocalDate returnDate, LocalDate userReturnDate) {
        long days = Math.abs(ChronoUnit.DAYS.between(returnDate, userReturnDate));
        if(returnDate.isAfter(userReturnDate) == false) {
            return 0;
        }
        if(days <= 3) {
            return days * 10;
        }
        if(days>3 && days<=7) {
            return 30 + ((days-3) * 20);
        }
        return 110 /*(30 + 4 * 20)*/+ ((days-7)*30);
    }
    
    public String getAccountPaid() {
        return accountPaid;
    }

    public void setAccountPaid(String paid) {
        accountPaid = paid;
    }

    public String mobileNocheck(String mobile){
        Pattern pattern = Pattern.compile("\\d{10}");
        Matcher match = pattern.matcher(mobile);
        boolean mobileCheck = match.matches();
        if(mobileCheck) {
            return "valid";
        }
        return "invalid";
    }
    public void bookrentalyes() {
        System.out.println("Would you like to rent this book? \"Yes\" or \"No\"");
        String s = sc.nextLine();
        if(s.equalsIgnoreCase("Yes")) {
            System.out.println("Enter book name");
            String userInput10 = sc.nextLine().trim();
            try {
                Database.databaseConnection();
                if(Database.bookCount(userInput10) <= 0) {
                    System.out.println("we are out of stock! Would you like to look for something else?");
                }
                else {
                    System.out.println("The rental period is 14 days, and the fee is 100.Let me know if you'd like to proceed!");
                    System.out.println("Enter YES or NO");
                    String userInput6 = sc.nextLine();
                    if(userInput6.trim().equalsIgnoreCase("YES")) {
                        System.out.println("Please tell about your details.");
                        System.out.println("Your name:");
                        String username = sc.nextLine().trim();
                        System.out.println("Your mobile no:");
                        String usermobileno = sc.nextLine().trim();
                        if(mobileNocheck(usermobileno).equalsIgnoreCase("valid")) {
                            Database.bookissued(userInput10);
                            Books.issueBook(username, userInput10, LocalDate.now(), LocalDate.now().plusDays(14),"No", 100, usermobileno);
                            System.out.println("Have a Good Day!!");
                            
                        }
                        else {
                            System.out.println("enter a valid mobile number");
                        }
                    }
                    else {
                        System.out.println("Would you like to look for another book?");
                        System.out.println("Enter yes or no");
                        String userInput = sc.nextLine().trim();
                        if(userInput.equalsIgnoreCase("yes")) {
                            Books.lookingForBook();
                        }
                        else {
                            System.out.println("Thank you. You are Welcome");
                        }
                    }
                }
            }catch(SQLException|ClassNotFoundException e) {
                System.out.println("There is an error");
                e.printStackTrace();
            }finally{
                Database.closeConnection();
            }
        }
        else {
            System.out.println("Would you like to look for another book?");
            System.out.println("Enter yes or no");
            String userInput = sc.nextLine().trim();
            if(userInput.equalsIgnoreCase("Yes")) {
                Books.lookingForBook();
            }
            else {
                System.out.println("Thank you. Visit Again");
            }
        }
    }
    public void returnBook(String username, String bookname) throws SQLException {
        Database.bookreturn(bookname);
        if(Database.userFound(username)) {
            if(Database.updation(username) == 0) {
                System.out.println("Already paid");
            }
            else {
                long amount = 100l;
                long latefee = lateFeeAmount(LocalDate.now(), Database.Date_Return(username));
                System.out.println("You have to pay: "+(amount+latefee));                
            }
        }
        else {  
            System.out.println("No user found"); 
        }
    }
}

