// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import org.lwjgl.opengl.GL11;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;
import me.Divine.utils.RenderUtil;
import java.awt.Color;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import me.Divine.settings.Setting;
import me.Divine.Divine;
import net.minecraft.client.Minecraft;
import me.Divine.module.Category;
import net.minecraft.client.gui.ScaledResolution;
import me.Divine.module.Module;

public class Inventory extends Module
{
    private final ScaledResolution sr;
    
    public Inventory() {
        super("Inventory", "", Category.RENDER);
        this.sr = new ScaledResolution(Minecraft.func_71410_x());
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("X", this, 1.0, 1.0, this.sr.func_78326_a() * 2, false));
        final Divine instance2 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Y", this, 1.0, 1.0, this.sr.func_78328_b() * 2, false));
    }
    
    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            GlStateManager.func_179094_E();
            RenderHelper.func_74520_c();
            final Divine instance = Divine.instance;
            final float x0 = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() - 2.0f;
            final Divine instance2 = Divine.instance;
            final float y0 = (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() - 2.0f;
            final Divine instance3 = Divine.instance;
            final float x2 = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() - 1.0f;
            final Divine instance4 = Divine.instance;
            drawRoundedRect(x0, y0, x2, (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() + 58.0f, (float)new Color(64, 41, 213).getRGB(), 0);
            final Divine instance5 = Divine.instance;
            final float x3 = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() + 177.0f;
            final Divine instance6 = Divine.instance;
            final float y2 = (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() - 1.0f;
            final Divine instance7 = Divine.instance;
            final float x4 = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() + 178.0f;
            final Divine instance8 = Divine.instance;
            drawRoundedRect(x3, y2, x4, (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() + 57.0f, (float)new Color(64, 41, 213, 255).getRGB(), 0);
            final Divine instance9 = Divine.instance;
            final float x5 = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() + 177.0f;
            final Divine instance10 = Divine.instance;
            final float y3 = (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() - 2.0f;
            final Divine instance11 = Divine.instance;
            final float x6 = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble();
            final Divine instance12 = Divine.instance;
            drawRoundedRect(x5, y3, x6, (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() + 58.0f, (float)new Color(124, 9, 77, 255).getRGB(), 0);
            final Divine instance13 = Divine.instance;
            final double left = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() - 2.0f;
            final Divine instance14 = Divine.instance;
            final double top = (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() - 3.0f;
            final Divine instance15 = Divine.instance;
            final double right = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() + 178.0f;
            final Divine instance16 = Divine.instance;
            RenderUtil.drawGradientSideways(left, top, right, (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() - 2.0f, new Color(64, 41, 213, 255).getRGB(), new Color(124, 9, 77, 255).getRGB());
            final Divine instance17 = Divine.instance;
            final double left2 = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() - 1.0f;
            final Divine instance18 = Divine.instance;
            final double top2 = (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() + 57.0f;
            final Divine instance19 = Divine.instance;
            final double right2 = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() + 177.0f;
            final Divine instance20 = Divine.instance;
            RenderUtil.drawGradientSideways(left2, top2, right2, (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() + 58.0f, new Color(64, 41, 213, 255).getRGB(), new Color(124, 9, 77, 255).getRGB());
            final Divine instance21 = Divine.instance;
            final double left3 = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() - 1.0f;
            final Divine instance22 = Divine.instance;
            final double top3 = (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() - 2.0f;
            final Divine instance23 = Divine.instance;
            final double right3 = (float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() + 177.0f;
            final Divine instance24 = Divine.instance;
            RenderUtil.drawGradientSideways(left3, top3, right3, (float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() + 57.0f, new Color(10, 10, 10, 155).getRGB(), new Color(10, 10, 10, 55).getRGB());
            for (int i = 0; i < 27; ++i) {
                final ItemStack item_stack = (ItemStack)Inventory.mc.field_71439_g.field_71071_by.field_70462_a.get(i + 9);
                final Divine instance25 = Divine.instance;
                final int item_position_x = (int)(float)Divine.settingsManager.getSettingByName(this, "X").getValDouble() + i % 9 * 20;
                final Divine instance26 = Divine.instance;
                final int item_position_y = (int)(float)Divine.settingsManager.getSettingByName(this, "Y").getValDouble() + i / 9 * 20;
                Inventory.mc.func_175599_af().func_180450_b(item_stack, item_position_x, item_position_y);
                Inventory.mc.func_175599_af().func_180453_a(Inventory.mc.field_71466_p, item_stack, item_position_x, item_position_y, (String)null);
            }
            Inventory.mc.func_175599_af().field_77023_b = -5.0f;
            RenderHelper.func_74518_a();
            GlStateManager.func_179121_F();
        }
    }
    
    public static void drawRoundedRect(final float x0, final float y0, final float x1, final float y1, final float radius, final int color) {
        GL11.glPushMatrix();
        final int numberOfArcs = 18;
        final float angleIncrement = 5.0f;
        final float a = (color >> 24 & 0xFF) / 255.0f;
        final float r = (color >> 16 & 0xFF) / 255.0f;
        final float g = (color >> 8 & 0xFF) / 255.0f;
        final float b = (color & 0xFF) / 255.0f;
        GL11.glDisable(2884);
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(r, g, b, a);
        GL11.glBegin(5);
        GL11.glVertex2f(x0 + radius, y0);
        GL11.glVertex2f(x0 + radius, y1);
        GL11.glVertex2f(x1 - radius, y0);
        GL11.glVertex2f(x1 - radius, y1);
        GL11.glEnd();
        GL11.glBegin(5);
        GL11.glVertex2f(x0, y0 + radius);
        GL11.glVertex2f(x0 + radius, y0 + radius);
        GL11.glVertex2f(x0, y1 - radius);
        GL11.glVertex2f(x0 + radius, y1 - radius);
        GL11.glEnd();
        GL11.glBegin(5);
        GL11.glVertex2f(x1, y0 + radius);
        GL11.glVertex2f(x1 - radius, y0 + radius);
        GL11.glVertex2f(x1, y1 - radius);
        GL11.glVertex2f(x1 - radius, y1 - radius);
        GL11.glEnd();
        GL11.glBegin(6);
        float centerX = x1 - radius;
        float centerY = y0 + radius;
        GL11.glVertex2f(centerX, centerY);
        for (int i = 0; i <= 18; ++i) {
            final float angle = i * 5.0f;
            GL11.glVertex2f((float)(centerX + radius * Math.cos(Math.toRadians(angle))), (float)(centerY - radius * Math.sin(Math.toRadians(angle))));
        }
        GL11.glEnd();
        GL11.glBegin(6);
        centerX = x0 + radius;
        centerY = y0 + radius;
        GL11.glVertex2f(centerX, centerY);
        for (int i = 0; i <= 18; ++i) {
            final float angle = i * 5.0f;
            GL11.glVertex2f((float)(centerX - radius * Math.cos(Math.toRadians(angle))), (float)(centerY - radius * Math.sin(Math.toRadians(angle))));
        }
        GL11.glEnd();
        GL11.glBegin(6);
        centerX = x0 + radius;
        centerY = y1 - radius;
        GL11.glVertex2f(centerX, centerY);
        for (int i = 0; i <= 18; ++i) {
            final float angle = i * 5.0f;
            GL11.glVertex2f((float)(centerX - radius * Math.cos(Math.toRadians(angle))), (float)(centerY + radius * Math.sin(Math.toRadians(angle))));
        }
        GL11.glEnd();
        GL11.glBegin(6);
        centerX = x1 - radius;
        centerY = y1 - radius;
        GL11.glVertex2f(centerX, centerY);
        for (int i = 0; i <= 18; ++i) {
            final float angle = i * 5.0f;
            GL11.glVertex2f((float)(centerX + radius * Math.cos(Math.toRadians(angle))), (float)(centerY + radius * Math.sin(Math.toRadians(angle))));
        }
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glEnable(2884);
        GL11.glDisable(3042);
        GlStateManager.func_179084_k();
        GL11.glPopMatrix();
        GlStateManager.func_179117_G();
    }
}
