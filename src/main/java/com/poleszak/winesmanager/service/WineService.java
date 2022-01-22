package com.poleszak.winesmanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poleszak.winesmanager.exception.UserNotFoundException;
import com.poleszak.winesmanager.model.Wine;
import com.poleszak.winesmanager.repo.WineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class WineService
{
    @Value("${pathFile}")
    public String pathFile;

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

    @Transactional
    public void deleteWine(Long id)
    {
        wineRepo.deleteWineById(id);
    }

    public void addWineToFile(Wine wine)
    {
        ObjectMapper mapper = new ObjectMapper();

        try {
            final String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(wine);

            Files.write(new File(pathFile).toPath(), List.of(json), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
