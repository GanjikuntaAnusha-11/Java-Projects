import java.sql.*;
import java.time.*;
import java.util.*;


public class Database {
    static String book_name;
    static boolean flag = false;
    private static Connection conn;
    static void databaseConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/librarymanagement";
        String username = "root";
        String password = "Anu11sh@";
        conn = DriverManager.getConnection(url, username, password);
    }
    static void closeConnection() {
        if(conn != null) {
            try {
                conn.close();
            }catch(SQLException e) {
                System.out.println("Oops something went wrong!!");
                e.printStackTrace();
            }
        }
    }

    static void displaybyName(String bookName) throws SQLException{
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established....");
        }
        String sql = "select bookname from books where bookname = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bookName);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {    
                    book_name = rs.getString("bookname");               
                    System.out.println("book found");
                }else {
                    System.out.println("book not found");
                    flag = true;
                }
            }
        }
    }

    static void displaybyAuthor(String author) throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql1 = "select bookid, bookname, bookgenre, booktype from books where bookauthor = ?";
        try(PreparedStatement stmt1 = conn.prepareStatement(sql1)) {
            stmt1.setString(1,author);
            try(ResultSet rs = stmt1.executeQuery()) {
                boolean found = false;
                    while(rs.next()) {
                        found = true;
                        String name = rs.getString("bookname");
                        System.out.println(name);
                }
                if(!found) {
                    System.out.println("Sorry!We don't have any books related to author!!");
                    flag = true;
                    return;
                }
            }
        }
    }

    static void displaybyGenre(String genre) throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql2 = "select bookid, bookname, bookauthor from books where booktype = ?";
        try(PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
            stmt2.setString(1, genre);
            try(ResultSet rs = stmt2.executeQuery()) {
                boolean found = false;
                while(rs.next()) {
                    found = true;
                    String name = rs.getString("bookname");
                    System.out.println(name);
                }
                if(!found) {
                    System.out.println("Sorry!We don't have any books related to genre!!");
                    flag = true;
                    return;
                }
            }
        }
    }

    static int entryUserDetails(String username, String book,LocalDate issue, LocalDate dateofreturn, String paid, int amount,String usermobileno) throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql3 = "insert into account(accountHolder,book_name,issue_date,return_date, paid, amountToBePaid,mobileno) values(?,?,?,?,?,?,?)";
        int n = 0;
        try(PreparedStatement stmt3 = conn.prepareStatement(sql3)) {
            stmt3.setString(1, username);
            stmt3.setString(2, book);
            stmt3.setDate(3, java.sql.Date.valueOf(issue));
            stmt3.setDate(4, java.sql.Date.valueOf(dateofreturn));
            stmt3.setString(5,paid);
            stmt3.setInt(6, amount);
            stmt3.setString(7, usermobileno);
            n = stmt3.executeUpdate();
        }
        return n;
    }

    static boolean bookFoundOrNot(String userBook) throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql4 = "select * from books where bookname = ?";
        try(PreparedStatement stmt4 = conn.prepareStatement(sql4)) {
            stmt4.setString(1,userBook);
            try(ResultSet rs = stmt4.executeQuery()) {
                while(rs.next()) {
                    return true;
                }                
            }
        }
        return false;
    }

    static LocalDate Date_Return(String username) throws SQLException{
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql5 = "select return_date from account where accountHolder = ?";
        try(PreparedStatement stmt5 = conn.prepareStatement(sql5)) {
            stmt5.setString(1,username);
            try(ResultSet rs = stmt5.executeQuery()) {
                if(rs.next()) {
                    return rs.getDate("return_date").toLocalDate();
                }
                else {
                    throw new SQLException("There is no user "+username);
                }
            }
        }
    }

    static boolean userFound(String username) throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql8 = "select accountId, accountHolder from account where accountHolder = ?";
        try(PreparedStatement stmt8 = conn.prepareStatement(sql8)) {
            stmt8.setString(1, username);
            try(ResultSet rs = stmt8.executeQuery()) {
                while(rs.next()) {
                    return true;
                }
            } 
        }
        return false;
    }

    static int if_user_already_paid(String username) throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql7 = "select * from account where accountHolder = ?";
        int amount = 0;
        try(PreparedStatement stmt7 = conn.prepareStatement(sql7)) {
            stmt7.setString(1, username);
            
            try(ResultSet rs = stmt7.executeQuery()) {
                while(rs.next()) {
                    amount = rs.getInt("amountToBePaid");
                }
            }
        }
        return amount;
    }

    static int updation(String username) throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        if(if_user_already_paid(username) != 0 ) {
            String sql6 = "update account set paid = ?, amountToBePaid = ? where accountHolder = ?";
            try(PreparedStatement stmt6 = conn.prepareStatement(sql6)) {
                stmt6.setString(1, "yes");
                stmt6.setInt(2, 0);
                stmt6.setString(3,username);
                return stmt6.executeUpdate();
            }
        }
        return 0;
    }

    static void distinctGenre() throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql9 = "select distinct(booktype) from books";
        try(PreparedStatement stmt9 = conn.prepareStatement(sql9)) {
            try(ResultSet rs = stmt9.executeQuery()) {
                while(rs.next()) {
                    System.out.println(rs.getString("booktype"));
                }
            }
        }
    }

    static void distinctAuthor() throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql10 = "select distinct(bookauthor) from books";
        try(PreparedStatement stmt10 = conn.prepareStatement(sql10)) {
            try(ResultSet rs = stmt10.executeQuery()) {
                while(rs.next()) {
                    System.out.println(rs.getString("bookauthor"));
                }
            }
        }
    }

    static void distinctBookName() throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql12 = "select distinct(bookname) from books";
        try(PreparedStatement stmt12 = conn.prepareStatement(sql12)) {
            try(ResultSet rs = stmt12.executeQuery()) {
                while(rs.next()) {
                    System.out.println(rs.getString("bookname"));
                }
            }
        }
    }

    static int noofrecords() throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql13 = "select count(*) from books";
        int rows = 0;
        try(PreparedStatement stmt13 = conn.prepareStatement(sql13)) {
            try(ResultSet rs = stmt13.executeQuery()) {
                if(rs.next()) {
                    rows = rs.getInt(1);
                }                
            } 
        }
        return rows;
    }

    static List<String> booksDisplay(String name) throws SQLException {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("BookName cannot be null or empty");
        }
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        List<String> booklist = new ArrayList<>();
        String sql11 = "select bookname from books where lower(bookname) like lower(?)";
        try(PreparedStatement stmt11 = conn.prepareStatement(sql11)) {
            stmt11.setString(1, "%"+name+"%");
            try(ResultSet rs = stmt11.executeQuery()) {
                while(rs.next()) {
                    booklist.add(rs.getString("bookname"));
                }
            }
        }
        return booklist;
    }

    static int bookCount(String name) throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql14 = "select bookcount from books where bookname = ?";
        try(PreparedStatement stmt14 = conn.prepareStatement(sql14)){
            stmt14.setString(1, name);
            try(ResultSet rs = stmt14.executeQuery()) {
                if(!rs.next()) {
                    throw new SQLException("No book found");
                }
                return rs.getInt("bookcount");
            }
        }
    }

    static void bookissued(String name) throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql15 = "update books set bookcount = ? , book_available = ? where bookname = ?";
        try(PreparedStatement stmt15 = conn.prepareStatement(sql15)) {
            if(bookCount(name) > 0) {
                stmt15.setInt(1, (bookCount(name)-1));
                stmt15.setString(2, "YES");
                stmt15.setString(3, name);
                stmt15.executeUpdate();
            }
            else {
                stmt15.setInt(1,0);
                stmt15.setString(2,"NO");
                stmt15.setString(3, name);
                stmt15.executeUpdate();
                System.out.println("Sorry!We are out of books!!!");
            }            
        }
    }

    static void bookreturn(String name) throws SQLException {
        if(conn == null || conn.isClosed()) {
            throw new SQLException("Database connection is not established...");
        }
        String sql16 = "update books set bookcount = ? , book_available = ? where bookname = ?";
        int bookcount = bookCount(name);
        try(PreparedStatement stmt16 = conn.prepareStatement(sql16)) {
            if(bookCount(name) < 10) {
                stmt16.setInt(1, bookcount+1);
                stmt16.setString(2, "YES");
                stmt16.setString(3, name);
                stmt16.executeUpdate();
            }
            else {
                stmt16.setInt(1,10);
                stmt16.setString(2,"YES");
                stmt16.setString(3, name);
                stmt16.executeUpdate();
            }
        }
    }
}
