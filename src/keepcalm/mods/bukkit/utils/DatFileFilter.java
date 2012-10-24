package keepcalm.mods.bukkit.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class DatFileFilter implements FilenameFilter {

	public boolean accept(File dir, String name) {
		return name.endsWith(".dat");
	}

}
