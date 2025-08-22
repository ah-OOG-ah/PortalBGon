/**
 * This file is part of PortalBGon - a mod to constrain your "doors".
 * Copyright (C) 2025 ah-OOG-ah
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

package klaxon.klaxon.portalbgon.mixins;

import javax.annotation.Nonnull;

import com.gtnewhorizon.gtnhmixins.builders.IMixins;
import com.gtnewhorizon.gtnhmixins.builders.MixinBuilder;

public enum Mixins implements IMixins {

    NUKE_PORTAL_BLOCK("Erase most of the methods inside BlockPortal", Side.COMMON, "minecraft.MixinBlockPortal");

    private final MixinBuilder builder;

    Mixins(String desc, Side side, String... classes) {
        builder = new MixinBuilder(desc).addSidedMixins(side, classes)
            .setPhase(Phase.EARLY);
    }

    @Nonnull
    @Override
    public MixinBuilder getBuilder() {
        return builder;
    }
}
