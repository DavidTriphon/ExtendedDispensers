package net.davidt.ext_disp.inventory.container;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.util.*;

import javax.annotation.*;


public class BreakerContainer extends Container
{
   private final IInventory _blockInventory;
   private final IIntArray  _blockData;
   private final Slot       _toolSlot;


   public BreakerContainer(
      @Nullable ContainerType <?> type, int id, PlayerInventory playerInventory)
   {
      this(type, id, playerInventory, new Inventory(10), new IntArray(1));
   }


   public BreakerContainer(
      @Nullable ContainerType <?> type, int id, PlayerInventory playerInventory,
      IInventory blockInventory, IIntArray blockData)
   {
      super(type, id);
      _blockInventory = blockInventory;
      _blockData = blockData;

      checkContainerSize(blockInventory, 10);
      checkContainerDataCount(blockData, 1);

      // block slots
      // tool slot
      _toolSlot = this.addSlot(new Slot(blockInventory, 9, 124, 35));

      // storage slots
      for (int i = 0; i < 3; ++i)
      {
         for (int j = 0; j < 3; ++j)
         {
            this.addSlot(new Slot(blockInventory, j + i * 3, 30 + j * 18, 17 + i * 18));
         }
      }

      // player inventory slots
      for (int i = 0; i < 3; ++i)
      {
         for (int j = 0; j < 9; ++j)
         {
            this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
         }
      }

      for (int k = 0; k < 9; ++k)
      {
         this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
      }
   }


   /**
    * Determines whether supplied player can use this container
    *
    * @param playerIn
    */
   @Override
   public boolean stillValid(PlayerEntity playerIn)
   {
      return true;
   }
}
