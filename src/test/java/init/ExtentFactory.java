package init;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getInstance(){
        ExtentReports extent;
        String Path = "./Reports/NewReport.html";
        extent = new ExtentReports(Path,false);
        extent
                .addSystemInfo("Selenium Version","3.15")
                .addSystemInfo("Platform","windows10");
        return extent;
    }
}
