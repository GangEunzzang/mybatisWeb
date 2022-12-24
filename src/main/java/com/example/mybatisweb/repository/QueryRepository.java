package com.example.mybatisweb.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class QueryRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getQuery(String query) {
        return jdbcTemplate.queryForList(query);
    }

}
