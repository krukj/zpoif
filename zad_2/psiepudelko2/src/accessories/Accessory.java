package accessories;

import helper.InitHelper;


public abstract class Accessory {
    protected String producer;

    public Accessory() {
        this.producer = InitHelper.provideRandomProducerNameGenerator();
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
