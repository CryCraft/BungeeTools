package bungeetools.events;

import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.PlayerInfo;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.api.plugin.Plugin;

public class OnPingListListener implements Listener {
	Plugin plugin;

	public OnPingListListener(Plugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPing(ProxyPingEvent event) {

		ServerPing response = event.getResponse();
		Players players = response.getPlayers();
		PlayerInfo[] playerInfo = this.plugin.getProxy().getPlayers().stream().map(player -> new ServerPing.PlayerInfo(player.getName(), player.getUniqueId())).toArray(ServerPing.PlayerInfo[]::new);
		players.setSample(playerInfo);
		response.setPlayers(players);
		event.setResponse(response);
	}

}