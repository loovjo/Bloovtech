package com.loovjo.bloovtech.block;

import com.loovjo.bloovtech.tileentity.TileEntityGrassEater;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGrassEater extends BlockContainer {

	public BlockGrassEater(Material mat) {
		super(mat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new TileEntityGrassEater();
	}

}
