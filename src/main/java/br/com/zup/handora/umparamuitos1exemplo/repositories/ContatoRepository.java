package br.com.zup.handora.umparamuitos1exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.handora.umparamuitos1exemplo.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
