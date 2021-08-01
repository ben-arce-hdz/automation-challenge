package com.wizeline.automationchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.wizeline.automationchallenge.base.BasePage;
import com.wizeline.automationchallenge.page.LoginPage;
import com.wizeline.automationchallenge.page.ProductsPage;

@SpringBootTest
public abstract class SpringBootTestApp {

}