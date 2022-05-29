package com.avaliacao01.tech4music.controller;

import java.util.List;

import com.avaliacao01.tech4music.dto.MusicaDto;
import com.avaliacao01.tech4music.service.MusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
   
    @Autowired
    private MusicaService service;

    @GetMapping
    public List<MusicaDto> listarMusicas(){

        return service.ListarTodasAsMusicas();
    }

    @GetMapping("/{id}")

    public MusicaDto obterPorId(@PathVariable String id){

        return service.obterPorId(id);
    }

    @PostMapping

    public MusicaDto listarMusica(@RequestBody MusicaDto musica){

        return service.adicionarMusica(musica);
    }

    @PutMapping("/{id}")

    public MusicaDto alterarPorId(@PathVariable String id, @RequestBody MusicaDto musica){

        return service.alterarPorId(id, musica);
    }

    @DeleteMapping("/{id}")

    public void excluirMusica(@PathVariable String id){

        service.excluirMusicaPorId(id);
    }




    


}
