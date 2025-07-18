import java.time.LocalDate;
import java.sql.*;
import java.util.*;

class Books {
    static int id = 1;
    static void issueBook(String username, String userBook,LocalDate issue, LocalDate returnDate, String paid, int amount, String mobile) {
        id++;
        try {
            Database.databaseConnection();
            if(Database.bookFoundOrNot(userBook)) {
                Database.entryUserDetails(username, userBook, issue, returnDate, paid,amount,mobile);
                System.out.println("Book is issued");
            }
            else {
                System.out.println("The book is not found!!!");
            }
        }catch(Exception e) {
            System.out.println("Something went wrong....");
            e.printStackTrace();
        }finally{
            Database.closeConnection();
        }
    }

    static void lookingForBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of book are you looking for?");
        System.out.println("1.Do you prefer to say about the details of book?\n2.Do you need any book suggestions?");
        System.out.println("Enter the number as mentioned above..");
        int userInput2 = sc.nextInt();
        if(userInput2 == 1) {
            try {
                Database.databaseConnection();
                sc.nextLine();
                System.out.println("Enter name of the book:");
                String userInput3 = sc.nextLine().trim();
                List<String> books = Database.booksDisplay(userInput3);
                for(String book : books) {
                    System.out.println(book);
                }
                if(Database.flag == false) {
                    Account account = new Account();
                    account.bookrentalyes();
                }
            }catch(SQLException  | ClassNotFoundException e) {
                System.out.println("Something went wrong..");
                e.printStackTrace();
            }finally {
                Database.closeConnection();
            }
        }
        else if(userInput2 == 2) {
            System.out.println("Enter any number from below..!");
            System.out.println("1.BookName\n2.Author\n3.Genre");
            int userInput4 = sc.nextInt();
            switch(userInput4) {
                case 1:
                    try {
                        Database.databaseConnection();
                        System.out.println("These are the books available");
                        Database.distinctBookName();
                        System.out.println("Enter book name");
                        sc.nextLine();
                        String userInput7 = sc.nextLine().trim();
                        Database.displaybyName(userInput7);
                        if(Database.flag == false) {
                            Account account = new Account();
                            account.bookrentalyes();
                        }
                    }catch(SQLException | ClassNotFoundException e) {
                        System.out.println("Something went wrong");
                        e.printStackTrace();
                    }finally {
                        Database.closeConnection();
                    }
                    break;
                case 2:
                    try {
                        Database.databaseConnection();
                        System.out.println("These are the authors available");
                        Database.distinctAuthor();
                        System.out.println("Enter author name");
                        sc.nextLine();                       
                        String userInput5 = sc.nextLine().trim();
                        Database.displaybyAuthor(userInput5);
                        if(Database.flag == false) {
                            Account account = new Account();
                            account.bookrentalyes();
                        }
                    }catch(SQLException | ClassNotFoundException e) {
                        System.out.println("Something went wrong");
                        e.printStackTrace();
                    }finally {
                        Database.closeConnection();
                    }
                    break;
                case 3:
                    try {
                        Database.databaseConnection();
                        System.out.println("These are the different genres available");
                        Database.distinctGenre();
                        System.out.println("Enter the genre");
                        sc.nextLine();
                        String userInput7 = sc.nextLine().trim();
                        Database.displaybyGenre(userInput7);
                        if(Database.flag == false) {
                            Account account = new Account();
                            account.bookrentalyes();
                        }
                    }catch(SQLException | ClassNotFoundException e) {
                        System.out.println("Something went wrong");
                        e.printStackTrace();
                    }finally {
                        Database.closeConnection();
                    }
                    break;
                default:
                    System.out.println("Enter a valid number");
                }
        }
        sc.close();
    }

    static void returnBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("You would like to return the book. Tell me your name and name of the book, please");
        String name1 = sc.nextLine().trim();  
        String name2 = sc.nextLine().trim();          
        try{
            Database.databaseConnection();
            Account acc = new Account();
            acc.returnBook(name1,name2);
        }catch(Exception e){
            System.out.println("There is an error");
            e.printStackTrace();
        }finally{
            Database.closeConnection();
        }                    
        sc.close();
    }
}