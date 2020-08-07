package ru.job4j.srp;

import java.util.function.Predicate;

/**
 *Class ReportXml создает отчет для программиста в xml формате.
 *@author chupin
 *@since 05.08.2020
 */
public class ReportXml implements Report {
    private Store store;

    public ReportXml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(System.lineSeparator())
                .append("<employers>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<employer>").append(System.lineSeparator())
                    .append("<name>").append(employee.getName()).append("</name>").append(System.lineSeparator())
                    .append("<hired>").append(employee.getHired()).append("</hired>").append(System.lineSeparator())
                    .append("<fired>").append(employee.getFired()).append("</fired>").append(System.lineSeparator())
                    .append("<salary>").append(employee.getSalary()).append("</salary>").append(System.lineSeparator())
                    .append("</employer>").append(System.lineSeparator());
        }
        text.append("</employers>").append(System.lineSeparator());
        return text.toString();
    }
}