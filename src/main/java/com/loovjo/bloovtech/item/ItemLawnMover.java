package com.loovjo.bloovtech.item;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemLawnMover extends Item {

	public int blocksLalled, maxLalled = 200;
	public Random rand;

	public boolean onSecondUse(ItemStack is, EntityPlayer player, World world,
			int x, int y, int z) {
		// System.out.println(x + " " + y + " " + z);
		if (blocksLalled > maxLalled) {
			return true;
		}
		if (world.getBlock(x, y, z) == Blocks.grass) {
			world.setBlock(x, y, z, Blocks.dirt);

			int i = 0, j = 0;
			ArrayList<ForgeDirection> d = new ArrayList<ForgeDirection>();
			d.add(ForgeDirection.EAST);
			d.add(ForgeDirection.WEST);
			d.add(ForgeDirection.SOUTH);
			d.add(ForgeDirection.NORTH);
			d.add(ForgeDirection.DOWN);
			d.add(ForgeDirection.UP);
			for (int i2 = 0; i2 < d.size(); i2++) {
				int index = rand.nextInt(d.size());
				if (onSecondUse(is, player, world, x + d.get(index).offsetX, y,
						z + d.get(index).offsetZ))
					blocksLalled += 1;

				d.remove(index);
			}

			return true;
		}
		return false;
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world,
			int x, int y, int z, int par7, float par8, float par9, float par10) {
		if (!world.isRemote) {
			blocksLalled = 0;
			maxLalled = 200;
			rand = world.rand;

			boolean a = false;
			try {
				a = onSecondUse(is, player, world, x, y, z);
			} catch (Exception e) {
				a = true;
			}
			return a;
		}
		return false;
	}

}
