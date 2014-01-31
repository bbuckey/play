package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringUtils {

	
	public static String makeFirstLetterUpperCase(String s) {
		String string = "";
		if (s != null) {
			string = s.substring(0, 1).toUpperCase() + s.substring(1);
		} 
		return string;
	}

	
	/**
	 * Given the class and the object the Fields and methods
	 * are then cycled through looking for the getters if one is found a 
	 * currently this will only work for classes that all private members are strings
	 * or a combination of strings and raw types future implementation will allow complex types  
	 * @param clazz
	 * @param obj
	 * @return
	 */
	public static String jsonify(Class<?> clazz, Object obj) throws Throwable{
		String json = "";
		Method[] methods = clazz.getMethods();
		Field[] fields = clazz.getDeclaredFields(); 
		for(Field f : fields){
			String fieldName = f.getName().toUpperCase();
			System.err.println(fieldName);
			for(Method m : methods){
				String methodName = m.getName().toUpperCase();
				System.err.println(methodName);
				if(methodName.startsWith("GET") && methodName.endsWith(fieldName)){
					try{
					Object o = m.invoke(obj);
					json += json.equals("") ? "{" + f.getName() + " : " +o.toString() :  " , " + f.getName() + " : " + o.toString();
					} catch (Throwable t){
						throw t;
					}
				}
				
			}
		}
		json = json.equals("") ? "{}" : json + " }";
		return json;
	}
	
	
}
