// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import me.Divine.settings.Setting;
import me.Divine.Divine;
import java.util.ArrayList;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class Gamma extends Module
{
    public float oldGamma;
    
    public Gamma() {
        super("FullBright", "", Category.RENDER);
        final ArrayList<String> bright = new ArrayList<String>();
        bright.add("Gamma");
        bright.add("Potion");
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Bright Mode", this, "Gamma", bright));
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        final Divine instance = Divine.instance;
        this.suff = Divine.settingsManager.getSettingByName(this, "Bright Mode").getValString();
        final Divine instance2 = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "Bright Mode").getValString().equals("Gamma")) {
            this.oldGamma = Gamma.mc.field_71474_y.field_74333_Y;
        }
        Gamma.mc.field_71474_y.field_74333_Y = 10.0f;
        final Divine instance3 = Divine.instance;
        if (Divine.settingsManager.getSettingByName(this, "Bright Mode").getValString().equals("Potion")) {
            Gamma.mc.field_71439_g.func_70690_d(new PotionEffect(Potion.func_188412_a(16), 817, 1));
        }
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        Gamma.mc.field_71474_y.field_74333_Y = this.oldGamma;
        Gamma.mc.field_71439_g.func_184589_d(Potion.func_188412_a(16));
    }
}
