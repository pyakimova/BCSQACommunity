package agolova2.pages;

import io.cucumber.core.gherkin.Scenario;
import jdk.jfr.Name;

import java.util.Arrays;

public class CoreEnvironment {

    private Scenario scenario;

    private ThreadLocal<ScopedVariables> variables = new ThreadLocal<>();

    private Pages pages = new Pages();

    public CoreEnvironment(Scenario scenario) {
        this.scenario = scenario;
        initPages();
    }

    public CoreEnvironment() {
        initPages();
    }

    @SuppressWarnings("unchecked")
    private void initPages() {
        new AnnotationScanner().getClassesAnnotatedWith(Name.class)
                .stream()
                .map(it -> {
                    if (CorePage.class.isAssignableFrom(it)) {
                        return (Class<? extends CorePage>) it;
                    } else {
                        throw new IllegalStateException("Класс " + it.getName() + " должен наследоваться от AkitaPage");
                    }
                })
                .forEach(clazz -> pages.put(getClassAnnotationValue(clazz), clazz));
    }

    private String getClassAnnotationValue(Class<?> c) {
        return Arrays.stream(c.getAnnotationsByType(Name.class))
                .findAny()
                .map(Name::value)
                .orElseThrow(() -> new AssertionError("Не найдены аннотации AkitaPage.Name в класса " + c.getClass().getName()));
    }

    public void write(Object object) {
        scenario.write(String.valueOf(object));
    }

    public ScopedVariables getVars() {
        return getVariables();
    }

    public Object getVar(String name) {
        return getVariables().get(name);
    }

    public void setVar(String name, Object object) {
        getVariables().put(name, object);
    }

    public Pages getPages() {
        return pages;
    }

    public CorePage getPage(String name) {
        return pages.get(name);
    }

    public <T extends CorePage> T getPage(Class<T> clazz, String name) {
        return pages.get(clazz, name);
    }

    public String replaceVariables(String textToReplaceIn) {
        return getVariables().replaceVariables(textToReplaceIn);
    }

    private ScopedVariables getVariables() {
        if (variables.get() == null) {
            variables.set(new ScopedVariables());
        }
        return variables.get();
    }
}
