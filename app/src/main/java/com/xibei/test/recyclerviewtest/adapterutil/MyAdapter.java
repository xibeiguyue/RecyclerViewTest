package com.xibei.test.recyclerviewtest.adapterutil;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xibei.test.recyclerviewtest.R;
import com.xibei.test.recyclerviewtest.bean.ItemBean;

import java.util.List;
import java.util.zip.Inflater;

import static android.graphics.BitmapFactory.decodeResource;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.media.CamcorderProfile.get;

/**
 * Description: RecyclerView的适配器
 * Author:Administrator
 * Date: 2016/11/30
 * Time: 17:00
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHold> {

    private Context mContext;
    private List<ItemBean> itemList;
    private Resources mResources;
    private LayoutInflater mInflater;

    public MyAdapter(Context mContext, List<ItemBean> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
        this.mResources = mContext.getResources();
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_adapter, parent, false);
        return new MyViewHold(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.MyViewHold holder, final int position) {
        ItemBean mBean = itemList.get(position);
        holder.title.setText(mBean.getTitle());
        holder.image.setImageResource(mBean.getResId());
        Bitmap mBitmap = BitmapFactory.decodeResource(mResources, mBean.getResId());
        Palette.from(mBitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant = palette.getVibrantSwatch(); //有活力的
                Palette.Swatch dv = palette.getDarkVibrantSwatch(); //有活力的  暗色
                Palette.Swatch lv = palette.getLightVibrantSwatch(); //有活力  亮色
                Palette.Swatch m = palette.getMutedSwatch(); //柔和
                Palette.Swatch dm = palette.getDarkMutedSwatch(); //柔和  暗色
                Palette.Swatch lm = palette.getLightMutedSwatch(); //柔和  亮色

                if (vibrant != null) {
                    int color1 = vibrant.getBodyTextColor();  //内容颜色
                    int color2 = vibrant.getTitleTextColor(); //标题颜色
                    int color3 = vibrant.getRgb(); //rgb颜色

                    if (position < 4) {
                        holder.title.setBackgroundColor(m.getRgb());
                        holder.title.setTextColor(m.getTitleTextColor());
                    } else {
                        holder.title.setBackgroundColor(color3);
                        holder.title.setTextColor(color2);
                    }
                }

            }
        });

    }

    @Override
    public int getItemCount() {

        return itemList == null?0:itemList.size();
    }


    public class MyViewHold extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView image;

        public MyViewHold(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
            image = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }
}
