package me.ByteCoder.Core.Module;

import com.sun.istack.internal.NotNull;

import javax.management.*;
import java.io.*;
import java.lang.instrument.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.*;

public class ModuleManager {

private Map<String, Module> modules;
	
public ModuleManager() {
    this.modules = new HashMap<String, Module>();
}

public void loadModule(@NotNull String name) {
    File dir = new File("modules" + File.separator);
    File mdir = new File(dir + File.separator + name + ".jar");
    File mddir = new File(mdir + File.separator + "Module-Info.properties");

    if(!mdir.exists()){
        System.out.println("Could'n find module '" + name + "'. Directory: " + mdir.toPath().toString());
    }else{
        URL url = null;
        try {
            url = mdir.toURL();
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        URL[] urls = new URL[]{url};
        ClassLoader classes = new URLClassLoader(urls);

        InputStream stream = classes.getResourceAsStream("Module-Info.properties");

        Scanner scan = new Scanner(stream);

        List<String> settings = new ArrayList<>();

        while(scan.hasNext()){
            settings.add(scan.nextLine());
        }

        scan.close();

        ModuleDescription description = new ModuleDescription(settings);

        try {
            Module main = (Module) classes.loadClass(description.getMainClass()).newInstance();

            main.onEnable();

            this.modules.put(description.getName(), main);

            System.out.println("Module: " + description.getName() + " has been loaded!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2){
            e2.printStackTrace();
        } catch (InstantiationException e3){
            e3.printStackTrace();
        }
    }
}

public void unloadModule(String name){
    this.modules.get(name).onDisable();

    this.modules.remove(name);
}
	
}
