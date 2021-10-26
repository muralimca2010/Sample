package com.userapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.userapp.BR;
import com.userapp.R;

public class Support extends BaseObservable implements Parcelable {


  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("text")
  @Expose
  private String text;


  public final static Creator<Support> CREATOR = new Creator<Support>() {

    @SuppressWarnings({
        "unchecked"
    })
    public Support createFromParcel(Parcel in) {
      return new Support(in);
    }

    public Support[] newArray(int size) {
      return (new Support[size]);
    }
  };

  protected Support(Parcel in) {
    this.url = ((String) in.readValue((String.class.getClassLoader())));
    this.text = ((String) in.readValue((String.class.getClassLoader())));
  }

  /**
   * No args constructor for use in serialization
   */
  public Support() {
  }

  /**
   *
   * @param url
   * @param text
   */
  public Support(String url, String text) {
    super();
    this.url = url;
    this.text = text;
  }



  @Bindable
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
    notifyPropertyChanged(BR.url);
  }

  public Support withUrl(String url) {
    this.url = url;
    return this;
  }

  @Bindable
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
    notifyPropertyChanged(BR.text);
  }

  public Support withText(String text) {
    this.text = text;
    return this;
  }


  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(url);
    dest.writeValue(text);
  }

  public int describeContents() {
    return 0;
  }

  public static final DiffUtil.ItemCallback<Support> CALLBACK = new DiffUtil.ItemCallback<Support>() {
    @Override
    public boolean areItemsTheSame(Support oldItem, Support newItem) {
      return oldItem.url.equals(newItem.url);
    }

    @Override
    public boolean areContentsTheSame(Support oldItem, Support newItem) {
      return true;
    }
  };
}