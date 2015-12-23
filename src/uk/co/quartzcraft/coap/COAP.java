package uk.co.quartzcraft.coap;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.quartzcraft.core.QuartzCore;
import uk.co.quartzcraft.core.command.framework.QCommandFramework;
import uk.co.quartzcraft.core.database.MySQL;
import uk.co.quartzcraft.core.systems.chat.QCChat;
import uk.co.quartzcraft.core.systems.config.QCConfig;

import java.sql.Connection;
import java.util.logging.Logger;

public class COAP extends JavaPlugin {

    public static Plugin plugin;
    public static Plugin core;

    public static QCConfig config;

    public final Logger logg = Logger.getLogger("Minecraft");
    public static final Logger log = Logger.getLogger("Minecraft");

    public static String releaseVersion = QuartzCore.getVersion();
    public static String version;

    public static Connection DBCoap = null;
    public static MySQL MySQLcoap = null;

    public QCommandFramework commandFramework;

    @Override
    public void onDisable() {
        //Shutdown notice
        log.info("[COAP] The ComeOutAndPlay Plugin has been disabled!");
    }

    @Override
    public void onEnable() {

        version = this.getDescription().getVersion();
        plugin = this;
        core = QuartzCore.plugin;

        log.info("[COAP] Running plugin configuration");
        this.saveDefaultConfig();

        String SQLCOAPHost = this.getConfig().getString("database.coap.host");
        String SQLCOAPDatabase = this.getConfig().getString("database.coap.database");
        String SQLCOAPUser = this.getConfig().getString("database.coap.username");
        String SQLCOAPPassword = this.getConfig().getString("database.coap.password");
        MySQLcoap = new MySQL(plugin, SQLCOAPHost, "3306", SQLCOAPDatabase, SQLCOAPUser, SQLCOAPPassword);

        //Phrases
        log.info("[COAP][STARTUP]Creating Phrases");

        QCChat.addPhrase("COAP", "Come Out and Play");

        //Database
        log.info("[COAP][STARTUP] Connecting to Database");
        DBCoap = MySQLcoap.openConnection();

        //Listeners
        log.info("[COAP][STARTUP] Registering Listeners");


        //Commands
        log.info("[COAP][STARTUP] Registering Commands");
        commandFramework = new QCommandFramework(this);
        //commandFramework.registerCommands(new CommandKingdom(this, core));

        //Startup notice
        log.info("[COAP] The ComeOutAndPlay Plugin has been enabled!");
        log.info("[COAP] ComeOutAndPlay version " + version + " compiled with QuartzCore version " + releaseVersion);
        //log.info("[QK] QuartzKingdoms version " + version + " compiled with QuartzCore version " + QuartzCore.getVersion());
    }
}
