package cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                this.employees.remove(i);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getAge(), e1.getAge()))
                .collect(Collectors.toList()).get(0);
    }

    public Employee getEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                return this.employees.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:%n", this.name));
        for (Employee e : employees) {
            sb.append(e.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
