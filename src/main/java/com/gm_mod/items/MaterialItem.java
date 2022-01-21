package com.gm_mod.items;

import net.minecraft.item.Foods;
import net.minecraft.item.Item;

public class MaterialItem extends Item {

    public MaterialItem() {
        super(new Item.Properties().tab(ModItemGroups.ABOBA_ONLY).stacksTo(1).food(Foods.HONEY_BOTTLE));
    }
}
