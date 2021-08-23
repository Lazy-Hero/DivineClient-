// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.misc;

import me.Divine.module.Category;
import java.util.Iterator;
import net.minecraft.client.gui.GuiScreen;
import me.Divine.Divine;
import me.Divine.module.ModuleManager;
import me.Divine.settings.Setting;
import me.Divine.module.render.HUD;
import me.Divine.module.Module;

public class Panic extends Module
{
    public static HUD hud;
    public static Setting setting;
    public ModuleManager moduleManager;
    
    @Override
    public void onEnable() {
        final ModuleManager moduleManager = Divine.instance.moduleManager;
        for (final Module modulew : ModuleManager.modules) {
            final Module module = modulew;
            if (module.isToggled()) {
                module.toggle();
            }
            module.setKey(0);
        }
        Panic.mc.field_71439_g.func_70664_aZ();
        Panic.mc.func_147108_a((GuiScreen)null);
        super.onEnable();
    }
    
    public Panic() {
        super("SelfDestruct", "", Category.MISC);
    }
}
