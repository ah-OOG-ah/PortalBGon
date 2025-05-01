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

import java.util.List;
import java.util.function.Supplier;

import com.gtnewhorizon.gtnhlib.mixin.IMixins;
import com.gtnewhorizon.gtnhlib.mixin.ITargetedMod;
import com.gtnewhorizon.gtnhlib.mixin.MixinBuilder;
import com.gtnewhorizon.gtnhlib.mixin.Phase;
import com.gtnewhorizon.gtnhlib.mixin.Side;

public enum Mixins implements IMixins {
    ;

    private final List<String> mixinClasses;
    private final Supplier<Boolean> applyIf;
    private final Phase phase;
    private final Side side;
    private final List<ITargetedMod> targetedMods;
    private final List<ITargetedMod> excludedMods;

    Mixins(MixinBuilder builder) {
        mixinClasses = builder.mixinClasses;
        applyIf = builder.applyIf;
        side = builder.side;
        targetedMods = builder.targetedMods;
        excludedMods = builder.excludedMods;
        phase = builder.phase;

        if (mixinClasses.isEmpty()) throw new RuntimeException("No mixin class specified for Mixin : " + name());
        if (targetedMods.isEmpty()) throw new RuntimeException("No targeted mods specified for Mixin : " + name());
        if (applyIf == null) throw new RuntimeException("No ApplyIf function specified for Mixin : " + name());
        if (phase == null) throw new RuntimeException("No Phase specified for Mixin : " + name());
        if (side == null) throw new RuntimeException("No Side function specified for Mixin : " + name());
    }

    @Override
    public List<String> getMixinClasses() {
        return mixinClasses;
    }

    @Override
    public Supplier<Boolean> getApplyIf() {
        return applyIf;
    }

    @Override
    public Phase getPhase() {
        return phase;
    }

    @Override
    public Side getSide() {
        return side;
    }

    @Override
    public List<ITargetedMod> getTargetedMods() {
        return targetedMods;
    }

    @Override
    public List<ITargetedMod> getExcludedMods() {
        return excludedMods;
    }
}
