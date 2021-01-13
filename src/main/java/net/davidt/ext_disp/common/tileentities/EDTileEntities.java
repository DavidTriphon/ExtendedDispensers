package net.davidt.ext_disp.common.tileentities;

import net.davidt.ext_disp.common.blocks.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

import static net.davidt.ext_disp.ExtendedDispensers.*;


public class EDTileEntities
{
   public static final DeferredRegister <TileEntityType <?>> TILE_ENTITIES =
      DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MOD_ID);

   public static final RegistryObject <TileEntityType <PlacerTE>> PLACER =
      TILE_ENTITIES.register("placer", () ->
         TileEntityType.Builder.of(PlacerTE::new, EDBlocks.PLACER.get()).build(null)
      );
}
