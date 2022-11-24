package it.antlia.store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.antlia.store.model.Book;

@SpringBootApplication
public class DemoStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Autore1", "Titolo1", "CasaEditrice1", 70, "ABCD");
		Book book2 = new Book("Autore2", "Titolo2", "CasaEditrice2", 70, "BCDE");
		Book book3 = new Book("Autore2", "Titolo3", "CasaEditrice2", 70, "BCDE");
		Book book4 = new Book("Autore2", "Titolo4", "CasaEditrice2", 70, "BCDE");
		Book book5 = new Book("Autore2", "Titolo5", "CasaEditrice2", 70, "BCDE");

		System.out.println(book1);

		// esempio di uso di una Mappa
		Map<Integer, Book> biblioteca = new HashMap<>();
		biblioteca.put(1, book1);
		biblioteca.put(2, book2);
		Book prestito = biblioteca.get(2);

		//esempio di uso di una Lista
		List<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		
		Book newBook = books.get(2);

		// List<String> titoli = new ArrayList<>();
		// for (int i=0; i<books.size(); i++) {
		// 	String titolo = books.get(i).getTitle();
		// 	titoli.add(titolo);
		// }

		List<String> titoli = books
								.stream()
								.map(b -> b.getTitle())
								//.map(Book::getTitle)
								.collect(Collectors.toList());

	List<String> titoli = books
	.stream()
	.map( new Function<Book, String>() {

		@Override
		public String apply(Book t) {
			return boo.getTitle();
		}
		
	} )
	.collect(Collectors.toList());

		// int = Integer
		// long = Long
		// double = Double
		// float = Float
		// byte = Byte
		// short = Short
		// char = Character
		// boolean = Boolean

		String quindici = "15";
		int iQuindici = Integer.parseInt(quindici);
		somma(1, 5);
		somma(new Integer("1"), new Integer("5"));
	}

	private int somma(int a, int b) {
		return a + b;
	}
}
