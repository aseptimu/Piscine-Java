package preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String process(String string) {
        return string.toUpperCase();
    }
}
