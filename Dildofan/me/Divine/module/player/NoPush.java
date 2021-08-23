// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.player;

import me.Divine.event.EventManager;
import me.Divine.event.EventTarget;
import me.Divine.wrappers.Wrapper;
import me.Divine.event.EventPreMotionUpdates;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class NoPush extends Module
{
    public NoPush() {
        super("NoPush", "NoPush", Category.PLAYER);
    }
    
    @EventTarget
    public void onEvent(final EventPreMotionUpdates event) {
        if (!this.isToggled()) {
            return;
        }
        Wrapper.player().field_70144_Y = 1.0f;
    }
    
    @Override
    public void onEnable() {
        EventManager.register(this);
        super.onEnable();
    }
    
    @Override
    public void onDisable() {
        EventManager.unregister(this);
        super.onDisable();
    }
}
