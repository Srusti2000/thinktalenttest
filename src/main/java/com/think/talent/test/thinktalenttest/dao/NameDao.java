package com.think.talent.test.thinktalenttest.dao;

import com.think.talent.test.thinktalenttest.domain.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NameDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Name> list() {
        String sql = "SELECT * FROM NAME";
        List<Name> listName = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Name.class));
        return listName;
    }
    public void save(Name name) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("name").usingColumns("id", "firstName", "lastName","fullName");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(name);
        insertActor.execute(param);
    }

    public Name get(int id) {
        String sql = "SELECT * FROM NAME WHERE id = ?";
        Object[] args = {id};
        Name name = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Name.class));
        return name;
    }

    public void update(Name name) {
        String sql = "UPDATE NAME SET firstname=:firstName, lastname=:lastName WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(name);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM NAME WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
