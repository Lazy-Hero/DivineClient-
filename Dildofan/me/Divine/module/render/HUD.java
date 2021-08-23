// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Iterator;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import me.Divine.font.Fonts;
import net.minecraft.client.renderer.GlStateManager;
import me.Divine.font.Fonts2;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import me.Divine.settings.Setting;
import me.Divine.Divine;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class HUD extends Module
{
    public HUD() {
        super("HUD", "", Category.RENDER);
        this.setToggled(true);
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("WaterMark", this, true));
        final Divine instance2 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("ArrayList", this, true));
    }
    
    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent.Text egoe) {
        final ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
        int y = 2;
        final int[] counter = { 1 };
        final Divine instance = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "WaterMark").getValBoolean()) {
            Fonts2.font.drawStringWithShadow("Divine", 2.0, 10.0, rainbow(1337, 1337L));
            GlStateManager.func_179094_E();
            GlStateManager.func_179139_a(0.7, 0.7, 0.7);
            Fonts2.font.drawStringWithShadow("b0.1", 50.0, 7.5, -1);
            GlStateManager.func_179121_F();
            final int var10002 = counter[0]++;
            String oldName = "";
            int oldColor = -1;
            final int p = 2;
            for (final Module mod : Divine.instance.moduleManager.getModuleList()) {
                final String name = mod.getName();
                final Divine instance2 = Divine.instance;
                if (Divine.settingsManager.getSettingByName(this, "ArrayList").getValBoolean() && !name.equalsIgnoreCase("HUD") && mod.isToggled() && mod.visible) {
                    final int x = sr.func_78326_a() - Fonts.font.getStringWidth(name) - 1;
                    final int count = 0;
                    final int offset = count * (HUD.mc.field_71466_p.field_78288_b + 6);
                    final int offsetColor = rainbow(1000000, 0L);
                    Gui.func_73734_a(x - 2, y - 2, x + Fonts.font.getStringWidth(name) + 1, (int)(y + Fonts.font.getHeight() + 1.9f), new Color(0, 0, 0, 200).getRGB());
                    Fonts.font.drawStringWithShadow(name, x - 1, y, offsetColor);
                    Gui.func_73734_a(x + Fonts.font.getStringWidth(name), y - 2, x + Fonts.font.getStringWidth(name) + 2, y + Fonts.font.getHeight() + 1, offsetColor);
                    oldName = name;
                    oldColor = offsetColor;
                    y += Fonts.font.getHeight() + 3;
                }
            }
        }
    }
    
    public static int rainbow(final int delay, final long index) {
        double rainbowState = Math.ceil((double)(System.currentTimeMillis() + index + delay)) / 15.0;
        rainbowState %= 360.0;
        return Color.getHSBColor((float)(rainbowState / 360.0), 0.4f, 1.0f).getRGB();
    }
}
