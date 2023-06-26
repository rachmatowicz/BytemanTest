package org.example;

import org.jboss.byteman.contrib.bmunit.BMScript;
import org.jboss.byteman.contrib.bmunit.BMUnitConfig;
import org.jboss.byteman.contrib.bmunit.BMUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Byteman test of an OuterClass instance
 */
@RunWith(BMUnitRunner.class)
@BMUnitConfig(debug = true, bmunitVerbose = true)
public class OuterClassTest
{

    /**
     * Test access to the various parts of the class
     */
    @Test
    @BMScript(value="Rule.btm", dir="target/test-classes/org/example/byteman")
    public void bytemanTest()
    {
        // create an instance of a non-static OuterClass using new
        OuterClass outer = new OuterClass();
        System.out.println("outerClassValue = "  + outer.outerClassValue);

        // create an instance of a static InnerStaticClass, don't need an instance of Outer
        OuterClass.InnerStaticClass innerStatic = new OuterClass.InnerStaticClass();
        System.out.println("innerStaticClassValue = "  + innerStatic.innerStaticClassValue);

        // create an instance of the non-static InnerInnerClass using new
        // we need an instance of the enclosing static class to do this
        OuterClass.InnerStaticClass.InnerInnerClass innerInner = innerStatic.new InnerInnerClass();
        System.out.println("innerInnerClassValue = "  + innerInner.innerInnerClassValue);

        innerInner.method("testArg");
    }
}
