package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.controller.dto.BookDTO;
import spring.domain.Author;
import spring.domain.Book;
import spring.domain.PublishYear;
import spring.repository.AuthorRepository;
import spring.repository.BookRepository;
import spring.repository.PublishYearRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublishYearRepository publishYearRepository;

    public List<BookDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> result = new ArrayList<>();
        books.forEach(b -> result.add(BookDTO.getInstance(b)));

        return result;
    }

    public BookDTO findByInd(Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            return BookDTO.getInstance(book);
        }
        return null;
    }

    public BookDTO add(BookDTO bookDTO) {
        Book book = new Book();
        book.setBookName(bookDTO.getBookName());

        //Здесь мы проверяем - есть ли в таблице авторов, заданный автор.
        // Если нет - добовляем и даем ссылку, если есть - даем ссылку
        Author author = authorRepository.findByNameAuthor(bookDTO.getAuthor());
        if (author == null) {
            author = new Author();
            author.setNameAuthor(bookDTO.getAuthor());
        }
        book.setAuthor(author);

        //то же проделываем с годом выпуска
        PublishYear year = publishYearRepository.findByYearOfBook(bookDTO.getYear());
        if (year == null) {
            year = new PublishYear();
            year.setYearOfBook(bookDTO.getYear());
            publishYearRepository.save(year);
        }
        book.setYear(year);

        bookRepository.save(book);
        BookDTO result = BookDTO.getInstance(book);

        return result;
    }
}
