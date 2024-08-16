package org.IceCube.Chat;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerMessageEvent;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.IceCube.PowerNukkitDS;





public class ChatListener implements Listener {

    public static PowerNukkitDS plugin;

    public ChatListener(PowerNukkitDS plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void chatEvent(PlayerChatEvent e){
        String msg = e.getMessage();
        PowerNukkitDS.sendMessage(e.getPlayer().getName()+" : "+msg);

        if(PowerNukkitDS.Instance.getConfig().getString("Debug").equals("true")){
            PowerNukkitDS.Instance.getLogger().info(msg);
        }




    }
    public String chatMessage(String msg){
        return msg;
    }

}
