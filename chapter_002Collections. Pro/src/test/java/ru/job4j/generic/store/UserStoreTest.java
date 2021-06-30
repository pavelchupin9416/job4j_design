package ru.job4j.generic.store;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;



    public class UserStoreTest {

        @Test
        public void whenFindById() {
            Store<User> userStore = new UserStore();
            User user1 = new User("1");
            User user2 = new User("2");
            User user3 = new User("3");
            userStore.add(user1);
            userStore.add(user2);
            userStore.add(user3);
            assertThat(userStore.findById("1"), is(user1));
        }

        @Test
        public void whenFindByIdFail() {
            Store<User> userStore = new UserStore();
            userStore.add(new User("1"));
            assertThat(userStore.findById("5"), nullValue());
        }

        @Test
        public void whenDelete() {
            Store<User> userStore = new UserStore();
            User user1 = new User("1");
            User user2 = new User("2");
            User user3 = new User("3");
            userStore.add(user1);
            userStore.add(user2);
            userStore.add(user3);
            boolean result = userStore.delete("3");
            assertThat(result, is(true));
        }

        @Test
        public void whenDeleteFail() {
            Store<User> userStore = new UserStore();
            User user1 = new User("1");
            userStore.add(user1);
            boolean result = userStore.delete("2");
            assertThat(result, is(false));
        }

        @Test
        public void whenReplace() {
            Store<User> userStore = new UserStore();
            User user1 = new User("1");
            User user2 = new User("2");
            User user3 = new User("3");
            userStore.add(user1);
            userStore.add(user2);
            boolean result = userStore.replace("2", user3);
            assertThat(result, is(true));
        }

        @Test
        public void whenReplaceFail() {
            Store<User> userStore = new UserStore();
            User user1 = new User("1");
            User user2 = new User("2");
            userStore.add(user1);
            boolean result = userStore.replace("2", user2);
            assertThat(result, is(false));
        }
}
