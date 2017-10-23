package customlistview.mysqlx18.com.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListViewAdapter customListViewAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] bookTitles = new String[]{
                "The Alchemist",
                "The Giver",
                "How to Kill a Mockingbird"
        };
        final String[] bookPages = new String[]{
                "300",
                "350",
                "900"
        };
        final String[] authors = new String[]{
                "Paulo",
                "Lois Lowry",
                "Harper Lee"
        };

        ArrayList<HashMap< String, String>> authorList = new ArrayList<>();
         for(int i = 0; i < 3; i++){
            HashMap<String, String> data = new HashMap<>();
             data.put("title", bookTitles[i]);
             data.put("pages", bookPages[i]);
             data.put("author", authors[i]);
             authorList.add(data);
        }
        listView = (ListView)findViewById(R.id.list);
        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), authorList);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int myPosition = position;

                String itemClickedId = listView.getItemAtPosition(myPosition).toString();
                Toast.makeText(getApplicationContext(), "Id Clicked: " + itemClickedId, Toast.LENGTH_LONG).show();
            }
        });

    }
}
