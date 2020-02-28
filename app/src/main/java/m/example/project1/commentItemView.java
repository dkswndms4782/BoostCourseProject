package m.example.project1;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;

public class commentItemView extends LinearLayout {
    TextView t1; TextView t2; TextView t3; TextView t4; TextView t5;
    RatingBar r1;
    CircleImageView d1;
    public commentItemView(Context context) {
        super(context);
        init(context);
    }

    public commentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view,this,true);
    }




}
