package com.lybj.base.jvm;
import java.lang.instrument.Instrumentation;


public class MyAgent {
  public static void premain(String args, Instrumentation inst) {
    Object obj = new Object();
    System.out.println("Bytes used by Object:"+ inst.getObjectSize(obj));
    System.out.println("Bytes used by MyObject:"+ inst.getObjectSize(new MyObject()));
  }
  public static void main(String[] args) {
    System.out.println("main is over");
  }
}