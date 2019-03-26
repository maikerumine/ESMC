/**
    Copyright (C) 2017 by jabelar

    This file is part of jabelar's Minecraft Forge modding examples; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    For a copy of the GNU General Public License see <http://www.gnu.org/licenses/>.
*/
package com.maikerumine.ESMC.init;

import java.io.File;

import com.maikerumine.ESMC.Main;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

// TODO: Auto-generated Javadoc
public class ModConfig
{
    // set up configuration properties (will be read from config file in preInit)
    public static File configFile;
    public static Configuration config;
    public static boolean allowDeconstructUnrealistic = false;
    public static boolean allowDeconstructEnchantedBooks = true;
    public static boolean allowHorseArmorCrafting = true;
    public static boolean allowPartialDeconstructing = true;
    
    /**
     * Process the configuration.
     *
     * @param event
     *            the event
     */
    public static void initConfig(FMLPreInitializationEvent event)
    {
        // might need to use suggestedConfigFile (event.getSuggestedConfigFile) location to publish
        configFile = event.getSuggestedConfigurationFile();
        // DEBUG
        System.out.println(Main.MODNAME + " config path = " + configFile.getAbsolutePath());
        System.out.println("Config file exists = " + configFile.canRead());

        config = new Configuration(configFile);

        syncConfig();
    }

    /**
     * Sync config.
     */
    /*
     * sync the configuration want it public so you can handle case of changes made in-game
     */
    public static void syncConfig()
    {
        config.load();
        allowDeconstructUnrealistic = config.get(Configuration.CATEGORY_GENERAL, "All Craftables Can Deconstruct", false,
                "Allow unrealistic deconstruction like pumpkins back from pumpkin seeds").getBoolean(false);
        // DEBUG
        System.out.println("Allow unrealistic deconstruction = " + allowDeconstructUnrealistic);
        allowHorseArmorCrafting = config
                .get(Configuration.CATEGORY_GENERAL, "Can Craft Horse Armor", true, "Allow crafting of horse armor and SADDLEs").getBoolean(true);
        // DEBUG
        System.out.println("Allow horse armor crafting = " + allowHorseArmorCrafting);
        allowDeconstructEnchantedBooks = config
                .get(Configuration.CATEGORY_GENERAL, "Can Deconstruct Enchanted Books", true, "Allow enchanted books to deconstruct like a regular book")
                .getBoolean(true);
        // DEBUG
        System.out.println("Allow enchanted book deconstruction = " + allowDeconstructEnchantedBooks);
        allowPartialDeconstructing = config
                .get(Configuration.CATEGORY_GENERAL, "Allow Partial Deconstruction", true, "Allow deconstruction of stacks that are less than crafting output")
                .getBoolean(true);
        // DEBUG
        System.out.println("Allow partial deconstruction = " + allowPartialDeconstructing);

        // save is useful for the first run where config might not exist, and doesn't hurt
        config.save();
    }
}
