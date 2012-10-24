package keepcalm.mods.bukkit.forgeHandler.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
/**
 * 
 * A basic Bukkit2ICommand command handler
 * This won't work with Multiverse until I work out the aliases.
 * So I'll probably add a command that does this properly, until I work out how
 * @author keepcalm
 *
 */
public class CommandExecutor2CommandBase extends CommandBase {
	private String name;
	//private Permission requiredPerms;
	//private final CommandExecutor myExec;
	private final Command bukkitCommandInstance;
	/**
	 * Initialises a new instance of a forge-friendly bukkit command handler.
	 * 
	 * 
	 * @param theBukkitExecer - the command that this instance will handle
	 * @param name - the name of the command
	 * @param wantedPerms - the permissions this command requires to run
	 */
	public CommandExecutor2CommandBase(Command cmd, String name) {
		/*this.name = name;
		this.requiredPerm = permissionWanted;*/
		this.bukkitCommandInstance = cmd;
		//this.myExec = cmd.
		this.name =name;
		//this.requiredPerms = wantedPerms;
		//this.bukkitCommandInstance = Bukkit.getServer().getPluginCommand(name);
		
	}
	
	public List<String> addTabCompletionOptions(ICommandSender who, String[] args) {
		
		return bukkitCommandInstance.tabComplete(new BukkitCommandSender(who), args);
	}
	
	public List<String> getCommandAliases() {
		//bukkitCommandInstance.
		return bukkitCommandInstance.getAliases();
	}
	
	public String getCommandUsage(ICommandSender who) {
		return bukkitCommandInstance.getDescription();
	}
	
	public boolean canCommandSenderUseCommand(ICommandSender who) {
		BukkitCommandSender j = new BukkitCommandSender(who);
		if ((bukkitCommandInstance.testPermissionSilent(j))) {
			return true;
		}
		return false;
		
	}
	
	@Override
	public String getCommandName() {
		return name;
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		bukkitCommandInstance.execute(new BukkitCommandSender(var1), this.name, var2);

	}
	public void execute(CommandSender g, String usedName, String[] args) {
		bukkitCommandInstance.execute(g, usedName, args);
	}

}
