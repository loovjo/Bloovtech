package com.loovjo.bloovtech.tileentity;

import com.loovjo.bloovtech.interfaces.IEnergyConnectable;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityEnergyBarrel extends TileEntity implements IEnergyConnectable {
	public int energyStored, energyMax = 100000;

	@Override
	public boolean canAccept(ForgeDirection fd, int amount) {
		return energyStored + amount <= energyMax;
	}

	@Override
	public void acceptEnergy(int amount, ForgeDirection fd) {
		energyStored += amount;
	}

	@Override
	public boolean canDraw(ForgeDirection fd, int amount) {
		return energyStored - amount >= 0;
	}

	@Override
	public void drawEnergy(int amount, ForgeDirection fd) {
		energyStored -= amount;
		
	}

	public float getEnergyScaled(int scale) {
		return energyStored / (float) energyMax * scale;
	}
}
