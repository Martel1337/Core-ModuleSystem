package me.ByteCoder.Core;

import me.ByteCoder.Core.Module.ModuleManager;

public class Main {

    public static ModuleManager manager;

public static void main(String[] args)
{
    manager = new ModuleManager();

    manager.loadModule("Test");
}
}
