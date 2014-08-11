package com.loovjo.bloovtech.tileentity;

import java.util.ArrayList;

import com.loovjo.bloovtech.BloovMain;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityGrassEater extends TileEntity {
	public int a = 0;

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote && a % 5 == 0) {
			int i = 0, j = 0;

			ArrayList<ForgeDirection> d = new ArrayList<ForgeDirection>();
			d.add(ForgeDirection.EAST);
			d.add(ForgeDirection.WEST);
			d.add(ForgeDirection.SOUTH);
			d.add(ForgeDirection.NORTH);
			if (worldObj.rand.nextInt(10) == 0)
				for (int k = 0; k < 3; k++) {
					ForgeDirection dir = d.get(worldObj.rand.nextInt(d.size()));
					int yOffset = worldObj.rand.nextInt(3) - 1;
					if (worldObj.getBlock(xCoord + dir.offsetX, yCoord
							+ yOffset, zCoord + dir.offsetZ) == Blocks.grass) {
						worldObj.setBlock(xCoord + dir.offsetX, yCoord
								+ yOffset, zCoord + dir.offsetZ,
								BloovMain.blockGrassEater);
					}
				}

			boolean anySideIsGrass = false;
			for (ForgeDirection dir2 : d) {
				if (worldObj.getBlock(xCoord + dir2.offsetX, yCoord
						+ dir2.offsetY, zCoord + dir2.offsetZ) == Blocks.grass) {
					anySideIsGrass = true;
				}
			}
			if (!anySideIsGrass) {
				worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.dirt);
			}

			if (worldObj.getBlock(xCoord, yCoord, zCoord) != BloovMain.blockGrassEater) {
				worldObj.removeTileEntity(xCoord, yCoord, zCoord);
			}
		}

	}
}