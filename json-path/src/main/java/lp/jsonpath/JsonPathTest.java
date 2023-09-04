package lp.jsonpath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

/**
 * @author : lvpeng01
 * @since : 2020/6/3
 **/
public class JsonPathTest {

    private static final ObjectMapper mapper = new ObjectMapper();

//    public static void main(String[] args) {
//        //        jacksonTest();
////        jsonPathTest();
////        jsonPathArray();
//        jsonIteratorTest();
//    }

    public static void main(String[] args) {
        ObjectMapper MAPPER = new ObjectMapper();
        String json = "{\"top\":\"\", \"left\":\"\", \"bottom\":\"\", \"confidence\":\"\", \"width\":195.0, "
                + "\"subLocations\":\"\", \"attributes\":\"\", \"right\":\"\", \"height\":504.0, \"objectType\":\"\"}";
//        String json = "{\"top\":\"\",\"left\":\"\",\"width\":195.0,\"height\":504.0}";
        Location objectLocation = null;
        try {
//            MAPPER.convertValue();
            objectLocation = MAPPER.readValue(json, Location.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(objectLocation);
    }

    public static void jacksonTest() {
        ObjectNode rootNode = mapper.createObjectNode();
        setJsonPointerValue(rootNode, JsonPointer.compile("/root/array/0/name"), new TextNode("John"));
        setJsonPointerValue(rootNode, JsonPointer.compile("/root/array/0/age"), new IntNode(17));
        setJsonPointerValue(rootNode, JsonPointer.compile("/root/array/4"), new IntNode(12));
        setJsonPointerValue(rootNode, JsonPointer.compile("/root/object/num"), new IntNode(81));
        setJsonPointerValue(rootNode, JsonPointer.compile("/root/object/str"), new TextNode("text"));
        setJsonPointerValue(rootNode, JsonPointer.compile("/descr"), new TextNode("description"));
        try {
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode));
        } catch (JsonProcessingException e) {
            System.out.println("error");
        }
    }

    private static void setJsonPointerValue(JsonNode node, JsonPointer pointer, JsonNode value) {
        JsonPointer parentPointer = pointer.head();
        JsonNode parentNode = node.at(parentPointer);
        String fieldName = pointer.last().toString().substring(1);

        if (parentNode.isMissingNode() || parentNode.isNull()) {
            parentNode = StringUtils.isNumeric(fieldName) ? mapper.createArrayNode() : mapper.createObjectNode();
            setJsonPointerValue(node, parentPointer, parentNode);
        }

        if (parentNode.isArray()) {
            assert parentNode instanceof ArrayNode;
            ArrayNode arrayNode = (ArrayNode) parentNode;
            int index = Integer.parseInt(fieldName);
            // expand array in case index is greater than array size (like JavaScript does)
            for (int i = arrayNode.size(); i <= index; i++) {
                arrayNode.addNull();
            }
            arrayNode.set(index, value);
        } else if (parentNode.isObject()) {
            ((ObjectNode) parentNode).set(fieldName, value);
        } else {
            throw new IllegalArgumentException("`" + fieldName + "` can't be set for parent node `"
                    + parentPointer + "` because parent is not a container but " + parentNode.getNodeType().name());
        }
    }

    private static void jsonPathTest() {

        String jsonStr = "{}";

        Configuration conf = Configuration.defaultConfiguration()
                .addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL)
                .addOptions(Option.SUPPRESS_EXCEPTIONS);
        DocumentContext parse = JsonPath.using(conf).parse(jsonStr);
        parse.set(JsonPath.compile("$.user.name"), "John");
        System.out.println(parse.jsonString());
    }

    private static void jsonPathArray() {
        String jsonStr = "{}";

        DocumentContext context = JsonPath.parse(jsonStr);
        context.put("$.user.age", "lp", "12");
        System.out.println(context.jsonString());
    }

    private static void jsonIteratorTest() {
        String jsonStr = "{\n"
                + "\"cross_line_count\": {\n"
                + "},\n"
                + "\"cross_line_alert\": { \"alertInterval\": 300, \"preTime\": 10, \"postTime\": 10, "
                + "\"saveImageClue\": true, \"saveVideoClue\": true }\n"
                + "}";
        try {
            JsonNode jsonNode = mapper.readTree(jsonStr);
//            Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
//            while (it.hasNext()) {
//                Map.Entry<String, JsonNode> next = it.next();
//                System.out.println("key is : " + next.getKey() + " value is : " + next.getValue());
//            }
            print(jsonNode);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void print(JsonNode jsonNode) {

        Iterator<Map.Entry<String, JsonNode>> iterator = jsonNode.fields();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonNode> next = iterator.next();
            System.out.println(" key is : " + next.getKey());
            System.out.println(" value is : " + next.getValue());
            print(next.getValue());
        }
    }

}
