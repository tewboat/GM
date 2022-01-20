package com.gm_mod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MaterialItem extends Item {

    public MaterialItem() {
        super(new Item.Properties().tab(ItemGroup.TAB_MATERIALS).stacksTo(63));
    }
}
