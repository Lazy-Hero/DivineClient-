// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.player;

import me.Divine.module.Category;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.util.Random;
import me.Divine.module.Module;

public class Derp extends Module
{
    private final Random e;
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        final float f = this.e.nextFloat() * 360.0f;
        final float cfr_ignored_0 = this.e.nextFloat() * 180.0f - 90.0f;
        Derp.mc.field_71439_g.field_70759_as = f;
        Derp.mc.field_71439_g.field_70761_aq = f;
    }
    
    public Derp() {
        super("Derp", "", Category.PLAYER);
        this.e = new Random();
    }
}
