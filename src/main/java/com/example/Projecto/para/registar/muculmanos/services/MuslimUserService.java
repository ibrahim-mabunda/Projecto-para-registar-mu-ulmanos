package com.example.Projecto.para.registar.muculmanos.services;

import com.example.Projecto.para.registar.muculmanos.models.MuslimUser;
import com.example.Projecto.para.registar.muculmanos.repositories.MuslimUserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuslimUserService {

    private final MuslimUserRepository repository;

    public MuslimUserService(MuslimUserRepository repository) {
        this.repository = repository;
    }

    public List<MuslimUser> listarTodos() {
        return repository.findAll();
    }

    public MuslimUser salvarUsuario(MuslimUser usuario) {
        return repository.save(usuario);
    }

    public Optional<MuslimUser> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletarUsuario(Long id) {
        repository.deleteById(id);
    }

    public List<MuslimUser> buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public List<MuslimUser> buscarPorNomeDaMesquita(String nomeDaMesquita) { // Novo método
        return repository.findByNomeDaMesquita(nomeDaMesquita);
    }
}