package net.davidt.ext_disp.blocks;

import net.davidt.ext_disp.tileentities.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import org.lwjgl.system.*;

import javax.annotation.*;


@SuppressWarnings("deprecation")
public class BreakerBlock extends ContainerBlock
{
   public static final DirectionProperty FACING  = DirectionalBlock.FACING;
   public static final BooleanProperty   ENABLED = BlockStateProperties.ENABLED;


   public BreakerBlock(Properties builder)
   {
      super(builder);
      this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH)
         .setValue(ENABLED, Boolean.FALSE));
   }


   @Override
   @NonnullDefault
   public void neighborChanged(
      BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
      boolean isMoving)
   {
      boolean flag = worldIn.hasNeighborSignal(pos) || worldIn.hasNeighborSignal(pos.above());
      boolean flag1 = state.getValue(ENABLED);
      if (flag && !flag1)
      {
         worldIn.setBlock(pos, state.setValue(ENABLED, Boolean.TRUE), 4);
      }
      else if (!flag && flag1)
      {
         worldIn.setBlock(pos, state.setValue(ENABLED, Boolean.FALSE), 4);
      }
   }


   @Override
   @NonnullDefault
   public void onRemove(
      BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving)
   {
      if (!state.is(newState.getBlock()))
      {
         TileEntity tileentity = worldIn.getBlockEntity(pos);
         if (tileentity instanceof BreakerTE)
         {
            InventoryHelper.dropContents(worldIn, pos, (BreakerTE) tileentity);
            worldIn.updateNeighbourForOutputSignal(pos, this);
         }

         super.onRemove(state, worldIn, pos, newState, isMoving);
      }
   }


   @Override
   @NonnullDefault
   public ActionResultType use(
      BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
      BlockRayTraceResult hit)
   {
      if (worldIn.isClientSide)
      {
         return ActionResultType.SUCCESS;
      }
      else
      {
         TileEntity tileentity = worldIn.getBlockEntity(pos);
         if (tileentity instanceof BreakerTE)
            player.openMenu((BreakerTE) tileentity);
         return ActionResultType.CONSUME;
      }
   }


   @NonnullDefault
   @Override
   public TileEntity newBlockEntity(IBlockReader worldIn)
   {
      return new BreakerTE();
   }


   @Override
   public BlockState getStateForPlacement(BlockItemUseContext context)
   {
      return this.defaultBlockState()
         .setValue(FACING, context.getNearestLookingDirection().getOpposite());
   }


   /**
    * Called by ItemBlocks after a block is set in the world, to allow post-place logic
    */
   @Override
   @NonnullDefault
   public void setPlacedBy(
      World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack)
   {
      if (stack.hasCustomHoverName())
      {
         TileEntity tileentity = worldIn.getBlockEntity(pos);
         if (tileentity instanceof BreakerTE)
         {
            ((BreakerTE) tileentity).setCustomName(stack.getHoverName());
         }
      }
   }


   @Override
   protected void createBlockStateDefinition(StateContainer.Builder <Block, BlockState> builder)
   {
      builder.add(FACING, ENABLED);
   }


   @Override
   public BlockRenderType getRenderShape(BlockState state)
   {
      return BlockRenderType.MODEL;
   }
}
