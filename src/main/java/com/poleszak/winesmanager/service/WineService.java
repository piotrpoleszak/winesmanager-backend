package com.poleszak.winesmanager.service;

import com.poleszak.winesmanager.exception.UserNotFoundException;
import com.poleszak.winesmanager.model.Wine;
import com.poleszak.winesmanager.repo.WineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
