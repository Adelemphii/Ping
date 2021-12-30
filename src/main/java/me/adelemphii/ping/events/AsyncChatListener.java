package me.adelemphii.ping.events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsyncChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if(!event.getMessage().contains("@")) return;

        String msg = event.getMessage();
        String player = event.getPlayer().getName();

        Pattern p = Pattern.compile("@(\\w{1,16})");
        Matcher m1 = p.matcher(msg);

        while(m1.find()) {
            String target = m1.group(1);
            Player targetPlayer = Bukkit.getPlayerExact(target);
            if(targetPlayer != null) {
                targetPlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                        new TextComponent(ChatColor.translateAlternateColorCodes('&',
                                "&6&l" + player + "&7&r has pinged you in chat!")));
                targetPlayer.playSound(targetPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

                msg = msg.replace("@" + target, ChatColor.translateAlternateColorCodes('&', "&6@" +
                        StringUtils.capitalize(target) + "&r"));
                event.setMessage(msg);
            }
        }

    }
}
