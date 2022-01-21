package com.gm_mod.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.FoodStats;
import net.minecraftforge.common.ToolType;

public class MaterialItem extends Item {

    public MaterialItem() {
        super(new Item.Properties().tab(ModItemGroups.ABOBA_ONLY).stacksTo(1));
    }
}
