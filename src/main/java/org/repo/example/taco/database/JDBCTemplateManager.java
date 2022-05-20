package org.repo.example.taco.database;

import org.repo.example.taco.models.Ingredient;
import org.repo.example.taco.models.Type;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplateManager {

    private JdbcTemplate jdbc;


    public Ingredient findOne(String id){
        return jdbc.queryForObject(
            "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient, id);

    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Type.valueOf(rs.getString("type")));

    }
}
