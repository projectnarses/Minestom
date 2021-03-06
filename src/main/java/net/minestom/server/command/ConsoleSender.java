package net.minestom.server.command;

import net.minestom.server.permission.Permission;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents the console when sending a command to the server.
 */
public class ConsoleSender implements CommandSender {

    private final List<Permission> permissions = new LinkedList<>();

    @Override
    public void sendMessage(@NotNull String message) {
        System.out.println(message);
    }

    @NotNull
    @Override
    public Collection<Permission> getAllPermissions() {
        return permissions;
    }
}
