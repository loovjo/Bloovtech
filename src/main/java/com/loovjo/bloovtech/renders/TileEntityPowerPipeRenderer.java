package com.loovjo.bloovtech.renders;

import org.lwjgl.opengl.GL11;

import com.loovjo.bloovtech.BloovMain;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityBeaconRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.shader.TesselatorVertexState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityPowerPipeRenderer extends TileEntitySpecialRenderer {

	ResourceLocation texture = new ResourceLocation(BloovMain.MODID,
			"textures/specialRender/powerPipe.png");

	float pixel = 1 / 16f;

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float d) {
		GL11.glTranslated(x, y, z);
		GL11.glDisable(GL11.GL_CULL_FACE);
		bindTexture(texture);
		drawCore(tileentity);
		GL11.glTranslated(-x, -y, -z);
		GL11.glEnable(GL11.GL_CULL_FACE);
	}

	private void drawCore(TileEntity te) {
		Tessellator t = Tessellator.instance;
		t.startDrawingQuads();;
		{
			t.addVertexWithUV(11*pixel, 11*pixel, 11*pixel, 0, 0);
			t.addVertexWithUV(1-11*pixel, 11*pixel, 11*pixel, 0, 5*pixel);
			t.addVertexWithUV(1-11*pixel, 1-11*pixel, 11*pixel, 5*pixel, 5*pixel);
			t.addVertexWithUV(11*pixel, 1-11*pixel, 11*pixel, 5*pixel, 0);

			t.addVertexWithUV(11*pixel, 11*pixel, 1-11*pixel, 0, 0);
			t.addVertexWithUV(1-11*pixel, 11*pixel, 1-11*pixel, 0, 5*pixel);
			t.addVertexWithUV(1-11*pixel, 1-11*pixel, 1-11*pixel, 5*pixel, 5*pixel);
			t.addVertexWithUV(11*pixel, 1-11*pixel, 1-11*pixel, 5*pixel, 0);

			t.addVertexWithUV(11*pixel, 1-11*pixel, 11*pixel, 0, 0);
			t.addVertexWithUV(11*pixel, 1-11*pixel, 1-11*pixel, 0, 5*pixel);
			t.addVertexWithUV(1-11*pixel, 1-11*pixel, 1-11*pixel, 5*pixel, 5*pixel);
			t.addVertexWithUV(1-11*pixel, 1-11*pixel, 11*pixel, 5*pixel, 0);

			t.addVertexWithUV(11*pixel, 11*pixel, 11*pixel, 0, 0);
			t.addVertexWithUV(11*pixel, 11*pixel, 1-11*pixel, 0, 5*pixel);
			t.addVertexWithUV(1-11*pixel, 11*pixel, 1-11*pixel, 5*pixel, 5*pixel);
			t.addVertexWithUV(1-11*pixel, 11*pixel, 11*pixel, 5*pixel, 0);

			t.addVertexWithUV(11*pixel, 11*pixel, 11*pixel, 0, 0);
			t.addVertexWithUV(11*pixel, 1-11*pixel, 11*pixel, 0, 5*pixel);
			t.addVertexWithUV(11*pixel, 1-11*pixel, 1-11*pixel, 5*pixel, 5*pixel);
			t.addVertexWithUV(11*pixel, 11*pixel, 1-11*pixel, 5*pixel, 0);

			t.addVertexWithUV(1-11*pixel, 11*pixel, 11*pixel, 0, 0);
			t.addVertexWithUV(1-11*pixel, 1-11*pixel, 11*pixel, 0, 5*pixel);
			t.addVertexWithUV(1-11*pixel, 1-11*pixel, 1-11*pixel, 5*pixel, 5*pixel);
			t.addVertexWithUV(1-11*pixel, 11*pixel, 1-11*pixel, 5*pixel, 0);
			
		}
		t.draw();
	}

}
