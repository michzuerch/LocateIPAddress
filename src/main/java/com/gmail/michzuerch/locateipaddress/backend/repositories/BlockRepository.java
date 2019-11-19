package com.gmail.michzuerch.locateipaddress.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.michzuerch.locateipaddress.backend.data.entity.Block;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
