package ru.job4j.srp;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *Class ReportBooker создает отчет для hr менеджера в порядке уменьшения зарплаты.
 *@author chupin
 *@since 05.08.2020
 */

import static java.lang.Double.compare;

public class ReportHR {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }


    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary");
        for (Employee employee : store.findBy(filter).stream().
                sorted((o1, o2) -> compare(o2.getSalary(), o1.getSalary())).collect(Collectors.toList())) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append("; ")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}
