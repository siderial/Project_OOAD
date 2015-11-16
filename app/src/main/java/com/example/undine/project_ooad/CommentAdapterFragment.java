package com.example.undine.project_ooad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15/11/2558.
 */
public class CommentAdapterFragment extends BaseAdapter {
    private LayoutInflater mInflater;
    List<Comment> mPosts;
<<<<<<< HEAD
    private MyViewHolder commentView;
    private Comment mPost;
=======
    private ViewHolder mViewHolder;


    private Bitmap mBitmap;
    private Comment mPost;
    private Activity mActivity;
>>>>>>> origin/v6.1

    //by nook 2015/11/03
    private static ArrayList<Comment> listContact;
    public CommentAdapterFragment(Context photosFragment, ArrayList<Comment> results){
        listContact = results;
        mInflater = LayoutInflater.from(photosFragment);
        mPosts=results;
    }

<<<<<<< HEAD


=======
>>>>>>> origin/v6.1
    @Override
    public int getCount() {
        return mPosts.size();
    }

    @Override
    public Object getItem(int position) {
        return mPosts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
<<<<<<< HEAD
            convertView = mInflater.inflate(R.layout.layout_comment, parent, false);
            commentView = new MyViewHolder();
            commentView.accountImage = (ImageView) convertView.findViewById(R.id.comment_account_image);
            commentView.accountName = (TextView) convertView.findViewById(R.id.account_name);
            commentView.description = (TextView) convertView.findViewById(R.id.descript);


            convertView.setTag(commentView);

        } else {
            commentView = (MyViewHolder) convertView.getTag();

        }

        mPost = mPosts.get(position);
        commentView.accountName.setText(mPost.getAccount().getName());
        commentView.description.setText(mPost.getDescription()+"");
=======
            convertView = mInflater.inflate(R.layout.post, parent, false);
            mViewHolder = new ViewHolder();
            mViewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.post_thumbnail);
            mViewHolder.author = (TextView) convertView.findViewById(R.id.post_author);
            mViewHolder.title = (TextView) convertView.findViewById(R.id.post_title);
            mViewHolder.date = (TextView) convertView.findViewById(R.id.post_date);

            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mPost = mPosts.get(position);

        mViewHolder.author.setText(mPost.getAccount().getName());
        mViewHolder.title.setText(mPost.getDescription()+"");
>>>>>>> origin/v6.1

        return convertView;
    }

<<<<<<< HEAD

    private static class MyViewHolder{
        ImageView accountImage;
        TextView accountName;
        TextView description;

    }
}
=======
    private static class ViewHolder{
        ImageView thumbnail;
        TextView title;
        TextView author;
        TextView date;
    }
}
>>>>>>> origin/v6.1
