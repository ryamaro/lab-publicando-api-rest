package me.dio.lab_publicando_api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.lab_publicando_api_rest.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{

    boolean existsBylinkedin(String linkedin);
}
