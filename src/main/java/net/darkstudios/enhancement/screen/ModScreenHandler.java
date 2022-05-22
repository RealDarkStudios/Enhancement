package net.darkstudios.enhancement.screen;

import net.darkstudios.enhancement.EnhancementMod;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandler {
    public static ScreenHandlerType<DragoniteBlasterScreenHandler> DRAGONITE_BLASTER_SCREEN_HANDLER;

    public static void registerScreenHandlers() {
        DRAGONITE_BLASTER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(EnhancementMod.MOD_ID, "dragonite_blaster"), DragoniteBlasterScreenHandler::new);
    }
}
