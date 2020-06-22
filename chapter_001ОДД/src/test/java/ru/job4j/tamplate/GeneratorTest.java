package ru.job4j.tamplate;


import static org.junit.Assert.assertThat;
import static org.junit.Assert;
import java.io.IOException;
import org.junit.Assert;
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

        try {
            generator.produce(templ, args);
            Assert.fail("Недостаточнго ключей в карте для шаблона.");
        } catch (MapException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    /*
    Тест на избыток ключей в карте.
     */
    @Test
    public void generatorMap() {
        Generator generator = new GeneratorTemplate();
        String templ = "I am a ${name}. ";
        Map<String, String> args = Map.of("name", "Pavel", "subject", "you","surname","Ivanov");
        try {
            generator.produce(templ, args);
            Assert.fail("В карте присутствуют лишние ключи");
        } catch (MapException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

}
