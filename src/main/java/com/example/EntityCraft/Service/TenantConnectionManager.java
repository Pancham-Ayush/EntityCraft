package com.example.EntityCraft.Service;

import com.example.EntityCraft.Configuration.DB_CONFIG;
import com.example.EntityCraft.Entity.DataBase;
import com.example.EntityCraft.Entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TenantManager
{

    @Autowired
    UserService  userService;

    @Autowired
    DB_CONFIG dbConfig;

    private final ConcurrentHashMap<Long, DataSource> dataSourceMap = new ConcurrentHashMap<>();

    public boolean createConnection(@RequestParam Long tenantId,String dbName)
    {
        if(dataSourceMap.containsKey(tenantId))
            return false;
        Tenant tenant = userService.findById(tenantId);
        if (tenant == null)
            return false;
        Optional<DataBase> optionalDataBase = tenant
                .getDbList()
                .stream()
                .filter(x -> x.getDbName().equalsIgnoreCase(dbName))
                .findFirst();

        if (!optionalDataBase.isPresent())
            return false;

        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(dbConfig.getDriverClassName());

        dataSource.setUrl(dbConfig.getBaseUrl()+ optionalDataBase.get().getDbName());

        dataSource.setUsername(dbConfig.getUsername());
        dataSource.setPassword(dbConfig.getPassword());

        dataSourceMap.put(
                tenantId,
                dataSource
        );

        return true;
    }
}
