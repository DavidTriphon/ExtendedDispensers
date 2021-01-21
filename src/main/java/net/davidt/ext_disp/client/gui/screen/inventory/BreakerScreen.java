package net.davidt.ext_disp.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.systems.*;
import net.davidt.ext_disp.inventory.container.*;
import net.minecraft.client.gui.screen.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

import javax.annotation.*;


public class BreakerScreen extends ContainerScreen <BreakerContainer>
{
   private static final ResourceLocation BREAKER_BACKGROUND =
      new ResourceLocation("textures/gui/container/crafting_table.png");


   public BreakerScreen(
      BreakerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn)
   {
      super(screenContainer, inv, titleIn);
   }


   @SuppressWarnings({"deprecation", "ConstantConditions"})
   @Override
   protected void renderBg(@Nonnull MatrixStack matrixStack, float partialTicks, int x, int y)
   {
      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.minecraft.getTextureManager().bind(BREAKER_BACKGROUND);
      int i = this.leftPos;
      int j = (this.height - this.imageHeight) / 2;
      this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
   }
}
