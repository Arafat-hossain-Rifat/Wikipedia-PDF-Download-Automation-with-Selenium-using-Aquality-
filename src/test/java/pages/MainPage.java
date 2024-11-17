package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private final ITextBox searchTextBox = getElementFactory().getTextBox(By.id("searchInput"), "Search Input");
    private final IButton searchButton = getElementFactory().getButton(By.xpath("//button[@class='pure-button pure-button-primary-progressive']"), "Search Button");

    public MainPage() {
        super(By.id("www-wikipedia-org"), "Main Page");
    }

    public void inputSearchQuery(String query) {
        searchTextBox.clearAndType(query);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
