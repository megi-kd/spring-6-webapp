package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repository.AuthorRepository;
import guru.springframework.spring6webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author authorOne = new Author();
        authorOne.setFirstName("Eric");
        authorOne.setLastName("Evans");

        Book bookOne = new Book();
        bookOne.setIsbn("1234");
        bookOne.setTitle("DDD");

        authorOne =  authorRepository.save(authorOne);
        bookOne = bookRepository.save(bookOne);

        Author authorTwo = new Author();
        authorTwo.setFirstName("Jane");
        authorTwo.setLastName("Austin");

        Book bookTwo = new Book();
        bookTwo.setIsbn("5678");
        bookTwo.setTitle("Emma");

        authorTwo =  authorRepository.save(authorTwo);
        bookTwo = bookRepository.save(bookTwo);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
