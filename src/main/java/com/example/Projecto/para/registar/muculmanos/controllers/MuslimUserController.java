package com.example.Projecto.para.registar.muculmanos.controllers;

import com.example.Projecto.para.registar.muculmanos.models.MuslimUser;
import com.example.Projecto.para.registar.muculmanos.services.MuslimUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/muslim-users")
public class MuslimUserController {

    private final MuslimUserService service;

    public MuslimUserController(MuslimUserService service) {
        this.service = service;
    }

    @Operation(
        summary = "Listar todos os usuários muçulmanos",
        description = "Este endpoint retorna uma lista de todos os usuários muçulmanos cadastrados",
        tags = {"Usuários Muçulmanos"}
    )
    @ApiResponse(responseCode = "200", description = "Lista de usuários muçulmanos retornada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @ApiResponse(responseCode = "404", description = "Nenhum usuário muçulmano encontrado")
    @GetMapping
    public ResponseEntity<List<MuslimUser>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<MuslimUser> salvarUsuario(@RequestBody MuslimUser usuario) {
        return ResponseEntity.ok(service.salvarUsuario(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MuslimUser> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        service.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<MuslimUser>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    @GetMapping("/search-mesquita")
    public ResponseEntity<List<MuslimUser>> buscarPorNomeDaMesquita(@RequestParam String nomeDaMesquita) {
        return ResponseEntity.ok(service.buscarPorNomeDaMesquita(nomeDaMesquita));
    }
}

