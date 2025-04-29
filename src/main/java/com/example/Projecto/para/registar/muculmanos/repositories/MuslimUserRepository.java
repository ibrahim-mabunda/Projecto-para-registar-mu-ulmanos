package com.example.Projecto.para.registar.muculmanos.repositories;

import com.example.Projecto.para.registar.muculmanos.models.MuslimUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuslimUserRepository extends JpaRepository<MuslimUser, Long> {
    List<MuslimUser> findByNome(String nome); // Busca por nome
    List<MuslimUser> findByNomeDaMesquita(String nomeDaMesquita); // Busca por nome da mesquita
}