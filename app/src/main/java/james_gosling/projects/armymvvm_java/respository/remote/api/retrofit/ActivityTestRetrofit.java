//package james_gosling.projects.armymvvm_java.respository.remote.api.retrofit;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import james_gosling.projects.armymvvm_java.R;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class ActivityTestRetrofit extends AppCompatActivity {
//
//    @BindView(R.id.result)
//    TextView res;
//    public String baseUrl = "";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test_retrofit);
//        ButterKnife.bind(this);
//
//        Retrofit retrofit = new Retrofit
//                .Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        PlaceHolderApi holderApi = retrofit.create(PlaceHolderApi.class);
//
//        Call<List<Post>> call = holderApi.getAll();
//
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//                if (!response.isSuccessful()){
//                    Toast.makeText(ActivityTestRetrofit.this, "Code: "+response.code(), Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                List<Post> list_posts = response.body();
//
//                for (Post post : list_posts) {
//                   String content = "CODE: "+response.code()+"\n"+
//                            "USER_ID: "+post.getUserId()+"\n"+
//                            "TITLE: "+post.getTitle()+"\n"+
//                            "BODY: "+post.getBody()+"\n\n\n";
//                    res.append(content);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//
//            }
//        });
//
//    }
//
//
//
//
//
//}
