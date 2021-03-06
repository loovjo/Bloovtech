package com.loovjo.bloovtech.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import com.loovjo.bloovtech.BloovMain;
import com.loovjo.bloovtech.container.ContainerSteamGenerator;
import com.loovjo.bloovtech.tileentity.TileEntitySteamGenerator;

public class GuiSteamGenerator extends GuiContainer {

	ResourceLocation texture = new ResourceLocation(BloovMain.MODID,
			"textures/gui/firedynamo.png");
	TileEntitySteamGenerator te;

	public GuiSteamGenerator(InventoryPlayer inv, TileEntitySteamGenerator te) {
		super(new ContainerSteamGenerator(inv, te));
		this.te = te;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		drawTexturedModalRect(guiLeft + 80,
				guiTop + 69 - te.getSteamScaled(62), 176, 14, 16,
				te.getSteamScaled(62));
		if (te.fuelLevel != 0)
			drawTexturedModalRect(guiLeft + 45,
					guiTop + 36 + 14 - te.getFuelScaled(12), 176,
					12 - te.getFuelScaled(12), 14, te.getFuelScaled(12));
	
		drawTexturedModalRect(guiLeft + 8,
				guiTop + 69 - te.getWaterScaled(62), 192, 14, 16,
				te.getWaterScaled(62));

		fontRendererObj.drawString("Water Level: " + te.waterStored,
				guiLeft + 50, guiTop + 5, 0);

		fontRendererObj.drawString("Steam     Generator", guiLeft + 50,
				guiTop + 20, 0);

	}

}
