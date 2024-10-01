/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.filmeWeb.controller;

import com.senac.filmeWeb.data.AnaliseEntity;
import com.senac.filmeWeb.data.FilmeEntity;
import com.senac.filmeWeb.service.AnaliseService;
import com.senac.filmeWeb.service.FilmeService;
import jakarta.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analises")
public class AnalisesController {
    @Autowired
    private AnaliseService analiseService;
    @Autowired
    private FilmeService filmeService;

    @PostMapping("/{filmeId}")
    public ResponseEntity<AnaliseEntity> adicionarAnalise(@PathVariable Long filmeId, @Valid @RequestBody AnaliseEntity analise) {
        return filmeService.buscarPorId(filmeId)
                .map(filme -> {
                    analise.setFilme(filme);
                    AnaliseEntity analiseSalva = analiseService.salvar(analise);
                    return ResponseEntity.status(HttpStatus.CREATED).body(analiseSalva);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{filmeId}")
    public ResponseEntity<AnaliseEntity> buscarAnalise(@PathVariable Long filmeId) {
        Optional<AnaliseEntity> analise = analiseService.buscarPorFilmeId(filmeId);
        return analise.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
     @PutMapping("/{filmeId}")
    public ResponseEntity<AnaliseEntity> atualizarAnalise(@PathVariable Long filmeId, @Valid @RequestBody AnaliseEntity analiseAtt) {
        Optional<AnaliseEntity> analiseExistente = analiseService.buscarPorFilmeId(filmeId);

        if (analiseExistente.isPresent()) {
            AnaliseEntity analise = analiseExistente.get();
            analise.setAnalise(analiseAtt.getAnalise());
            analise.setNota(analiseAtt.getNota());

            AnaliseEntity analiseSalva = analiseService.salvar(analise);
            return ResponseEntity.ok(analiseSalva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
      @DeleteMapping("/{filmeId}")
    public ResponseEntity<Void> deletarAnalise(@PathVariable Long filmeId) {
        Optional<AnaliseEntity> analiseExiste = analiseService.buscarPorFilmeId(filmeId);

        if (analiseExiste.isPresent()) {
            AnaliseEntity analise = analiseExiste.get();
            FilmeEntity filme = analise.getFilme();

            filme.setAnalise(null);
            analiseService.deletar(analiseExiste.get().getId());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

