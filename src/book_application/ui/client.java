package book_application.ui;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import book_application.model.book;
import book_application.service.book_api_serviceimpl;

public class client {
	public static void main(String[] args) {
		book_api_serviceimpl service = new book_api_serviceimpl();
		Scanner sc = new Scanner(System.in);
		String title = null;
		String author = null;
		int isbn = 0;
		int price = 0;
		int discount = 0;
		int total = 0;
		while(true) {
			System.out.println("**************Book Application**********");
			System.out.println("1.Add book");
			System.out.println("2.Update book");
			System.out.println("3.Delete book");
			System.out.println("4.Get book");
			System.out.println("5.Get All book");
			
			int options =sc.nextInt();
			
			switch(options) {
			case 1: 
				System.out.println("Enter the book title to be added");
				title = sc.next();
				System.out.println("Enter the book author to be added");
				author = sc.next();
				book a = new book(title, author, 0);
				isbn = service.add_book(a);
				System.out.println("Book Added Successfully with id : "+isbn);
				break;
			case 2:
				System.out.println("Enter info to update the book");
				System.out.println("Enter the ISBN");
				isbn = sc.nextInt();
				System.out.println("Enter the book title to be added");
				title = sc.next();
				System.out.println("Enter the book author to be added");
				author = sc.next();
				book update_book = new book(title, author,isbn);
				book update_book1 = service.update_book(update_book);
				System.out.println("Book updated Successfully with id :" + update_book1);
				break;
			case 3:
				System.out.println("enter ISBN :");
				isbn = sc.nextInt();
				service.delete_book(isbn);
				System.out.println("Deleted Succesfully");
				break;
			case 4:
				System.out.println("enter ISBN");
			    isbn = sc.nextInt();
				book book1=service.get_book(isbn);
				System.out.println(book1);
				break;
			case 5:
				Map<Integer,book> book = service.getAllBook();// entry
				Set<Integer> keys = book.keySet();
				
				  Iterator<Integer> itr = keys.iterator(); 
				  while(itr.hasNext()) { 
					  int key=itr.next(); 
					  System.out.println(key+" "+book.get(key)); }
				 
				break;
			default:
				System.out.println("Thank you for using Application");
				System.exit(0);

				break;
			}
		}
	}

}
