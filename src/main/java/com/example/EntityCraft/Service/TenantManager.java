package com.example.EntityCraft.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TenantManager
{

    private final ConcurrentHashMap<String, DataSource> dataSourceMap = new ConcurrentHashMap<>();

}
