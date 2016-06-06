/**
 * This file is used to load properties related to Platform Bots
 */
package com.bsb.hike.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author amita
 *
 */
public class PlatformBotsConfig extends ConfigFile {
    private static volatile PlatformBotsConfig config = null;

    private final String GAMESBOT_CONFIG_FILE = System.getProperty("user.dir") + "/support/config/gamesBot.properties";

    private final String TESTBOT_CONFIG_FILE = System.getProperty("user.dir") + "/support/config/testBot.properties";

    private final String DBOT_CONFIG_FILE = System.getProperty("user.dir") + "/support/config/dbot.properties";

    private String gamesBotJson;
    private String testBotJson;
    private String dbotJson;
    private String gamesBotMsisdn;
    private String testBotMsisdn;

    public static PlatformBotsConfig getInstance() {
        if (config == null) {
            synchronized (PlatformBotsConfig.class) {
                if (config == null) {
                    config = new PlatformBotsConfig();
                }
            }
        }
        return config;
    }

    public PlatformBotsConfig() {
        loadGamesProperties(getPropertiesFromFile(GAMESBOT_CONFIG_FILE));
        loadTestBotProperties(getPropertiesFromFile(TESTBOT_CONFIG_FILE));
        loadDBotProperties(getPropertiesFromFile(DBOT_CONFIG_FILE));
    }

    public Properties getPropertiesFromFile(String propsFile) {
        Properties properties = new Properties();
        try {
            InputStream propertiesFile = new FileInputStream(new File(propsFile));
            if (propertiesFile != null) {
                properties.load(propertiesFile);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); }
        catch (Throwable e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void loadGamesProperties(Properties properties) {
        gamesBotJson = getStringProperty(properties, "gamesBotJson", "testgamesBotJson");
    }

    public void loadTestBotProperties(Properties properties) {
        testBotJson = getStringProperty(properties, "testBotJson", "testBotJson");
    }

    public void loadDBotProperties(Properties properties) {
        dbotJson = getStringProperty(properties, "dbotJson", "dbotJson");
        gamesBotMsisdn = getStringProperty(properties, "gamesBotMsisdn", "gamesBotMsisdn");
        testBotMsisdn = getStringProperty(properties, "testBotMsisdn", "testBotMsisdn");
    }
    
    public String getGamesBotJson() {
        return gamesBotJson;
    }

    public void setGamesBotJson(String gamesBotJson) {
        this.gamesBotJson = gamesBotJson;
    }

    public String getTestBotJson() {
        return testBotJson;
    }

    public void setTestBotJson(String testBotJson) {
        this.testBotJson = testBotJson;
    }

    public String getDbotJson() {
        return dbotJson;
    }

    public void setDbotJson(String dbotJson) {
        this.dbotJson = dbotJson;
    }

    public String getGamesBotMsisdn() {
        return gamesBotMsisdn;
    }

    public void setGamesBotMsisdn(String gamesBotMsisdn) {
        this.gamesBotMsisdn = gamesBotMsisdn;
    }

    public String getTestBotMsisdn() {
        return testBotMsisdn;
    }

    public void setTestBotMsisdn(String testBotMsisdn) {
        this.testBotMsisdn = testBotMsisdn;
    }
}
