package p08_pet_clinics;

import java.util.LinkedHashMap;
import java.util.Map;

public class Clinic {

    private Map<Integer, Pet> rooms;

    public Clinic(int rooms) {
        setRooms(rooms);
    }

    public void setRooms(int rooms) {
        if (rooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        this.rooms = new LinkedHashMap<>();
        for (int i = 1; i <= rooms; i++) {
            this.rooms.put(i, null);
        }
    }

    public boolean addPet(Map<String, Pet> pets, String petName) {
        boolean petFound = false;
        Pet pet = null;
        for (Map.Entry<String, Pet> stringPetEntry : pets.entrySet()) {
            if (stringPetEntry.getKey().equals(petName)) {
                pet = pets.get(stringPetEntry.getKey());
                petFound = true;
                break;
            }
        }

        if (!petFound) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        int count = 0;
        int cursor = rooms.size() / 2 + 1;

        while (count != rooms.size()) {
            if (rooms.get(cursor) == null) {
                rooms.put(cursor, pet);
                return true;
            } else {
                count++;
                if (count % 2 == 0) {
                    cursor += count;
                } else {
                    cursor -= count;
                }
            }
        }
        return false;
    }

    public boolean release() {
        int count = 0;
        int cursor = rooms.size() / 2 + 1;

        while (count != rooms.size()) {
            if (rooms.get(cursor) != null) {
                rooms.put(cursor, null);
                return true;
            } else {
                if (cursor != rooms.size()) {
                    cursor++;
                } else {
                    cursor = 1;
                }
            }
            count++;
        }
        return false;
    }

    public String print(int room) {
        return this.rooms.get(room) == null ? "Room empty" : this.rooms.get(room).toString();
        //System.out.println(this.rooms.get(room) == null ? "Room empty" : this.rooms.get(room));
    }

    public String print() {
//        for (Map.Entry<Integer, Pet> room : rooms.entrySet()) {
//            if (room.getValue() == null) {
//                System.out.println("Room empty");
//            } else {
//                System.out.println(room.getValue());
//            }
//        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Pet> room : rooms.entrySet()) {
            if (room.getValue() == null) {
                sb.append("Room empty").append(System.lineSeparator());
            } else {
                sb.append(room.getValue()).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

    public boolean hasEmptyRooms() {
        int emptyRooms = 0;

        for (Map.Entry<Integer, Pet> integerPetEntry : rooms.entrySet()) {
            if (integerPetEntry.getValue() == null) {
                emptyRooms++;
            }
        }

        return emptyRooms > 0;
    }
}
