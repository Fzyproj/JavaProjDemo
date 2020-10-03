// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Main.java

package com.lucfzy;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.lucfzy:
//            OrderHeader, OrderInvoice

public class Main
{

    public Main()
    {
    }

    public static void main(String args[])
        throws InvocationTargetException, IllegalAccessException
    {
        OrderHeader orderHeader1 = new OrderHeader("123456");
        OrderInvoice orderInvoice = new OrderInvoice();
        System.out.println(orderInvoice);
    }
}
