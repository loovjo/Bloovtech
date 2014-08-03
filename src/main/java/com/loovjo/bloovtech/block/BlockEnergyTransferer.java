package com.loovjo.bloovtech.block;

import com.loovjo.bloovtech.tileentity.TileEntityEnergyTransferer;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEnergyTransferer extends BlockContainer {

	public BlockEnergyTransferer(Material mat) {
		super(mat);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityEnergyTransferer();
	}

}
