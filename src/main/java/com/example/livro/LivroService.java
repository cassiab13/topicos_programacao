package com.example.livro;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public List<Livro> findAll() {
        return repository.findAll();
    }

    public Livro create(Livro livro) {
        return repository.save(livro);
    }

    public Livro update(Long id, Livro novoLivro) {
       Livro livro = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        livro.setNome(novoLivro.getNome());
        livro.setAutor(novoLivro.getAutor());
        livro.setStatus(novoLivro.getStatus());
       return repository.save(livro);
    }

    public void delete(Long id){
       repository.deleteById(id);
    }

    public List<Livro> findByStatus(Status status){return repository.findByStatus(status);
    }
}
