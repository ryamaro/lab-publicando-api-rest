package me.dio.lab_publicando_api_rest.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.lab_publicando_api_rest.model.Contato;
import me.dio.lab_publicando_api_rest.repository.ContatoRepository;
import me.dio.lab_publicando_api_rest.service.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Override
    public Contato findById(int id) {
        return contatoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Contato create(Contato contato) {
        if (contatoRepository.existsBylinkedin(contato.getLinkedin())) {
            throw new IllegalArgumentException("esse usuario ja existe");
        }

        return contatoRepository.save(contato);
    }

    @Override
    public void deleteById(int id) {

        contatoRepository.findById(id).orElseThrow(NoSuchElementException::new);
        contatoRepository.deleteById(id);
    }

}
