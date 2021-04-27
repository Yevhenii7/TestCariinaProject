package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.compare.CandidateBlock;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecss;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CompareModelsPages extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'candidate-search')]")
    private List<CandidateBlock> candidateBlocks;


    public CompareModelsPages(WebDriver driver) {
        super(driver);
    }

    public List<ModelSpecss> compareModels(String... models) {
        CandidateBlock candidateBlock;
        List<ModelSpecss> modelSpecsses = new ArrayList<>();
        ModelSpecss modelSpecss;
        for (int index = 0; index < models.length; index++) {
            modelSpecss = new ModelSpecss();
            candidateBlock = candidateBlocks.get(index);
            candidateBlock.sendKeysToInputField(models[index]);
            candidateBlock.getFirstPhone();
            for (ModelSpecss.SpecType type : ModelSpecss.SpecType.values()) {
                ExtendedWebElement spec = findExtendedWebElement(By.xpath(
                        String.format("//tr[.//a[text()='%s']]//td[@class='nfo'][%d]", type.getType(), index + 1)));
                modelSpecss.setToModelSpecsMap(type, spec.getText());
            }
            modelSpecsses.add(modelSpecss);
        }
        return modelSpecsses;
    }
}
