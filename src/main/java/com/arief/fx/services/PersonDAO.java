package com.arief.fx.services;

import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Repository;

/**
 * Created by Arief on 8/20/2017.
 */

import com.arief.fx.entity.Person;
import java.util.List;


public interface PersonDAO {

    void simpanData(Person p) throws PSQLException;
    List<Person> getAll();
}
