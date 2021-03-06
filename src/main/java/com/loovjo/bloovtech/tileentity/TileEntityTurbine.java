package com.loovjo.bloovtech.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityTurbine extends TileEntity {
	public int powerMax = 8000, powerStored = 0, steamStored,
			steamToPowerRate = 2, hmspp = 10, steamMax = 16000,
			transferRate = 20;

	@Override
	public void updateEntity() {
		if (steamStored > steamToPowerRate - 1) {
			if (powerStored < powerMax)
				powerStored += hmspp;
			steamStored -= hmspp * steamToPowerRate * powerStored == 0 ? 1
					: 0.05;
		}
		TileEntity te = worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
		if (te != null && te instanceof TileEntityEnergyBarrel) {
			TileEntityEnergyBarrel te2 = (TileEntityEnergyBarrel) te;
			for (int i = 0; i < transferRate; i++) {
				if (powerStored > 0) {
					if (te2.energyStored < te2.energyMax) {
						te2.energyStored++;
						powerStored--;
					}
				}
			}
		}

	}

	public int getPowerScaled(int scale) {
		return (int) (powerStored / (float) powerMax * scale);
	}

	public int getSteamScaled(int scale) {
		return (int) (steamStored / (float) steamMax * scale);
	}
}
