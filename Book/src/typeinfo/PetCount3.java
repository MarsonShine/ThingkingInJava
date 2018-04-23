package typeinfo;

import net.mindview.util.MapData;
import typeinfo.pets.LiteralPetCreator;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.mindview.util.Println.*;

public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes, 0));
        }

        public void count(Pet pet) {
            // Class.isInstance() 消除 instanceofs:
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                if (pair.getKey().isInstance(pet))
                    put(pair.getKey(), pair.getValue() + 1);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                sb.append(pair.getKey().getSimpleName());
                sb.append("=");
                sb.append(pair.getValue());
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("}");
            return sb.toString();
        }
    }

    public static void main(String[] args){
        PetCounter petCounter = new PetCounter();
        for (var pet : Pets.createArray(20)){
            printnb(pet.getClass().getSimpleName() + " ");
            petCounter.count(pet);
        }
        print();
        print(petCounter);
    }
}
