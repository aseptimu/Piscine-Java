package printer;

import render.Renderer;

public class PrinterWithDateTimeImpl implements Printer {

    Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void print(String time) {
        renderer.out(time);
    }
}
