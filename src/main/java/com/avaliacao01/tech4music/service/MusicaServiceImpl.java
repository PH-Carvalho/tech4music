package com.avaliacao01.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.avaliacao01.tech4music.dto.MusicaDto;
import com.avaliacao01.tech4music.model.Musica;
import com.avaliacao01.tech4music.repository.MusicaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<MusicaDto> ListarTodasAsMusicas() {
        List<Musica> musicas = repository.findAll();

        List<MusicaDto> musicasDto = musicas.stream()
        .map(p->mapper.map(p,MusicaDto.class))
        .collect(Collectors.toList());
        
        return musicasDto;
    }

    @Override
    public MusicaDto obterPorId(String id) {
        Optional<Musica> musica = repository.findById(id);

        if(musica.isPresent()){
        return  mapper.map(musica.get(), MusicaDto.class) ;
        }
        return null;
    }

    @Override
    public MusicaDto adicionarMusica(MusicaDto musica) {
        
        Musica musicaAdicionar = mapper.map(musica, Musica.class);
        
        repository.save(musicaAdicionar);

        return mapper.map(musicaAdicionar, MusicaDto.class);


    }

    @Override
    public void excluirMusicaPorId(String id) {
       
        repository.deleteById(id);
        
    }

    @Override
    public MusicaDto alterarPorId(String id, MusicaDto musica) {

        Optional<Musica> buscarMusica = repository.findById(id);

        if(buscarMusica.isPresent()){
        
        Musica musicaAlterar = mapper.map(musica, Musica.class);
        musicaAlterar.setId(id);
        musicaAlterar= repository.save(musicaAlterar);
        return mapper.map(musicaAlterar, MusicaDto.class);
        }

        return null;
    }
    
    
}
