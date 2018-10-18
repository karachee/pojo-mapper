package com.karachee.pojomapper.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.karachee.pojomapper.models.TestObj;
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

    private ObjectMapper objectMapper = new ObjectMapper(){{
        enable(SerializationFeature.INDENT_OUTPUT);
    }};

    @Test
    public void test() throws Exception {

        List<Object> values = Arrays.asList("Something", "Something 2", LocalDate.now(), 1, "Note 1", "Note 2");
        Map<Object, Object> valueMap = new HashMap<Object, Object>(){{
            put("testKey", "value from valueMap");
        }};

        Mapper<TestObj> mapper = new Mapper.Builder(TestObj.class)
                .withValueList(values)
                .withValueMap(valueMap)
                .build();

        TestObj test = mapper.map();
        assertNotNull(test);
    }
}
