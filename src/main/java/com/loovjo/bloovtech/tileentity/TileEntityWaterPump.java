package com.loovjo.bloovtech.tileentity;

import net.minecraft.dispenser.IPosition;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityWaterPump extends TileEntity {

	public float waterLevel, addLevel, moveSpeed = 20, speed = 50, maxWater = 4000, tick, waterPullInSpeed = 40;
	@Override
	public void updateEntity() {
		waterPullInSpeed = 20;
		tick++;
		super.updateEntity();
		int waterSides = 0;
		for (ForgeDirection dir : ForgeDirection.values()) {
			if (worldObj.getBlock(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ) == Blocks.water) {
				waterSides++;
			}
		}
		if (waterSides > 1 && tick % waterPullInSpeed == 0) {
			addLevel += 1000;
		}
		if (addLevel > 0) {
			waterLevel += speed;
			addLevel -= speed;
		}
		if (addLevel < 0) {
			addLevel = 0;
		}
		if (waterLevel > maxWater) {
			waterLevel = maxWater;
		}
		TileEntity t1 = worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
		if (t1 != null && t1 instanceof TileEntitySteamGenerator) {
			TileEntitySteamGenerator t = (TileEntitySteamGenerator) t1;
			if (waterLevel > 0 && t.waterStored < t.maxWater) {
				t.waterStored += moveSpeed;
				waterLevel -= moveSpeed;
			}
		}
	}

}
