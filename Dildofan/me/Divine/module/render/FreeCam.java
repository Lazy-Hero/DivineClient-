// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import me.Divine.wrappers.Wrapper;
import net.minecraft.network.play.client.CPacketPlayer;
import me.Divine.value.ASD;
import me.Divine.module.Category;
import me.Divine.utils.visual.Entity301;
import me.Divine.module.Module;

public class FreeCam extends Module
{
    public Entity301 entity301;
    
    public FreeCam() {
        super("FreeCam", "", Category.RENDER);
        this.entity301 = null;
    }
    
    @Override
    public boolean onPacket(final Object packet, final ASD.Side side) {
        return side != ASD.Side.OUT || (!(packet instanceof CPacketPlayer) && !(packet instanceof CPacketPlayer.Position) && !(packet instanceof CPacketPlayer.Rotation) && !(packet instanceof CPacketPlayer.PositionRotation));
    }
    
    @Override
    public void onEnable() {
        final Wrapper instance = Wrapper.INSTANCE;
        if (Wrapper.player() != null && Wrapper.INSTANCE.world() != null) {
            final WorldClient world = Wrapper.INSTANCE.world();
            final Wrapper instance2 = Wrapper.INSTANCE;
            this.entity301 = new Entity301((World)world, Wrapper.player().func_146103_bH());
            final Entity301 entity301 = this.entity301;
            final Wrapper instance3 = Wrapper.INSTANCE;
            final double field_70165_t = Wrapper.player().field_70165_t;
            final Wrapper instance4 = Wrapper.INSTANCE;
            final double field_70163_u = Wrapper.player().field_70163_u;
            final Wrapper instance5 = Wrapper.INSTANCE;
            entity301.func_70107_b(field_70165_t, field_70163_u, Wrapper.player().field_70161_v);
            this.entity301.field_71071_by = Wrapper.INSTANCE.inventory();
            final Entity301 entity302 = this.entity301;
            final Wrapper instance6 = Wrapper.INSTANCE;
            entity302.field_70125_A = Wrapper.player().field_70125_A;
            final Entity301 entity303 = this.entity301;
            final Wrapper instance7 = Wrapper.INSTANCE;
            entity303.field_70177_z = Wrapper.player().field_70177_z;
            final Entity301 entity304 = this.entity301;
            final Wrapper instance8 = Wrapper.INSTANCE;
            entity304.field_70759_as = Wrapper.player().field_70759_as;
            Wrapper.INSTANCE.world().func_72838_d((Entity)this.entity301);
        }
        super.onEnable();
    }
    
    @Override
    public void onDisable() {
        if (this.entity301 != null && Wrapper.INSTANCE.world() != null) {
            final Wrapper instance = Wrapper.INSTANCE;
            Wrapper.player().func_70107_b(this.entity301.field_70165_t, this.entity301.field_70163_u, this.entity301.field_70161_v);
            final Wrapper instance2 = Wrapper.INSTANCE;
            Wrapper.player().field_70125_A = this.entity301.field_70125_A;
            final Wrapper instance3 = Wrapper.INSTANCE;
            Wrapper.player().field_70177_z = this.entity301.field_70177_z;
            final Wrapper instance4 = Wrapper.INSTANCE;
            Wrapper.player().field_70759_as = this.entity301.field_70759_as;
            Wrapper.INSTANCE.world().func_72900_e((Entity)this.entity301);
            this.entity301 = null;
        }
        super.onDisable();
    }
}
