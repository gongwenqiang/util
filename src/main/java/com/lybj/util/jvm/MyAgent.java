package com.lybj.util.jvm;

import com.lybj.util.arithmetic.DigitConvertAlg;

import java.lang.instrument.Instrumentation;

public class MyAgent {
  private static volatile Instrumentation globalInstr;
  public static void premain(String args, Instrumentation inst) {
    globalInstr = inst;
  }
  public static long getObjectSize(Object obj) {
    if (globalInstr == null)
      throw new IllegalStateException("Agent not initted");
    return globalInstr.getObjectSize(obj);
  }

  public static void main(String[] args) {
    DigitConvertAlg digitConvertAlg = new DigitConvertAlg();
    System.out.println(getObjectSize(digitConvertAlg));
  }
}