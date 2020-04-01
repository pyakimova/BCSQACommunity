package bcs.qa.community;

import bcs.qa.community.pages.ArticlePage;
import bcs.qa.community.pages.MainPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;

public class StepDefinitions {

    MainPage mainPage = new MainPage();
    ArticlePage articlePage = new ArticlePage();

    @Дано("Открыта главная страница wikipedia.org")
    public void открыта_главная_страница_wikipedia_org() {
        mainPage.open();
    }

    @Если("в поисковую строку ввести значение {string}")
    public void в_поисковую_строку_ввести_значение(String string) {
        mainPage.setSearchField(string);
    }

    @Если("кликнуть на кнопку поиска")
    public void кликнуть_на_кнопку_поиска() {
        mainPage.clickSearchButton();
    }

    @То("на странице результатов будет присутствовать статья с названием {string}")
    public void на_странице_результатов_будет_присутствовать_статья_с_названием(String string) {
        articlePage.checkArticleeNameIsPresent(string);
    }
}