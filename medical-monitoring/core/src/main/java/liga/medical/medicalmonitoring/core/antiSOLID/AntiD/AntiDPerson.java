package liga.medical.medicalmonitoring.core.antiSOLID.AntiD;

import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AntiDPerson {

    @NonNull
    private String personName;

    @NonNull
    private AntiDCat petCat;

    @NonNull
    private AntiDDog petDog;

    @NonNull
    private AntiDParrot petParrot;

}
