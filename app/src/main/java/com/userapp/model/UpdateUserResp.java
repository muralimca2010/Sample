package com.userapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.userapp.BR;

public class UpdateUserResp extends BaseObservable implements Parcelable {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("job")
  @Expose
  private String job;
  @SerializedName("updatedAt")
  @Expose
  private String updatedAt;

  public final static Creator<UpdateUserResp> CREATOR = new Creator<UpdateUserResp>() {

    @SuppressWarnings({
        "unchecked"
    })
    public UpdateUserResp createFromParcel(Parcel in) {
      return new UpdateUserResp(in);
    }

    public UpdateUserResp[] newArray(int size) {
      return (new UpdateUserResp[size]);
    }
  };

  protected UpdateUserResp(Parcel in) {
    this.name = ((String) in.readValue((String.class.getClassLoader())));
    this.job = ((String) in.readValue((String.class.getClassLoader())));
    this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
  }

  /**
   * No args constructor for use in serialization
   */
  public UpdateUserResp() {
  }

  /**
   *
   * @param name
   * @param job
   * @param updatedAt
   */
  public UpdateUserResp(String name, String job, String updatedAt) {
    super();
    this.name = name;
    this.job = job;
    this.updatedAt = updatedAt;
  }



  @Bindable
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    notifyPropertyChanged(BR.name);
  }

  public UpdateUserResp withName(String name) {
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

  public UpdateUserResp withJob(String job) {
    this.job = job;
    return this;
  }


  @Bindable
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setCreatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    notifyPropertyChanged(BR.updatedAt);
  }

  public UpdateUserResp withUpdateAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(name);
    dest.writeValue(job);
    dest.writeValue(updatedAt);
  }

  public int describeContents() {
    return 0;
  }

  public static final DiffUtil.ItemCallback<UpdateUserResp> CALLBACK = new DiffUtil.ItemCallback<UpdateUserResp>() {
    @Override
    public boolean areItemsTheSame(UpdateUserResp oldItem, UpdateUserResp newItem) {
      return oldItem.name == newItem.name;
    }

    @Override
    public boolean areContentsTheSame(UpdateUserResp oldItem, UpdateUserResp newItem) {
      return true;
    }
  };
}