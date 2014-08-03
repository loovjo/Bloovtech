package com.loovjo.bloovtech.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import com.loovjo.bloovtech.BloovMain;
import com.loovjo.bloovtech.container.ContainerElectricBag;

public class GuiElectricBag extends GuiContainer {
	
	ResourceLocation texture = new ResourceLocation(BloovMain.MODID, "textures/gui/electricbag.png");
	
	public GuiElectricBag(InventoryPlayer invplayer, TileEntity te) {
		super(new ContainerElectricBag(invplayer, te));
		xSize = 248;
		ySize = 254;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
