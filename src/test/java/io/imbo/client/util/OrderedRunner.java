/**
 * Thanks to "joscarsson" from StackOverflow for this ordered test runner!
 * 
 * @see http://stackoverflow.com/questions/3089151/12320716#12320716
 */
package io.imbo.client.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class OrderedRunner extends BlockJUnit4ClassRunner {
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Order {
	    public int order();
	}
	
	public OrderedRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> list = super.computeTestMethods();
        Collections.sort(list, new Comparator<FrameworkMethod>() {
            @Override
            public int compare(FrameworkMethod f1, FrameworkMethod f2) {
                Order o1 = f1.getAnnotation(Order.class);
                Order o2 = f2.getAnnotation(Order.class);

                if (o1 == null || o2 == null) {
                	return -1;
                }
                
                return o1.order() - o2.order();
            }
        });
        return list;
    }
}