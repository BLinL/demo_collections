package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

  public static void main(String[] args) {
    CompletableFuture.supplyAsync(() -> {
      System.out.println("hihi");
      return "ok";
      //throw new RuntimeException("error 1");
    }).handleAsync((result, exception) -> {
      if (exception != null) {
        return exception.getCause();
      }else { ;
        return result;
      }
    }).thenApplyAsync((returnStr)->{
      System.out.println(Thread.currentThread().getName() + "-" + returnStr);
      return returnStr;
    });

    System.out.println("异步任务");
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
      System.out.println("nice to meet you");
      throw new RuntimeException("error 1");
      //return "mee too";

    });

    try {
      System.out.println(future.join());
    } catch (Exception e){
     // e.printStackTrace();
    }
  }
}
