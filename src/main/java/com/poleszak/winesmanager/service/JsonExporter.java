package com.poleszak.winesmanager.service;
import com.poleszak.winesmanager.model.Wine;
import java.util.List;

public interface JsonExporter
{
    String export(List<Wine> customers);
}
