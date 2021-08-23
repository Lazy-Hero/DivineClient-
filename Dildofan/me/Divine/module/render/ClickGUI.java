// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import net.minecraft.client.gui.GuiScreen;
import me.Divine.Divine;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class ClickGUI extends Module
{
    public ClickGUI() {
        super("ClickGUI", "", Category.RENDER);
        this.setKey(54);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        ClickGUI.mc.func_147108_a((GuiScreen)Divine.instance.clickGui);
        this.setToggled(false);
    }
}
