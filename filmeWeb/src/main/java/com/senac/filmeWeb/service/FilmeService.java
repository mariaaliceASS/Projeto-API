
package com.senac.filmeWeb.service;

import com.senac.filmeWeb.data.FilmeEntity;
import com.senac.filmeWeb.data.FilmeRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public List<FilmeEntity> listarTodos() {
        return filmeRepository.findAll();
    }

    public Optional<FilmeEntity> buscarPorId(Long id) {
        return filmeRepository.findById(id);
    }

    public FilmeEntity salvar(FilmeEntity filme) {
        return filmeRepository.save(filme);
    }

    public void deletar(Long id) {
        filmeRepository.deleteById(id);
    }
}