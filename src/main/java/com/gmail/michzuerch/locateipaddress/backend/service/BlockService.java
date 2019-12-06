package com.gmail.michzuerch.locateipaddress.backend.service;

import com.gmail.michzuerch.locateipaddress.backend.data.entity.Block;
import com.gmail.michzuerch.locateipaddress.backend.data.entity.User;
import com.gmail.michzuerch.locateipaddress.backend.repositories.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.BiConsumer;

@Service
public class BlockService implements CrudService<Block> {

	private final BlockRepository blockRepository;

	@Autowired
	public BlockService(BlockRepository blockRepository) {
		super();
		this.blockRepository = blockRepository;
	}

	@Transactional(rollbackOn = Exception.class)
	public Block saveBlock(User currentUser, Long id, BiConsumer<User, Block> blockFiller) {
		Block block;
		if (id == null) {
			block = new Block();
		} else {
			block = load(id);
		}
		blockFiller.accept(currentUser, block);
		return blockRepository.save(block);
	}

	@Transactional(rollbackOn = Exception.class)
	public Block saveBlock(Block block) {
		return blockRepository.save(block);
	}

	@Override
	public JpaRepository<Block, Long> getRepository() {
		return blockRepository;
	}

	@Override
	@Transactional
	public Block createNew(User currentUser) {
		Block block = new Block();
		return block;
	}
}
