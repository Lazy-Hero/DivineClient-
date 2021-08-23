// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class NoHurtCam extends Module
{
    public NoHurtCam() {
        super("NoHurtCam", "", Category.RENDER);
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        NoHurtCam.mc.field_71439_g.field_70737_aN = 0;
        NoHurtCam.mc.field_71439_g.field_70172_ad = 0;
        NoHurtCam.mc.field_71439_g.field_70771_an = 0;
        NoHurtCam.mc.field_71439_g.field_70738_aO = 0;
    }
}
