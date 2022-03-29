package de.craftsarmy.coinapi.api.config;

import de.craftsarmy.coinapi.CoinAPI;
import de.craftsarmy.coinapi.api.events.EventType;
import de.craftsarmy.coinapi.api.player.CoinPlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public final class Config extends AbstractConfig {

    @Override
    public void load(String path, String file, ConfigCreateConsumer consumer) {
        try {
            this.file = new File(path, file);
            if (!this.file.getParentFile().exists())
                this.file.getParentFile().mkdirs();
            boolean joined = this.file.createNewFile();
            this.configuration = YamlConfiguration.loadConfiguration(this.file);
            if (joined) {
                consumer.consume(this.configuration);
                this.configuration.save(this.file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setCoins(CoinPlayer player, long amount) {
        this.configuration.set("coins." + player.getPlayer().getUniqueId(), amount);
        save();
        CoinAPI.api().getEventHandler().trigger(player, EventType.GENERIC);
    }

    @Override
    public long getCoins(CoinPlayer player) {
        if (this.configuration.contains("coins." + player.getPlayer().getUniqueId()))
            return this.configuration.getLong("coins." + player.getPlayer().getUniqueId());
        return -1;
    }

    @Override
    public void save() {
        try {
            this.configuration.save(this.file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
