package com.karachee.pojomapper.extractors;

import com.karachee.pojomapper.annotations.FromMapKey;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class FromMapKeyExtractor implements IExtractor{

    private Map<Object, Object> values;

    public FromMapKeyExtractor(Map<Object, Object> values){
        this.values = values;
    }

    @Override
    public Object extract(Field field, List<Object> parentObjs){
        Object obj = null;

        FromMapKey fromMapKey = (field!=null) ? field.getAnnotation(FromMapKey.class) : null;
        if(fromMapKey !=null && values!=null){

            String stringKey = fromMapKey.stringKey();
            if(StringUtils.isNotBlank(stringKey)){
                obj = (values.containsKey(stringKey)) ? values.get(stringKey) : null;
            }
        }

        return obj;
    }
}
