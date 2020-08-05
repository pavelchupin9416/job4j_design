package ru.job4j.srp;

import java.util.function.Predicate;

/**
 *Class ReportJson создает отчет для программиста в json формате.
 *@author chupin
 *@since 05.08.2020
 */
public class ReportJson {
    private Store store;

    public ReportJson(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append("{").append(System.lineSeparator())
                    .append("\"name\": ").append("\"").append(employee.getName()).append("\",").append(System.lineSeparator())
                    .append("\"hired\": ").append(employee.getHired()).append(",").append(System.lineSeparator())
                    .append("\"fired\": ").append(employee.getFired()).append(",").append(System.lineSeparator())
                    .append("\"salary\": ").append(employee.getSalary()).append(",").append(System.lineSeparator())
                    .append("}").append(System.lineSeparator());
        }
        return text.toString();
    }
}
