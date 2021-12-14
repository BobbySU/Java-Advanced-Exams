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
        if (this.personList.size() < this.capacity) {
            this.personList.add(person);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.personList.size(); i++) {
            if (this.personList.get(i).getName().equals(name)) {
                this.personList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (int i = 0; i < this.personList.size(); i++) {
            if (this.personList.get(i).getName().equals(name)
                    && this.personList.get(i).getHometown().equals(hometown)) {
                return this.personList.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return this.personList.size();
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
