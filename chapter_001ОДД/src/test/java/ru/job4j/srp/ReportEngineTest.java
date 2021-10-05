package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHRGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Victor", now, now, 300);
        Employee worker2 = new Employee("Petr", now, now, 200);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        ReportHR hr = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(System.lineSeparator())
                .append(worker1.getName()).append("; ")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append("; ")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getSalary()).append(";");
        assertThat(hr.generate(em -> true), is(expect.toString()));
    }

        @Test
        public void whenProgrammerGenerated() {
            MemStore store = new MemStore();
            Calendar now = Calendar.getInstance();
            Employee worker = new Employee("Ivan", now, now, 100);
            store.add(worker);
            ReportProgrammer programmer = new ReportProgrammer(store);
            StringBuilder expect = new StringBuilder()
                    .append("<html>").append(System.lineSeparator())
                    .append("<head>").append(System.lineSeparator())
                    .append("<title>").append("Report Programmer").append("</title>").append(System.lineSeparator())
                    .append("</head>").append(System.lineSeparator())
                    .append("<body>").append(System.lineSeparator())
                    .append("<h1>").append("Name; Hired; Fired; Salary")
                    .append("</h1>").append(System.lineSeparator())
                        .append("<p>").append(worker.getName()).append("; ")
                        .append(worker.getHired()).append("; ")
                        .append(worker.getFired()).append("; ")
                        .append(worker.getSalary()).append("; ").append("</p>").append(System.lineSeparator())
                    .append("</body>").append(System.lineSeparator())
                    .append("</html>").append(System.lineSeparator());
            assertThat(programmer.generate(em -> true), is(expect.toString()));
        }

        @Test
        public void whenBookerGenerated() {
            MemStore store = new MemStore();
            Calendar now = Calendar.getInstance();
            Employee worker = new Employee("Ivan", now, now, 100);
            Employee worker1 = new Employee("Victor", now, now, 300);
            Employee worker2 = new Employee("Petr", now, now, 200);
            store.add(worker);
            store.add(worker1);
            store.add(worker2);
            ReportBooker booker = new ReportBooker(store);
            StringBuilder expect = new StringBuilder()
                    .append("Name; Hired; Fired; Salary dollars")
                    .append(System.lineSeparator())
                    .append(worker.getName()).append("; ")
                    .append(worker.getHired()).append("; ")
                    .append(worker.getFired()).append("; ")
                    .append(worker.getSalary() / 73.19).append("; ")
                    .append(System.lineSeparator())
                    .append(worker1.getName()).append("; ")
                    .append(worker1.getHired()).append("; ")
                    .append(worker1.getFired()).append("; ")
                    .append(worker1.getSalary() / 73.19).append("; ")
                    .append(System.lineSeparator())
                    .append(worker2.getName()).append("; ")
                    .append(worker2.getHired()).append("; ")
                    .append(worker2.getFired()).append("; ")
                    .append(worker2.getSalary() / 73.19).append("; ");
            assertThat(booker.generate(em -> true), is(expect.toString()));
        }

    @Test
    public void whenJsonGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportJson json = new ReportJson(store);
        StringBuilder expect = new StringBuilder();
        expect.append("{").append(System.lineSeparator())
                .append("\"name\": ").append("\"").append(worker.getName()).append("\",").append(System.lineSeparator())
                .append("\"hired\": ").append(worker.getHired()).append(",").append(System.lineSeparator())
                .append("\"fired\": ").append(worker.getFired()).append(",").append(System.lineSeparator())
                .append("\"salary\": ").append(worker.getSalary()).append(",").append(System.lineSeparator())
                .append("}").append(System.lineSeparator());
        assertThat(json.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenXmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportXml xml = new ReportXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(System.lineSeparator())
                .append("<employers>").append(System.lineSeparator())
                .append("<employer>").append(System.lineSeparator())
                    .append("<name>").append(worker.getName()).append("</name>").append(System.lineSeparator())
                    .append("<hired>").append(worker.getHired()).append("</hired>").append(System.lineSeparator())
                    .append("<fired>").append(worker.getFired()).append("</fired>").append(System.lineSeparator())
                    .append("<salary>").append(worker.getSalary()).append("</salary>").append(System.lineSeparator())
                    .append("</employer>").append(System.lineSeparator())
                    .append("</employers>").append(System.lineSeparator());
        assertThat(xml.generate(em -> true), is(expect.toString()));
    }
}