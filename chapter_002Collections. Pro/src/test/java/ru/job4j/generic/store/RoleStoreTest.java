package ru.job4j.generic.store;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

public class RoleStoreTest {

    @Test
    public void whenFindById() {
        Store<Role> roleStore = new RoleStore();
        Role user1 = new Role("1");
        Role user2 = new Role("2");
        Role user3 = new Role("3");
        roleStore.add(user1);
        roleStore.add(user2);
        roleStore.add(user3);
        assertThat(roleStore.findById("1"), is(user1));
    }

    @Test
    public void whenFindByIdFail() {
        Store<Role> roleStore = new RoleStore();
        roleStore.add(new Role("1"));
        assertThat(roleStore.findById("5"), nullValue());
    }

    @Test
    public void whenDelete() {
        Store<Role> roleStore = new RoleStore();
        Role role1 = new Role("1");
        Role role2 = new Role("2");
        Role role3 = new Role("3");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        boolean result = roleStore.delete("2");
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteFail() {
        Store<Role> roleStore = new RoleStore();
        Role role1 = new Role("1");
        roleStore.add(role1);
        boolean result = roleStore.delete("2");
        assertThat(result, is(false));
    }

    @Test
    public void whenReplace() {
        Store<Role> roleStore = new RoleStore();
        Role role1 = new Role("1");
        Role role2 = new Role("2");
        Role role3 = new Role("3");
        roleStore.add(role1);
        roleStore.add(role2);
        boolean result = roleStore.replace("2", role3);
        assertThat(result, is(true));
    }

    @Test
    public void whenReplaceFail() {
        Store<Role> roleStore = new RoleStore();
        Role role1 = new Role("1");
        Role role2 = new Role("2");
        roleStore.add(role1);
        boolean result = roleStore.replace("2", role2);
        assertThat(result, is(false));
    }
}
