package net.davidt.ext_disp.client.gui.screen.inventory;

import net.davidt.ext_disp.inventory.container.*;
import net.minecraft.client.gui.*;


public class EDScreens
{
   public static void setup()
   {
      ScreenManager.register(EDContainers.BREAKER.get(), BreakerScreen::new);
   }
}
