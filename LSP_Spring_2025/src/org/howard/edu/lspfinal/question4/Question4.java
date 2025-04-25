package org.howard.edu.lspfinal.question4;

/**
 * Question 4 solution.
 * Briefly discuss one instance where using a design pattern may not be beneficial.
 */
public class Question4 {
    /*
     * One instance where using a design pattern may not be beneficial is when
     * the added abstraction and indirection outweigh the gains in flexibility
     * or reuse—what we referred as patternitis.
     *
     * For example, applying the Facade pattern to a subsystem that consists of
     * only one or two simple classes actually adds an extra layer of indirection
     * without reducing complexity. Instead of clients calling the subsystem’s
     * methods directly, they must go through a facade class that simply delegates
     * those calls. This unnecessary wrapper:
     *   - Increases the number of classes and files
     *   - Obscures the real dependencies and workflow
     *   - Makes debugging and testing harder
     *
     * As we discussed Facade (Design Patterns), we emphasized using a
     * facade only when you have a complex subsystem that truly benefits from
     * a unified, simplified interface. When the subsystem interface is already
     * simple, the facade pattern introduces needless overhead rather than value.
     */
}
