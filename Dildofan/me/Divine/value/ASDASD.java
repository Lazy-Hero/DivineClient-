// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.value;

import java.util.Iterator;
import net.minecraft.client.Minecraft;
import me.Divine.module.Module;
import me.Divine.Divine;

public class ASDASD
{
    public boolean onPacket(final Object packet, final ASD.Side side) {
        boolean suc = true;
        for (final Module hack : Divine.instance.moduleManager.getModuleList()) {
            if (hack.isToggled()) {
                if (Minecraft.func_71410_x().field_71441_e == null) {
                    continue;
                }
                suc &= hack.onPacket(packet, side);
            }
        }
        return suc;
    }
}
