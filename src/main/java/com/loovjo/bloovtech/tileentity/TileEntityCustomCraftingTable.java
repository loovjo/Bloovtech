package com.loovjo.bloovtech.tileentity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCustomCraftingTable extends TileEntity {
	public Block type;
	public TileEntityCustomCraftingTable(Block type) {
		this.type = type;
	}
}
