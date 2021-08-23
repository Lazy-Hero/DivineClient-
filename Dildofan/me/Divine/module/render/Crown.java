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

public class Crown extends Module
{
    public Crown() {
        super("Crown", "", Category.RENDER);
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Flame", this, true));
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        final Divine instance = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "Flame").getValBoolean()) {
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.FLAME, Footprints.mc.field_71439_g.field_70165_t + 0.4, Footprints.mc.field_71439_g.field_70163_u + 2.1, Footprints.mc.field_71439_g.field_70161_v + 0.1, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.FLAME, Footprints.mc.field_71439_g.field_70165_t + 0.1, Footprints.mc.field_71439_g.field_70163_u + 2.1, Footprints.mc.field_71439_g.field_70161_v + 0.4, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.FLAME, Footprints.mc.field_71439_g.field_70165_t - 0.4, Footprints.mc.field_71439_g.field_70163_u + 2.1, Footprints.mc.field_71439_g.field_70161_v + 0.3, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.FLAME, Footprints.mc.field_71439_g.field_70165_t + 0.4, Footprints.mc.field_71439_g.field_70163_u + 2.1, Footprints.mc.field_71439_g.field_70161_v - 0.4, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.FLAME, Footprints.mc.field_71439_g.field_70165_t - 0.5, Footprints.mc.field_71439_g.field_70163_u + 2.1, Footprints.mc.field_71439_g.field_70161_v - 0.2, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.FLAME, Footprints.mc.field_71439_g.field_70165_t - 0.3, Footprints.mc.field_71439_g.field_70163_u + 2.1, Footprints.mc.field_71439_g.field_70161_v - 0.5, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.FLAME, Footprints.mc.field_71439_g.field_70165_t + 0.1, Footprints.mc.field_71439_g.field_70163_u + 2.1, Footprints.mc.field_71439_g.field_70161_v - 0.6, 0.0, 0.0, 0.0, new int[0]);
            Footprints.mc.field_71441_e.func_175688_a(EnumParticleTypes.FLAME, Footprints.mc.field_71439_g.field_70165_t + 0.4, Footprints.mc.field_71439_g.field_70163_u + 2.1, Footprints.mc.field_71439_g.field_70161_v - 0.3, 0.0, 0.0, 0.0, new int[0]);
        }
    }
}
