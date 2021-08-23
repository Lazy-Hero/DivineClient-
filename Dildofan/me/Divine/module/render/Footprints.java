// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.settings.Setting;
import me.Divine.Divine;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class Footprints extends Module
{
    public Footprints() {
        super("Footprints", "", Category.RENDER);
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Cloud", this, false));
        final Divine instance2 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Flame", this, true));
        final Divine instance3 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Smoke", this, false));
        final Divine instance4 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("RedStone", this, false));
        final Divine instance5 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("FireWork", this, false));
        final Divine instance6 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Portal", this, false));
        final Divine instance7 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Spit", this, false));
        final Divine instance8 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Heart", this, false));
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        final Divine instance = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "Heart").getValBoolean()) {
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.HEART, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        }
        final Divine instance2 = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "Cloud").getValBoolean()) {
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.CLOUD, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        }
        final Divine instance3 = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "Flame").getValBoolean()) {
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.FLAME, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        }
        final Divine instance4 = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "Smoke").getValBoolean()) {
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.SMOKE_LARGE, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        }
        final Divine instance5 = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "RedStone").getValBoolean()) {
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.REDSTONE, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.1, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.REDSTONE, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.REDSTONE, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.3, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.REDSTONE, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.4, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.REDSTONE, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.5, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        }
        final Divine instance6 = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "FireWork").getValBoolean()) {
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.FIREWORKS_SPARK, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.5, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        }
        final Divine instance7 = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "Portal").getValBoolean()) {
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.PORTAL, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.PORTAL, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.PORTAL, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.PORTAL, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.PORTAL, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        }
        final Divine instance8 = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "Spit").getValBoolean()) {
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.SPIT, Footprints.mc.field_71439_g.field_70165_t, Footprints.mc.field_71439_g.field_70163_u + 0.2, Footprints.mc.field_71439_g.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        }
    }
}
