package preprocessor;

public class PreProcessorToLower implements PreProcessor {
    @Override
    public String process(String string) {
        return string.toLowerCase();
    }
}
