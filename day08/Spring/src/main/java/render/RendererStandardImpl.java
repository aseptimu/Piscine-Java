package render;

import preprocessor.PreProcessor;

import java.time.LocalDateTime;

public class RendererStandardImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void out(String text) {
        System.out.println(text);
    }

//    public void out(LocalDateTime time) {
//        System.out.println(time);
//    }
}
