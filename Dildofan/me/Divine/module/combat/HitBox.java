// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.combat;

import me.Divine.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import me.Divine.utils.Utils;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.settings.Setting;
import me.Divine.Divine;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class HitBox extends Module
{
    public HitBox() {
        super("HitBox", "Increase Hitbox size", Category.COMBAT);
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Width", this, 0.3, 0.1, 3.0, false));
        final Divine instance2 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Height", this, 0.3, 0.1, 3.0, false));
    }
    
    @SubscribeEvent
    @Override
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        for (final EntityPlayer player : Utils.getPlayersList()) {
            if (!this.check((EntityLivingBase)player)) {
                continue;
            }
            if (player == null) {
                continue;
            }
            final Divine instance = Divine.instance;
            final float width = (float)Divine.settingsManager.getSettingByName(this, "Width").getValDouble();
            final Divine instance2 = Divine.instance;
            final float height = (float)Divine.settingsManager.getSettingByName(this, "Height").getValDouble();
            Utils.setEntityBoundingBoxSize((Entity)player, width, height);
        }
    }
    
    @Override
    public void onDisable() {
        for (final EntityPlayer player : Utils.getPlayersList()) {
            Utils.setEntityBoundingBoxSize((Entity)player);
        }
        super.onDisable();
    }
    
    public boolean check(final EntityLivingBase entity) {
        if (!(entity instanceof EntityPlayerSP)) {
            final Wrapper instance = Wrapper.INSTANCE;
            if (entity != Wrapper.player() && !entity.field_70128_L) {
                return true;
            }
        }
        return false;
    }
}
