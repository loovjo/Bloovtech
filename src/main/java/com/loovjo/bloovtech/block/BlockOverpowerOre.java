package com.loovjo.bloovtech.block;

import java.util.ArrayList;
import java.util.Arrays;

import com.loovjo.bloovtech.BloovMain;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockOverpowerOre extends Block {

	public BlockOverpowerOre(Material mat) {
		super(mat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z,
			int metadata, int fortune) {
		return new ArrayList<ItemStack>(Arrays.asList(new ItemStack[] {new ItemStack(BloovMain.blockOverPowerOre)}));
	}

}
