package liga.medical.medicalmonitoring.core.antiSOLID.AntiI;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AntiIHorse implements AntiIActions{

    @NonNull
    private String name;

    @Override
    public void move() {
        System.out.println("Run!");
    }

    @Override
    public void voice() {
        System.out.println("Neigh!");
    }
}
