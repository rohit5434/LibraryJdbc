import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static BookDAO b = new BookDAO();
    static UserDAO u = new UserDAO();
    static IssueDAO i = new IssueDAO();

    public static void main(String[] args) throws Exception {
        while (true) {
            menu();
            String c = sc.nextLine();
            switch (c) {
                case "1": addBook(); break;
                case "2": listBooks(); break;
                case "3": addUser(); break;
                case "4": listUsers(); break;
                case "5": issueBook(); break;
                case "6": returnBook(); break;
                case "7": searchBook(); break;
                case "8": removeBook(); break;
                case "0": return;
                default: System.out.println("Invalid");
            }
        }
    }

    static void menu() {
        System.out.println("\n1 Add Book\n2 List Books\n3 Add User\n4 List Users\n5 Issue Book\n6 Return Book\n7 Search Book\n8 Remove Book\n0 Exit");
        System.out.print("Choice: ");
    }

    static void addBook() throws Exception {
        System.out.print("Title: "); String t = sc.nextLine();
        System.out.print("Author: "); String a = sc.nextLine();
        b.add(t, a);
        System.out.println("Added");
    }

    static void listBooks() throws Exception {
        for (String s : b.list()) System.out.println(s);
    }

    static void addUser() throws Exception {
        System.out.print("Name: "); String n = sc.nextLine();
        u.add(n);
        System.out.println("User Added");
    }

    static void listUsers() throws Exception {
        for (String s : u.list()) System.out.println(s);
    }

    static void issueBook() throws Exception {
        System.out.print("Book ID: "); int bid = Integer.parseInt(sc.nextLine());
        System.out.print("User ID: "); int uid = Integer.parseInt(sc.nextLine());
        System.out.println(i.issue(bid, uid) ? "Issued" : "Cannot Issue");
    }

    static void returnBook() throws Exception {
        System.out.print("Book ID: "); int bid = Integer.parseInt(sc.nextLine());
        System.out.println(i.ret(bid) ? "Returned" : "Cannot Return");
    }

    static void searchBook() throws Exception {
        System.out.print("Query: "); String q = sc.nextLine();
        for (String s : b.search(q)) System.out.println(s);
    }

    static void removeBook() throws Exception {
        System.out.print("Book ID: "); int bid = Integer.parseInt(sc.nextLine());
        System.out.println(b.remove(bid) ? "Removed" : "Cannot Remove");
    }
}
