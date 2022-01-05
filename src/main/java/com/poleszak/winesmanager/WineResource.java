package com.poleszak.winesmanager;

import com.poleszak.winesmanager.model.Wine;
import com.poleszak.winesmanager.service.WineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/wine")
public class WineResource
{
    private final WineService wineService;

    public WineResource(WineService wineService)
    {
        this.wineService = wineService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Wine>> getAllWines ()
    {
        List<Wine> wines = wineService.findAllWines();

        return new ResponseEntity<>(wines, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Wine> getWineById (@PathVariable("id") Long id)
    {
        Wine wine = wineService.findWineById(id);

        return new ResponseEntity<>(wine, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Wine> addWine(@RequestBody Wine wine)
    {
        Wine newWine = wineService.addWine(wine);
        wineService.addWineToFile(wine);

        return new ResponseEntity<>(newWine, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Wine> updateWine(@RequestBody Wine wine)
    {
        Wine updateWine = wineService.updateWine(wine);

        return new ResponseEntity<>(updateWine, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWine(@PathVariable("id") Long id)
    {
        wineService.deleteWine(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
