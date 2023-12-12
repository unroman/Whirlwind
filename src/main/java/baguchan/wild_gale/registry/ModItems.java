package baguchan.wild_gale.registry;

import baguchan.wild_gale.WhirlWindMod;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.WindCharge;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, WhirlWindMod.MODID);
    public static final Supplier<Item> WHIRL_WIND_SPAWNEGG = ITEM_REGISTRY.register("whirl_wind_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.WHIRLWIND, 11506911, 9529055, (new Item.Properties())));
    public static final Supplier<Item> WIND_CHARGE = ITEM_REGISTRY.register("wind_charge", () -> new Item((new Item.Properties())));
    public static final Supplier<Item> BREEZE_ROD = ITEM_REGISTRY.register("breeze_rod", () -> new Item((new Item.Properties())));
    public static final Supplier<Item> BREEZE_POWDER = ITEM_REGISTRY.register("breeze_powder", () -> new Item((new Item.Properties())));

    public static void dispenserInit() {
        DispenserBlock.registerBehavior(WIND_CHARGE.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level p_123476_, Position p_123477_, ItemStack p_123478_) {
                WindCharge windcharge = new WindCharge(EntityType.WIND_CHARGE, p_123476_);
                return windcharge;
            }

            @Override
            protected void playSound(BlockSource p_302441_) {
                super.playSound(p_302441_);
            }

            @Override
            protected float getPower() {
                return 0.7F;
            }

            @Override
            protected float getUncertainty() {
                return 1.0F;
            }
        });
    }
}
