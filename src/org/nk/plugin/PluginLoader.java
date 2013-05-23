package org.nk.plugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.jar.JarFile;



public class PluginLoader {

	public PluginLoader() throws IOException {
		File folder = new File(System.getenv("APPDATA") + "/.NuclearKittens/plugins/");

		for (int i = 0; i < folder.listFiles().length; i++) {
			File file = folder.listFiles()[i];
			if (file.toString().endsWith(".jar")) {
				loadPlugin(file, properties(file));
			}
		}
	}

	private void loadPlugin(File file, String mainClass) {
		try {
			URL fileURL = file.toURI().toURL();
			String jarURL = "jar:" + fileURL + "!/";
			URL urls[] = { new URL(jarURL) };
			URLClassLoader ucl = new URLClassLoader(urls);
			Plugin p = (Plugin) Class.forName(mainClass, true, ucl).newInstance();
			p.enable();
		} catch (MalformedURLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	private String properties(File file) {
		try {
			Properties prop = new Properties();
			JarFile jar = new JarFile(file);
			prop.load(jar.getInputStream(jar.getEntry("plugin.properties")));
			jar.close();
			return prop.getProperty("class");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
