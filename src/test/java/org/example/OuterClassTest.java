package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Byteman test of an OuterClass instance
 */
public class OuterClassTest extends TestCase
{
    public OuterClassTest(String testName )
    {
        super( testName );
    }


    /**
     * Test access to the various parts of the class
     */
    public void mainTest()
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
