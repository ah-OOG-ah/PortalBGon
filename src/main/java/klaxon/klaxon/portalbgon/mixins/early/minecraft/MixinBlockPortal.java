package klaxon.klaxon.portalbgon.mixins.early.minecraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * Prevents the portal block from doing anything useful. Most of these are deliberate overwrites, because if some other
 * mod is trying to do something with the portal block it's probably not going to do anything correct!
 */
@SuppressWarnings("UnusedMixin")
@Mixin(BlockPortal.class)
public abstract class MixinBlockPortal extends Block {

    /**
     * @author ah-OOG-ah
     * @reason delete itself on tick, if it somehow ever gets created.
     */
    @Overwrite
    public void updateTick(World world, int x, int y, int z, Random random) {
        world.setBlockToAir(x, y, z);
    }

    /**
     * @author ah-OOG-ah
     * @reason completely block portal creation
     */
    @Overwrite
    public boolean func_150000_e(World world, int x, int y, int z) {
        return false;
    }

    /**
     * @author ah-OOG-ah
     * @reason delete itself on BUD, if it somehow ever gets created.
     */
    @Overwrite
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
        world.setBlockToAir(x, y, z);
    }

    /**
     * @author ah-OOG-ah
     * @reason I think you get the gist of it by now.
     */
    @Overwrite
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entityIn) {
        world.setBlockToAir(x, y, z);
    }

    protected MixinBlockPortal(Material materialIn) {
        super(materialIn);
    }
}
