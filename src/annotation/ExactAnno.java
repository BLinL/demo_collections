package annotation;

/**
 * @author bliu
 * @date 2021-03-15 10:57
 */
public class ExactAnno {
    public static void main(String[] args) {
        if(A.class.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation myAnnotation = A.class.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation.value());
            System.out.println(myAnnotation.annotationType());
        }
    }
}
