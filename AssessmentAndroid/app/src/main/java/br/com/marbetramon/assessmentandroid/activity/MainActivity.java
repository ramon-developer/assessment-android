package br.com.marbetramon.assessmentandroid.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import br.com.marbetramon.assessmentandroid.R;
import br.com.marbetramon.assessmentandroid.adapter.StackOverFlowAdapter;
import br.com.marbetramon.assessmentandroid.api.RestClient;
import br.com.marbetramon.assessmentandroid.api.StackOverflowService;
import br.com.marbetramon.assessmentandroid.model.Tag;
import br.com.marbetramon.assessmentandroid.model.TagList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        btnGo = (Button) findViewById( R.id.btn_go );
        btnGo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        } );
    }

    private void callApi() {
//        try {
            StackOverflowService service = RestClient.getClient().create( StackOverflowService.class );

            editText = (EditText) findViewById( R.id.et_digit );
            Call<TagList> call = service.getTags( editText.getText().toString() );

            Log.wtf( "URL CHAMADA: ", call.request().url() + " " );

            call.enqueue( new Callback<TagList>() {
                @Override
                public void onResponse(@NonNull Call<TagList> call, @NonNull Response<TagList> response) {
                    if (response.body() != null) {
                        generateTagList( response.body().getTagArrayList() );
                    }
                }

                @Override
                public void onFailure(@NonNull Call<TagList> call, @NonNull Throwable t) {
                    Toast.makeText( MainActivity.this, "Algo está errado: " + t.getMessage(), Toast.LENGTH_SHORT ).show();
                }
            } );
//        }
//        catch (Exception e) {
//            Log.d( "Error", e.getMessage() );
//            Toast.makeText( this, e.toString(), Toast.LENGTH_SHORT ).show();
//        }
    }

    private void generateTagList(ArrayList<Tag> tagArrayList) {

        RecyclerView recyclerView = (RecyclerView) findViewById( R.id.rv_response );

        StackOverFlowAdapter adapter = new StackOverFlowAdapter( tagArrayList );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( MainActivity.this );
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setAdapter( adapter );
    }
}
