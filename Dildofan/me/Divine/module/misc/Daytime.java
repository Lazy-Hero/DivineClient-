// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.misc;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import me.Divine.settings.Setting;
import me.Divine.Divine;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class Daytime extends Module
{
    private long time;
    
    public Daytime() {
        super("Daytime", "", Category.MISC);
        this.time = 0L;
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("TimeChanger", this, 1.5, 0.0, 20.0, false));
    }
    
    @SubscribeEvent
    public void onUpdate(final RenderGameOverlayEvent e) {
        if (Daytime.mc.field_71439_g == null) {
            return;
        }
        final Divine instance = Divine.instance;
        final double timer = Divine.settingsManager.getSettingByName(this, "TimeChanger").getValDouble();
        Daytime.mc.field_71441_e.func_72877_b((long)timer);
    }
    
    @SubscribeEvent
    public void onTick(final RenderGameOverlayEvent e) {
        if (Daytime.mc.field_71439_g == null) {
            return;
        }
        final Divine instance = Divine.instance;
        final double timer = Divine.settingsManager.getSettingByName(this, "TimeChanger").getValDouble();
        Daytime.mc.field_71441_e.func_72877_b((long)timer);
    }
}
