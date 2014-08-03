package com.loovjo.bloovtech.block;

import com.loovjo.bloovtech.BloovMain;
import com.loovjo.bloovtech.tileentity.TileEntitySteamGenerator;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFireDynamo extends BlockContainer {

	public BlockFireDynamo(Material p_i45394_1_) {
		super(p_i45394_1_);
		
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySteamGenerator();
	}

	@Override
	public boolean onBlockActivated(World world, int x,
			int y, int z, EntityPlayer player,
			int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {
		player.openGui(BloovMain.instance, 1, world, x, y, z);
		return true;
	}
	
	

}
