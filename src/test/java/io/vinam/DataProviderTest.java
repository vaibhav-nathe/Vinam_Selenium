package io.vinam;

import io.vinam.webpages.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void hello(String name) {
        System.out.println(name);
    }

    @DataProvider(name = "data")
    public Object[][] data() throws Exception {
        return ExcelUtils.readExcelData("AutomationCreation", "Sheet1");
    }
}