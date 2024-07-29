package me.dio.lab_publicando_api_rest.service;

import me.dio.lab_publicando_api_rest.model.Contato;

public interface ContatoService {
    Contato findById(int id);
    Contato create(Contato contato);
    void deleteById(int id);
}
