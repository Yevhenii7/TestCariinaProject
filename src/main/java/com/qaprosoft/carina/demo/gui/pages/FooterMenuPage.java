package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenuPage extends AbstractUIObject {

    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(linkText = "Reviews")
    private ExtendedWebElement reviewLink;

    @FindBy(linkText = "Compare")
    private ExtendedWebElement compareLink;

    public FooterMenuPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePages openHomePage() {
        homeLink.click();
        return new HomePages(driver);
    }

    public ReviewsPage openReviewsPage() {
        reviewLink.click();
        return new ReviewsPage(driver);
    }

    public CompareModelsPages openComparePage() {
        compareLink.click();
        return new CompareModelsPages(driver);
    }

}
