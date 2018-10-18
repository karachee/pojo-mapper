package com.karachee.pojomapper.extractors;

import java.lang.reflect.Field;
import java.util.List;

public interface IExtractor {

    public Object extract(Field field, List<Object> parentObjs);
}
