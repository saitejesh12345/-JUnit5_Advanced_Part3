# -JUnit5_Advanced_Part3
Do check out ReadMeFile,Change Test Instance lifecycle with @TestInstance (PER_CLASS, PER_METHOD) few some other Concepts are involved.

# Change Test Instance lifecycle with @TestInstance (PER_CLASS, PER_METHOD)

**1.** we know that Bydefault Junit creates a new instance of a testClass for each TestMethod.If you have three testMethods in a Single Test Class,
when you run all test methods in this test class for each test method junit will create a new instance of a class.

**2.** If you want execute all test methods in same test instance then you can Annoate testClass with **@TestInstance(LifeCycle.PER_CLASS)**
when u using this mode only one instanes will be created per Testclass it is very helpful when you working with **Integration Testing**.

**we will learn how to make good test methodRuns in a SingleInstance of a testClass.**

