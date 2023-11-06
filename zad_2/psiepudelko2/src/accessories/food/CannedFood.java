package accessories.food;

import helper.InitHelper;


public class CannedFood extends Food{
    public CannedFood() {
        this.calories = InitHelper.provideRandomCaloriesValue(100, 150);
    }

    @Override
    public String toString() {
        return "CannedFood{" +
                "calories=" + calories +
                ", producer='" + producer + '\'' +
                '}';
    }
}
