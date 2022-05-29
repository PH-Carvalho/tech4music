package com.avaliacao01.tech4music.service;

import java.util.List;

import com.avaliacao01.tech4music.dto.MusicaDto;

public interface MusicaService {
    
    List<MusicaDto> ListarTodasAsMusicas();
    MusicaDto obterPorId(String id);
    MusicaDto adicionarMusica(MusicaDto musica);
    void excluirMusicaPorId(String id);
    MusicaDto alterarPorId(String id , MusicaDto musica);
}
