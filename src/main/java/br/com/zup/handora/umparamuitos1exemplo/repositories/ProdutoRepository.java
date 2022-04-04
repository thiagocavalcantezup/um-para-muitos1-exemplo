package br.com.zup.handora.umparamuitos1exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.handora.umparamuitos1exemplo.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
