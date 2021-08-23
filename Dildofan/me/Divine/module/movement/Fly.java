// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.movement;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class Fly extends Module
{
    public Fly() {
        super("Fly", "", Category.MOVEMENT);
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        Fly.mc.field_71439_g.field_70181_x = 0.1;
        Fly.mc.field_71439_g.field_70181_x = 1.0E-6;
        Fly.mc.field_71439_g.field_70181_x = 0.05999999865889549;
        Fly.mc.field_71439_g.field_70181_x = -0.03999999910593033;
        Fly.mc.field_71439_g.field_70747_aH = 0.2f;
    }
}
