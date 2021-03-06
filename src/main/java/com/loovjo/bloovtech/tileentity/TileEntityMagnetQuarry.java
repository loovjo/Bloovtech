package com.loovjo.bloovtech.tileentity;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.regex.Pattern;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMagnetQuarry extends TileEntity {

	public int i = 0;
	public boolean hasOre;

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote){
			for (Field o : Blocks.class.getFields()) {
				Object obj;
				try {
					obj = o.get(new Blocks());
					if (obj instanceof Block) {

						Block b = (Block) obj;
						if (Pattern.compile("ore|block")
								.matcher(b.getUnlocalizedName()).find()) {
							if (new Random().nextInt(b.getUnlocalizedName().contains("block") ? 90 : 10) == 0) {
								ItemStack is = null;

								if (new Random().nextInt(2) == 0)
									try {
										is = FurnaceRecipes.smelting()
												.getSmeltingResult(
														new ItemStack(b));

									} catch (Exception e) {
									}
								if (is == null) {
									is = new ItemStack(b);
								}
								worldObj.spawnEntityInWorld(new EntityItem(
										worldObj, xCoord + 0.5, yCoord + 2,
										zCoord + 0.5, is));
							}
						}
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		if (new Random().nextInt(200) == 0) {
			worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.air);
			worldObj.createExplosion(null, xCoord, yCoord, zCoord, 5, true);
		}
	}
	}
}
