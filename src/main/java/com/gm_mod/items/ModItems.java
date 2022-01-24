package com.gm_mod.items;

import com.gm_mod.gm;
import com.gm_mod.items.MaterialItem;
import com.gm_mod.items.ModItemGroups;
import com.gm_mod.items.ModItemTier;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


import java.util.HashMap;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, gm.MOD_ID);

    public static final String[] names = new String[]{"aboba", "ne_aboba"};

    public static final HashMap<String,RegistryObject<Item>> HASH_MAP = createItem(names);

    public static HashMap<String,RegistryObject<Item>> createItem(String... names) {
        HashMap<String,RegistryObject<Item>> map = new HashMap<String,RegistryObject<Item>>();
        for (String name:names) {
            map.put(name, ITEMS.register(name, MaterialItem::new));
        }
        return map;
    }

    public static final RegistryObject<Item> ABOBA_PICK = ITEMS.register("aboba_pick",
            () -> new SwordItem(ModItemTier.ABOBA, 2, 3f,
                    new Item.Properties().tab(ModItemGroups.ABOBA_ONLY).stacksTo(1).food(Foods.HONEY_BOTTLE)));
    public static final RegistryObject<Item> ABOBA_SWORD = ITEMS.register("aboba_sword",
            () -> new PickaxeItem(ModItemTier.ABOBA, 2, 3f,
                    new Item.Properties().tab(ModItemGroups.ABOBA_ONLY).stacksTo(1).food(Foods.HONEY_BOTTLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
