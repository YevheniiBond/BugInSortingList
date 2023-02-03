package utils;

import org.testng.annotations.DataProvider;

public class DataProviderCredentials {
    public static final String BAKERY = "Пекарня";
    public static final String BREAD = "Хліб";

    public static final String CIABATTA = "Чіабата МілльВілль";

    public static final String SHVARC_MILVIL = "Батон Рум'янець Молочний";



    @DataProvider
    public static Object[][] inputDetails() {
        return new Object[][]{
                {BAKERY, BREAD}};
    }
}
