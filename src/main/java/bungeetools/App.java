package bungeetools;

import bungeetools.commands.CreativeCommand;
import bungeetools.commands.LobbyCommand;
import bungeetools.commands.SurvivalCommand;
import bungeetools.events.OnPingListListener;
import bungeetools.events.OnPostLoginEvent;
import net.md_5.bungee.api.plugin.Plugin;

public class App extends Plugin {

    @Override
    public void onEnable() {
        getLogger().info("bungeetools enabled!");

        //events
        getProxy().getPluginManager().registerListener(this, new OnPostLoginEvent());
        getProxy().getPluginManager().registerListener(this, new OnPingListListener(this));

        //commands
        getProxy().getPluginManager().registerCommand(this, new LobbyCommand());
        getProxy().getPluginManager().registerCommand(this, new SurvivalCommand());
        getProxy().getPluginManager().registerCommand(this, new CreativeCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("bungeetools disabled");
    }
}
