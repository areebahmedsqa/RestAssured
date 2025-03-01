import org.testng.annotations.DataProvider;

public class Test_Data {

    @DataProvider(name="DataForPost")
    public Object[][] PostData(){
        return new Object[][]{
                {"New Activity 1", "2025-12-31T00:00:00.000Z", "false"},
                {"New Activity 2", "2025-13-31T00:00:00.000Z", "false"},
                {"New Activity 3", "2025-15-31T00:00:00.000Z", "true"}
        };
    }
}
