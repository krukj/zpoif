package model.jacht;

import java.util.Objects;

public class JachtMotorowy extends Jacht {
    protected int mocSilnika;

    public JachtMotorowy(String nazwaProducenta, int dlugosc, int masa, String typ, int mocSilnika) {
        super(nazwaProducenta, dlugosc, masa, typ);
        this.mocSilnika = mocSilnika;
    }

    public int getMocSilnika() {
        return mocSilnika;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(mocSilnika);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        JachtMotorowy other = (JachtMotorowy) obj;
        return mocSilnika == other.mocSilnika;
    }

    @Override
    public String toString() {
        return "JachtMotorowy{" +
                "mocSilnika=" + mocSilnika +
                ", typ='" + typ + '\'' +
                ", nazwaProducenta='" + nazwaProducenta + '\'' +
                ", dlugosc=" + dlugosc +
                ", masa=" + masa +
                '}';
    }
}
