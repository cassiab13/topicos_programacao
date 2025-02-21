package com.example.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "livros")
public class LivroController {

    @Autowired
    public LivroService service;

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id,@RequestBody Livro novoLivro){
        return ResponseEntity.ok().body(service.update(id, novoLivro));
    }
}
