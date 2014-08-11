package com.loovjo.bloovtech.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityCutWood extends TileEntity {

	private int tick, tickMax = -1, leavesJumped, maxLeavesJumped = 2;
	private EntityPlayer player;
	private ItemStack is;

	public TileEntityCutWood(EntityPlayer p, ItemStack is) {
		player = p;
		this.is = is;
	}

	public TileEntityCutWood(EntityPlayer p, ItemStack is, int leavesJumped) {
		player = p;
		this.is = is;
		this.leavesJumped = leavesJumped;
	}

	@Override
	public void updateEntity() {
		if (tickMax < 0)
			tickMax = worldObj.rand.nextInt(4);
		if (!worldObj.isRemote) {
			// System.out.println(tick);
			if (tick >= tickMax) {
				tick = -1;
				this.worldObj.removeTileEntity(this.xCoord, this.yCoord,
						this.zCoord);
				this.invalidate();
				if (is.getItemDamage() > 0) {
					if (worldObj.getBlock(xCoord, yCoord, zCoord) == Blocks.log
							|| worldObj.getBlock(xCoord, yCoord, zCoord) == Blocks.log2) {
						worldObj.func_147480_a(xCoord, yCoord, zCoord, true);

						if (is.attemptDamageItem(1, worldObj.rand)) {
							for (int i = 0; i < player.inventory
									.getSizeInventory(); i++) {
								ItemStack a = player.inventory
										.getStackInSlot(i);
								if (a != null) {
									if (a.equals(is)) {
										player.inventory.setInventorySlotContents(i, null);
									}
								}
							}
						}

					}

					for (int offsetX = -1; offsetX < 2; offsetX++) {
						for (int offsetY = -1; offsetY < 2; offsetY++) {
							for (int offsetZ = -1; offsetZ < 2; offsetZ++) {
								int x = xCoord + offsetX, y = yCoord + offsetY, z = zCoord
										+ offsetZ;
								if (worldObj.getBlock(x, y, z) == Blocks.log
										|| worldObj.getBlock(x, y, z) == Blocks.log2
										|| worldObj.getBlock(x, y, z) == Blocks.leaves
										|| worldObj.getBlock(x, y, z) == Blocks.leaves2) {
									// System.out.println(worldObj.getBlock(x,
									// y, z));
									int lj = leavesJumped;
									if (worldObj.getBlock(x, y, z) == Blocks.leaves
											|| worldObj.getBlock(x, y, z) == Blocks.leaves2)
										lj++;
									else
										lj = 0;
									if (lj < maxLeavesJumped)
										worldObj.setTileEntity(x, y, z,
												new TileEntityCutWood(player,
														is, lj));
									// System.out.println("lal");

								}
							}
						}
					}
				}
			}
			if (tick >= 0)
				tick++;
			if (is.getItemDamage() <= 0) {
				is.setItemDamage(0);
			}

		}
	}
}