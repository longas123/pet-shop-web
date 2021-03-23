package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnidadeRepository {

    private JdbcTemplate jdbcTemplate;

    public UnidadeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Unidade> listar(){
        return jdbcTemplate.query("select id, nome, endereco from tb_unidade", new UnidadeMapper());
    }
}
