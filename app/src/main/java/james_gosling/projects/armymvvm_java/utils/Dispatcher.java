package james_gosling.projects.armymvvm_java.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import james_gosling.projects.armymvvm_java.utils.Logs.Status;

public class Dispatcher<T> {

    @NonNull
   public final Status status;
   public final String message;
   public final T data;

   public Dispatcher(@NonNull Status status , @Nullable T data ,@Nullable String message){

       this.status = status;
       this.data = data;
       this.message = message;

   }

   public static <T> Dispatcher<T> success(@NonNull T data){
       return new Dispatcher<>(Status.SUCCESS , data , null);
   }
   public static <T> Dispatcher<T> loading(@NonNull T data){
       return new Dispatcher<>(Status.LOADING , data , null);
   }
   public static <T> Dispatcher<T> error(@NonNull T data , String msg){
       return new Dispatcher<>(Status.LOADING , data , msg);
   }


}



