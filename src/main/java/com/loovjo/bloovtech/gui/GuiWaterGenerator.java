package com.loovjo.bloovtech.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LogWrapper;
import net.minecraft.util.ResourceLocation;

import com.loovjo.bloovtech.BloovMain;
import com.loovjo.bloovtech.container.ContainerWaterGenerator;
import com.loovjo.bloovtech.tileentity.TileEntityWaterPump;

public class GuiWaterGenerator extends GuiContainer {

	public ResourceLocation texture = new ResourceLocation(BloovMain.MODID,
			"textures/gui/waterPump.png");
	public TileEntityWaterPump te;

	public GuiWaterGenerator(InventoryPlayer invplayer, TileEntityWaterPump te) {
		super(new ContainerWaterGenerator(invplayer, te));
		this.te = te;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		drawTexturedModalRect(guiLeft + 80, guiTop + 80
				- (int) (te.waterLevel / te.maxWater * 62f), 176, 0, 16,
				 (int) (te.waterLevel / te.maxWater * 62f));

		fontRendererObj.drawString("Water Level: " + te.waterLevel,
				guiLeft + 50, guiTop + 5, 0);
	}

}
