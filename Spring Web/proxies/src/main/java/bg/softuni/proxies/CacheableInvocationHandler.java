package bg.softuni.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheableInvocationHandler implements InvocationHandler {

  private Map<String, Object> cachedValues = new ConcurrentHashMap<>();
  private final Object realObject;
  public CacheableInvocationHandler(Object realObject) {
    this.realObject = realObject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    Cacheable cacheableAnnotation = realObject.getClass().
        getMethod(method.getName(), method.getParameterTypes()).
        getAnnotation(Cacheable.class);

    if (cacheableAnnotation != null) {
      //
      String cacheId = cacheableAnnotation.value();
      if (cachedValues.containsKey(cacheId)) {
        return cachedValues.get(cacheId);
      } else {
        var value = method.invoke(realObject, args);
        cachedValues.put(cacheId, value);
        return value;
      }
    } else {
      return method.invoke(realObject, args);
    }
  }
}
