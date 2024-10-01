/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.filmeWeb.service;

import com.senac.filmeWeb.data.AnaliseEntity;
import com.senac.filmeWeb.data.AnaliseRepository;
import com.senac.filmeWeb.data.FilmeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service 
@Transactional
public class AnaliseService {
    @Autowired
    private AnaliseRepository analiseRepository;
    
    @Autowired
    private FilmeRepository filmeRepository;
    
    public Optional<AnaliseEntity> buscarPorId(Long id) {
    return analiseRepository.findById(id);
}
    
    public Optional<AnaliseEntity> buscarPorFilmeId(Long filmeId){
        return Optional.ofNullable(analiseRepository.findByFilmeId(filmeId));
    }
    
    public AnaliseEntity salvar(AnaliseEntity analise){
        return analiseRepository.save(analise);
    }
    
    public void deletar (Long id){
        analiseRepository.deleteById(id);
    }
}
