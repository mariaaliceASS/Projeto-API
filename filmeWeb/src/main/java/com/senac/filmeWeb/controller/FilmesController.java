/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.filmeWeb.controller;

import com.senac.filmeWeb.data.FilmeEntity;
import com.senac.filmeWeb.service.FilmeService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/filmes")
public class FilmesController {
    @Autowired
    private FilmeService filmeService;
    
    @GetMapping
    public List<FilmeEntity> listarFilmes(){
        return filmeService.listarTodos();
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<FilmeEntity> buscarFilme(@PathVariable Long id) {
        Optional<FilmeEntity> filme = filmeService.buscarPorId(id);
        return filme.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/adicionar")
    public ResponseEntity<FilmeEntity> adicionarFilme (@Valid @RequestBody FilmeEntity filme) {
        FilmeEntity filmeSalvo = filmeService.salvar(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeSalvo);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<FilmeEntity> atualizarFilme (@PathVariable Long id,@Valid @RequestBody FilmeEntity filmeAtt){
      Optional<FilmeEntity> filmeExiste = filmeService.buscarPorId(id);
      
      if(filmeExiste.isPresent()){
       FilmeEntity filme = filmeExiste.get();
       filme.setTitulo(filmeAtt.getTitulo());
       filme.setSinopse(filmeAtt.getSinopse());
       filme.setGenero(filmeAtt.getGenero());
       filme.setAnolancamento(filmeAtt.getAnolancamento());
       
       FilmeEntity filmeSalvo = filmeService.salvar(filme);
       return ResponseEntity.ok(filmeSalvo);
          
      }else{
         return ResponseEntity.notFound().build();

      }
      
    }
    

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
