import org.junit.jupiter.api.Test;
import static Stack.StringAnalyzer.analyzer;
import static Stack.StringAnalyzer.analyzer2;
import static org.junit.jupiter.api.Assertions.*;

class StringAnalyzerTest {

    @Test
    void analyzer_true(){
        assertTrue(analyzer("(()((())()))"));
        assertTrue(analyzer("(()()(()))"));
    }

    @Test
    void analyzer_false(){
        assertFalse(analyzer("())("));
        assertFalse(analyzer("))(("));
        assertFalse(analyzer("((())"));
    }
}
