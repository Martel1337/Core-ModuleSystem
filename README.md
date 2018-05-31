# Core-ModuleSystem
Simple jar-module system

Creating module steps:

 *1 - Put into your main project module system.
 *2 - When you have created your module, create into jar file config with name 'Module-Info.properties'
 *3 - Into config file type information about module:
     name=FirstModule                     ##Module name
     main=me.ByteCoder.Module.Test.Start  ##Main class of module
     author=ByteCoder_                    ##Author of module
 *4 - When you have finished created folder with name 'modules' and put your module into this folder.
 *5 - Run module with method #ModuleManager.loadModule(name);
 *6 - Working!
