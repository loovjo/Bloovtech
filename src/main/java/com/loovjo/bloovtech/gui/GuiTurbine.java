package com.loovjo.bloovtech.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.loovjo.bloovtech.BloovMain;
import com.loovjo.bloovtech.container.ContainerSteamGenerator;
import com.loovjo.bloovtech.container.ContainerTurbine;
import com.loovjo.bloovtech.tileentity.TileEntityTurbine;

public class GuiTurbine extends GuiContainer {

	public ResourceLocation texture = new ResourceLocation(BloovMain.MODID,
			"textures/gui/turbine.png");
	public TileEntityTurbine te;
	public GuiTurbine(InventoryPlayer invplayer, TileEntityTurbine te) {
		super(new ContainerTurbine(invplayer, te));
		this.te = te;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		drawTexturedModalRect(guiLeft + 80,
				guiTop + 69 - te.getPowerScaled(62), 176, 0, 16,
				te.getPowerScaled(62));

		drawTexturedModalRect(guiLeft + 8,
				guiTop + 69 - te.getSteamScaled(62), 192, 0, 16,
				te.getSteamScaled(62));
		
		fontRendererObj.drawSplitString(I18n.format("message.eb.energy", new Object[] {te.powerStored, te.powerMax, te.getPowerScaled(100)+"%"}), guiLeft + 97, guiTop + 6, 76, 0);
	}

}
