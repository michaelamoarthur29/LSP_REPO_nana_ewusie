package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class using Template Method pattern
 */
public abstract class Report {

    // Template Method (final so subclasses cannot change order)
    public final void generateReport() {
        loadData();
        formatHeader();
        formatBody();
        formatFooter();
    }

    protected abstract void loadData();
    protected abstract void formatHeader();
    protected abstract void formatBody();
    protected abstract void formatFooter();
}
