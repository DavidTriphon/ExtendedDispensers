package net.davidt.ext_disp.tileentities;

import net.davidt.ext_disp.inventory.container.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

import javax.annotation.*;


public class BreakerTE extends LockableLootTileEntity
   implements ISidedInventory, ITickableTileEntity
{
   private static final int[]                   SLOTS_STORAGE =
      new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
   private static final int[]                   SLOTS_TOOL    = new int[] {9};
   private static final int[]                   SLOTS_ALL     =
      new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
   private final        Item                    _currentTool  = null;
   private              NonNullList <ItemStack> _items        =
      NonNullList.withSize(10, ItemStack.EMPTY);


   public BreakerTE()
   {
      this(EDTileEntityTypes.BREAKER.get());
   }


   protected BreakerTE(TileEntityType <?> typeIn)
   {
      super(typeIn);
   }


   @Override
   public void load(BlockState state, CompoundNBT nbt)
   {
      super.load(state, nbt);
      this._items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
      ItemStackHelper.loadAllItems(nbt, _items);
   }


   @Override
   public CompoundNBT save(CompoundNBT compound)
   {
      super.save(compound);
      ItemStackHelper.saveAllItems(compound, _items);
      return compound;
   }


   @Override
   protected ITextComponent getDefaultName()
   {
      return new TranslationTextComponent("container.breaker");
   }


   @Override
   protected Container createMenu(int id, PlayerInventory player)
   {
      return new BreakerContainer(EDContainers.BREAKER.get(), id, player);
   }


   @Override
   public int[] getSlotsForFace(Direction side)
   {
      if (side.getAxis() != Direction.Axis.Y) // sides
         return SLOTS_TOOL;
      else if (side == Direction.UP) // top
         return SLOTS_STORAGE;
      else // bottom
         // add condition to stop pulling tools out through bottom on conditions in canTakeItem
         return SLOTS_ALL;
   }


   /**
    * Returns true if automation can insert the given item in the given slot from the given side.
    *
    * @param index
    * @param itemStackIn
    * @param directionIn
    */
   @Override
   public boolean canPlaceItemThroughFace(
      int index, ItemStack itemStackIn, @Nullable Direction directionIn)
   {
      return this.canPlaceItem(index, itemStackIn);
   }


   /**
    * Returns true if automation can extract the given item in the given slot from the given side.
    *
    * @param index
    * @param stack
    * @param directionIn
    */
   @Override
   public boolean canTakeItemThroughFace(
      int index, ItemStack stack, Direction directionIn)
   {
      if (directionIn == Direction.DOWN)
         return isTakeableTool(stack.getItem());
      return true;
   }


   @Override
   protected NonNullList <ItemStack> getItems()
   {
      return _items;
   }


   @Override
   protected void setItems(NonNullList <ItemStack> itemsIn)
   {
      _items = itemsIn;
   }


   /**
    * Returns the number of slots in the inventory.
    */
   @Override
   public int getContainerSize()
   {
      return _items.size();
   }


   @Override
   public void tick()
   {
      // TODO: breaker logic here
   }


   private static boolean isValidTool(Item item)
   {
      return true;
   }


   private static boolean isTakeableTool(Item item)
   {
      return false;
   }
}
