package com.tukalo.university.dao;

import com.tukalo.university.model.Lector;

import java.util.List;

public interface LectorDAO {
    List<Lector> findByTemplate(String template);
}
