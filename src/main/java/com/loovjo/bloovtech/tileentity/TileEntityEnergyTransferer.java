package com.loovjo.bloovtech.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import com.loovjo.bloovtech.interfaces.IEnergyConnectable;

public class TileEntityEnergyTransferer extends TileEntity {
	private int x, y, z, energy, transferrate = 20;
	private boolean hasChecked;

	public void updateEntity() {
		if (!hasChecked) {
			hasChecked = true;
			x = xCoord;
			y = yCoord;
			z = zCoord;
		}

		for (ForgeDirection fd : ForgeDirection.values()) {
			TileEntity te = worldObj.getTileEntity(x + fd.offsetX, y
					+ fd.offsetY, z + fd.offsetZ);
			if (te instanceof IEnergyConnectable) {
				IEnergyConnectable te2 = (IEnergyConnectable) te;
				if (te2.canAccept(fd, transferrate)) {
					te2.acceptEnergy(transferrate, fd);
				}

			}
		}
		for (ForgeDirection fd : ForgeDirection.values()) {
			TileEntity te = worldObj.getTileEntity(xCoord + fd.offsetX, yCoord
					+ fd.offsetY, zCoord + fd.offsetZ);
			if (te instanceof IEnergyConnectable) {
				IEnergyConnectable te2 = (IEnergyConnectable) te;
				if (te2.canDraw(fd, transferrate)) {
					te2.drawEnergy(transferrate, fd);
				}

			}
		}
	}
}
