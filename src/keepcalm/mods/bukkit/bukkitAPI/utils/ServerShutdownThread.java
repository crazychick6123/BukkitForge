package keepcalm.mods.bukkit.bukkitAPI.utils;

//import net.minecraft.src.ExceptionWorldConflict;
import net.minecraft.server.MinecraftServer;

public class ServerShutdownThread extends Thread {
    private final MinecraftServer server;

    public ServerShutdownThread(MinecraftServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            server.stopServer();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
}
