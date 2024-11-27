public class PercentageCalculationFromScreenSize {

    public static int calculateThePercentageOfWidth(int percentageValue){
        return (GamePanel.WIDTH*percentageValue)/100;
    }

    public static int calculateThePercentageOfHeight(int percentageValue){
        return (GamePanel.HEIGHT*percentageValue)/100;
    }
}
