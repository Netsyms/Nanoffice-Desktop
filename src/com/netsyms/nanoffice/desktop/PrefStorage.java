package com.netsyms.nanoffice.desktop;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 *
 * @author Skylar Ittner
 */
public class PrefStorage {

    private static final Preferences prefs = Preferences.userNodeForPackage(PrefStorage.class);

    /**
     *
     * @param key
     * @param value
     */
    public static void saveSetting(String key, String value) {
        prefs.put(key, value);
    }

    /**
     *
     * @param key
     * @return
     */
    public static boolean isset(String key) {
        return !getSetting(key, "NULL").equals("NULL");
    }

    /**
     *
     * @param key
     */
    public static void unset(String key) {
        saveSetting(key, "");
        save();
        prefs.remove(key);
        save();
    }

    /**
     *
     * @param key
     * @return
     */
    public static String getSetting(String key) {
        return prefs.get(key, "");
    }

    /**
     *
     * @param key
     * @param emptyResponse
     * @return
     */
    public static String getSetting(String key, String emptyResponse) {
        return prefs.get(key, emptyResponse);
    }

    /**
     *
     * @return
     */
    public static boolean save() {
        try {
            prefs.flush();
            prefs.sync();
        } catch (BackingStoreException ex) {
            System.err.println("Settings could not be saved!");
            return false;
        }
        return true;
    }

    /**
     * Wipe all settings.
     *
     * @throws java.util.prefs.BackingStoreException
     */
    public static void wipe() throws BackingStoreException {
        prefs.clear();
    }

    // xkcd 221 compliance.
    int getRandomNumber() {
        return 4; // chosen by fair dice roll.
        // guaranteed to be random.
    }
}
