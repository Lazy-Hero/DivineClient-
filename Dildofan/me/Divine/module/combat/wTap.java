// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.combat;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.network.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class wTap extends Module
{
    public wTap() {
        super("wTap", "", Category.COMBAT);
    }
    
    @SubscribeEvent
    public void onAttack(final AttackEntityEvent attackEntityEvent) {
        if (attackEntityEvent.getTarget() instanceof EntityLivingBase) {
            if (wTap.mc.field_71439_g.func_70051_ag()) {
                wTap.mc.field_71439_g.func_70031_b(false);
            }
            wTap.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketEntityAction((Entity)wTap.mc.field_71439_g, CPacketEntityAction.Action.START_SPRINTING));
            wTap.mc.field_71439_g.func_70031_b(true);
        }
    }
}
