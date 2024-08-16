package org.IceCube.DiscordListeners;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.IceCube.PowerNukkitDS;

public class McFromDiscordEvent extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if(!e.getAuthor().isBot()) {
            if (e.getChannelType().equals(ChannelType.TEXT)) {
                if (e.getChannel().getName().equals(PowerNukkitDS.Instance.getConfig().getString("ChannelName"))) {
                    String message = e.getMessage().getContentRaw();
                    if(PowerNukkitDS.Instance.getConfig().getString("Debug").equals("true")){
                        PowerNukkitDS.Instance.getLogger().info("new message recieved!");
                    }

                    SenderToMCPE.sendToMCPE(message);
                }
            }
        }

    }
}
