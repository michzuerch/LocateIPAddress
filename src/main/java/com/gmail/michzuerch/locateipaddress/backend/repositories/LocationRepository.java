package com.gmail.michzuerch.locateipaddress.backend.repositories;

import com.gmail.michzuerch.locateipaddress.backend.data.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
