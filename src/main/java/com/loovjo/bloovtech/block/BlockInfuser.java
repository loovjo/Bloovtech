package com.loovjo.bloovtech.block;

import com.loovjo.bloovtech.BloovMain;
import com.loovjo.bloovtech.tileentity.TileEntityInfuser;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInfuser extends BlockContainer {

	public BlockInfuser(Material mat) {
		super(mat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new TileEntityInfuser();
	}

	@Override
	public boolean onBlockActivated(World world, int x,
			int y, int z, EntityPlayer player,
			int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {
		player.openGui(BloovMain.instance, 5, world, x, y, z);
		return false;
	}

}
