package bungeetools.events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class OnPostLoginEvent implements Listener {
	@EventHandler
	public void onPostLogin(PostLoginEvent Event) {
		ProxiedPlayer player = Event.getPlayer();
		sendChatJoinMessage(Event);
		sendChatJoinPlayer(player);
	}

	public void sendChatJoinPlayer(ProxiedPlayer player) {
		TextComponent welcomeMessage = new TextComponent("Welcome to CryCraft!");
		welcomeMessage.setColor(ChatColor.YELLOW);

		TextComponent message = new TextComponent("Links: ");
		message.setColor(ChatColor.YELLOW);

		TextComponent discord = new TextComponent("Discord");
		discord.setColor(ChatColor.DARK_AQUA);
		discord.setBold(true);
		discord.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/qgzsXJd"));
		discord.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to join the discord server!").create()));

		TextComponent seperator = new TextComponent(", ");
		seperator.setColor(ChatColor.WHITE);
		seperator.setBold(false);

		TextComponent website = new TextComponent("Website");
		website.setColor(ChatColor.DARK_AQUA);
		website.setBold(true);
		website.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Work in progress!").create()));

		message.addExtra(discord);
		message.addExtra(seperator);
		message.addExtra(website);

		player.sendMessage();
		player.sendMessage();
		player.sendMessage(welcomeMessage);
		player.sendMessage();
		player.sendMessage(message);
		player.sendMessage();
		player.sendMessage();
	}
	
	public void sendChatJoinMessage(PostLoginEvent Event) {
		for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
			TextComponent message = new TextComponent(Event.getPlayer().getDisplayName() + " joined the server");
			message.setColor(ChatColor.YELLOW);
			player.sendMessage(message);
		}
	}
}