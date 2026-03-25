module com.venturini.agent {
    requires java.instrument;
    requires java.management;

    exports com.venturini.agent;
    exports com.venturini.utils;
}