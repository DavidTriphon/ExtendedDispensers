package net.davidt.ext_disp.common.items;

import net.davidt.ext_disp.common.blocks.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

import static net.davidt.ext_disp.ExtendedDispensers.*;


public class EDItems
{
   public static final DeferredRegister <Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

   public static final RegistryObject <BlockItem> PLACER =
      ITEMS.register("placer", () -> new BlockItem(
         EDBlocks.PLACER.get(), new Item.Properties().tab(ItemGroup.TAB_REDSTONE)
      ));
}
