// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.player;

import me.Divine.settings.Setting;
import me.Divine.module.Category;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.settings.KeyBinding;
import me.Divine.Divine;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import me.Divine.module.Module;

public class AutoGApple extends Module
{
    private int oldSlot;
    private boolean eating;
    
    boolean isFood(final ItemStack itemStack) {
        return !isNullOrEmptyStack(itemStack) && itemStack.func_77973_b() instanceof ItemAppleGold;
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        final StringBuilder sb = new StringBuilder();
        final Divine instance = Divine.instance;
        this.suff = sb.append(Divine.settingsManager.getSettingByName(this, "Health").getValDouble()).append("").toString();
        final double n = AutoGApple.mc.field_71439_g.func_110143_aJ() + AutoGApple.mc.field_71439_g.func_110139_bj();
        final Divine instance2 = Divine.instance;
        if (n > (float)Divine.settingsManager.getSettingByName(this, "Health").getValDouble() && this.eating) {
            this.eating = false;
            this.stop();
            return;
        }
        if (!this.canEat()) {
            return;
        }
        if (this.isFood(AutoGApple.mc.field_71439_g.func_184592_cb())) {
            final double n2 = AutoGApple.mc.field_71439_g.func_110143_aJ();
            final Divine instance3 = Divine.instance;
            if (n2 <= (float)Divine.settingsManager.getSettingByName(this, "Health").getValDouble() && this.canEat()) {
                KeyBinding.func_74510_a(AutoGApple.mc.field_71474_y.field_74313_G.func_151463_i(), true);
                this.eating = true;
            }
        }
        if (!this.canEat()) {
            this.stop();
        }
    }
    
    public static boolean isNullOrEmptyStack(final ItemStack itemStack) {
        return itemStack == null || itemStack.func_190926_b();
    }
    
    public boolean canEat() {
        final Entity entity;
        return AutoGApple.mc.field_71476_x == null || (!((entity = AutoGApple.mc.field_71476_x.field_72308_g) instanceof EntityVillager) && !(entity instanceof EntityTameable));
    }
    
    void stop() {
        KeyBinding.func_74510_a(AutoGApple.mc.field_71474_y.field_74313_G.func_151463_i(), false);
    }
    
    public AutoGApple() {
        super("AutoApple", "", Category.PLAYER);
        this.oldSlot = -1;
        this.eating = false;
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Health", this, 11.5, 1.0, 20.0, false));
    }
}
