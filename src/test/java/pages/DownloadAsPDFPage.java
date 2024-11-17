package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DownloadAsPDFPage extends Form {

    private final ITextBox fileNameElement = getElementFactory().getTextBox(By.className("mw-electronpdfservice-selection-label-desc"),"File Name Element");
    private final ILink downloadLink = getElementFactory().getLink(By.className("oo-ui-buttonElement-button"), "Download Link");

    public DownloadAsPDFPage() {
        super(By.id("mw-content-text"), "Download as PDF Page");
    }

    public String getDownloadFileName() {
        return fileNameElement.getText();
    }

    public void clickDownloadLink() {
        downloadLink.click();
    }
}
