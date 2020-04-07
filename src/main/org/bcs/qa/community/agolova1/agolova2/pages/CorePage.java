package agolova2.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;
import static agolova2.PropertyLoader.loadProperty;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;


public abstract class CorePage{

    private static final String WAITING_APPEAR_TIMEOUT_IN_MILLISECONDS = "8000";

    public SelenideElement getElement(String elementName) {
        return (SelenideElement) java.util.Optional.ofNullable(namedElements.get(elementName))
                .orElseThrow(() -> new IllegalArgumentException("Элемент " + elementName + " не описан на странице " + this.getClass().getName()));
    }

    public List<SelenideElement> getElementsList(String listName) {
        Object value = namedElements.get(listName);
        if (!(value instanceof List)) {
            throw new IllegalArgumentException("Список " + listName + " не описан на странице " + this.getClass().getName());
        }
        Stream<Object> s = ((List) value).stream();
        return s.map(CorePage::castToSelenideElement).collect(toList());
    }

    public String getAnyElementText(String elementName) {
        SelenideElement element = getElement(elementName);
        if (element.getTagName().equals("input")) {
            return element.getValue();
        } else {
            return element.getText();
        }
    }

    public List<SelenideElement> getPrimaryElements() {
        if (primaryElements == null) {
            primaryElements = readWithWrappedElements();
        }
        return new ArrayList<>(primaryElements);
    }

    public final CorePage appeared() {
        isAppeared();
        return this;
    }

    public final CorePage disappeared() {
        isDisappeared();
        return this;
    }

    protected void isAppeared() {
        String timeout = loadProperty("waitingAppearTimeout", WAITING_APPEAR_TIMEOUT_IN_MILLISECONDS);
        getPrimaryElements().parallelStream().forEach(elem ->
                elem.waitUntil(Condition.appear, Integer.valueOf(timeout)));
    }

    protected void isDisappeared() {
        String timeout = loadProperty("waitingAppearTimeout", WAITING_APPEAR_TIMEOUT_IN_MILLISECONDS);
        getPrimaryElements().parallelStream().forEach(elem ->
                elem.waitWhile(Condition.exist, Integer.valueOf(timeout)));
    }

    public void waitElementsUntil(Condition condition, int timeout, SelenideElement... elements) {
        Waiters.waitElementsUntil((Condition) condition, timeout, elements);
    }

    public void waitElementsUntil(Condition condition, int timeout, List<SelenideElement> elements) {
        Waiters.waitElementsUntil((Condition) condition, timeout, elements);
    }

    public void waitElementsUntil(Condition condition, int timeout, String... elementNames) {
        List<SelenideElement> elements = Arrays.stream(elementNames)
                .map(name -> namedElements.get(name))
                .flatMap(v -> v instanceof List ? ((List<?>) v).stream() : Stream.of(v))
                .map(CorePage::castToSelenideElement)
                .filter(Objects::nonNull)
                .collect(toList());
        Waiters.waitElementsUntil((Condition) condition, timeout, elements);
    }

    public static SelenideElement getButtonFromListByName(List<SelenideElement> listButtons, String nameOfButton) {
        List<String> names = new ArrayList<>();
        for (SelenideElement button : listButtons) {
            names.add(button.getText());
        }
        return listButtons.get(names.indexOf(nameOfButton));
    }

    private static SelenideElement castToSelenideElement(Object object) {
        if (object instanceof SelenideElement) {
            return (SelenideElement) object;
        }
        return null;
    }

    private Map<String, Object> namedElements;
    private List<SelenideElement> primaryElements;

    public CorePage initialize() {
        namedElements = readNamedElements();
        primaryElements = readWithWrappedElements();
        return this;
    }

    private Map<String, Object> readNamedElements() {
        checkNamedAnnotations();
        return Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> f.getDeclaredAnnotation(Name.class) != null)
                .peek(f -> {
                    if (!SelenideElement.class.isAssignableFrom(f.getType()) && !List.class.isAssignableFrom(f.getType()))
                        throw new IllegalStateException(
                                format("Поле с аннотацией @Name должно иметь тип SelenideElement или List<SelenideElement>, но найдено поле с типом %s", f.getType()));
                })
                .collect(toMap(f -> f.getDeclaredAnnotation(Name.class).value(), this::extractFieldValueViaReflection));
    }

    private void checkNamedAnnotations() {
        List<String> list = Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> f.getDeclaredAnnotation(Name.class) != null)
                .map(f -> f.getDeclaredAnnotation(Name.class).value())
                .collect(toList());
        if (list.size() != new HashSet<>(list).size()) {
            throw new IllegalStateException("Найдено несколько аннотаций @Name с одинаковым значением в классе " + this.getClass().getName());
        }
    }

    private List<SelenideElement> readWithWrappedElements() {
        List<SelenideElement> collect = Arrays.stream(getClass().getDeclaredFields())
                .filter(f -> f.getDeclaredAnnotation(Optional.class) == null)
                .map(this::extractFieldValueViaReflection)
                .flatMap(v -> v instanceof List ? ((List<?>) v).stream() : Stream.of(v))
                .map(CorePage::castToSelenideElement)
                .filter(Objects::nonNull)
                .collect(toList());
        return collect;
    }

    private Object extractFieldValueViaReflection(Field field) {
        return null;//FIXME
    }

}