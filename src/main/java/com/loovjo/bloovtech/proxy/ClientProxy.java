package com.loovjo.bloovtech.proxy;

import com.loovjo.bloovtech.renders.TileEntityCustomCraftingTableRenderer;
import com.loovjo.bloovtech.renders.TileEntityPowerPipeRenderer;
import com.loovjo.bloovtech.tileentity.TileEntityCustomCraftingTable;
import com.loovjo.bloovtech.tileentity.TileEntityPowerPipe;
import com.loovjo.bloovtech.tileentity.TileEntityWaterPump;
import com.loovjo.bloovtech.tileentity.TileEntityWaterPumpRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	@Override()
	public void registerRenderStuff() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerPipe.class, new TileEntityPowerPipeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterPump.class, new TileEntityWaterPumpRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomCraftingTable.class, new TileEntityCustomCraftingTableRenderer());
	}
}
