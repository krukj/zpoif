package accessories.food;

import helper.InitHelper;

public class DryFood extends Food{

    public DryFood() {
        this.calories = InitHelper.provideRandomCaloriesValue(300, 400);
    }

    @Override
    public String toString() {
        return "DryFood{" +
                "calories=" + calories +
                ", producer='" + producer + '\'' +
                '}';
    }
}
