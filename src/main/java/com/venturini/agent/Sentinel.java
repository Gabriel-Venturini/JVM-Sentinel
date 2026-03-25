package com.venturini.agent;

import com.venturini.utils.TextUtils;

import java.lang.instrument.Instrumentation;

/**
 * Java Agent entry point responsible for initializing the Sentinel agent.
 * <p>
 * This class is loaded by the JVM before the application's {@code main} method
 * when the agent is specified using the {@code -javaagent} parameter.
 * <p>
 * Its main responsibility is to perform early-stage setup and provide
 * basic runtime diagnostics, such as displaying the current process ID (PID).
 *
 * <p><b>Usage:</b>
 * <pre>
 * java -javaagent:jvm-sentinel-&lt;version&gt;.jar -jar your-application.jar
 * </pre>
 *
 * <p>
 * Current behavior:
 * <ul>
 *     <li>Prints a startup banner indicating the agent is active</li>
 *     <li>Displays the current JVM process ID centered in the output</li>
 * </ul>
 *
 * <p>
 * This class is not intended to be instantiated.
 *
 * @author Gabriel Venturini
 */
public class Sentinel {

    private Sentinel() {
        // Prevent instantiation
    }

    /**
     * JVM hook executed before the application's {@code main} method.
     *
     * @param args optional agent arguments provided via {@code -javaagent}
     * @param inst the {@link Instrumentation} instance provided by the JVM,
     *             used for class transformation and bytecode instrumentation
     */
    public static void premain(String args, Instrumentation inst) {
        String centeredPID = TextUtils.centerString("PID: " + getPID(), 20);

        System.out.println("---- Agent active! ----");
        System.out.println(centeredPID);
    }

    /**
     * Retrieves the current JVM process ID (PID).
     *
     * @return the PID of the running JVM process
     */
    private static long getPID() {
        return ProcessHandle.current().pid();
    }
}