package bookop;

import model.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookOperationImpl  implements BookOperations {
    private static Connection con = null;

    @Override
    public String addABook(Book book) {
        PreparedStatement ps = null;
        con = DBManager.getConnection();
        String str = "insert into book values (?,?,?)";

        try {
            ps = con.prepareStatement(str);
            ps.setInt(1,book.getBookId());
            ps.setString(2,book.getBookName());
            ps.setInt(3,book.getBookPrice());
            ps.executeUpdate();
            return "One row inserted: Book inserted successfully...";



        } catch (SQLException e) {
            //e.printStackTrace();
            return ("insertion failed due to exception....");
        }



    }

    @Override
    public ArrayList<Book> getAllBooks() {

        ArrayList<Book>  blist = new ArrayList<Book>();
       con = DBManager.getConnection();

        try {
            Statement st  = con.createStatement();
            ResultSet rs =  st.executeQuery("select * from book");
            while (rs.next())
            {
                Book book = new Book(rs.getInt(1),rs.getString(2),rs.getInt(3));
                blist.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return blist;
    }

    @Override
    public Book getABook(int bookId) {
        con = DBManager.getConnection();
        Book book=null;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book where bookId="+bookId);
            while(rs.next())
            {
                 book = new Book(rs.getInt(1),rs.getString(2),rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return book;
    }

    @Override
    public String setBookPrice(int bookId, int upPrice) {

        PreparedStatement ps = null;
        String str = "update book set bookPrice = ? where bookId=?";

        con = DBManager.getConnection();
        try {
            ps = con.prepareStatement(str);
            ps.setInt(1,upPrice);
            ps.setInt(2,bookId);

            ps.executeUpdate();

            return "One row updated..Book price updated successfully..";

        } catch (SQLException e) {
            //e.printStackTrace();
            return ("Updation failed due to exception....");
        }


    }
}
