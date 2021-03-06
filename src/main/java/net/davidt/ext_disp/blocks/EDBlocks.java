package net.davidt.ext_disp.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

import static net.davidt.ext_disp.ExtendedDispensers.*;


public class EDBlocks
{
   public static final DeferredRegister <Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

   public static final RegistryObject <PlacerBlock> PLACER =
      BLOCKS.register("placer", () -> new PlacerBlock(
         AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5F)
      ));

   public static final RegistryObject <BreakerBlock> BREAKER =
      BLOCKS.register("breaker", () -> new BreakerBlock(
         AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5F)
      ));
}
