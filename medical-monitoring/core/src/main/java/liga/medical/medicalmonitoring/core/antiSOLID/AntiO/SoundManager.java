package liga.medical.medicalmonitoring.core.antiSOLID.AntiO;

public class SoundManager {

    private static void makeSound(Object object){
        if(object instanceof AntiOCat){
            System.out.println("Mew!");
        }
        else if(object instanceof  AntiODog){
            System.out.println("Woof!");
        }
    }
}
