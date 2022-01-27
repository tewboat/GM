package com.gm_mod;

import com.gm_mod.blocks.ModBlocks;
import com.gm_mod.items.ModItems;
import com.sun.javafx.sg.prism.NodeEffectInput;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("gm_mod")
public class gm
{

    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "gm_mod";

    public gm() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);

        ModItems.ITEMS.register(eventBus);
        ModBlocks.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }
}
