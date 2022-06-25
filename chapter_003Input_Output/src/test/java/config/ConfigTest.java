package config;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    private static final String filestest =System.getProperty("user.dir") + "\\data\\";


    @Test
    public void whenPairWithoutComment() {
        String path =filestest + "pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"),is("postgres"));
        assertThat(config.value("hibernate.connection.driver_class"),is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.password"),is("123"));
    }
    @Test
    public void whenPairWithComment() {
        String path =filestest + "pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"),is("postgres"));
        assertThat(config.value("hibernate.connection.driver_class"),is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.password"),is("123"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithIllegalArgumentKey() {
        String path =filestest + "pair_with_illegal_argument_key.properties";
        Config config = new Config(path);
        config.load();

    }
    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithIllegalArgumentValue()  {
        String path =filestest + "pair_with_illegal_argument_value.properties";
        Config config = new Config(path);
        config.load();

    }
    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithIllegalArgumentNotEquals() {
        String path =filestest + "pair_with_illegal_argument_not_equals.properties";
        Config config = new Config(path);
        config.load();

    }
    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithIllegalArgument() {
        String path =filestest + "pair_with_illegal_argument.properties";
        Config config = new Config(path);
        config.load();

    }
}
