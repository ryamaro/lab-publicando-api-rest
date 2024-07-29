package me.dio.lab_publicando_api_rest.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.lab_publicando_api_rest.model.Contato;
import me.dio.lab_publicando_api_rest.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> FindById(@PathVariable int id){
        var contato = contatoService.findById(id);
        return ResponseEntity.ok(contato);
    }

    @PostMapping
    public ResponseEntity<Contato> Crate(@RequestBody Contato contato){
        var contatoCriado = contatoService.create(contato);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(contatoCriado.getId())
            .toUri();
        return ResponseEntity.created(location).body(contatoCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> Delete(@PathVariable int id){
        contatoService.deleteById(id);
        return ResponseEntity.ok(id + " deletado!");
    }
}
