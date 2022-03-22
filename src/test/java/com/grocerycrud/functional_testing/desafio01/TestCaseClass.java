package com.grocerycrud.functional_testing.desafio01;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;


public class TestCaseClass extends IntermediateClass {
    String URL="https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap";
    Map<String, String> person = new Data().generateFormArray();
    Map<String, String> personUpdate = new Data().generateUpdateArray();

    @Test
    public void registerUser(){
        try {
            driver.get(URL);
            HomePage homePage = PageFactory.initElements(driver, HomePage.class);
            FormPage formPage = PageFactory.initElements(driver, FormPage.class);

            homePage.addCustomer();
            formPage.fillForm01(person);
            } catch (Exception e) {e.printStackTrace();}
    }

    @Test
    public void checkUsername(){
        driver.get(URL);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        FormPage formPage = PageFactory.initElements(driver, FormPage.class);

        homePage.addCustomer();
        formPage.fillForm02(person);
        homePage.checkCustomer(person.get("name"));
        formPage.checkCustomer(person.get("name"), person.get("last_name"));
    }

    @Test
    public void updateUser(){
        try{
            driver.get(URL);
            HomePage homePage = PageFactory.initElements(driver, HomePage.class);
            FormPage formPage = PageFactory.initElements(driver, FormPage.class);

            homePage.addCustomer();
            formPage.fillForm02(person);
            homePage.editCustomer();
            formPage.editCustomer(personUpdate);

        }catch (Exception e) {e.printStackTrace();}
    }

    @Test
    public void deleteUser(){
        try {
            driver.get(URL);
            HomePage homePage = PageFactory.initElements(driver, HomePage.class);
            FormPage formPage = PageFactory.initElements(driver, FormPage.class);

            homePage.addCustomer();
            formPage.fillForm02(person);
            homePage.deleteCustomer(person.get("name"));
        } catch (Exception e) {e.printStackTrace();}
    }

}

