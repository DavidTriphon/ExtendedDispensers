package net.davidt.ext_disp.tileentities;

import net.davidt.ext_disp.blocks.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

import java.util.function.*;

import static net.davidt.ext_disp.ExtendedDispensers.*;


public class EDTileEntityTypes
{
   public static final DeferredRegister <TileEntityType <?>> TILE_ENTITIES =
      DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MOD_ID);

   public static final RegistryObject <TileEntityType <PlacerTE>>  PLACER  =
      register("placer", PlacerTE::new, EDBlocks.PLACER);
   public static final RegistryObject <TileEntityType <BreakerTE>> BREAKER =
      register("breaker", BreakerTE::new, EDBlocks.BREAKER);


   private static <T extends TileEntity, B extends Block> RegistryObject <TileEntityType <T>> register(
      String name, Supplier <T> tileEntitySupplier, RegistryObject <B> blockRegistry)
   {
      return TILE_ENTITIES.register(name, () -> TileEntityType.Builder.of(
         tileEntitySupplier, blockRegistry.get()).build(null));
   }
}
