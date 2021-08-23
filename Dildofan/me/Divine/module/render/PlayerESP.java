// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import java.awt.Color;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import me.Divine.settings.Setting;
import me.Divine.Divine;
import java.util.ArrayList;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class PlayerESP extends Module
{
    public Module mod;
    
    public PlayerESP() {
        super("PlayerESP", "", Category.RENDER);
        final ArrayList<String> mode = new ArrayList<String>();
        mode.add("2D");
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Mode", this, "2D", mode));
    }
    
    @SubscribeEvent
    public void r(final RenderWorldLastEvent event) {
        final Divine instance = Divine.instance;
        this.suff = Divine.settingsManager.getSettingByName(this, "Mode").getValString();
        if (PlayerESP.mc.field_71439_g == null) {
            return;
        }
        for (final EntityPlayer player : PlayerESP.mc.field_71441_e.field_73010_i) {
            this.doOther2DESP(player, event.getPartialTicks());
        }
    }
    
    private void doOther2DESP(final EntityPlayer entity, final float ticks) {
        if (entity != PlayerESP.mc.field_71439_g) {
            final Divine instance = Divine.instance;
            if (Divine.settingsManager.getSettingByName(this, "Mode").getValString().equals("2D")) {
                GL11.glPushMatrix();
                GL11.glEnable(3042);
                GL11.glDisable(2929);
                GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                GlStateManager.func_179147_l();
                GL11.glBlendFunc(770, 771);
                glColor(Rainbow(8000, 0).getRGB());
                GL11.glDisable(3553);
                final double x = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * ticks - PlayerESP.mc.func_175598_ae().field_78730_l;
                final double y = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * ticks - PlayerESP.mc.func_175598_ae().field_78731_m;
                final double z = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * ticks - PlayerESP.mc.func_175598_ae().field_78728_n;
                final float DISTANCE = PlayerESP.mc.field_71439_g.func_70032_d((Entity)entity);
                Math.min(DISTANCE * 0.15f, 0.15f);
                float SCALE = 0.035f;
                SCALE /= 2.0f;
                entity.func_70631_g_();
                GlStateManager.func_179109_b((float)x, (float)y + entity.field_70131_O + 0.5f - (entity.func_70631_g_() ? (entity.field_70131_O / 2.0f) : 0.0f), (float)z);
                GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                GlStateManager.func_179114_b(-PlayerESP.mc.func_175598_ae().field_78735_i, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-SCALE, -SCALE, -SCALE);
                final float HEALTH = entity.func_110143_aJ();
                int COLOR1;
                if (HEALTH > 20.0) {
                    COLOR1 = -65292;
                }
                else if (HEALTH >= 10.0) {
                    COLOR1 = -16711936;
                }
                else if (HEALTH >= 3.0) {
                    COLOR1 = -23296;
                }
                else {
                    COLOR1 = -65536;
                }
                new Color(0, 0, 0);
                final double thickness = 1.5f + DISTANCE * 0.01f;
                final double xLeft = -20.0;
                final double xRight = 20.0;
                final double yUp = 27.0;
                final double yDown = 130.0;
                final Color color = new Color(Rainbow(8000, 0).getRGB());
                drawBorderedRect((float)xLeft, (float)yUp, (float)xRight, (float)yDown, (float)thickness + 0.5f, Colors.BLACK.c, 0);
                drawBorderedRect((float)xLeft, (float)yUp, (float)xRight, (float)yDown, (float)thickness, color.getRGB(), 0);
                drawBorderedRect((float)xLeft - 3.0f - DISTANCE * 0.2f, (float)yDown - (float)(yDown - yUp), (float)xLeft - 2.0f, (float)yDown, 0.15f, Colors.BLACK.c, new Color(100, 100, 100).getRGB());
                drawBorderedRect((float)xLeft - 3.0f - DISTANCE * 0.2f, (float)yDown - (float)(yDown - yUp) * Math.min(1.0f, entity.func_110143_aJ() / 20.0f), (float)xLeft - 2.0f, (float)yDown, 0.15f, Colors.BLACK.c, COLOR1);
                drawBorderedRect((float)xLeft, (float)yDown + 2.0f, (float)xRight, (float)yDown + 3.0f + DISTANCE * 0.2f, 0.15f, Colors.BLACK.c, new Color(100, 100, 100).getRGB());
                drawBorderedRect((float)xLeft, (float)yDown + 2.0f, (float)xLeft + (float)(xRight - xLeft) * Math.min(1.0f, entity.func_71024_bL().func_75116_a() / 20.0f), (float)yDown + 3.0f + DISTANCE * 0.2f, 0.15f, Colors.BLACK.c, new Color(0, 150, 255).getRGB());
                GL11.glEnable(3553);
                GL11.glEnable(2929);
                GlStateManager.func_179084_k();
                GL11.glDisable(3042);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glNormal3f(1.0f, 1.0f, 1.0f);
                GL11.glPopMatrix();
            }
        }
    }
    
    public static void glColor(final int hex) {
        final float alpha = (hex >> 24 & 0xFF) / 255.0f;
        final float red = (hex >> 16 & 0xFF) / 255.0f;
        final float green = (hex >> 8 & 0xFF) / 255.0f;
        final float blue = (hex & 0xFF) / 255.0f;
        GL11.glColor4f(red, green, blue, alpha);
    }
    
    public static void drawBorderedRect(final float x, final float y, final float x2, final float y2, final float l1, final int col1, final int col2) {
        drawRect(x, y, x2, y2, col2);
        final float f = (col1 >> 24 & 0xFF) / 255.0f;
        final float f2 = (col1 >> 16 & 0xFF) / 255.0f;
        final float f3 = (col1 >> 8 & 0xFF) / 255.0f;
        final float f4 = (col1 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(f2, f3, f4, f);
        GL11.glLineWidth(l1);
        GL11.glBegin(1);
        GL11.glVertex2d((double)x, (double)y);
        GL11.glVertex2d((double)x, (double)y2);
        GL11.glVertex2d((double)x2, (double)y2);
        GL11.glVertex2d((double)x2, (double)y);
        GL11.glVertex2d((double)x, (double)y);
        GL11.glVertex2d((double)x2, (double)y);
        GL11.glVertex2d((double)x, (double)y2);
        GL11.glVertex2d((double)x2, (double)y2);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    public static void drawRect(final float g, final float h, final float i, final float j, final int col1) {
        final float f = (col1 >> 24 & 0xFF) / 255.0f;
        final float f2 = (col1 >> 16 & 0xFF) / 255.0f;
        final float f3 = (col1 >> 8 & 0xFF) / 255.0f;
        final float f4 = (col1 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(f2, f3, f4, f);
        GL11.glBegin(7);
        GL11.glVertex2d((double)i, (double)h);
        GL11.glVertex2d((double)g, (double)h);
        GL11.glVertex2d((double)g, (double)j);
        GL11.glVertex2d((double)i, (double)j);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    public static Color Rainbow(final int speed, final int r) {
        final float hex = (float)((System.currentTimeMillis() + r) % speed);
        return Color.getHSBColor(hex / speed, 1.0f, 1.0f);
    }
    
    public enum Colors
    {
        BLACK(-16711423), 
        BLUE(-12028161), 
        DARKBLUE(-12621684), 
        GREEN(-9830551), 
        DARKGREEN(-9320847), 
        WHITE(-65794), 
        AQUA(-7820064), 
        DARKAQUA(-12621684), 
        GREY(-9868951), 
        DARKGREY(-14342875), 
        RED(-65536), 
        DARKRED(-8388608), 
        ORANGE(-29696), 
        DARKORANGE(-2263808), 
        YELLOW(-256), 
        DARKYELLOW(-2702025), 
        MAGENTA(-18751), 
        SLOWLY(-13220000), 
        SLOWLY2(-106165216), 
        SLOWLY3(-17791255), 
        SLOWLY4(-15425034), 
        DARKMAGENTA(-2252579);
        
        public int c;
        
        private Colors(final int co) {
            this.c = co;
        }
    }
}
