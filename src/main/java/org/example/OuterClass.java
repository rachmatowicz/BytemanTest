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
            // this uses a hideen field this.this$0 to hold the static
            int innerInnerClassValue = 3;
            void method(String arg) {
                protocolVersion = 5;
                System.out.println("InnerInnerClass: pv = " + getProtocolVersion());
            }
        }
    }
}
