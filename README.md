# pojo-mapper

Recursively map java POJOs using simple annotations that instruct value extractors where to extract values from

src/test/java/com/karachee/pojomapper/mappers/MapperTest.java:

Other.java snippet:

```
    @FromListIndex(index = 0)
    private String string0;

    @FromListIndex(index = 1)
    private String string1;
```
Mapper Setup:
```
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
```

Code model snippet:

```
    @FromListIndex(index = 11, parent = "MainPart.Information")
    @FromListIndex(index = 43, parent = "MultiUsePart.Information")
    private String code1;

    @FromListIndex(index = 13, parent = "MainPart.Information")
    @FromListIndex(index = 44, parent = "MultiUsePart.Information")
    private String code2;
```

Multiple value lists. 

```
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
```

Output with multiple parts mapped with multiple indices and parent restrictions:

```
{
  "string0" : "String0",
  "string1" : "String1",
  "string2" : "String2",
  "string3" : "String3",
  "string4" : "String4",
  "string5" : "String5",
  "string6" : "String6",
  "string7" : "String7",
  "string9" : "String8",
  "mainPart" : {
    "string6" : "String6",
    "string7" : "String7",
    "string18" : "String18",
    "string16" : "String16",
    "string17" : "String17",
    "string10" : "String10",
    "multiUseParts" : [ {
      "string32" : "String32",
      "souble35" : 35.0,
      "string323" : "String33",
      "integer34" : 34,
      "double36" : 26.0,
      "double39" : 29.0,
      "double37" : 37.0,
      "double38" : 28.0,
      "double40" : 40.0,
      "double41" : 41.0,
      "double42" : 42.0,
      "information" : {
        "double24" : 24.0,
        "double21" : 20.0,
        "string23" : "String23",
        "string19" : "String19",
        "string22" : "String22",
        "double25" : 25.0,
        "double28" : 28.0,
        "double26" : 26.0,
        "double27" : 27.0,
        "double29" : 29.0,
        "double31" : 31.0,
        "double30" : 30.0,
        "descriptions" : [ {
          "desc" : "String46"
        } ],
        "codes" : [ {
          "code1" : "String43",
          "code2" : "String45"
        } ]
      },
      "descriptions" : [ { } ]
    }, {
      "string32" : "String322",
      "souble35" : 35.02,
      "string323" : "String332",
      "integer34" : 342,
      "double36" : 26.02,
      "double39" : 29.02,
      "double37" : 37.02,
      "double38" : 28.02,
      "double40" : 40.02,
      "double41" : 41.02,
      "double42" : 42.02,
      "information" : {
        "double24" : 24.02,
        "double21" : 20.02,
        "string23" : "String232",
        "string19" : "String192",
        "string22" : "String222",
        "double25" : 25.02,
        "double28" : 28.02,
        "double26" : 26.02,
        "double27" : 27.02,
        "double29" : 29.02,
        "double31" : 31.02,
        "double30" : 30.02,
        "descriptions" : [ {
          "desc" : "String462"
        } ],
        "codes" : [ {
          "code1" : "String432",
          "code2" : "String452"
        } ]
      },
      "descriptions" : [ { } ]
    } ],
    "information" : {
      "double24" : 24.0,
      "double21" : 20.0,
      "string23" : "String23",
      "string19" : "String19",
      "string22" : "String22",
      "double25" : 25.0,
      "double28" : 28.0,
      "double26" : 26.0,
      "double27" : 27.0,
      "double29" : 29.0,
      "double31" : 31.0,
      "double30" : 30.0,
      "descriptions" : [ {
        "desc" : "String14"
      } ],
      "codes" : [ {
        "code1" : "String11",
        "code2" : "String13"
      } ]
    }
  }
}
```