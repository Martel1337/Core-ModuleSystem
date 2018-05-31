package me.ByteCoder.Core.Module;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public class ModuleDescription {

private Map<String, String> desc;

public ModuleDescription(List<String> list){
    this.desc = new HashMap<String, String>();

    for (String s : list) {
        desc.put(s.split("=")[0], s.split("=")[1]);
    }
}

public String getName(){
    return this.desc.get("name");
}

public String getMainClass(){
    return this.desc.get("main-class");
}

public String getVersion(){
    return this.desc.get("version");
}

public String getAuthor(){
    return this.desc.get("author");
}

public Object getValue(String field){
    return this.desc.get(field);
}

public void setValue(String field, String value){
    this.desc.put(field, value);
}
}
