/**
    Copyright (C) 2017 by jabelar

    This file is part of jabelar's Minecraft Forge modding examples; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    For a copy of the GNU General Public License see <http://www.gnu.org/licenses/>.
*/

package com.maikerumine.ESMC.networking;

import com.maikerumine.ESMC.Main;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

// TODO: Auto-generated Javadoc
/**
 * @author jabelar
 *
 */
public class MessageToServer implements IMessage
{

    private String text;

    /**
     * Instantiates a new message to server.
     */
    public MessageToServer()
    {
        // need this constructor
    }

    /**
     * Instantiates a new message to server.
     *
     * @param parText
     *            the par text
     */
    public MessageToServer(String parText)
    {
        text = parText;
        // DEBUG
        System.out.println("MyMessage constructor");
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.minecraftforge.fml.common.network.simpleimpl.IMessage#fromBytes(io.netty.buffer.ByteBuf)
     */
    @Override
    public void fromBytes(ByteBuf buf)
    {
        text = ByteBufUtils.readUTF8String(buf); // this class is very useful in general for writing more complex objects
        // DEBUG
        System.out.println("fromBytes = " + text);
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.minecraftforge.fml.common.network.simpleimpl.IMessage#toBytes(io.netty.buffer.ByteBuf)
     */
    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeUTF8String(buf, text);
        // DEBUG
        System.out.println("toBytes = " + text);
    }

    public static class Handler implements IMessageHandler<MessageToServer, IMessage>
    {

        /*
         * (non-Javadoc)
         * 
         * @see net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler#onMessage(net.minecraftforge.fml.common.network.simpleimpl.IMessage,
         * net.minecraftforge.fml.common.network.simpleimpl.MessageContext)
         */
        @Override
        public IMessage onMessage(final MessageToServer message, MessageContext ctx)
        {
            // DEBUG
            System.out.println(String.format("Received %s from %s", message.text, Main.proxy.getPlayerEntityFromContext(ctx).func_145748_c_()));
            // Know it will be on the server so make it thread-safe
            final EntityPlayerMP thePlayer = (EntityPlayerMP) Main.proxy.getPlayerEntityFromContext(ctx);
            thePlayer.func_184102_h().func_152344_a(
                    new Runnable() {
                        @Override
                        public void run()
                        {
                            return;
                        }
                    });
            return null; // no response in this case
        }
    }
}
