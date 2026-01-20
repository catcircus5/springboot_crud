package com.example.BOOK;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.bson.types.ObjectId;

import java.util.Map;
import java.util.List;
import java.util.Optional;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepo repo;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return repo.save(book);
    }

    @GetMapping
    public List<Book> getBooks(){
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id){
        repo.deleteById(new ObjectId(id.trim()));
        return "Deleted!";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable String id, @RequestBody Book updatedBook){
        ObjectId oid = new ObjectId(id.trim());
        Optional<Book> optionalBook = repo.findById(oid);
        Book tochange = optionalBook.get();
        tochange.setBookName(updatedBook.getBookName());
        tochange.setAuthorName(updatedBook.getAuthorName());
        repo.save(tochange);
        return "updated!";
    }
//
//    its a PUT(update) request. id comes from the URL, updatedBook comes from request body
//    id is a string if its in the URL, so oid is the ObjectId version of
//    Optional is a wrapper for Book in case it doesnt exist.
//    we then extract Book from optionalBook.
//    then we use the lombok made functions to update, using values from the request body
//
//
//

}
