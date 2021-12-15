package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool(){
        return this.fishInPool.size();
    }

    public void add(Fish fish){
        if (this.fishInPool.size() < this.capacity) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name){
        for (int i = 0; i < this.fishInPool.size(); i++) {
            if (this.fishInPool.get(i).getName().equals(name)) {
                this.fishInPool.remove(i);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name){
        for (int i = 0; i < this.fishInPool.size(); i++) {
            if (this.fishInPool.get(i).getName().equals(name)){
                return this.fishInPool.get(i);
            }
        }
        return null;
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d",this.name,this.size)).append(System.lineSeparator());
        this.fishInPool.forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
