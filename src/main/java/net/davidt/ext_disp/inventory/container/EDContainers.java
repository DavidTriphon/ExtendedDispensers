package net.davidt.ext_disp.inventory.container;

import net.minecraft.inventory.container.*;
import net.minecraftforge.common.extensions.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

import static net.davidt.ext_disp.ExtendedDispensers.*;


public class EDContainers
{
   public static final DeferredRegister <ContainerType <?>> CONTAINERS =
      DeferredRegister.create(ForgeRegistries.CONTAINERS, MOD_ID);

   public static final RegistryObject <ContainerType <BreakerContainer>> BREAKER =
      CONTAINERS.register("breaker", () -> IForgeContainerType.create(
         (windowId, playerInv, extraData) ->
            new BreakerContainer(EDContainers.BREAKER.get(), windowId, playerInv)
      ));
}
