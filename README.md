## JavaResolver for jQuery QueryBuilder
This library helps you for execute that created validations via  [jQuery QueryBuilder](http://querybuilder.js.org/).

> Tested for only (jQuery QueryBuilder v2.4.3).
### Using
You can execute to generated validations basically. 
Generated validation json should be convert to `Map` for using executions.  `Gson` dependency is good for converting to `Map` from string. 

```xml
<dependency>
	<groupId>com.google.code.gson</groupId>
	<artifactId>gson</artifactId>
	<version>2.8.0</version>
</dependency>
```


#### Example Validation Json
```js
// String validationString=..
 {
         "condition":"OR",
         "rules":[
            {
               "field":"number",
               "type":"integer",
               "operator":"equal",
               "value":"7"
            },
            {
               "field":"number",
               "type":"integer",
               "operator":"equal",
               "value":"8"
            }
         ],
         "not":false
      }
```
#### Using Validation Execution 
```java
//your data object
Map yourData = new HashMap<>();
yourData.put("number", "7");

//convert plain text validation  
Gson gson = new GsonBuilder().create();
Map map = gson.fromJson(validationString, Map.class);

//create validation 
ValidationGroup validationGroup = new ValidationGroup(map);

//execute validation
boolean result=validationGroup.execute(yourData)
assertTrue(result);// result will `true` according to example


```
