package com.loovjo.bloovtech.tileentity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import com.loovjo.bloovtech.BloovMain;

public class TileEntityWaterPumpRenderer extends TileEntitySpecialRenderer {

	ResourceLocation texture = new ResourceLocation(BloovMain.MODID,
			"textures/specialRender/waterPump.png");

	private float pixel = 1 / 16f;

	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y,
			double z, float var8) {
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslated(x, y-0.7, z);
		GL11.glDisable(GL11.GL_CULL_FACE);
		pixel = 1 / 16f;
		Tessellator t = Tessellator.instance;
		bindTexture(texture);
		t.startDrawingQuads();
		{
			t.addVertexWithUV(11 * pixel, 1 - 11 * pixel, 11*pixel, 5*pixel, 0);
			t.addVertexWithUV(11 * pixel, 11 * pixel, 11*pixel, 5*pixel, 5*pixel);
			t.addVertexWithUV(1 - 11 * pixel, 11 * pixel, 11*pixel, 0, 5*pixel);
			t.addVertexWithUV(1 - 11 * pixel, 1 - 11 * pixel, 11*pixel, 0, 0);

			t.addVertexWithUV(11 * pixel, 1 - 11 * pixel, 1-11*pixel, 5*pixel, 0);
			t.addVertexWithUV(1 - 11 * pixel, 1 - 11 * pixel, 1-11*pixel, 0, 0);
			t.addVertexWithUV(1 - 11 * pixel, 11 * pixel, 1-11*pixel, 0, 5*pixel);
			t.addVertexWithUV(11 * pixel, 11 * pixel, 1-11*pixel, 5*pixel, 5*pixel);

			t.addVertexWithUV(11 * pixel, 1 - 11 * pixel, 11*pixel, 5*pixel, 0);
			t.addVertexWithUV(11 * pixel, 1 - 11 * pixel, 1-11*pixel, 0, 0);
			t.addVertexWithUV(11 * pixel, 11 * pixel, 1-11*pixel, 0, 5*pixel);
			t.addVertexWithUV(11 * pixel, 11 * pixel, 11*pixel, 5*pixel, 5*pixel);
			
			t.addVertexWithUV(1-11 * pixel, 1 - 11 * pixel, 11*pixel, 5*pixel, 0);
			t.addVertexWithUV(1-11 * pixel, 1 - 11 * pixel, 1-11*pixel, 0, 0);
			t.addVertexWithUV(1-11 * pixel, 11 * pixel, 1-11*pixel, 0, 5*pixel);
			t.addVertexWithUV(1-11 * pixel, 11 * pixel, 11*pixel, 5*pixel, 5*pixel);

			t.addVertexWithUV(1-11 * pixel, 1 - 11 * pixel, 11*pixel, 5*pixel, 0);
			t.addVertexWithUV(1-11 * pixel, 1 - 11 * pixel, 1-11*pixel, 0, 0);
			t.addVertexWithUV(1-11 * pixel, 11 * pixel, 1-11*pixel, 0, 5*pixel);
			t.addVertexWithUV(1-11 * pixel, 11 * pixel, 11*pixel, 5*pixel, 5*pixel);

			t.addVertexWithUV(1-11 * pixel, 1-11 * pixel, 11*pixel, 10*pixel, 0);
			t.addVertexWithUV(1-11 * pixel, 1-11 * pixel, 1-11*pixel, 5*pixel, 0);
			t.addVertexWithUV(11 * pixel, 1-11 * pixel, 1-11*pixel, 5*pixel, 5*pixel);
			t.addVertexWithUV(11 * pixel, 1-11 * pixel, 11*pixel, 10*pixel, 5*pixel);

		}
		t.draw();

		GL11.glTranslated(-x, -(y-0.7), -z);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_LIGHTING);
	}

}
