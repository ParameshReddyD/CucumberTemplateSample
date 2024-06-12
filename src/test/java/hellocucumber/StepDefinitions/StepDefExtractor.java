package hellocucumber.StepDefinitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class StepDefExtractor {

    public static void main(String[] args) {
        List<String> stepDefinitions = extractStepDefinitions(Test1234.class);
        stepDefinitions.forEach(System.out::println);
    }

    public static List<String> extractStepDefinitions(Class<?> stepDefinitionsClass) {
        List<String> stepDefinitions = new ArrayList<>();
        Method[] methods = stepDefinitionsClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Given.class) ||
                    method.isAnnotationPresent(When.class) ||
                    method.isAnnotationPresent(Then.class) ||
                    method.isAnnotationPresent(ParameterType.class)) {
                stepDefinitions.add(method.getName());
            }
        }
        return stepDefinitions;
    }
}
