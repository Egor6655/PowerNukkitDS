package org.IceCube.DiscordListeners;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import org.IceCube.PowerNukkitDS;

import java.util.Objects;


public class DiscordReciever extends ListenerAdapter implements EventListener {

    @Override
    public void onReady(ReadyEvent e) {
        TextChannel t = e.getJDA().getTextChannelsByName("чатмайнкрафт",true).get(0);

        PowerNukkitDS.Instance.getLogger().info("успешно!");
        t.sendMessage(PowerNukkitDS.Instance.getConfig().getString("on-server")).queue();

    }





}
