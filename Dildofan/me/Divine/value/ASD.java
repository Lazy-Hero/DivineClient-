// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.value;

import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import me.Divine.utils.ChatUtils;
import io.netty.channel.ChannelHandler;
import net.minecraft.client.Minecraft;
import io.netty.channel.ChannelDuplexHandler;

public class ASD extends ChannelDuplexHandler
{
    private ASDASD eventHandler;
    
    public ASD(final ASDASD eventHandler) {
        this.eventHandler = eventHandler;
        try {
            final ChannelPipeline pipeline = Minecraft.func_71410_x().func_147114_u().func_147298_b().channel().pipeline();
            pipeline.addBefore("packet_handler", "PacketHandler", (ChannelHandler)this);
        }
        catch (Exception exception) {
            ChatUtils.error("Connection: Error on attaching");
            exception.printStackTrace();
        }
    }
    
    public void channelRead(final ChannelHandlerContext ctx, final Object packet) throws Exception {
        if (!this.eventHandler.onPacket(packet, Side.IN)) {
            return;
        }
        super.channelRead(ctx, packet);
    }
    
    public void write(final ChannelHandlerContext ctx, final Object packet, final ChannelPromise promise) throws Exception {
        if (!this.eventHandler.onPacket(packet, Side.OUT)) {
            return;
        }
        super.write(ctx, packet, promise);
    }
    
    public enum Side
    {
        IN, 
        OUT;
    }
}
