package com.loovjo.bloovtech.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.loovjo.bloovtech.tileentity.TileEntityPowerPipe;

public class BlockPowerPipe extends BlockContainer {

	public BlockPowerPipe(Material mat) {
		super(mat);
		useNeighborBrightness = true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityPowerPipe();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return 0;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		return false;
	}

}
