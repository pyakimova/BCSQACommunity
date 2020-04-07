package agolova2.pages;

import com.codeborne.selenide.Selenide;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public final class CoreScenario {

    private static CoreScenario instance = new CoreScenario();

    private static CoreEnvironment environment;

    private CoreScenario() {
    }

    public static CoreScenario getInstance() {
        return instance;
    }

    public CoreEnvironment getEnvironment() {
        return environment;
    }

    public void setEnvironment(CoreEnvironment akitaEnvironment) {
        environment = akitaEnvironment;
    }

    public static void sleep(int seconds) {
        Selenide.sleep(TimeUnit.MILLISECONDS.convert(seconds, TimeUnit.SECONDS));
    }

    public CorePage getCurrentPage() {
        return environment.getPages().getCurrentPage();
    }

    public void setCurrentPage(CorePage page) {
        if (page == null) {
            throw new IllegalArgumentException("Происходит переход на несуществующую страницу. " +
                    "Проверь аннотации @Name у используемых страниц");
        }
        environment.getPages().setCurrentPage(page);
    }

    public static <T extends CorePage> void withPage(Class<T> clazz, Consumer<T> consumer) {
        withPage(clazz, true, consumer);
    }

    public static <T extends CorePage> void withPage(Class<T> clazz, boolean checkIfElementsAppeared, Consumer<T> consumer) {
        Pages.withPage(clazz, checkIfElementsAppeared, consumer);
    }

    public Pages getPages() {
        return this.getEnvironment().getPages();
    }

    public CorePage getPage(String name) {
        return this.getEnvironment().getPage(name);
    }

    public void write(Object object) {
        this.getEnvironment().write(object);
    }

    public Object getVar(String name) {
        Object obj = this.getEnvironment().getVar(name);
        if (obj == null) {
            throw new IllegalArgumentException("Переменная " + name + " не найдена");
        }
        return obj;
    }


    public Object tryGetVar(String name) {
        return this.getEnvironment().getVar(name);
    }

    public <T extends CorePage> T getPage(Class<T> clazz, boolean checkIfElementsAppeared) {
        return Pages.getPage(clazz, checkIfElementsAppeared);
    }


    public <T extends CorePage> T getPage(Class<T> clazz) {
        return Pages.getPage(clazz, true);
    }

    public <T extends CorePage> T getPage(Class<T> clazz, String name) {
        return this.getEnvironment().getPage(clazz, name);
    }

    public String replaceVariables(String stringToReplaceIn) {
        return this.getEnvironment().replaceVariables(stringToReplaceIn);
    }

    public void setVar(String name, Object object) {
        this.getEnvironment().setVar(name, object);
    }

    public ScopedVariables getVars() {
        return this.getEnvironment().getVars();
    }
}
