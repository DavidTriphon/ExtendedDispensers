package net.davidt.ext_disp.tileentities;

import net.minecraft.tileentity.*;
import net.minecraft.util.text.*;


public class PlacerTE extends DispenserTileEntity
{
   public PlacerTE()
   {
      this(EDTileEntityTypes.PLACER.get());
   }

   protected PlacerTE(TileEntityType <?> tileEntityType)
   {
      super(tileEntityType);
   }


   @Override
   protected ITextComponent getDefaultName()
   {
      return new TranslationTextComponent("container.placer");
   }
}
