package com.gm_mod.blocks;

import com.gm_mod.gm;
import com.gm_mod.items.ModItems;
import com.gm_mod.items.ModItemGroups;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, gm.MOD_ID);

    public static final RegistryObject<Block> ABOBA_ORE = registerBlock("aboba_ore",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).strength(8f)));

    public static final RegistryObject<Block> ABOBA_BLOCK = registerBlock("aboba_block",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).strength(8f)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemGroups.ABOBA_ONLY)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
