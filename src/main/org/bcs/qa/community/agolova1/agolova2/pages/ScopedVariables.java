package agolova2.pages;
//работа с переменными, заданнми пользователем (подстановка значения)

import com.google.common.collect.Maps;
import groovy.lang.GroovyShell;
import java.math.BigDecimal;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScopedVariables {

    private Map<String, Object> variables = Maps.newHashMap();
    public Object evaluate(String expression) {
        GroovyShell shell = new GroovyShell();
        variables.entrySet().forEach(e -> {
            try {
                shell.setVariable(e.getKey(), new BigDecimal(e.getValue().toString()));
            } catch (NumberFormatException exp) {
                shell.setVariable(e.getKey(), e.getValue());
            }
        });
        return shell.evaluate(expression);
    }

    public String replaceVariables(String textToReplaceIn) {
        Pattern p = Pattern.compile("\\{([^{}]+)\\}");
        Matcher m = p.matcher(textToReplaceIn);
        StringBuffer buffer = new StringBuffer();
        while (m.find()) {
            String varName = m.group(1);
            String value = get(varName).toString();
            m.appendReplacement(buffer, value);
        }
        m.appendTail(buffer);
        return buffer.toString();
    }

    public void put(String name, Object value) {
        variables.put(name, value);
    }

    public Object get(String name) {
        return  variables.get(name);
    }

    public void clear() {
        variables.clear();
    }

    public Object remove(String key) {
        return variables.remove(key);
    }
}
