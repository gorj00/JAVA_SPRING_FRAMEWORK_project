package demo6_AOP_aspects.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // Related advices
    /**
     * @Before()
     * @AfterReturning(), may contain returned result, may modify for the calling program,  example below:
     *      @AfterReturning(
     *          pointcut="****",
     *          returning="result"
     *      )
     *      public void afterMethodAdvice(
     *          JointPoint joinPoint, List<Object> result
     *      ) {}
     * @AfterThrowing(), exception propagates to the calling program
     *      @AfterReturning(
     *          pointcut="****",
     *          throwing="exception" // (Throwable type in method param
     *      )
     * @After(). runs in both cases, success or failure, runs before the previous two
     * @Around(), runs before and after the method execution; may swallow / handle / stop exception,
     *      new param - ProceedingJointPoint => a handle to target method
     *      @Around("execution(****)")
     *      public Object aroundMethodAdvice(ProceedingJointPoint pjp) throws Throwable {
     *          // ... before logic
     *          Object result pjp.proceed();
     *          // ... after logic
     *          return result;
     *      }
     */

    /**
     * POINTCUT: a predicate expression for where advice should be applied,
     * focus on EXECUTION
     *
     * execution(
     *      modifiers?
     *      return type
     *      declaring type?
     *      method name(param)
     *      throws?
     * ) + wildcards may be used
     *
     * Match addAccount() in AccountDAO class:
     *      execution(public void package_path.AccountDAO.addAccount())
     *
     * Match addAccount() in any class:
     *      execution(public void addAccount())
     *
     * Match methods starting with `add` (with wildcards
     *      execution(public void add*())
     *
     * Match methods with any modifier and any return type
     *      execution(* * add*())
     *      OR execution(* add*()) since modifier is optional
     *
     * Match all methods in a particular package
     *      execution(* package_path.*.*(..))
     *      ==> any return rype, any class, any method name, any number of params
     *
     * Param matching:
     *      ()   - matches method with no arguments
     *      (*)  - matches method with one arhument of any type
     *      (..) - matches method with zero or more arguments of any type
     *      (`specific`) - use qualified name for classes, example:
     *                   execution(public void addAccount(package_path.Account))
     *                   generic example:  @Before(expressionOne() && !expressionTwo())
     *
     * COMBINING POINTCUTS:
     *      may use logical operators && || !, works as a logical if statement
     *
     * ASPECTS ORDER:
     *      separate advices into different aspects files, use @Order(int) annotation on the file
     *      lower number means higher precedence
     *      negative numbers allowed, does not have to consecutive (-2, 7, 9 ==> allowed)
     *      same order in multiple aspects - order undefined
     *
     * JOINTPOINTS: Read methods arguments
     * @Before("...")
     * public void beforeMethodAdvice(JointPoint jointPoint) {
     *     MethodSignature methodSig = (MethodSignature) jointPont.getSignature();
     *     // Method: package_path.Class.method(param1 type, params2 type, ...)
     *
     *     Object[] args = jointPoint.getArgs();
     * }
     *
     *
     * 
     */

    // DYNAMIC POINTCUT
    @Pointcut("execution(public void addAccount())")
    private void forAddAccount() {}

    @Before("forAddAccount()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    // HARDCODED POINTCUT
    /*
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
    */
}
