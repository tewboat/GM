package com.gm_mod.items;

import com.gm_mod.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {
    public static final ItemGroup ABOBA_ONLY = new ModItemGroup("ABOBA_ONLY", () -> new ItemStack(ModItems.ABOBA.get()));
}