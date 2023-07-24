package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.service.BookService;
import spring.controller.dto.BookDTO;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Integer id) {
        return bookService.findByInd(id);
    }

    @PostMapping("/add")
    public BookDTO add(@RequestBody BookDTO bookDTO) {
        return bookService.add(bookDTO);
    }

}
