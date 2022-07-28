package render;

import preprocessor.PreProcessor;

import java.time.LocalDateTime;

public class RendererErrImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void out(String text) {
        text = preProcessor.process(text);
        System.err.println(text);
    }
    
//    public void out(LocalDateTime time) {
//        System.out.println(time);
//    }
}
