package reflectionAndAnnotations;

import reflectionAndAnnotations.highQualityMistakes.Reflection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Class<Reflection> clazz = Reflection.class;

        String path = "src";
        Stream<Path> pathStream = Files.list(Path.of(path));
        List<? extends Class<?>> collect = pathStream.map(p -> p.toString().substring(4, p.toString().indexOf("."))).map(s -> {
            try {
                return Class.forName(s);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        Class<?> demoReflection = Class.forName("reflectionAndAnnotations.highQualityMistakes.Reflection");


    }
}
