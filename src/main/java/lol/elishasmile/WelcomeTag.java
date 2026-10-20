package lol.elishasmile;

import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.tag.Tag;

import static lol.elishasmile.Main.instanceContainer;

public class welcomeMessage extends Command {
    public static final Tag<String> WELCOME_MESSAGE = Tag.String("welcome_message").defaultValue("Welcome to the server!");

    public welcomeMessage() {
        super("message");

        setDefaultExecutor((sender, context) -> {
            sender.sendMessage("Usage: /message <Custom Message>");
        });

        var stringArgument = ArgumentType.String("welcome");

        addSyntax((sender, context) -> {
            sender.sendMessage("Message changed to " + context.get(("welcome")));
            instanceContainer.setTag(WELCOME_MESSAGE, context.get("welcome"));
        }, stringArgument);
    }
}
