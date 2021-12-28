package com.poleszak.winesmanager.service;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.poleszak.winesmanager.exception.UserNotFoundException;
import com.poleszak.winesmanager.model.Wine;
import com.poleszak.winesmanager.repo.WineRepo;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class WineService
{
    private final WineRepo wineRepo;

    @Autowired
    public WineService(WineRepo wineRepo)
    {
        this.wineRepo = wineRepo;
    }

    public Wine addWine(Wine wine)
    {
        wine.setWineCode(UUID.randomUUID().toString());

        return wineRepo.save(wine);
    }

    public List<Wine> findAllWines()
    {
        return wineRepo.findAll();
    }

    public Wine updateWine(Wine wine)
    {
        return wineRepo.save(wine);
    }

    public Wine findWineById(Long id)
    {
        return wineRepo.findWineById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteWine(Long id)
    {
        wineRepo.deleteWineById(id);
    }

    public void addWineToFile(Wine wine)
    {
        ObjectMapper mapper = new ObjectMapper();

        try {
            final String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(wine);

            Files.write(new File("C:\\Users\\poles\\OneDrive\\Pulpit\\Projects\\winesmanager-backend\\src\\main\\java\\com\\poleszak\\winesmanager\\db\\data.json").toPath(), Arrays.asList(json), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
