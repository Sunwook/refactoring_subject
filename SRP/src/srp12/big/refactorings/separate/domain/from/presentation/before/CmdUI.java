package srp12.big.refactorings.separate.domain.from.presentation.before;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CmdUI {
	private static Scanner scanner = new Scanner(System.in);

	private List<Customer> customers = new ArrayList<Customer>();
	private List<Video> videos = new ArrayList<Video>();

	public void start() {
		generateSamples();

		boolean quit = false;
		while (!quit) {
			int command = getCommand();
			switch (command) {
			case 0:
				quit = true;
				break;
			case 1:
				listCustomers();
				break;
			case 2:
				listVideos();
				break;
			case 3:
				register("customer");
				break;
			case 4:
				register("video");
				break;
			case 5:
				rentVideo();
				break;
			case 6:
				returnVideo();
				break;
			case 7:
				getCustomerReport();
				break;
			case 8:
				clearRentals();
				break;
			default:
				break;
			}
		}
		System.out.println("Bye");
	}

	public void clearRentals() {
		System.out.println("Enter customer code: ");
		int customerCode = scanner.nextInt();

		Customer foundCustomer = null;
		for (Customer customer : customers) {
			if (customer.getCode() == customerCode) {
				foundCustomer = customer;
				break;
			}
		}
		
		if (foundCustomer == null) {
			System.out.println("No customer found");
		} else {
			System.out.println("Id: " + foundCustomer.getCode() + "\nName: " + foundCustomer.getName() + "\tRentals: "
					+ foundCustomer.getRentals().size());
			for (Rental rental : foundCustomer.getRentals()) {
				System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
				System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
			}
			List<Rental> rentals = new ArrayList<>();
			foundCustomer.setRentals(rentals);
		}
	}

	public void returnVideo() {
		System.out.println("Enter customer code: ");
		int customerCode = scanner.nextInt();

		Customer foundCustomer = null ;
		for ( Customer customer: customers ) {
			if ( customer.getCode() == customerCode) {
				foundCustomer = customer ;
				break ;
			}
		}
		if ( foundCustomer == null ) return ;

		System.out.println("Enter video title to return: ");
		String videoTitle = scanner.next();

		List<Rental> customerRentals = foundCustomer.getRentals();

		for (Rental rental : customerRentals) {
			if (rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented()) {
				Video video = rental.returnVideo();
				video.setRented(false);
				break;
			}
		}
	}

	public void listVideos() {
		System.out.println("List of videos");

		for (Video video : videos) {
			System.out.println("Price code: " + video.getPriceCode() + "\tTitle: " + video.getTitle());
		}
		System.out.println("End of list");
	}

	public void listCustomers() {
		System.out.println("List of customers");

		for (Customer customer : customers) {
			System.out.println("ID: " + customer.getCode() + "\nName: " + customer.getName() + "\tRentals: "
					+ customer.getRentals().size());
			for (Rental rental : customer.getRentals()) {
				System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
				System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
				System.out.println("\tReturn Status: " + rental.getStatus());
			}
		}
		System.out.println("End of list");
	}

	public void getCustomerReport() {
		System.out.println("Enter customer code: ");
		int customerCode = scanner.nextInt();

		Customer foundCustomer = null ;
		for ( Customer customer: customers ) {
			if ( customer.getCode() == customerCode) {
				foundCustomer = customer ;
				break ;
			}
		}

		if (foundCustomer == null) {
			System.out.println("No customer found");
		} else {
			String result = foundCustomer.getReport();
			System.out.println(result);
		}
	}

	public void rentVideo() {
		System.out.println("Enter customer code: ");
		int customerCode = scanner.nextInt();

		Customer foundCustomer = null ;
		for ( Customer customer: customers ) {
			if ( customer.getCode() == customerCode) {
				foundCustomer = customer ;
				break ;
			}
		}
		if ( foundCustomer == null ) return ;

		System.out.println("Enter video title to rent: ");
		String videoTitle = scanner.next();

		Video foundVideo = null ;
		for ( Video video: videos ) {
			if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
				foundVideo = video ;
				break ;
			}
		}
		if ( foundVideo == null ) return;

		Rental rental = new Rental(foundVideo);
		foundVideo.setRented(true);

		List<Rental> customerRentals = foundCustomer.getRentals();
		customerRentals.add(rental);
		foundCustomer.setRentals(customerRentals);
	}

	public void register(String object) {
		if (object.equals("customer")) {
			System.out.println("Enter customer name: ");
			String name = scanner.next();

			System.out.println("Enter customer code: ");
			int code = scanner.nextInt();

			Customer customer = new Customer(code, name);
			customers.add(customer);
		} else {
			System.out.println("Enter video title to register: ");
			String title = scanner.next();

			System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):");
			int videoType = scanner.nextInt();

			System.out.println("Enter price code( 1 for Regular, 2 for New Release ):");
			int priceCode = scanner.nextInt();

			Date registeredDate = new Date();
			Video video = new Video(title, videoType, priceCode, registeredDate);
			videos.add(video);
		}
	}

	public int getCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt();

		return command;
	}

	private void generateSamples() {
		Customer james = new Customer(0, "James");
		Customer brown = new Customer(1, "Brown");
		customers.add(james);
		customers.add(brown);

		Video v1 = new Video("V1", Video.CD, Video.REGULAR, new Date());
		v1.setRented(true);
		Video v2 = new Video("V2", Video.DVD, Video.NEW_RELEASE, new Date());
		v2.setRented(true);
		videos.add(v1);
		videos.add(v2);
		
		Rental r1 = new Rental(v1);
		Rental r2 = new Rental(v2);

		james.addRental(r1);
		james.addRental(r2);
	}
}
