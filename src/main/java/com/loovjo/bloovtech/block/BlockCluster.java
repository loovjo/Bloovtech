package com.loovjo.bloovtech.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCluster extends Block {

	public BlockCluster(Material p_i45394_1_) {
		super(p_i45394_1_);
		setHarvestLevel("pickaxe", 2);
	}

}
