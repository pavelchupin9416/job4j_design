package ru.job4j.srp;

import java.util.function.Predicate;

/**
 *Class ReportBooker создает отчет для бухгалтера с долларовой зарплатой.
 *@author chupin
 *@since 05.08.2020
 */

public class ReportBooker {
    private Store store;

    public ReportBooker(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary dollars");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append("; ")
                    .append(employee.getHired()).append("; ")
                    .append(employee.getFired()).append("; ")
                    .append(employee.getSalary() / 73.19).append("; ");
        }
        return text.toString();
    }
}
