package org.IceCube;


import cn.nukkit.plugin.PluginBase;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.IceCube.Chat.ChatListener;
import org.IceCube.DiscordListeners.DiscordReciever;
import org.IceCube.DiscordListeners.McFromDiscordEvent;


public class PowerNukkitDS extends PluginBase
{

    public static PowerNukkitDS Instance;
    private static JDA api;







    public void onLoad(){
        Instance = this;


    }


    @Override
    public void onEnable() {
        saveDefaultConfig();


        getLogger().info("плагин запущен!!!");
        this.getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        String token = getConfig().getString("Token");
        if(token.isEmpty()){
            getLogger().info("Write token to the config.yml !");
            getServer().getPluginManager().disablePlugin(this);
        }else {
            try {
                api = JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                        .setStatus(OnlineStatus.ONLINE)
                        .setActivity(Activity.playing("minecraft"))
                        .addEventListeners(new DiscordReciever())
                        .addEventListeners(new McFromDiscordEvent())
                        .build();
            }catch(Exception e){
                e.printStackTrace();

            }
        }

    }

    @Override
    public void onDisable(){
        TextChannel ch = api.getTextChannelsByName(getConfig().getString("ChannelName"),true).get(0);
        ch.sendMessage(getConfig().getString("off-server")).queue();
    }
    public static void sendMessage(String msg)
    {


        TextChannel ch = api.getTextChannelsByName(PowerNukkitDS.Instance.getConfig().getString("ChannelName"),true).get(0);
        ch.sendMessage(msg).queue();
    }

}
