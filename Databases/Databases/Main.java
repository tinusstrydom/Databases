package Databases;

import java.util.*;
import java.sql.*;

class Books{
	//Local variable
	//create and assigned Connection object data to variable
	public String dbUrl = "jdbc:mysql://localhost:3306/ebookstore";
	public String dbUser = "myuser";
	public String dbPass = "myuser08";
	
	//Create variable that will be used
	String title, author;
	int id, qty;
	
	//Main menu method to print out main menu
	public void mainMenu(){
	    System.out.println("--------------------Main Menu-------------------");
	    System.out.println("Enter 1 to View All Books.");
	    System.out.println("Enter 2 to Enter Book.");
	    System.out.println("Enter 3 to Update Book.");
	    System.out.println("Enter 4 to Delete Book.");
	    System.out.println("Enter 5 to Search Books.");
	    System.out.println("Enter 0 to Exit Application.");
	    System.out.println("------------------------------------------------");
	}
	//Update menu method to print out update menu
	public void updateMenu(){
	    System.out.println("------------------Update Menu-------------------");
	    System.out.println("Enter 1 to update id of book.");
	    System.out.println("Enter 2 to update title of book.");
	    System.out.println("Enter 3 to update author of book.");
	    System.out.println("Enter 4 to update qty of book");
	    System.out.println("Enter 0 back to Main Menu");
	    System.out.println("------------------------------------------------");
	}
	//Search menu method to print out search menu 
	public void searchMenu(){
	    System.out.println("-------------------Search Menu------------------");
	    System.out.println("Enter 1 to search titles of books");
	    System.out.println("Enter 2 to search authors of the books");
	    System.out.println("Enter 0 to Exit Application.");
	    System.out.println("------------------------------------------------");
	}
	//View book method 
	//viewBook method to view all books in the database
	public void viewBook() {
		// Try/catch statement 
		try{
			// Allocate database connection object
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			// Allocate statement object in connection
			Statement stmt = conn.createStatement();
			// Execute SQL select query
			// Query result is returned in the ResultSet object 
			String sqlSelect = "select * from books";
			ResultSet rset = stmt.executeQuery(sqlSelect);
			
			//printout heading for columns from database
			System.out.println("Id\t\t\tTitle\t\t\t\tAuthor\t\tQty");
			//While loop to get each column from resultset
			while(rset.next()) {
				id = rset.getInt("id");
				title = rset.getString("title");
				author = rset.getString("author");
				qty = rset.getInt("qty");
				//print out using format to to format table 
				System.out.format("%3d%45s%20s%5d%n",id,title,author,qty);
				}
		//Catch exception
		}catch(SQLException ex) {
				ex.printStackTrace();
		}
	}
	//Enter book method to add new book to database
	public void enterBook(int id, String title, String author,int qty) {
		// Try/catch statement 
		try{
			// Allocate database connection object
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			// Allocate statement object in connection
			Statement stmt = conn.createStatement();
			// Execute SQL insert query
			// Execute update 
			String sqlInsert = "insert into books values("+id+",'"+title+"','"+author+"',"+qty+")";
			stmt.executeUpdate(sqlInsert);
		//Catch exception	
		}catch(SQLException ex) {
				ex.printStackTrace();
		}
	}
	//Update id to update id number of book
	public void updateId(int id, int idUpdate) {
		// Try/catch statement 
		try{
			// Allocate database connection object
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			// Allocate statement object in connection
			Statement stmt = conn.createStatement();
			// Execute SQL update query
			// Execute update 
			String sqlUpdate = "update books set id="+idUpdate+" where id="+id;
			stmt.executeUpdate(sqlUpdate);	
		//Catch exception
		}catch(SQLException ex) {
				ex.printStackTrace();
		}
	}
	//Update title to update title 
	public void updateTitle(int id, String titleUpdate) {
		// Try/catch statement 
		try{
			// Allocate database connection object
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			// Allocate statement object in connection
			Statement stmt = conn.createStatement();
			// Execute SQL update query
			// Execute update 
			String sqlUpdate = "update books set title='"+titleUpdate+"' where id="+id;
			stmt.executeUpdate(sqlUpdate);
		//Catch exception	
		}catch(SQLException ex) {
				ex.printStackTrace();
		}
	}
	
	public void updateAuthor(int id, String authorUpdate) {
		try{
			// Allocate database connection object
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			// Allocate statement object in connection
			Statement stmt = conn.createStatement();
			// Execute SQL update query
			// Execute update 
			String sqlUpdate = "update books set author='"+authorUpdate+"' where id="+id;
			stmt.executeUpdate(sqlUpdate);
		//Catch exception
		}catch(SQLException ex) {
				ex.printStackTrace();
		}
	}
	
	public void updateQty(int id, int qtyUpdate) {
		//Try/catch
		try{
			// Allocate database connection object
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			// Allocate statement object in connection
			Statement stmt = conn.createStatement();
			// Execute SQL update query
			// Execute update 
			String sqlUpdate = "update books set qty='"+qtyUpdate+"' where id="+id;
			stmt.executeUpdate(sqlUpdate);
		//Catch exception
		}catch(SQLException ex) {
				ex.printStackTrace();
		}
	}
	
	public void deleteBook(int id) {
		// Try/catch statement 
		try{
			// Allocate database connection object
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			// Allocate statement object in connection
			Statement stmt = conn.createStatement();
			// Execute SQL delete query
			// Execute update 
			String sqlDelete = "delete from books where id="+id;
			stmt.executeUpdate(sqlDelete);
		//Catch exception
		}catch(SQLException ex) {
				ex.printStackTrace();
		}
	}
	
	public void searchTitle(String word) {
		// Try/catch statement 
		try{
			// Allocate database connection object
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			// Allocate statement object in connection
			Statement stmt = conn.createStatement();
			// Execute SQL Select query ,result in resultset object
			// Execute update 
			String sqlSearch = "select * from books where title like '"+word+"%'" ;
			stmt.executeQuery(sqlSearch);
			ResultSet rset = stmt.executeQuery(sqlSearch);
			//printout heading for columns from database
			System.out.println("Id\t\t\tTitle\t\t\t\tAuthor\t\tQty");
			//While loop to get each column from resultset
			while(rset.next()) {
				id = rset.getInt("id");
				title = rset.getString("title");
				author = rset.getString("author");
				qty = rset.getInt("qty");
				System.out.format("%3d%45s%20s%5d%n",id,title,author,qty);
			}
		//Catch exception	
		}catch(SQLException ex) {
				ex.printStackTrace();
		}
	}
	
	public void searchAuthor(String author) {
		// Try/catch statement 
		try{
			// Allocate database connection object
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			// Allocate statement object in connection
			Statement stmt = conn.createStatement();
			String sqlSearch = "select * from books where author='"+author+"'" ;
			
			stmt.executeQuery(sqlSearch);
			ResultSet rset = stmt.executeQuery(sqlSearch);
			//printout heading for columns from database
			System.out.println("Id\t\t\tTitle\t\t\t\tAuthor\t\tQty");
			//While loop to get each column from resultset
			while(rset.next()) {
				id = rset.getInt("id");
				title = rset.getString("title");
				author = rset.getString("author");
				qty = rset.getInt("qty");
				System.out.format("%3d%45s%20s%5d%n",id,title,author,qty);
			}
		//Catch exception	
		}catch(SQLException ex) {
				ex.printStackTrace();
		}
	}
}//End of class

public class Main{
	public static void main(String[] args) {
		//Print out header for welcoming to ebookstore
		System.out.println("***********************Welcome to Ebook Store!************************");
	    System.out.println("              Please Select From The Following Options:               ");
	    System.out.println("**********************************************************************");
	    
	    //Scanner input for mainchoice from main menu
	    Scanner mainChoiceInput = new Scanner(System.in);
	    //Create new object from books class
		Books books = new Books();
		
		//Local variables
		//create variables
		int id, qty, mainChoice, updateChoice, searchChoice;
		String title, author;
		Scanner idInput, titleInput, authorInput, qtyInput;
	    
		//Use do/while loop, if 0 is chosen program exit
		
		do{
			//call main menu
			books.mainMenu();
			//mainchoice gets value from scanner input nextInt
 			mainChoice = mainChoiceInput.nextInt();
 			//Switch statement loop through menu choice 
			switch(mainChoice) {
				//case one: view books in database
			    //calls viewbook method that links to database and show details in table
				//break from switch
				case 1:
					System.out.println("Books currently available at Ebook Store:");
					books.viewBook();
					break;
				//case two: enter book into database
				//request from user input for each column 
				//enter book method enter book to database 
				//view book show books in database
				//break from switch	
				case 2:
					idInput = new Scanner(System.in);
					System.out.println("Please enter id for book:");
					id = idInput.nextInt();
					titleInput = new Scanner(System.in);
					System.out.println("Please enter title of the book:");
					title= titleInput.nextLine();
					authorInput = new Scanner(System.in);
					System.out.println("Please enter author of the book:");
					author = authorInput.nextLine();
					qtyInput = new Scanner(System.in);
					System.out.println("Please enter quantity available:");
					qty = qtyInput.nextInt();
					books.enterBook(id, title, author, qty);
					books.viewBook();
					break;
				//case three: update any field in the database
				//Do/while loop allow user to select what they want to update ,0 to exit back to main menu
				//Request user input 
				//Switch statement to select choice of the update menu 
					//case 1 : update id take input from user for id to update and new id input to store
					//case 2 : update title of book using id to find title to update and store
					//case 3 : update author of book using id to find title to update and store
					//case 4 : update qty of book using id to find and to update qty and store
					//after case is done ,update database is called to view
				case 3:
					Scanner updateChoiceInput = new Scanner(System.in);
					do {
						books.updateMenu();
						updateChoice = updateChoiceInput.nextInt(); 
						switch(updateChoice) {
						 	case 1:
						 		idInput = new Scanner(System.in);
								System.out.println("Please enter id you want to update:");
								id = idInput.nextInt();
								Scanner idUpdateInput = new Scanner(System.in);
								System.out.println("Please enter id:");
								int idUpdate = idUpdateInput.nextInt();
								books.updateId(id, idUpdate);
								books.viewBook();
						 		break;
						 	case 2:
						 		idInput = new Scanner(System.in);
								System.out.println("Please enter id for the title you want to Update");
								id = idInput.nextInt();
								Scanner titleUpdateInput = new Scanner(System.in);
								System.out.println("Please enter title:");
								String titleUpdate = titleUpdateInput.nextLine();
								books.updateTitle(id, titleUpdate);
								books.viewBook();
						 		break;
						 	case 3:
						 		idInput = new Scanner(System.in);
								System.out.println("Please enter id for the author you want to Update:");
								id = idInput.nextInt();
								Scanner authorUpdateInput = new Scanner(System.in);
								System.out.println("Please enter author:");
								String authorUpdate = authorUpdateInput.nextLine();
								books.updateAuthor(id, authorUpdate);
								books.viewBook();
						 		break;
						 	case 4:
						 		idInput = new Scanner(System.in);
								System.out.println("Please enter id for the qauntity you want to Update:");
								id = idInput.nextInt();
								Scanner qtyUpdateInput = new Scanner(System.in);
								System.out.println("Please enter qauntity:");
								int qtyUpdate = qtyUpdateInput.nextInt();
								books.updateQty(id, qtyUpdate);
								books.viewBook();
						 		break;
							}	
						}while(updateChoice!=0);
					break;	
				//case four: delete field in the database
				//request user input ,use id to delete data
				case 4:
					idInput = new Scanner(System.in);
					System.out.println("Please enter id for book to delete:");
					id = idInput.nextInt();
					books.deleteBook(id);
					books.viewBook();
					break;
				//case five: search field in the database
				//Do/while loop allow user to select what they want to search ,0 to exit back to main menu
				//request user input
				//Switch statement to select choice of the search menu 
					//case 1 : search title of book, uses a wildcard
					//case 2 : search author of book 
				case 5:
					Scanner searchChoiceInput = new Scanner(System.in);
					do {
						books.searchMenu();
						searchChoice = searchChoiceInput.nextInt();
						switch(searchChoice) {
						 	case 1:
						 		Scanner wordInput = new Scanner(System.in);
								System.out.println("Please enter word to search in title of books:");
								String searchWord = wordInput.nextLine();
								books.searchTitle(searchWord);
						 		break;
						 	case 2:
						 		Scanner authorUpdateInput = new Scanner(System.in);
								System.out.println("Please enter author name:");
								String searchAuthor = authorUpdateInput.nextLine();
								books.searchAuthor(searchAuthor);
						 		break;
						}
					}while(searchChoice!=0);
			}	
		}while(mainChoice!=0);
		//close main choice
		mainChoiceInput.close();
	}
}//End of main
