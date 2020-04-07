package agolova2.pages;

import com.codeborne.selenide.Selenide;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.function.Consumer;

public final class Pages {

    private Map<String, CorePage> pages;
    private CorePage currentPage;

    public Pages() {
        pages = Maps.newHashMap();
    }

    public CorePage getCurrentPage() {
        if (currentPage == null) throw new IllegalStateException("Текущая страница не задана");
        return currentPage;
    }

    public void setCurrentPage(CorePage page) {
        this.currentPage = page;
    }

    public static <T extends CorePage> void withPage(Class<T> clazz, boolean checkIfElementsAppeared, Consumer<T> consumer) {
        T page = getPage(clazz, checkIfElementsAppeared);
        consumer.accept(page);
    }

    public CorePage get(String pageName) {
        return getPageMapInstanceInternal().get(pageName);
    }

    @SuppressWarnings("unchecked")
    public <T extends CorePage> T get(Class<T> clazz, String name) {
        CorePage page = getPageMapInstanceInternal().get(name);
        if (!clazz.isInstance(page)) {
            throw new IllegalStateException(name + " page is not a instance of " + clazz + ". Named page is a " + page);
        }
        return (T) page;
    }

    private Map<String, ? extends CorePage> getPageMapInstanceInternal() {
        return pages;
    }

    public <T extends CorePage> void put(String pageName, T page) throws IllegalArgumentException {
        if (page == null)
            throw new IllegalArgumentException("Была передана пустая страница");
        pages.put(pageName, page);
    }


    public void put(String pageName, Class<? extends CorePage> clazz) {
        pages.put(pageName, Selenide.page(clazz).initialize());
    }
}
