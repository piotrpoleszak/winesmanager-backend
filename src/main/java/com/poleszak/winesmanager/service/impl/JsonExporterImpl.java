package com.poleszak.winesmanager.service.impl;

import com.google.gson.Gson;
import com.poleszak.winesmanager.model.Wine;
import com.poleszak.winesmanager.service.JsonExporter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonExporterImpl implements JsonExporter
{

    @Override
    public String export(List<Wine> customers) {
        Gson gson = new Gson();
        String customerInJson = gson.toJson(customers);
        return customerInJson;
    }

}