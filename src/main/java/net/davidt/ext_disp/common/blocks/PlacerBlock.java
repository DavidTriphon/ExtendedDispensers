package net.davidt.ext_disp.common.blocks;

import net.davidt.ext_disp.common.tileentities.*;
import net.minecraft.block.*;
import net.minecraft.dispenser.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;


public class PlacerBlock extends DispenserBlock
{
   private static final IDispenseItemBehavior PLACE_BEHAVIOR     = new ShulkerBoxDispenseBehavior();
   private static final IDispenseItemBehavior DISPENSE_BEHAVIOUR =
      new DefaultDispenseItemBehavior();


   public PlacerBlock(Properties builder)
   {
      super(builder);
   }


   @Override
   protected void dispenseFrom(
      ServerWorld worldIn, BlockPos pos)
   {
      ProxyBlockSource proxyblocksource = new ProxyBlockSource(worldIn, pos);
      DispenserTileEntity dispensertileentity = proxyblocksource.getEntity();
      int i = dispensertileentity.getRandomSlot();
      if (i < 0)
      {
         worldIn.levelEvent(1001, pos, 0);
      }
      else
      {
         ItemStack itemstack = dispensertileentity.getItem(i);
         IDispenseItemBehavior dispenseItemBehavior =
            (itemstack.getItem() instanceof BlockItem) ? PLACE_BEHAVIOR : DISPENSE_BEHAVIOUR;
         itemstack = dispenseItemBehavior.dispense(proxyblocksource, itemstack);
         dispensertileentity.setItem(i, itemstack);
      }
   }


   @Override
   protected IDispenseItemBehavior getDispenseMethod(ItemStack stack)
   {
      return PLACE_BEHAVIOR;
   }


   @Override
   public TileEntity newBlockEntity(IBlockReader worldIn)
   {
      return new PlacerTE();
   }
}
