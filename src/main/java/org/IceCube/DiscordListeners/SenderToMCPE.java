package org.IceCube.DiscordListeners;

import cn.nukkit.Nukkit;
import cn.nukkit.Player;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import org.IceCube.PowerNukkitDS;

import java.util.*;

public class SenderToMCPE  {
    public static void sendToMCPE(String msg) {
        Map<UUID,Player> playerMap = PowerNukkitDS.Instance.getServer().getOnlinePlayers();
        for(Map.Entry<UUID,Player> entry: playerMap.entrySet()){
            Player p = entry.getValue();
            p.sendMessage(msg);

        }




    }
}
