package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ArticlePage extends Form {

    private final IButton toolMenuButton =getElementFactory().getButton(By.id("vector-page-tools-dropdown"), "Tool Menu Button");
    private final IButton downloadAsPDFButton =getElementFactory().getButton(By.id("coll-download-as-rl"), "Download as PDF Button");

    public ArticlePage() {
        super(By.id("firstHeading"), "Article Page");
    }

    public void clickToolMenuButton() {
        toolMenuButton.click();
    }



    public void clickDownloadAsPDFButton() {
        downloadAsPDFButton.click();
    }
}