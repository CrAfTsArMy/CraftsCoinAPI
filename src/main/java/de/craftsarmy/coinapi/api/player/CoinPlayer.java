package de.craftsarmy.coinapi.api.player;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.concurrent.ConcurrentHashMap;

public final class CoinPlayer {

    private OfflinePlayer player;

    public CoinPlayer(String name) {
        this.player = Bukkit.getOfflinePlayer(name);
    }

    public boolean isOnline() {
        return player.isOnline();
    }

    public Player getAsPlayer() {
        return player.getPlayer();
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

    private static final ConcurrentHashMap<String, CoinPlayer> players = new ConcurrentHashMap<>();

    public static CoinPlayer name(String name) {
        if(players.containsKey(name))
            return players.get(name);
        CoinPlayer player = new CoinPlayer(name);
        players.put(name, player);
        return player;
    }

}
