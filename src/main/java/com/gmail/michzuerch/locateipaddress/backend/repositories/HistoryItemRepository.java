package com.gmail.michzuerch.locateipaddress.backend.repositories;

import com.gmail.michzuerch.locateipaddress.backend.data.entity.HistoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
