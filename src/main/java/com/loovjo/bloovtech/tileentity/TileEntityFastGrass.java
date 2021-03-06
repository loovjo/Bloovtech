package com.loovjo.bloovtech.tileentity;

import java.util.ArrayList;

import com.loovjo.bloovtech.BloovMain;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityFastGrass extends TileEntity {
	public int a = 0;

	@Override
	public void updateEntity() {
		a = 0;
		if (!worldObj.isRemote && a % 5 == 0) {
			int i = 0, j = 0;

			ArrayList<ForgeDirection> d = new ArrayList<ForgeDirection>();
			d.add(ForgeDirection.EAST);
			d.add(ForgeDirection.WEST);
			d.add(ForgeDirection.SOUTH);
			d.add(ForgeDirection.NORTH);
			if (worldObj.rand.nextInt(10) == 0)
				for (int k = 0; k < 9; k++) {
					ForgeDirection dir = d.get(worldObj.rand.nextInt(d.size()));

					int yOffset = worldObj.rand.nextInt(3) - 1;
					if (worldObj.getBlock(xCoord + dir.offsetX, yCoord
							+ yOffset, zCoord + dir.offsetZ) == Blocks.dirt) {
						worldObj.setBlock(xCoord + dir.offsetX, yCoord
								+ yOffset, zCoord + dir.offsetZ,
								BloovMain.blockFastGrass);
					}
				}

			boolean anySideIsDirt = false;
			for (ForgeDirection dir2 : d) {
				for (int i2 = -1; i2 < 1; i2++) {
					if (worldObj.getBlock(xCoord + dir2.offsetX, yCoord + i2,
							zCoord + dir2.offsetZ) == Blocks.dirt) {
						anySideIsDirt = true;
					}
				}
			}
			if (!anySideIsDirt) {
				worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.grass);
			}

			if (worldObj.getBlock(xCoord, yCoord, zCoord) != BloovMain.blockFastGrass) {
				worldObj.removeTileEntity(xCoord, yCoord, zCoord);
			}
		}

	}
}
