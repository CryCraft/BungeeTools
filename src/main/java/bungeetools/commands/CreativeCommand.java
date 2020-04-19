package bungeetools.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CreativeCommand extends Command {

	public CreativeCommand() {
		super("creative", "bungeetools.command.creative");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;

			if (!(player.getServer().getInfo().getName().equalsIgnoreCase("creative"))) {
				ServerInfo target = ProxyServer.getInstance().getServerInfo("creative");
				player.connect(target);
			} else {
				sender.sendMessage(new TextComponent(ChatColor.RED + "You are already connected to this server"));
			}
		} else {
			sender.sendMessage(new TextComponent(ChatColor.RED + "Failed to send you to the creative!"));
		}
	}

}