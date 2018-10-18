package com.karachee.pojomapper.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.karachee.pojomapper.models.TestObj;
import com.karachee.pojomapper.models.other.Other;
import com.karachee.pojomapper.models.other.parts.MultiUsePart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class MapperTest {
    private static final Logger logger = LogManager.getLogger(MapperTest.class);

    private ObjectMapper objectMapper = new ObjectMapper() {{
        enable(SerializationFeature.INDENT_OUTPUT);
    }};

    @Test
    public void test() throws Exception {

        List<Object> values = Arrays.asList("Something", "Something 2", LocalDate.now(), 1, "Note 1", "Note 2");
        Map<Object, Object> valueMap = new HashMap<Object, Object>() {{
            put("testKey", "value from valueMap");
        }};

        Mapper<TestObj> mapper = new Mapper.Builder(TestObj.class)
                .withValueList(values)
                .withValueMap(valueMap)
                .build();

        TestObj test = mapper.map();
        assertNotNull(test);
    }

    @Test
    public void test2() throws Exception {
        List<Object> values = Arrays.asList("String0", "String1", "String2", "String3",
                "String4", "String5", "String6", "String7", "String8", "String29",
                "String10", "String11","String12", "String13", "String14","String15",
                "String16", "String17", "String18",
                "String19", "String20", 20.00,
                "String22", "String23", 24.00, 25.00, 26.00, 27.00,
                28.00, 29.00, 30.00, 31.00, "String32", "String33",
                34, 35.00, 26.00, 37.00, 28.00, 29.00,
                40.00, 41.00, 42.00, "String43", "String45", "String46");

        Mapper<Other> mapper = new Mapper.Builder(Other.class)
                .withValueList(values)
                .build();

        Other test = mapper.map();
        assertNotNull(test);
        logger.info(objectMapper.writeValueAsString(test));
    }

    @Test
    public void test3() throws Exception {
        List<Object> valuess = Arrays.asList("String0", "String1", "String2", "String3",
                "String4", "String5", "String6", "String7", "String8", "String9",
                "String10", "String11","String12", "String13", "String14","String15",
                "String16", "String17", "String18",
                "String19", "String20", 20.00,
                "String22", "String23", 24.00, 25.00, 26.00, 27.00,
                28.00, 29.00, 30.00, 31.00, "String32", "String33",
                34, 35.00, 26.00, 37.00, 28.00, 29.00,
                40.00, 41.00, 42.00, "String43", "String45", "String46");

        List<Object> values2 = Arrays.asList("String02", "String12", "String22", "String32",
                "String42", "String52", "String62", "String72", "String82", "String92",
                "String102", "String112","String122", "String132", "String142","String152",
                "String162", "String172", "String182",
                "String192", "String202", 20.02,
                "String222", "String232", 24.02, 25.02, 26.02, 27.02,
                28.02, 29.02, 30.02, 31.02, "String322", "String332",
                342, 35.02, 26.02, 37.02, 28.02, 29.02,
                40.02, 41.02, 42.02, "String432", "String452", "String462");

        List<List<Object>> valueLists = Arrays.asList(valuess, values2);


        Other other = null;
        for (int i=0; i< valueLists.size(); i++) {
            List<Object> values = valueLists.get(i);
            if(0 == i) {
                Mapper<Other> mapper = new Mapper.Builder(Other.class).withValueList(values).build();
                other = mapper.map();
            }else{
                Mapper<MultiUsePart> mapper = new Mapper.Builder(MultiUsePart.class).withValueList(values).build();

                MultiUsePart multiUsePart = mapper.map();
                if(other!=null && other.getMainPart()!=null && multiUsePart!=null){
                    other.getMainPart().addMultiUsePart(multiUsePart);
                }
            }
        }

        assertNotNull(other);
        logger.info(objectMapper.writeValueAsString(other));
    }
}
