class A {
  public void tempt(String name, boolean ofAge) { // Noncompliant
    if (ofAge) {
      offerLiquor(name);
    } else {
      offerCandy(name);
    }
  }

  public void offerLiquor(String name) { // Compliant
  }

  public void doStuff(boolean willingly) { // Compliant - ignore case of non-used variables
  }

  public void temptAdult(String name) { // Compliant
    offerLiquor(name);
  }

  public void attempt(String name, int size, boolean isNice) { // Compliant
    boolean freeLiquor = isNice || (size > 165);
    if (freeLiquor) {
      offerLiquor(name);
    } else {
      tempt(name, isNice);
    }
  }
}

abstract class B {
  public int foo(int a, boolean b, boolean c) { // Noncompliant - b and c
    if (b) {
    } else {
    }
    if (c) {
    } else {
    }
    return 0;
  }

  abstract public int bar(int a, boolean b); // Compliant

  public int qix(int a, boolean b, boolean c) { // Compliant
    if (b && c) {
    } else {
    }
    return 0;
  }

  public int hop(int a, boolean b) { // Noncompliant - b is used as selector in the inner class
    class InnerClass {
      int foo() {
        if (b) {
        } else {
        }
        return 0;
      }
    }
    return 0;
  }

  public int tuc(int a, boolean b) { // Noncompliant
    return b ? a+1 : a-1;
  }

  private int hal(int a, boolean b) { // Compliant - rule only check for public methods
    return b ? a+1 : a-1;
  }

  public int lap(int a, boolean b) { // Compliant
    return b && false ? a+1 : a-1;
  }
}