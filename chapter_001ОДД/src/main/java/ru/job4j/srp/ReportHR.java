package ru.job4j.srp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *Class ReportBooker создает отчет для hr менеджера в порядке уменьшения зарплаты.
 *@author chupin
 *@since 05.08.2020
 */

import static java.lang.Double.compare;

public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary");
        store.findBy(filter).stream().sorted((o1, o2) -> compare(o2.getSalary(), o1.getSalary()))
                .forEach(o -> text.append(System.lineSeparator())
                        .append(o.getName()).append("; ")
                        .append(o.getSalary()).append(";"));
        /*for (Employee employee : store.findBy(filter).stream().
                sorted((o1, o2) -> compare(o2.getSalary(), o1.getSalary())).collect(Collectors.toList())) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append("; ")
                    .append(employee.getSalary()).append(";");
        }*/
        return text.toString();
    }
}
