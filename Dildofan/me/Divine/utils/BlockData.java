// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.utils;

import net.minecraft.init.Blocks;
import me.Divine.wrappers.Wrapper;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class BlockData
{
    public final BlockPos position;
    public final EnumFacing face;
    
    public BlockData(final BlockPos add, final EnumFacing up) {
        this.position = add;
        this.face = up;
    }
    
    public static BlockData getBlockData(final BlockPos pos) {
        if (Wrapper.INSTANCE.world().func_180495_p(pos.func_177982_a(0, -1, 0)).func_177230_c() != Blocks.field_150350_a) {
            return new BlockData(pos.func_177982_a(0, -1, 0), EnumFacing.UP);
        }
        if (Wrapper.INSTANCE.world().func_180495_p(pos.func_177982_a(-1, 0, 0)).func_177230_c() != Blocks.field_150350_a) {
            return new BlockData(pos.func_177982_a(-1, 0, 0), EnumFacing.EAST);
        }
        if (Wrapper.INSTANCE.world().func_180495_p(pos.func_177982_a(1, 0, 0)).func_177230_c() != Blocks.field_150350_a) {
            return new BlockData(pos.func_177982_a(1, 0, 0), EnumFacing.WEST);
        }
        if (Wrapper.INSTANCE.world().func_180495_p(pos.func_177982_a(0, 0, -1)).func_177230_c() != Blocks.field_150350_a) {
            return new BlockData(pos.func_177982_a(0, 0, -1), EnumFacing.SOUTH);
        }
        if (Wrapper.INSTANCE.world().func_180495_p(pos.func_177982_a(0, 0, 1)).func_177230_c() != Blocks.field_150350_a) {
            return new BlockData(pos.func_177982_a(0, 0, 1), EnumFacing.NORTH);
        }
        return null;
    }
}
