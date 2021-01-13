package net.davidt.ext_disp.common.tileentities;

import net.minecraft.tileentity.*;
import net.minecraft.util.text.*;


public class PlacerTE extends DispenserTileEntity
{
   public PlacerTE()
   {
      this(EDTileEntities.PLACER.get());
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
