package groomingSalon;

import java.util.ArrayList;
import java.util.List;;

public class GroomingSalon {
    private int capacity;
    private List<Pet> petList;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.petList = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Pet pet) {
        if (this.petList.size() < this.capacity) {
            this.petList.add(pet);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.petList.size(); i++) {
            if (this.petList.get(i).getName().equals(name)) {
                this.petList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (int i = 0; i < this.petList.size(); i++) {
            if (this.petList.get(i).getName().equals(name)&&this.petList.get(i).getOwner().equals(owner)){
                return this.petList.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return this.petList.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        this.petList.forEach(e -> sb.append(String.format("%s %S",e.getName(),e.getOwner()))
                .append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
