package ru.job4j.tamplate;


import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import java.util.Map;

public class GeneratorTest {
    @Test
    public void generator() {
        Generator generator = new GeneratorTemplate();
        String templ = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Pavel", "subject", "you");
        String result = generator.produce(templ, args);
        String exsample = "I am a Pavel, Who are you? ";
        assertThat(result, is(exsample));
    }

    /*
    Тест на избыток ключей в шаблоне.
     */
    @Test
    public void generatorTemp() {
        Generator generator = new GeneratorTemplate();
        String templ = "I am a ${name} ${surname}, Who are ${subject}? . ";
        Map<String, String> args = Map.of("name", "Pavel", "subject", "you");
        String result = generator.produce(templ, args);
        String exsample = "Недостаточнго ключей в карте для шаблона.";
        assertThat(result, is(exsample));
    }

    /*
    Тест на избыток ключей в карте.
     */
    @Test
    public void generatorMap() {
        Generator generator = new GeneratorTemplate();
        String templ = "I am a ${name}. ";
        Map<String, String> args = Map.of("name", "Pavel", "subject", "you","surname","Ivanov");
        String result = generator.produce(templ, args);
        String exsample = "В карте присутствуют лишние ключи";
        assertThat(result, is(exsample));
    }

}
