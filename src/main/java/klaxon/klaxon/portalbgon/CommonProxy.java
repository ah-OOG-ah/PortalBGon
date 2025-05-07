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

import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent ignored) {
        try {
            ConfigurationManager.registerConfig(PGBConfig.class);
        } catch (ConfigException e) {
            throw new RuntimeException(e);
        }

        if (PGBConfig.redirectXDimTp) {
            FMLCommonHandler.instance()
                .bus()
                .register(this);
        }
    }

    @SubscribeEvent
    public void onPlayerDimChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (event.toDim == -1) {
            event.player.travelToDimension(event.fromDim);
        }
    }
}
