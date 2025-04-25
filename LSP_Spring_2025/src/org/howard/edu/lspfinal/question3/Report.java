package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class defining the report-generation template.
 */
public abstract class Report {
    /**
     * Template method: define fixed workflow.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
        System.out.println();
    }

    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}

