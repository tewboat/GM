package com.gm_mod.init;

import com.gm_mod.gm;

import com.gm_mod.items.MaterialItem;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, gm.MOD_ID);

    public static final RegistryObject<Item> ABOBA = ITEMS.register("aboba", MaterialItem::new);
}
