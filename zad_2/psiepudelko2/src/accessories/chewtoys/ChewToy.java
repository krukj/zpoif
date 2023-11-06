package accessories.chewtoys;

import accessories.Accessory;
import helper.InitHelper;

import java.util.Random;

public class ChewToy extends Accessory {
    protected boolean certificate;

    public ChewToy() {
        this.certificate = InitHelper.provideRandomAttestationGenerator(new Random().nextBoolean());
    }

    public boolean isCertificate() {
        return certificate;
    }

    @Override
    public String toString() {
        return "ChewToy{" +
                "certificate=" + certificate +
                ", producer='" + producer + '\'' +
                '}';
    }
}
