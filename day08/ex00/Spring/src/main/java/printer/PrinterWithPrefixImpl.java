package printer;

import render.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private String prefix;
    private final Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void print(String text) {
        renderer.out(prefix + " " + text);
    }
}
