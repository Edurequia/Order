package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities_enum.OrderStatus;


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		
		System.out.println("Enter cliente data: ");
		System.out.printf("Name: ");
		String name = sc.next();
		sc.nextLine();
		System.out.printf("Email: ");
		String email = sc.next();
		System.out.printf("Birth date (DD/MM/YYYY): ");
		String date = sc.next();
		LocalDate birthDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("");
		System.out.println("Enter order data: ");
		System.out.printf("Status: ");
		String status = sc.next();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		
		
		System.out.println("");
		for (int i=0; i<items; i++) {
			System.out.printf("Enter #%d item data: %n", i+1);
			System.out.printf("Product name: ");
			String productName = sc.next();
			System.out.printf("Product price: ");
			Double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			System.out.println("");
			
			Product product = new Product(productName, productPrice);
			OrderItem it = new OrderItem(quantity, productPrice, product);
			
			System.out.println("");
			order.addItem(it);
			
		}
		
		System.out.print(order);
		
		
		sc.close();
	}

}
