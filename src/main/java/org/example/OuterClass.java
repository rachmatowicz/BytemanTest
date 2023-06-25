package org.example;

/**
 * A test class for testing Byteman rule processing across a class hierarchy
 */
final class OuterClass {
    int outerClassValue = 1;

    public static class InnerStaticClass {
        int innerStaticClassValue = 2;

        private volatile int protocolVersion = -1;

        int getProtocolVersion() {
            return protocolVersion;
        }

        public class InnerInnerClass {
            int innerInnerClassValue = 3;
            void method(String arg) {
                System.out.println("pv = " + getProtocolVersion());
            }
        }
    }
}
