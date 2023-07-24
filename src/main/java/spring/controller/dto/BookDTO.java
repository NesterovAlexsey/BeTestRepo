package spring.controller.dto;

import lombok.*;
import spring.domain.Book;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDTO {
    private Integer id;
    private String bookName;
    private String author;
    private Integer year;

    //метод создает образец для класса букDTO для выдачи на фронт из объекта класса бук
    public static BookDTO getInstance(Book book) {
        return new BookDTO(book.getBookId(),
                book.getBookName(),
                book.getAuthor().getNameAuthor(),
                book.getYear().getYearOfBook());
    }
}
