package net.darkstudios.enhancement.command;

import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.KillCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.BaseText;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class EnhancementTopLevelCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("enhancement").then(CommandManager.literal("help").executes(EnhancementTopLevelCommand::help)));
    }

    private static int help(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        context.getSource().sendFeedback(new LiteralText("§eThese commands are implemented. §cThese are not"), true);
        context.getSource().sendFeedback(new LiteralText(defaultHelpFeedback("e", "help", "Shows this help menu!")), true);
        context.getSource().sendFeedback(new LiteralText(defaultHelpFeedback("c", "admin help", "Shows the admin help menu")), true);return 1;
    }

    private static String defaultHelpFeedback(String colorCode, String CommandArgument, String whatCommandDoes) {
        String textToReturn = String.format("§%s/enhancement %s - %s", colorCode, CommandArgument, whatCommandDoes);
        return textToReturn;
    }
}
