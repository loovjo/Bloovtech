package com.loovjo.bloovtech.container;

import com.loovjo.bloovtech.tileentity.TileEntityInfuser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerInfuser extends Container {

	public ContainerInfuser(InventoryPlayer inventory,
			TileEntityInfuser tileEntity) {
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return true;
	}

}
