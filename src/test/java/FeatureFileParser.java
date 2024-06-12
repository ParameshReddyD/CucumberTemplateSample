//import io.cucumber.messages.types.*;
//import io.cucumber.messages.NdjsonToMessageIterable;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class FeatureFileParser {
//
//    public static void main(String[] args) {
//        try {
//            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//            Document doc = docBuilder.newDocument();
//
//            Element rootElement = doc.createElement("features");
//            doc.appendChild(rootElement);
//
//            Files.walk(Paths.get("src/test/resources/features"))
//                    .filter(Files::isRegularFile)
//                    .forEach(path -> {
//                        try {
//                            String content = new String(Files.readAllBytes(path));
//                            NdjsonToMessageIterable messages = new NdjsonToMessageIterable(content.lines().collect(Collectors.toList()));
//                            for (Envelope envelope : messages) {
//                                if (envelope.getGherkinDocument().isPresent()) {
//                                    GherkinDocument document = envelope.getGherkinDocument().get();
//                                    Feature feature = document.getFeature().orElse(null);
//                                    if (feature != null) {
//                                        Element featureElement = doc.createElement("feature");
//                                        featureElement.setAttribute("name", feature.getName());
//                                        rootElement.appendChild(featureElement);
//
//                                        List<ScenarioDefinition> scenarioDefinitions = feature.getChildren();
//                                        for (ScenarioDefinition scenarioDefinition : scenarioDefinitions) {
//                                            if (scenarioDefinition instanceof Scenario) {
//                                                Scenario scenario = (Scenario) scenarioDefinition;
//                                                Element scenarioElement = doc.createElement("scenario");
//                                                scenarioElement.setAttribute("name", scenario.getName());
//                                                featureElement.appendChild(scenarioElement);
//
//                                                List<Step> steps = scenario.getSteps();
//                                                for (Step step : steps) {
//                                                    Element stepElement = doc.createElement("step");
//                                                    stepElement.setAttribute("keyword", step.getKeyword());
//                                                    stepElement.appendChild(doc.createTextNode(step.getText()));
//                                                    scenarioElement.appendChild(stepElement);
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    });
//
//            // Write the content into XML file
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(doc);
//            StreamResult result = new StreamResult(new File("features.xml"));
//            transformer.transform(source, result);
//
//            System.out.println("File saved!");
//
//        } catch (ParserConfigurationException | TransformerException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
