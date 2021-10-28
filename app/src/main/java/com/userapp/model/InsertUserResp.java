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

public class InsertUserResp extends BaseObservable implements Parcelable {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("job")
  @Expose
  private String job;
  @SerializedName("id")
  @Expose
  private String id;
  @SerializedName("createdAt")
  @Expose
  private String createdAt;

  public final static Creator<InsertUserResp> CREATOR = new Creator<InsertUserResp>() {

    @SuppressWarnings({
        "unchecked"
    })
    public InsertUserResp createFromParcel(Parcel in) {
      return new InsertUserResp(in);
    }

    public InsertUserResp[] newArray(int size) {
      return (new InsertUserResp[size]);
    }
  };

  protected InsertUserResp(Parcel in) {
    this.name = ((String) in.readValue((String.class.getClassLoader())));
    this.job = ((String) in.readValue((String.class.getClassLoader())));
    this.id = ((String) in.readValue((String.class.getClassLoader())));
    this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
  }

  /**
   * No args constructor for use in serialization
   */
  public InsertUserResp() {
  }

  /**
   *
   * @param name
   * @param job
   * @param id
   * @param createdAt
   */
  public InsertUserResp(String name, String job, String id, String createdAt) {
    super();
    this.name = name;
    this.job = job;
    this.id = id;
    this.createdAt = createdAt;
  }



  @Bindable
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    notifyPropertyChanged(BR.name);
  }

  public InsertUserResp withName(String name) {
    this.name = name;
    return this;
  }

  @Bindable
  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
    notifyPropertyChanged(BR.job);
  }

  public InsertUserResp withJob(String job) {
    this.job = job;
    return this;
  }

  @Bindable
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
    notifyPropertyChanged(BR.id);
  }

  public InsertUserResp withId(String id) {
    this.id = id;
    return this;
  }

  @Bindable
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    notifyPropertyChanged(BR.createdAt);
  }

  public InsertUserResp withCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(name);
    dest.writeValue(job);
    dest.writeValue(id);
    dest.writeValue(createdAt);
  }

  public int describeContents() {
    return 0;
  }

  public static final DiffUtil.ItemCallback<InsertUserResp> CALLBACK = new DiffUtil.ItemCallback<InsertUserResp>() {
    @Override
    public boolean areItemsTheSame(InsertUserResp oldItem, InsertUserResp newItem) {
      return oldItem.id == newItem.id;
    }

    @Override
    public boolean areContentsTheSame(InsertUserResp oldItem, InsertUserResp newItem) {
      return true;
    }
  };
}