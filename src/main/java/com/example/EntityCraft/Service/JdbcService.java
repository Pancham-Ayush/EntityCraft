package com.example.EntityCraft.Service;

import com.example.EntityCraft.Contract.JdbcContract;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;


    @Service
    public class JdbcService implements JdbcContract {

    private final DataSource dataSource;

    public JdbcService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean createDatabase(String tenantName) {

        String sql = """
                      CREATE DATABASE %s
                     """.formatted(tenantName);

        try (
                Connection con = dataSource.getConnection();

                PreparedStatement ps =
                        con.prepareStatement(sql)
        )
        {
            ps.executeUpdate();
            return true;
        }
        catch (Exception e) {

            return false;
        }
    }


    }