package com.senac.filmeWeb.controller;

import com.senac.filmeWeb.data.FilmeEntity;
import com.senac.filmeWeb.service.FilmeService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaginasController {
    @Autowired
    private FilmeService filmeService;
    // Serve a página de cadastro de filmes
    @GetMapping("/cadastrarFilmes")
    public String cadastrarFilmes(Model model) {
        model.addAttribute("filme", new FilmeEntity()); // Adiciona um novo objeto Filme para ser preenchido no form
        return "cadastrarFilmes"; // Nome do arquivo HTML (cadastrarFilmes.html) dentro de src/main/resources/templates
    }
    
    @GetMapping("/detalhes")
    public String detalhesFilme(@RequestParam Long filmeId, Model model) {  // (@PathVariable Long id, Model model) {
        Optional<FilmeEntity> filme = filmeService.buscarPorId(filmeId);
        if (filme.isPresent()) {
            model.addAttribute("filme", filme.get());
            model.addAttribute("filmeId", filme.get().getId().toString());
            return "detalhes"; // Nome da view para os detalhes
        } else {
            return "erro"; // Nome da página de erro
        }
    }
    
    @GetMapping("/editar")
    public String editarFilme(@RequestParam Long filmeId, Model model) {  // (@PathVariable Long id, Model model) {
        Optional<FilmeEntity> filme = filmeService.buscarPorId(filmeId);
        if (filme.isPresent()) {
            model.addAttribute("filme", filme.get());
            model.addAttribute("filmeId", filme.get().getId().toString());
            return "editarFilmes"; // Nome da view para os detalhes
        } else {
            return "erro"; // Nome da página de erro
        }
    }
    // Serve a página de listagem de filmes
    @GetMapping("/listarFilmes")
    public String listarFilmes() {
        return "listarFilmes"; // Nome do arquivo HTML (listarFilmes.html)
    }
}
