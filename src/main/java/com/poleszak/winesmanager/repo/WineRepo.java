package com.poleszak.winesmanager.repo;

import com.poleszak.winesmanager.model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WineRepo extends JpaRepository<Wine, Long>
{
    void deleteWineById(Long id);

    Optional<Wine> findWineById(Long id);
}
