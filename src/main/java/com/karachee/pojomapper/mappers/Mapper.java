package com.karachee.pojomapper.mappers;

import com.karachee.pojomapper.annotations.FromListIndex;
import com.karachee.pojomapper.annotations.FromListIndexContainer;
import com.karachee.pojomapper.annotations.FromMapKey;
import com.karachee.pojomapper.extractors.FromMapKeyExtractor;
import com.karachee.pojomapper.extractors.FromListIndexExtractor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Mapper<T> {
    private static final Logger logger = LogManager.getLogger(Mapper.class);

    private T t;

    private FromListIndexExtractor fromListIndexExtractor;
    private FromMapKeyExtractor fromMapKeyExtractor;

    private Mapper() {}

    public T map(){
        if (t != null) {
            map(t.getClass(), t, null);
        }
        return t;
    }

    private void map(Class klass, Object obj, List<Object> parentObjs) {
        if (klass != null) {
            parentObjs = (parentObjs == null) ? new ArrayList<>() : parentObjs;
            parentObjs.add(obj);

            for (Field field : klass.getDeclaredFields()) {
                if (hasMappingAnnotation(field.getType())) {
                    Object nestedObj = getNewInstance(field.getType());
                    setValue(field.getName(), obj, nestedObj);
                    map(field.getType(), nestedObj, parentObjs);
                } else{
                    Class<?> parameterizedClass = (StringUtils.isNotBlank(StringUtils.substringBetween(field.getGenericType().getTypeName(), "<", ">"))) ? getParameterizedClass(field) : null;
                    if(hasMappingAnnotation(parameterizedClass)) {
                        Object parameterizedClassInstance = getNewInstance(parameterizedClass);
                        Object interfaceImplementation = getInterfaceImplementationAndAddValue(field.getType(), parameterizedClassInstance);
                        map(parameterizedClass, parameterizedClassInstance, parentObjs);
                        setValue(field.getName(), obj, interfaceImplementation);
                    } else {
                        handleField(field, obj, parentObjs);
                    }
                }
            }
            parentObjs.remove(obj);
        }
    }

    private Object getNewInstance(Class<?> klass){
        Object instance = null;
        if(klass!=null) {
            try {
                instance = klass.newInstance();
            } catch (Exception e) {
                logger.error("Error creating new instance for class {}, ", klass.getSimpleName(),e);
            }
        }

        return instance;
    }

    private boolean hasMappingAnnotation(Class klass){
        return klass!=null && Arrays.stream(klass.getDeclaredFields()).anyMatch(x -> x.isAnnotationPresent(FromListIndex.class) || x.isAnnotationPresent(FromListIndexContainer.class) || x.isAnnotationPresent(FromMapKey.class));
    }

    private Object getInterfaceImplementationAndAddValue(Type type, Object itemToAdd) {
        Object obj = null;

        if (type != null) {
            try {
                if (type.toString().equals("interface java.util.List")) {
                    obj = new ArrayList();
                    ((List)obj).add(itemToAdd);
                }
            } catch (Exception e) {
                logger.error("Error attempting to get Interface Implementation and Adding Value. Type: {}", type.toString(), e);
            }
        }

        return obj;
    }

    private Class<?> getParameterizedClass(Field field) {
        ParameterizedType genericType = (ParameterizedType) field.getGenericType();
        return (genericType!=null && ArrayUtils.isNotEmpty(genericType.getActualTypeArguments())) ? (Class<?>) genericType.getActualTypeArguments()[0] : null;
    }

    private void handleField(Field field, Object obj, List<Object> parentObjs) {
        if (field != null) {
            if (field.isAnnotationPresent(FromListIndex.class) || field.isAnnotationPresent(FromListIndexContainer.class)) {
                if (this.fromListIndexExtractor != null) {
                    setValue(field.getName(), obj, this.fromListIndexExtractor.extract(field, parentObjs));
                } else {
                    logger.error("Missing value list. Use withValueList while building Mapper");
                }
            } else if (field.isAnnotationPresent(FromMapKey.class)) {
                if (this.fromMapKeyExtractor != null) {
                    setValue(field.getName(), obj, this.fromMapKeyExtractor.extract(field, parentObjs));
                } else {
                    logger.error("Missing value Map. Use withValueMap while building Mapper");
                }
            }
        }
    }

    private void setValue(String fieldName, Object obj, Object value) {
        if(StringUtils.isNotBlank(fieldName) && obj!=null && value!=null) {
            try {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, obj.getClass());
                propertyDescriptor.getWriteMethod().invoke(obj, value);
            } catch (Exception e) {
                String fieldSimpleName = null;
                try {
                    Class<?> type = obj.getClass().getDeclaredField(fieldName).getType();
                    fieldSimpleName = (type!=null) ? type.getSimpleName() : null;
                } catch (NoSuchFieldException e1) {
                    e1.printStackTrace();
                }
                logger.error("Error attempting to set value. Field Name: {}. Object: {}, Value: {}.\nField is of type: {}, Value to set is of type: {}.\n Also please make sure {} has setter",
                        fieldName, obj.getClass(), value, fieldSimpleName, value.getClass().getSimpleName(),fieldName, e);
            }
        }
    }

    private void setT(T t) {
        this.t = t;
    }

    private void setValuesList(List<Object> valuesList) {
        this.fromListIndexExtractor = new FromListIndexExtractor(valuesList);
    }

    private void setValuesMap(Map<Object, Object> valuesMap) {
        this.fromMapKeyExtractor = new FromMapKeyExtractor(valuesMap);
    }

    public static class Builder<T> {
        private static final Logger logger = LogManager.getLogger(Builder.class);

        private T t;
        private List<Object> valuesList;
        private Map<Object, Object> valuesMap;

        public Builder(Class<T> klass) {
            try {
                this.t = klass.newInstance();
            } catch (Exception e) {
               logger.error("Error creating new instance of generic type, ", e);
            }
        }

        public Builder withValueList(List<Object> valuesList) {
            this.valuesList = valuesList;
            return this;
        }

        Builder withValueMap(Map<Object, Object> valuesMap) {
            this.valuesMap = valuesMap;
            return this;
        }

        public Mapper build() {
            Mapper mapper = new Mapper();
            mapper.setT(t);
            mapper.setValuesList(this.valuesList);
            mapper.setValuesMap(this.valuesMap);
            return mapper;
        }
    }
}