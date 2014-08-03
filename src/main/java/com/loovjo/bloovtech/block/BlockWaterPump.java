package com.loovjo.bloovtech.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.loovjo.bloovtech.BloovMain;
import com.loovjo.bloovtech.tileentity.TileEntityWaterPump;

public class BlockWaterPump extends BlockContainer {

	public BlockWaterPump(Material mat) {
		super(mat);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityWaterPump();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int p_149727_6_, float p_149727_7_,
			float p_149727_8_, float p_149727_9_) {
		player.openGui(BloovMain.instance, 2, world, x, y, z);
		return true;
	}

}
