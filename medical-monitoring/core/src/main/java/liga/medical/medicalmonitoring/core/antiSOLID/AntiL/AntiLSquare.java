package liga.medical.medicalmonitoring.core.antiSOLID.AntiL;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AntiLSquare extends AntiLRectangle{

    public int getSize() {
        return super.getHeight();
    }

    public void setSize(int size) {
        super.setWidth(size);
        super.setHeight(size);
    }
}
