package com.karachee.pojomapper.extractors;

import com.karachee.pojomapper.annotations.FromListIndex;
import com.karachee.pojomapper.annotations.FromListIndexContainer;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FromListIndexExtractor implements IExtractor{

    private List<Object> values;

    public FromListIndexExtractor(List<Object> values){
        this.values = values;
    }

    @Override
    public Object extract(Field field, List<Object> parentObjs){
        Object obj = null;

        FromListIndex fromListIndex = (field!=null) ? field.getAnnotation(FromListIndex.class) : null;
        if(fromListIndex!=null){
            obj = extractSingular(fromListIndex);
        }else{
            String flattenedParents = (CollectionUtils.isNotEmpty(parentObjs)) ? parentObjs.stream().map(x -> x.getClass().getSimpleName()).collect(Collectors.joining(".")) :null;
            FromListIndexContainer fromListIndexContainer = (field!=null) ? field.getAnnotation(FromListIndexContainer.class) : null;
            if(fromListIndexContainer!=null && StringUtils.isNotBlank(flattenedParents)){

                for (FromListIndex listIndex : fromListIndexContainer.value()) {
                    if(hasParentMatch(listIndex.parent(), flattenedParents)){
                        obj = extractSingular(listIndex);
                        break;
                    }
                }
            }
        }

        return obj;
    }

    private boolean hasParentMatch(String parent, String flattenedParents){
        return StringUtils.isNotBlank(parent) && StringUtils.isNotBlank(flattenedParents) && flattenedParents.contains(parent);
    }

    private Object extractSingular(FromListIndex fromListIndex){
        Object obj = null;

        if(fromListIndex !=null && values!=null){
            int index = fromListIndex.index();

            if(index!=-1){
                obj = (values.size() > index)? values.get(index) : obj;
            }else{
                int[] indices = fromListIndex.indices();
                if(ArrayUtils.isNotEmpty(indices)) {
                    obj = new ArrayList<>();
                    for (int i : indices) {
                        if (values.size() > i) {
                            ((ArrayList) obj).add(values.get(i));
                        }
                    }
                }
            }
        }

        return obj;
    }
}
