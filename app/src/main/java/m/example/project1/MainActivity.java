package m.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button like; Button dislike;
    boolean thumb_like = false;
    boolean thumb_dislike = false;
    int likeCountVal = 15;
    int dislikeCountVal = 1;
    ListView listView;
    TextView likeCount;TextView dislikeCount;
    CommentAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        like = (Button)findViewById(R.id.like);
        dislike = (Button)findViewById(R.id.dislike);
        likeCount = (TextView)findViewById(R.id.likeCount);
        dislikeCount = (TextView)findViewById(R.id.dislikeCount);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thumb_like)
                    decrLikeCount();
                else if(!thumb_like && thumb_dislike)
                {
                    incrLikeCount();
                    decrDisLikeCount();
                    thumb_dislike = !thumb_dislike;
                }
                else if(!thumb_like && !thumb_dislike)
                    incrLikeCount();
                thumb_like = !thumb_like;
            }
        });

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thumb_dislike)
                    decrDisLikeCount();
                else if(!thumb_dislike && thumb_like)
                {
                    incrDisLikeCount();
                    decrLikeCount();
                    thumb_like = !thumb_like;
                }
                else if(!thumb_dislike && !thumb_like)
                    incrDisLikeCount();
                thumb_dislike = !thumb_dislike;
            }
        });
        adapter = new CommentAdapter();
        adapter.additem(new commentItem());
        adapter.additem(new commentItem());
        adapter.additem(new commentItem());
        adapter.additem(new commentItem());
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        Button make_comment  = (Button) findViewById(R.id.make_comment);
        make_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(getApplicationContext(),"작성하기 버튼이 눌렸습니다.",Toast.LENGTH_LONG).show();
            }
        });
        Button view_all  = (Button) findViewById(R.id.view_all);
        view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast =  Toast.makeText(getApplicationContext(),"모두보기 버튼이 눌렸습니다.",Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
    class CommentAdapter extends BaseAdapter {
        ArrayList<commentItem> items = new ArrayList<commentItem>();
        public int getCount() {
            return items.size();
        }
        public Object getItem(int position) {
            return items.get(position);
        }
        public long getItemId(int position) {
            return position;
        }

        public void additem(commentItem item){
            items.add(item);
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            commentItemView v = null;
           if(convertView == null)
            { v = new commentItemView(getApplicationContext());}
            else
            {  v =(commentItemView) convertView ;}
            return v;
        }
    }
    public void incrLikeCount()
    {
        likeCountVal+=1;
        likeCount.setText(String.valueOf(likeCountVal));
        like.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }
    public void decrLikeCount()
    {
        likeCountVal-=1;
        likeCount.setText(String.valueOf(likeCountVal));
        like.setBackgroundResource(R.drawable.ic_thumb_up);
    }
    public void incrDisLikeCount()
    {
        dislikeCountVal+=1;
        dislikeCount.setText(String.valueOf(dislikeCountVal));
        dislike.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }
    public void decrDisLikeCount()
    {
        dislikeCountVal-=1;
        dislikeCount.setText(String.valueOf(dislikeCountVal));
        dislike.setBackgroundResource(R.drawable.ic_thumb_down);
    }

}
