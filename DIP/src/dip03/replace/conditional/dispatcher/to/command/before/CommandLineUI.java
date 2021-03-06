/*
 * SMELL: Switch Statement
 *   -- Conditional logic is used to dispatch requests and execute actions. 
 *
 * TREATMENT: Replace Conditional Dispatcher with Command
 *   -- Create a Command for each action. 
 *   -- Store the Commands in a collection and replace the conditional 
 *      logic with code to fetch and execute Commands. 
 *   
  */
package dip03.replace.conditional.dispatcher.to.command.before;

import java.util.*;

public class CommandLineUI {

	static Library lib = new Library();
	
	public static void printHeader() { 
		System.out.println("COMMANDS:");
		System.out.println("addUser name, address, phone"); 
		System.out.println("addBook title, authors, ISBN"); 
		// region Add commands later
		System.out.println("addlntUser name, address, phone, id"); 
		System.out.println("rmUser userld"); 
		System.out.println("addReport title, ref, authors"); 
		System.out.println("addJournal title"); 
		System.out.println("rmDoc docid"); 
		System.out.println("borrowDoc userld, docId"); 
		System.out.println("returnDoc docId"); 
		System.out.println("searchUser name"); 
		System.out.println("searchDoc title"); 
		System.out.println("isHolding userld, docId"); 
		System.out.println("printLoans"); 
		System.out.println("printUser userld");
		// endRegion
		System.out.println("printDoc docId");
		System.out.println("exit");
	}
	
	public static String [] getArgs(String cmd) { 
		String args[] = new String [0];
		String s = cmd.trim();
		if (s.indexOf(" ") != -1) {
			s = s.substring(s.indexOf(" "));
			args = s.trim().split(",");
			for (int i =0 ; i <args.length ; i++)
				args[i] = args[i].trim();
		}
		return args; 
	}
	
	/*
	 * Conditional-dispatcher
	 */
	public static void dispatchCommand(String cmd) {
		String args [] = getArgs (cmd);
		if (cmd.startsWith("addUser")) {
			if (args.length < 3) return;
			User user = new User (args[0] , args[1], args [2]);
			lib.addUser(user);
			System.out.println("Added user: " + user.getName() + 
					" - " + user.getAddress() + " - " + user.getPhone());
		} else if (cmd.startsWith("addBook")) {
			if (args.length < 3) return;
			Document doc = new Book(args[0], args[1], args[2]);
			lib.addDocument(doc);
			System.out.println("Added doc: " + doc.getCode() + 
					" - " + doc.getTitle());
		}	
		/* 
		 * else if .........
		 */
	}

	public static void main(String[] args) {
		printHeader();
		
		String s = "";
		Scanner scanner = new Scanner(System.in);
		
		s = scanner.nextLine();	// <----- insert this line
		while (!s.equals("exit"))
		{
			dispatchCommand(s);
			s = scanner.nextLine();
		}
		
		scanner.close();
	}

	public static Library getLibrary() {
		return lib;
	}
}
