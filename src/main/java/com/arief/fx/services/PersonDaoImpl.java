package com.arief.fx.services;

import com.arief.fx.entity.Person;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Arief on 8/20/2017.
 */
@Repository
public class PersonDaoImpl implements PersonDAO {


    @Autowired
    private NamedParameterJdbcTemplate named;



    @Override
    public void simpanData(Person p) throws PSQLException{
       String sql= "insert into person values (:id,:nama) ";

       Map map = new HashMap();

       map.put("id",p.getId());
       map.put("nama",p.getNama());

       named.update(sql,map);

    }

    @Override
    public List<Person> getAll() {
        String sql = "select * from person";
        return
                named.query(sql,new BeanPropertyRowMapper<Person>(Person.class));
    }
}
