package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> personList;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.personList = new ArrayList<>();
    }

    public void add(Person person) {
        if (personList.size() < capacity) {
            personList.add(person);
        }
    }

    public boolean remove(String name) {
        Person person = null;
        try {
            person = personList.stream().filter(p -> p.getName().equals(name)).findFirst().get();
        } catch (NoSuchElementException exception) {
        }
        return personList.remove(person);
    }

    public Person getPerson(String name, String hometown) {
        Person person = null;
        try {
            person = personList.stream()
                    .filter(e -> e.getName().equals(name) && e.getHometown().equals(hometown))
                    .findFirst().get();
        } catch (NoSuchElementException exception) {
        }
        return person;
    }

    public int getCount() {
        return personList.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", this.name));
        for (Person e : personList) {
            sb.append(e.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
