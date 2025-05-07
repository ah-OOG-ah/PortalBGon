/**
 * This file is part of PortalBGon - a mod to constrain your "doors".
 * Copyright (C) 2025 ah-OOG-ah
 * Copyright (C) 2025 Midnight145
 *
 * PortalBGon is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PortalBGon is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package klaxon.klaxon.portalbgon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = PortalBGon.MODID, version = Tags.VERSION, name = "PortalBGon", acceptedMinecraftVersions = "[1.7.10]")
public class PortalBGon {

    public static final String MODID = "portalbgon";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(
        clientSide = "klaxon.klaxon.portalbgon.ClientProxy",
        serverSide = "klaxon.klaxon.portalbgon.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }
}
