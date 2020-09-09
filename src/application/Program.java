package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.println("Insira os dados do cliente: ");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Data de nascimento (DD/MM/AAAA): ");
		Date birthDate = sdf.parse(sc.next());
		System.out.println();
		
		Cliente client = new Cliente(name,email,birthDate);
		
		System.out.println("Insira os dados do pedido:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("Quantos itens o pedido vai ter? ");
		int N = sc.nextInt();
		
		System.out.println();
		
		for (int i=0; i<N; i++) {
			System.out.println("Entre com os o item #" + (i+1));
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Preço do produto: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantidade: ");
			int quantity = sc.nextInt();
			
			Product product = new Product (productName, productPrice);
			OrderItem it = new OrderItem(quantity, productPrice, product);
			
			order.addItem(it);
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}
}
