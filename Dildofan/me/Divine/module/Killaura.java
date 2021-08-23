// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Iterator;
import me.Divine.utils.system.GCDUtil;
import net.minecraft.util.EnumHand;
import me.Divine.utils.RotationUtils;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.settings.Setting;
import me.Divine.Divine;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import java.util.List;
import me.Divine.event.Counter;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;

class Killaura extends Module
{
    public static EntityLivingBase target;
    Random rand;
    public static float yaw;
    public static float pitch;
    public Random random;
    public Counter counter;
    private final List<EntityLivingBase> targets;
    private EntityPlayer bot;
    
    public Killaura() {
        super("Killaura", "", Category.COMBAT);
        this.targets = new ArrayList<EntityLivingBase>();
        this.rand = new Random();
        this.random = new Random();
        this.counter = new Counter();
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Range", this, 3.2, 0.1, 6.0, false));
        final Divine instance2 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("OnlyCriticals", this, false));
    }
    
    @Override
    public void onEnable() {
        this.bot = null;
        super.onEnable();
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        if (this.bot == null && Killaura.mc.field_71439_g.func_110144_aD() instanceof EntityPlayer) {
            this.bot = (EntityPlayer)Killaura.mc.field_71439_g.func_110144_aD();
        }
        final StringBuilder sb = new StringBuilder();
        final Divine instance = Divine.instance;
        this.suff = sb.append(Divine.settingsManager.getSettingByName(this, "Range").getValDouble()).append("").toString();
        final Divine instance2 = Divine.instance;
        final boolean criticals = Divine.settingsManager.getSettingByName(this, "OnlyCriticals").getValBoolean();
        final Divine instance3 = Divine.instance;
        final float aurarange = (float)Divine.settingsManager.getSettingByName(this, "Range").getValDouble();
        if (Killaura.mc.field_71439_g == null) {
            return;
        }
        for (final Entity targetez : Killaura.mc.field_71441_e.field_72996_f) {
            if (targetez != Killaura.mc.field_71439_g && (this.bot == null || targetez == this.bot)) {
                if (targetez.func_82150_aj()) {
                    continue;
                }
                if (Killaura.mc.field_71439_g.func_184825_o(0.0f) == 1.0f && Killaura.mc.field_71439_g.func_70032_d(targetez) <= aurarange && Killaura.mc.field_71439_g.field_70143_R >= 0.1 && criticals) {
                    Killaura.mc.field_71439_g.field_70177_z = RotationUtils.getNeededRotations(targetez)[0];
                    Killaura.mc.field_71439_g.field_70125_A = RotationUtils.getNeededRotations(targetez)[1] + this.random.nextFloat() * 35.0f - 5.0f;
                    Killaura.mc.field_71442_b.func_78764_a((EntityPlayer)Killaura.mc.field_71439_g, targetez);
                    Killaura.mc.field_71439_g.func_184609_a(EnumHand.MAIN_HAND);
                    GCDUtil.getFixedRotation(Killaura.yaw);
                    GCDUtil.getFixedRotation(Killaura.pitch);
                    this.counter.reset();
                }
                else {
                    if (Killaura.mc.field_71439_g.func_184825_o(0.0f) != 1.0f || Killaura.mc.field_71439_g.func_70032_d(targetez) > aurarange) {
                        continue;
                    }
                    if (criticals) {
                        continue;
                    }
                    Killaura.mc.field_71439_g.field_70177_z = RotationUtils.getNeededRotations(targetez)[0];
                    Killaura.mc.field_71439_g.field_70125_A = RotationUtils.getNeededRotations(targetez)[1] + this.random.nextFloat() * 35.0f - 5.0f;
                    Killaura.mc.field_71442_b.func_78764_a((EntityPlayer)Killaura.mc.field_71439_g, targetez);
                    Killaura.mc.field_71439_g.func_184609_a(EnumHand.MAIN_HAND);
                    GCDUtil.getFixedRotation(Killaura.yaw);
                    GCDUtil.getFixedRotation(Killaura.pitch);
                    this.counter.reset();
                }
            }
        }
    }
}
