package com.gmail.michzuerch.locateipaddress.backend.repositories;

import com.gmail.michzuerch.locateipaddress.backend.data.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
