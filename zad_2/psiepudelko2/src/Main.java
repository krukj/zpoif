import accessories.Accessory;
import accessories.chewtoys.SquealingChewToy;
import box.MyDogBox;
import box.NewDogBox;

public class Main {
    public static void main(String[] args) {
        MyDogBox myDogBox = new MyDogBox();
        for (Accessory accessory: myDogBox.accessories) {
            System.out.println(accessory);
        }
        System.out.println("--------------------------");
        myDogBox.detectNonAttestationChew();
        System.out.println("--------------------------");
        myDogBox.detectCaloricFood();
        System.out.println("--------------------------");
        myDogBox.getSummarizedDryFoodCalories();
        NewDogBox box = new NewDogBox(myDogBox.accessories);
        System.out.println("--------------------------");
        box.getAverageWetFoodCalories();
        System.out.println("--------------------------");
        box.upgradeProducerName("Przesada");
        for (Accessory accessory: myDogBox.accessories) {
            System.out.println(accessory);
        }
        System.out.println("--------------------------");
        box.upgradeFrequency4All();
        for (Accessory accessory: myDogBox.accessories) {
            if (accessory instanceof SquealingChewToy) {
                System.out.println(accessory);
            }
        }


    }
}