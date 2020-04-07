package agolova2.pages;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Set;

public class AnnotationScanner {

    private static Reflections reflection = new Reflections();

    public Set<Class<?>> getClassesAnnotatedWith(Class<? extends Annottion> annotation) {
        return reflection.getTypesAnnotatedWith(annotation);
    }

}