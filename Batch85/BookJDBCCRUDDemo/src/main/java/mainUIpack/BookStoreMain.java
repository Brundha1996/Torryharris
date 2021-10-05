package mainUIpack;

import bookop.BookOperationImpl;
import model.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookStoreMain {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        BookOperationImpl boi = new BookOperationImpl();

         while (true)
         {
             System.out.println("1. Add a Book");  // Admin
             System.out.println("2. List all the Books");  // Admin  , User
             System.out.println("3. Get a Book");  // Admin , User
             System.out.println("4. Update a Book Price"); // Admin
             System.out.println("5. Exit");

             System.out.println("Enter your choice:");
             int choice = sc.nextInt();

             switch(choice)
             {
                 case 1:
                 {
                     System.out.println("Enter the details of the book");
                     int bookId = sc.nextInt();
                     String bookName = sc.next();
                     int bookPrice = sc.nextInt();
                     Book book = new Book(bookId,bookName,bookPrice);
                     System.out.println(boi.addABook(book));

                     break;
                 }

                 case 2:
                 {
                     ArrayList<Book> blist= boi.getAllBooks();
                     for (Book book:blist)
                     {
                         System.out.println(book);
                     }

                    break;
                 }

                case 3:
                 {
                     System.out.println("Enter the  book id to be searched");
                     int bookId = sc.nextInt();
                     Book book = boi.getABook(bookId);

                     if (book != null)
                         System.out.println(book);
                     else
                         System.out.println("Book not found in the Store");

                     break;
                 }
                case 4:
                 {
                     System.out.println("Enter the  book id ");
                     int bookId = sc.nextInt();
                     System.out.println("Enter the  updated price of the book  ");
                     int upPrice = sc.nextInt();
                     System.out.println(boi.setBookPrice(bookId,upPrice));

                     break;
                 }
                 default:
                        sc.close();
                        System.out.println("Bye Bye!!!");
                        System.exit(0);

             }



         }



    }
}
