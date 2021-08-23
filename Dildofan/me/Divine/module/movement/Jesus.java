// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.movement;

import me.Divine.module.Category;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.module.Module;

public class Jesus extends Module
{
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        if (Jesus.mc.field_71439_g.func_70090_H()) {
            Jesus.mc.field_71439_g.field_70747_aH = 0.8f;
            Jesus.mc.field_71439_g.field_70181_x = 0.4;
        }
    }
    
    public Jesus() {
        super("Jesus", "", Category.MOVEMENT);
    }
}
