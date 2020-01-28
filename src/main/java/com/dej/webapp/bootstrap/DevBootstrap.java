package com.dej.webapp.bootstrap;

import com.dej.webapp.models.Author;
import com.dej.webapp.models.Book;
import com.dej.webapp.models.Publisher;
import com.dej.webapp.repositories.AuthorRepository;
import com.dej.webapp.repositories.BookRepository;
import com.dej.webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher p1 = new Publisher("p1", "a1");
        Book ddd = new Book("Dom", "31132", p1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(p1);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher p2 = new Publisher("p2", "a2");
        Book noEjb = new Book("J2EE", "654654", p2);
        rod.getBooks().add(noEjb);

        authorRepository.save(rod);
        publisherRepository.save(p2);
        bookRepository.save(noEjb);
    }
}
