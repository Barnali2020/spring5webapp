package com.barnali.project1.bootstrap;

import com.barnali.project1.domain.Author;
import com.barnali.project1.domain.Book;
import com.barnali.project1.domain.Publisher;
import com.barnali.project1.repositories.AuthorRepository;
import com.barnali.project1.repositories.BookRepository;
import com.barnali.project1.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St. Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);


        Author author1 = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "123123");
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher);
        author1.getBooks().add(book1);
        publisher.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        Author author2 = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "3939459459");
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher);
        author2.getBooks().add(book2);
        publisher.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);
    }
}
