package com.loovjo.bloovtech.interfaces;

import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergyConnectable {
	public boolean canAccept(ForgeDirection fd, int amount);
	// Only going to be called if "canAccept" is true
	public void acceptEnergy(int amount, ForgeDirection fd);
	public boolean canDraw(ForgeDirection fd, int amount);
	// Only going to be called if "canDraw" is true
	public void drawEnergy(int amount, ForgeDirection fd);
}
