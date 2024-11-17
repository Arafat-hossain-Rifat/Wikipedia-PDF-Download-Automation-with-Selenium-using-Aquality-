package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.DownloadAsPDFPage;
import pages.MainPage;
import utils.FileUtils;

import java.io.File;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class FileDownloadTest extends BaseTest {

    private static final String SEARCH_QUERY = "Albert Einstein";

    @Test
    public void verifyDownloadAsPDF() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not displayed");

        mainPage.inputSearchQuery(SEARCH_QUERY);
        mainPage.clickSearchButton();

        ArticlePage articlePage = new ArticlePage();
        articlePage.clickToolMenuButton();
        articlePage.clickDownloadAsPDFButton();

        DownloadAsPDFPage downloadPage = new DownloadAsPDFPage();
        String expectedFileName = downloadPage.getDownloadFileName();
        downloadPage.clickDownloadLink();

        String downloadDirectory = getBrowser().getDownloadDirectory();
        File downloadedFile = new File(downloadDirectory, expectedFileName);
        Assert.assertTrue(FileUtils.isFileExist(downloadedFile), String.format("%s is not downloaded", expectedFileName));

    }
}
