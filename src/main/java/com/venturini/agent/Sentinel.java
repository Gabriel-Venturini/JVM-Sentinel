package com.venturini.agent;

import java.lang.instrument.Instrumentation;

public class Sentinel {

    public static void premain(String args, Instrumentation inst) {
        System.out.println("---- Agent ativo! ----");
    }
}