package bungeetools.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SurvivalCommand extends Command {

	public SurvivalCommand() {
		super("survival", "bungeetools.command.survival");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;

			if (!(player.getServer().getInfo().getName().equalsIgnoreCase("survival"))) {
				ServerInfo target = ProxyServer.getInstance().getServerInfo("survival");
				player.connect(target);
			} else {
				sender.sendMessage(new TextComponent(ChatColor.RED + "You are already connected to this server"));
			}
		} else {
			sender.sendMessage(new TextComponent(ChatColor.RED + "Failed to send you to the survival!"));
		}
	}
}