package daou.syscore.alertmgmtproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import daou.syscore.alertmgmtproject.R;
import daou.syscore.alertmgmtproject.item.FcmPushInfo;

/**
 * Created by daou on 2017-11-26.
 */

public class FcmPuchAdapter extends ArrayAdapter<FcmPushInfo>{
    private ViewHolder mViewHolder = null;
    private LayoutInflater mInflater = null;

    class ViewHolder {
        public TextView no = null;
        public TextView title = null;
        public TextView body = null;
        public TextView regDate = null;
    }

    public FcmPuchAdapter(Context context, int resource, List<FcmPushInfo> info) {
        super(context, resource, info);

        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null) {
            mViewHolder = new ViewHolder();
            // 어댑터 템플릿 view 객체화
            v = mInflater.inflate(R.layout.listview_fcm_push, null);

            mViewHolder.no = (TextView) v.findViewById(R.id.customPushNo);
            mViewHolder.title = (TextView) v.findViewById(R.id.customPushTitle);
            mViewHolder.body = (TextView) v.findViewById(R.id.customPushBody);
            mViewHolder.regDate = (TextView) v.findViewById(R.id.customPushRegDate);

            v.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder) v.getTag();
        }

        mViewHolder.no.setText(Integer.toString(getItem(position).getNo()));
        mViewHolder.title.setText(getItem(position).getTitle());
        mViewHolder.body.setText(getItem(position).getBody());
        mViewHolder.regDate.setText(getItem(position).getRegDate());

        return v;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public FcmPushInfo getItem(int position) {
        return super.getItem(position);
    }

}
