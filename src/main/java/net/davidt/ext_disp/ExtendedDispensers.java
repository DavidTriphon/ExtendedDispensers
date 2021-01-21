package net.davidt.ext_disp;

import net.davidt.ext_disp.blocks.*;
import net.davidt.ext_disp.client.gui.screen.inventory.*;
import net.davidt.ext_disp.inventory.container.*;
import net.davidt.ext_disp.items.*;
import net.davidt.ext_disp.tileentities.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.*;
import org.apache.logging.log4j.*;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExtendedDispensers.MOD_ID)
public class ExtendedDispensers
{
   public static final String MOD_ID   = "ext_disp";
   public static final String MOD_NAME = "Extended Dispensers";

   // Directly reference a log4j logger.
   private static final Logger LOGGER = LogManager.getLogger();


   public ExtendedDispensers()
   {
      IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

      modBus.register(this);

      EDBlocks.BLOCKS.register(modBus);
      EDItems.ITEMS.register(modBus);
      EDTileEntityTypes.TILE_ENTITIES.register(modBus);
      EDContainers.CONTAINERS.register(modBus);
   }


   @SubscribeEvent
   public void clientSetup(FMLClientSetupEvent event)
   {
      EDScreens.setup();
   }
}
