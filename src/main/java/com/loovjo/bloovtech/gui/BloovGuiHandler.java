package com.loovjo.bloovtech.gui;

import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.world.World;

import com.loovjo.bloovtech.container.ContainerElectricBag;
import com.loovjo.bloovtech.container.ContainerInfuser;
import com.loovjo.bloovtech.container.ContainerSteamGenerator;
import com.loovjo.bloovtech.container.ContainerTurbine;
import com.loovjo.bloovtech.container.ContainerWaterGenerator;
import com.loovjo.bloovtech.tileentity.TileEntityInfuser;
import com.loovjo.bloovtech.tileentity.TileEntitySteamGenerator;
import com.loovjo.bloovtech.tileentity.TileEntityTurbine;
import com.loovjo.bloovtech.tileentity.TileEntityWaterPump;

import cpw.mods.fml.common.network.IGuiHandler;

public class BloovGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case 0:
			return new ContainerElectricBag(player.inventory,
					world.getTileEntity(x, y, z));
		case 1:
			return new ContainerSteamGenerator(player.inventory,
					(TileEntitySteamGenerator) world.getTileEntity(x, y, z));
		case 2:
			return new ContainerWaterGenerator(player.inventory,
					(TileEntityWaterPump) world.getTileEntity(x, y, z));
		case 3:
			return new ContainerWorkbench(player.inventory, world, x, y, z);
		case 4:
			return new ContainerTurbine(player.inventory, (TileEntityTurbine) world.getTileEntity(x, y, z));
		case 5:
			return new ContainerInfuser(player.inventory, (TileEntityInfuser) world.getTileEntity(x, y, z));
		
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch (ID) {
		case 0:
			return new GuiElectricBag(player.inventory, world.getTileEntity(x,
					y, z));
		case 1:
			return new GuiSteamGenerator(player.inventory,
					(TileEntitySteamGenerator) world.getTileEntity(x, y, z));
		case 2:
			return new GuiWaterGenerator(player.inventory, (TileEntityWaterPump) world.getTileEntity(x, y, z));
		case 3:
			return new GuiCrafting(player.inventory, world, x, y, z);
		case 4:
			return new GuiTurbine(player.inventory, (TileEntityTurbine) world.getTileEntity(x, y, z));
		case 5:
			return new GuiInfuser();
		
		}
		
		return null;
	}
}
